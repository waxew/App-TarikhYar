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

// نام SharedPreferences و کلیدهای داخلی برنامه در یک نقطه ثابت نگهداری می‌شوند.
private const val PREFS = "tarikhyar_settings"
private const val KEY_NOTIFICATIONS = "notifications_enabled"
private const val KEY_LAST_NOTIFIED_VERSION = "last_notified_version"
private const val UPDATE_CHANNEL = "tarikhyar_updates"
private const val UPDATE_URL = "https://raw.githubusercontent.com/waxew/App-TarikhYar/main/version.json"
private const val NETWORK_TIMEOUT_MS = 6000

// این مدل اطلاعات نسخه جدید را بعد از خواندن version.json نگهداری می‌کند.
data class UpdateInfo(
    val versionCode: Int,
    val versionName: String,
    val message: String,
    val downloadUrl: String,
)

object AppPreferences {
    // وضعیت روشن/خاموش بودن اعلان‌ها از SharedPreferences خوانده می‌شود.
    fun notificationsEnabled(context: Context): Boolean =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getBoolean(KEY_NOTIFICATIONS, true)

    // تغییر وضعیت اعلان‌ها بدون مسدودکردن UI ذخیره می‌شود.
    fun setNotificationsEnabled(context: Context, enabled: Boolean) {
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(KEY_NOTIFICATIONS, enabled)
            .apply()
    }

    // آخرین نسخه‌ای که برای آن Notification نشان داده‌ایم از نمایش تکراری اعلان در هر اجرای برنامه جلوگیری می‌کند.
    fun lastNotifiedVersion(context: Context): Int =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getInt(KEY_LAST_NOTIFIED_VERSION, 0)

    // بعد از نمایش اعلان نسخه جدید، versionCode همان نسخه ذخیره می‌شود.
    fun setLastNotifiedVersion(context: Context, versionCode: Int) {
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit()
            .putInt(KEY_LAST_NOTIFIED_VERSION, versionCode)
            .apply()
    }
}

object NotificationHelper {
    // Android 8 به بالا برای نمایش Notification به NotificationChannel نیاز دارد.
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

    // این تابع بررسی می‌کند سیستم‌عامل اجازه ارسال Notification را داده است یا خیر.
    fun canNotify(context: Context): Boolean =
        Build.VERSION.SDK_INT < 33 ||
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS,
            ) == PackageManager.PERMISSION_GRANTED

    // Notification آزمایشی برای اطمینان کاربر از فعال بودن اعلان‌ها ارسال می‌شود.
    fun showTest(context: Context) {
        if (!AppPreferences.notificationsEnabled(context) || !canNotify(context)) return
        show(context, 1501, "تاریخ‌یار آماده است", "اعلان‌ها با موفقیت فعال هستند.")
    }

    // Notification نسخه جدید فقط زمانی نمایش داده می‌شود که مجوز و تنظیم داخلی هر دو فعال باشند.
    fun showUpdate(context: Context, info: UpdateInfo) {
        if (!AppPreferences.notificationsEnabled(context) || !canNotify(context)) return
        show(
            context,
            1502,
            "نسخه جدید تاریخ‌یار منتشر شد",
            "نسخه ${info.versionName} آماده دریافت است.",
        )
    }

    // تمام Notificationهای تاریخ‌یار از این تابع مشترک ساخته می‌شوند.
    private fun show(context: Context, id: Int, title: String, text: String) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
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
    // بررسی شبکه در Thread جدا انجام می‌شود تا Main Thread مسدود نشود.
    fun checkAsync(context: Context, onResult: (UpdateInfo?) -> Unit = {}) {
        val appContext = context.applicationContext
        Thread {
            val result = fetchUpdateInfo()

            // اگر نسخه جدیدتر باشد، اعلان فقط یک بار برای همان versionCode نمایش داده می‌شود.
            if (
                result != null &&
                result.versionCode > BuildConfig.VERSION_CODE &&
                AppPreferences.notificationsEnabled(appContext) &&
                NotificationHelper.canNotify(appContext) &&
                AppPreferences.lastNotifiedVersion(appContext) < result.versionCode
            ) {
                NotificationHelper.showUpdate(appContext, result)
                AppPreferences.setLastNotifiedVersion(appContext, result.versionCode)
            }

            // Callback همیشه روی Main Thread اجرا می‌شود تا UI بتواند State را امن تغییر دهد.
            Handler(Looper.getMainLooper()).post {
                onResult(result)
            }
        }.start()
    }

    // اتصال HTTP timeout دارد تا در شبکه ضعیف Thread برای مدت نامحدود منتظر نماند.
    private fun fetchUpdateInfo(): UpdateInfo? {
        var connection: HttpURLConnection? = null
        return try {
            connection = URL(UPDATE_URL).openConnection() as HttpURLConnection
            connection.connectTimeout = NETWORK_TIMEOUT_MS
            connection.readTimeout = NETWORK_TIMEOUT_MS
            connection.requestMethod = "GET"
            connection.useCaches = false

            if (connection.responseCode !in 200..299) {
                null
            } else {
                val json = connection.inputStream.bufferedReader().use { reader ->
                    reader.readText()
                }
                parse(json)
            }
        } catch (_: Exception) {
            null
        } finally {
            connection?.disconnect()
        }
    }

    // Parser سبک برای فایل کوچک version.json استفاده می‌شود تا وابستگی JSON اضافی به برنامه تحمیل نشود.
    private fun parse(json: String): UpdateInfo? {
        fun int(name: String): Int? =
            Regex("\\\"$name\\\"\\s*:\\s*(\\d+)")
                .find(json)
                ?.groupValues
                ?.get(1)
                ?.toIntOrNull()

        fun str(name: String): String =
            Regex("\\\"$name\\\"\\s*:\\s*\\\"([^\\\"]*)\\\"")
                .find(json)
                ?.groupValues
                ?.get(1)
                .orEmpty()

        val code = int("latestVersionCode") ?: return null
        val name = str("latestVersionName")

        // اگر نام نسخه خالی باشد داده ناقص تلقی می‌شود.
        if (name.isBlank()) return null

        return UpdateInfo(
            versionCode = code,
            versionName = name,
            message = str("message"),
            downloadUrl = str("downloadUrl"),
        )
    }
}
