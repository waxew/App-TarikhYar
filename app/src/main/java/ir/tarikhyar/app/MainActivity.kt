// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app

// راهنما: این import وابستگی «android.os.Bundle» را برای استفاده در این فایل وارد می‌کند.
import android.os.Bundle
// راهنما: این import وابستگی «androidx.activity.ComponentActivity» را برای استفاده در این فایل وارد می‌کند.
import androidx.activity.ComponentActivity
// راهنما: این import وابستگی «androidx.activity.compose.setContent» را برای استفاده در این فایل وارد می‌کند.
import androidx.activity.compose.setContent
// راهنما: این import وابستگی «androidx.activity.enableEdgeToEdge» را برای استفاده در این فایل وارد می‌کند.
import androidx.activity.enableEdgeToEdge
// راهنما: این import وابستگی «ir.tarikhyar.app.core.system.AppPreferences» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.system.AppPreferences
// راهنما: این import وابستگی «ir.tarikhyar.app.core.system.NotificationHelper» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.system.NotificationHelper
// راهنما: این import وابستگی «ir.tarikhyar.app.core.system.ReminderScheduler» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.system.ReminderScheduler
// راهنما: این import وابستگی «ir.tarikhyar.app.core.system.UpdateChecker» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.system.UpdateChecker
// راهنما: این import وابستگی «ir.tarikhyar.app.core.system.UserSettings» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.system.UserSettings
// راهنما: این import وابستگی «ir.tarikhyar.app.core.ui.theme.TarikhYarTheme» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.ui.theme.TarikhYarTheme

/** Activity اصلی، سرویس‌های محلی و تم انتخابی کاربر را هنگام اجرا آماده می‌کند. */
// راهنما: این خط یک کلاس و مسئولیت مشخص آن را در معماری برنامه تعریف می‌کند.
class MainActivity : ComponentActivity() {
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    override fun onCreate(savedInstanceState: Bundle?) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        super.onCreate(savedInstanceState)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        NotificationHelper.createChannel(this)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ReminderScheduler.scheduleAll(this)
        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
        if (AppPreferences.notificationsEnabled(this) && UserSettings.updateNotifications(this)) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            UpdateChecker.checkAsync(this)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        enableEdgeToEdge()
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        setContent {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            TarikhYarTheme(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                themeMode = UserSettings.themeMode(this),
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                accentStyle = UserSettings.accentStyle(this),
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                fontScale = UserSettings.fontScale(this),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            ) {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                TarikhYarApp()
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
