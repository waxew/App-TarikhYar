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
import java.net.URL

private const val PREFS = "tarikhyar_settings"
private const val KEY_NOTIFICATIONS = "notifications_enabled"
private const val UPDATE_CHANNEL = "tarikhyar_updates"
private const val UPDATE_URL = "https://raw.githubusercontent.com/waxew/App-TarikhYar/main/version.json"

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
}

object NotificationHelper {
    fun createChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = context.getSystemService(NotificationManager::class.java)
            val channel = NotificationChannel(
                UPDATE_CHANNEL,
                "اعلان‌های تاریخ‌یار",
                NotificationManager.IMPORTANCE_DEFAULT,
            ).apply {
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

    private fun show(context: Context, id: Int, title: String, text: String) {
        val intent = Intent(context, MainActivity::class.java)
        val pending = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
        )
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
        Thread {
            val result = try {
                parse(URL(UPDATE_URL).readText())
            } catch (_: Exception) {
                null
            }
            if (result != null && result.versionCode > BuildConfig.VERSION_CODE) {
                NotificationHelper.showUpdate(context, result)
            }
            Handler(Looper.getMainLooper()).post { onResult(result) }
        }.start()
    }

    private fun parse(json: String): UpdateInfo? {
        fun int(name: String): Int? = Regex("\\\"$name\\\"\\s*:\\s*(\\d+)").find(json)?.groupValues?.get(1)?.toIntOrNull()
        fun str(name: String): String = Regex("\\\"$name\\\"\\s*:\\s*\\\"([^\\\"]*)\\\"").find(json)?.groupValues?.get(1).orEmpty()
        val code = int("latestVersionCode") ?: return null
        return UpdateInfo(
            versionCode = code,
            versionName = str("latestVersionName"),
            message = str("message"),
            downloadUrl = str("downloadUrl"),
        )
    }
}
