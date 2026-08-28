// این فایل سرویس‌های سیستمی تاریخ‌یار شامل تنظیمات محلی، اعلان و بررسی بروزرسانی را نگهداری می‌کند.
package ir.tarikhyar.app.core.system

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import ir.tarikhyar.app.BuildConfig
import ir.tarikhyar.app.MainActivity
import ir.tarikhyar.app.R
import java.net.HttpURLConnection
import java.net.URL

private const val PREFS = "tarikhyar_settings"
private const val KEY_NOTIFICATIONS = "notifications_enabled"
private const val KEY_LAST_NOTIFIED_VERSION = "last_notified_version"
private const val UPDATE_CHANNEL = "tarikhyar_updates"
private const val UPDATE_URL = "https://raw.githubusercontent.com/waxew/App-TarikhYar/main/version.json"
private const val NETWORK_TIMEOUT_MS = 6000

data class UpdateInfo(
    val versionCode: Int,
    val versionName: String,
    val message: String,
    val downloadUrl: String,
)

object AppPreferences {
    fun notificationsEnabled(context: Context): Boolean =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getBoolean(KEY_NOTIFICATIONS, true)

    fun setNotificationsEnabled(context: Context, enabled: Boolean) {
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().putBoolean(KEY_NOTIFICATIONS, enabled).apply()
    }

    fun lastNotifiedVersion(context: Context): Int =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getInt(KEY_LAST_NOTIFIED_VERSION, 0)

    fun setLastNotifiedVersion(context: Context, versionCode: Int) {
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().putInt(KEY_LAST_NOTIFIED_VERSION, versionCode).apply()
    }
}

object NotificationHelper {
    fun createChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = context.getSystemService(NotificationManager::class.java)
            val channel = NotificationChannel(UPDATE_CHANNEL, "اعلان‌های تاریخ‌یار", NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "اعلان نسخه جدید و یادآوری‌های تاریخ‌یار"
            }
            manager.createNotificationChannel(channel)
        }
    }

    fun canNotify(context: Context): Boolean =
        Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED

    fun showTest(context: Context) {
        if (!AppPreferences.notificationsEnabled(context) || !canNotify(context)) return
        show(context, 1501, "تاریخ‌یار آماده است", "اعلان‌ها با موفقیت فعال هستند.")
    }

    fun showUpdate(context: Context, info: UpdateInfo) {
        if (!AppPreferences.notificationsEnabled(context) || !canNotify(context)) return
        show(context, 1502, "نسخه جدید تاریخ‌یار منتشر شد", "نسخه ${info.versionName} آماده دریافت است.")
    }

    fun showReminder(context: Context, title: String, text: String) {
        if (!AppPreferences.notificationsEnabled(context) || !canNotify(context)) return
        show(context, (System.currentTimeMillis() and 0x7fffffff).toInt(), title, text)
    }

    private fun show(context: Context, id: Int, title: String, text: String) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
        val pending = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        val notification = NotificationCompat.Builder(context, UPDATE_CHANNEL)
            .setSmallIcon(R.drawable.ic_launcher)
            .setContentTitle(title)
            .setContentText(text)
            .setStyle(NotificationCompat.BigTextStyle().bigText(text))
            .setAutoCancel(true)
            .setContentIntent(pending)
            .build()
        context.getSystemService(NotificationManager::class.java).notify(id, notification)
    }
}

object UpdateChecker {
    fun checkAsync(context: Context, onResult: (UpdateInfo?) -> Unit = {}) {
        val appContext = context.applicationContext
        Thread {
            val result = fetchUpdateInfo()
            if (result != null && result.versionCode > BuildConfig.VERSION_CODE && AppPreferences.notificationsEnabled(appContext) && UserSettings.updateNotifications(appContext) && NotificationHelper.canNotify(appContext) && AppPreferences.lastNotifiedVersion(appContext) < result.versionCode) {
                NotificationHelper.showUpdate(appContext, result)
                AppPreferences.setLastNotifiedVersion(appContext, result.versionCode)
            }
            Handler(Looper.getMainLooper()).post { onResult(result) }
        }.start()
    }

    private fun fetchUpdateInfo(): UpdateInfo? {
        var connection: HttpURLConnection? = null
        return try {
            connection = URL(UPDATE_URL).openConnection() as HttpURLConnection
            connection.connectTimeout = NETWORK_TIMEOUT_MS
            connection.readTimeout = NETWORK_TIMEOUT_MS
            connection.requestMethod = "GET"
            connection.useCaches = false
            if (connection.responseCode !in 200..299) null else parse(connection.inputStream.bufferedReader().use { it.readText() })
        } catch (_: Exception) {
            null
        } finally {
            connection?.disconnect()
        }
    }

    private fun parse(json: String): UpdateInfo? {
        fun int(name: String): Int? = Regex("\\\"$name\\\"\\s*:\\s*(\\d+)").find(json)?.groupValues?.get(1)?.toIntOrNull()
        fun str(name: String): String = Regex("\\\"$name\\\"\\s*:\\s*\\\"([^\\\"]*)\\\"").find(json)?.groupValues?.get(1).orEmpty()
        val code = int("latestVersionCode") ?: return null
        val name = str("latestVersionName")
        if (name.isBlank()) return null
        return UpdateInfo(code, name, str("message"), str("downloadUrl"))
    }
}
