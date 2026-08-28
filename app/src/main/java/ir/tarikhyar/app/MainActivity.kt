package ir.tarikhyar.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ir.tarikhyar.app.core.system.AppPreferences
import ir.tarikhyar.app.core.system.NotificationHelper
import ir.tarikhyar.app.core.system.ReminderScheduler
import ir.tarikhyar.app.core.system.UpdateChecker
import ir.tarikhyar.app.core.system.UserSettings
import ir.tarikhyar.app.core.ui.theme.TarikhYarTheme

/** Activity اصلی، سرویس‌های محلی و تم انتخابی کاربر را هنگام اجرا آماده می‌کند. */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NotificationHelper.createChannel(this)
        ReminderScheduler.scheduleAll(this)
        if (AppPreferences.notificationsEnabled(this) && UserSettings.updateNotifications(this)) {
            UpdateChecker.checkAsync(this)
        }
        enableEdgeToEdge()
        setContent {
            TarikhYarTheme(
                themeMode = UserSettings.themeMode(this),
                accentStyle = UserSettings.accentStyle(this),
                fontScale = UserSettings.fontScale(this),
            ) {
                TarikhYarApp()
            }
        }
    }
}
