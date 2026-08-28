// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// این فایل سرویس‌های سیستمی تاریخ‌یار شامل تنظیمات محلی، اعلان و بررسی بروزرسانی را نگهداری می‌کند.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.core.system

// راهنما: این import وابستگی «android.Manifest» را برای استفاده در این فایل وارد می‌کند.
import android.Manifest
// راهنما: این import وابستگی «android.app.NotificationChannel» را برای استفاده در این فایل وارد می‌کند.
import android.app.NotificationChannel
// راهنما: این import وابستگی «android.app.NotificationManager» را برای استفاده در این فایل وارد می‌کند.
import android.app.NotificationManager
// راهنما: این import وابستگی «android.app.PendingIntent» را برای استفاده در این فایل وارد می‌کند.
import android.app.PendingIntent
// راهنما: این import وابستگی «android.content.Context» را برای استفاده در این فایل وارد می‌کند.
import android.content.Context
// راهنما: این import وابستگی «android.content.Intent» را برای استفاده در این فایل وارد می‌کند.
import android.content.Intent
// راهنما: این import وابستگی «android.content.pm.PackageManager» را برای استفاده در این فایل وارد می‌کند.
import android.content.pm.PackageManager
// راهنما: این import وابستگی «android.os.Build» را برای استفاده در این فایل وارد می‌کند.
import android.os.Build
// راهنما: این import وابستگی «android.os.Handler» را برای استفاده در این فایل وارد می‌کند.
import android.os.Handler
// راهنما: این import وابستگی «android.os.Looper» را برای استفاده در این فایل وارد می‌کند.
import android.os.Looper
// راهنما: این import وابستگی «androidx.core.app.NotificationCompat» را برای استفاده در این فایل وارد می‌کند.
import androidx.core.app.NotificationCompat
// راهنما: این import وابستگی «androidx.core.content.ContextCompat» را برای استفاده در این فایل وارد می‌کند.
import androidx.core.content.ContextCompat
// راهنما: این import وابستگی «ir.tarikhyar.app.BuildConfig» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.BuildConfig
// راهنما: این import وابستگی «ir.tarikhyar.app.MainActivity» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.MainActivity
// راهنما: این import وابستگی «ir.tarikhyar.app.R» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.R
// راهنما: این import وابستگی «java.net.HttpURLConnection» را برای استفاده در این فایل وارد می‌کند.
import java.net.HttpURLConnection
// راهنما: این import وابستگی «java.net.URL» را برای استفاده در این فایل وارد می‌کند.
import java.net.URL

// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
private const val PREFS = "tarikhyar_settings"
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
private const val KEY_NOTIFICATIONS = "notifications_enabled"
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
private const val KEY_LAST_NOTIFIED_VERSION = "last_notified_version"
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
private const val UPDATE_CHANNEL = "tarikhyar_updates"
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
private const val UPDATE_URL = "https://raw.githubusercontent.com/waxew/App-TarikhYar/main/version.json"
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
private const val NETWORK_TIMEOUT_MS = 6000

// راهنما: این data class یک مدل داده سبک برای نگهداری مقادیر مرتبط تعریف می‌کند.
data class UpdateInfo(
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val versionCode: Int,
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val versionName: String,
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val message: String,
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val downloadUrl: String,
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
)

// راهنما: این object یک نمونه Singleton برای سرویس یا داده مشترک برنامه ایجاد می‌کند.
object AppPreferences {
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun notificationsEnabled(context: Context): Boolean =
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getBoolean(KEY_NOTIFICATIONS, true)

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun setNotificationsEnabled(context: Context, enabled: Boolean) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().putBoolean(KEY_NOTIFICATIONS, enabled).apply()
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun lastNotifiedVersion(context: Context): Int =
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getInt(KEY_LAST_NOTIFIED_VERSION, 0)

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun setLastNotifiedVersion(context: Context, versionCode: Int) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().putInt(KEY_LAST_NOTIFIED_VERSION, versionCode).apply()
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این object یک نمونه Singleton برای سرویس یا داده مشترک برنامه ایجاد می‌کند.
object NotificationHelper {
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun createChannel(context: Context) {
        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val manager = context.getSystemService(NotificationManager::class.java)
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val channel = NotificationChannel(UPDATE_CHANNEL, "اعلان‌های تاریخ‌یار", NotificationManager.IMPORTANCE_DEFAULT).apply {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                description = "اعلان نسخه جدید و یادآوری‌های تاریخ‌یار"
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            manager.createNotificationChannel(channel)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun canNotify(context: Context): Boolean =
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun showTest(context: Context) {
        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
        if (!AppPreferences.notificationsEnabled(context) || !canNotify(context)) return
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        show(context, 1501, "تاریخ‌یار آماده است", "اعلان‌ها با موفقیت فعال هستند.")
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun showUpdate(context: Context, info: UpdateInfo) {
        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
        if (!AppPreferences.notificationsEnabled(context) || !canNotify(context)) return
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        show(context, 1502, "نسخه جدید تاریخ‌یار منتشر شد", "نسخه ${info.versionName} آماده دریافت است.")
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun showReminder(context: Context, title: String, text: String) {
        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
        if (!AppPreferences.notificationsEnabled(context) || !canNotify(context)) return
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        show(context, (System.currentTimeMillis() and 0x7fffffff).toInt(), title, text)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    private fun show(context: Context, id: Int, title: String, text: String) {
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val intent = Intent(context, MainActivity::class.java).apply {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val pending = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val notification = NotificationCompat.Builder(context, UPDATE_CHANNEL)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            .setSmallIcon(R.drawable.ic_launcher)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            .setContentTitle(title)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            .setContentText(text)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            .setStyle(NotificationCompat.BigTextStyle().bigText(text))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            .setAutoCancel(true)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            .setContentIntent(pending)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            .build()
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        context.getSystemService(NotificationManager::class.java).notify(id, notification)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این object یک نمونه Singleton برای سرویس یا داده مشترک برنامه ایجاد می‌کند.
object UpdateChecker {
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun checkAsync(context: Context, onResult: (UpdateInfo?) -> Unit = {}) {
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val appContext = context.applicationContext
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        Thread {
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val result = fetchUpdateInfo()
            // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
            if (result != null && result.versionCode > BuildConfig.VERSION_CODE && AppPreferences.notificationsEnabled(appContext) && UserSettings.updateNotifications(appContext) && NotificationHelper.canNotify(appContext) && AppPreferences.lastNotifiedVersion(appContext) < result.versionCode) {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                NotificationHelper.showUpdate(appContext, result)
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                AppPreferences.setLastNotifiedVersion(appContext, result.versionCode)
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            Handler(Looper.getMainLooper()).post { onResult(result) }
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        }.start()
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    private fun fetchUpdateInfo(): UpdateInfo? {
        // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
        var connection: HttpURLConnection? = null
        // راهنما: این return نتیجه تابع را برمی‌گرداند و اجرای همان تابع را پایان می‌دهد.
        return try {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            connection = URL(UPDATE_URL).openConnection() as HttpURLConnection
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            connection.connectTimeout = NETWORK_TIMEOUT_MS
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            connection.readTimeout = NETWORK_TIMEOUT_MS
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            connection.requestMethod = "GET"
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            connection.useCaches = false
            // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
            if (connection.responseCode !in 200..299) null else parse(connection.inputStream.bufferedReader().use { it.readText() })
        // راهنما: این بخش خطای احتمالی بلوک try را کنترل می‌کند تا برنامه Crash نکند.
        } catch (_: Exception) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            null
        // راهنما: این بخش در هر حالت برای آزادسازی منبع یا پاک‌سازی نهایی اجرا می‌شود.
        } finally {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            connection?.disconnect()
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    private fun parse(json: String): UpdateInfo? {
        // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
        fun int(name: String): Int? = Regex("\\\"$name\\\"\\s*:\\s*(\\d+)").find(json)?.groupValues?.get(1)?.toIntOrNull()
        // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
        fun str(name: String): String = Regex("\\\"$name\\\"\\s*:\\s*\\\"([^\\\"]*)\\\"").find(json)?.groupValues?.get(1).orEmpty()
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val code = int("latestVersionCode") ?: return null
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val name = str("latestVersionName")
        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
        if (name.isBlank()) return null
        // راهنما: این return نتیجه تابع را برمی‌گرداند و اجرای همان تابع را پایان می‌دهد.
        return UpdateInfo(code, name, str("message"), str("downloadUrl"))
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
