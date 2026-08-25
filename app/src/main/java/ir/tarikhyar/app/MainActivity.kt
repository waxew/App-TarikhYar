package ir.tarikhyar.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ir.tarikhyar.app.core.ui.theme.TarikhYarTheme

/** Single-activity entry point. All screens are built with Jetpack Compose. */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TarikhYarTheme {
                TarikhYarApp()
            }
        }
    }
}
