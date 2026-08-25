package ir.tarikhyar.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ir.tarikhyar.app.core.system.AppPreferences
import ir.tarikhyar.app.core.system.NotificationHelper
import ir.tarikhyar.app.core.system.UpdateChecker
import ir.tarikhyar.app.core.ui.theme.TarikhYarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NotificationHelper.createChannel(this)
        if (AppPreferences.notificationsEnabled(this)) {
            UpdateChecker.checkAsync(this)
        }
        enableEdgeToEdge()
        setContent {
            TarikhYarTheme {
                TarikhYarApp()
            }
        }
    }
}
