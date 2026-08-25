package ir.tarikhyar.app.feature.notifications

import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.BuildConfig
import ir.tarikhyar.app.core.system.AppPreferences
import ir.tarikhyar.app.core.system.NotificationHelper
import ir.tarikhyar.app.core.system.UpdateChecker
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.PrimaryButton
import ir.tarikhyar.app.ui.components.ResultCard
import ir.tarikhyar.app.ui.components.shareText

@Composable
fun NotificationsScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var enabled by remember { mutableStateOf(AppPreferences.notificationsEnabled(context)) }
    var status by remember { mutableStateOf("اعلان‌های تاریخ‌یار برای نسخه‌های جدید و یادآوری‌ها استفاده می‌شوند.") }

    val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        enabled = granted
        AppPreferences.setNotificationsEnabled(context, granted)
        status = if (granted) "اجازه اعلان فعال شد." else "اجازه اعلان داده نشد."
        if (granted) NotificationHelper.showTest(context)
    }

    Column(modifier.fillMaxSize()) {
        AppTopBar("اعلان‌ها", onBack) { shareText(context, "تاریخ‌یار", "اعلان‌های نسخه جدید تاریخ‌یار") }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            item {
                ResultCard {
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("اعلان نسخه جدید", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                            Text(if (enabled) "فعال" else "غیرفعال", color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        Switch(checked = enabled, onCheckedChange = { value ->
                            if (!value) {
                                enabled = false
                                AppPreferences.setNotificationsEnabled(context, false)
                            } else if (Build.VERSION.SDK_INT >= 33 && !NotificationHelper.canNotify(context)) {
                                permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                            } else {
                                enabled = true
                                AppPreferences.setNotificationsEnabled(context, true)
                            }
                        })
                    }
                    Text(status, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    PrimaryButton("اعلان آزمایشی") {
                        if (Build.VERSION.SDK_INT >= 33 && !NotificationHelper.canNotify(context)) {
                            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        } else {
                            enabled = true
                            AppPreferences.setNotificationsEnabled(context, true)
                            NotificationHelper.showTest(context)
                            status = "یک اعلان آزمایشی ارسال شد."
                        }
                    }
                }
            }
            item {
                ResultCard {
                    Text("وضعیت بروزرسانی", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    Text("نسخه نصب‌شده: ${BuildConfig.VERSION_NAME}", fontWeight = FontWeight.Bold)
                    PrimaryButton("بررسی نسخه جدید") {
                        status = "در حال بررسی نسخه جدید..."
                        UpdateChecker.checkAsync(context) { info ->
                            status = when {
                                info == null -> "بررسی آنلاین انجام نشد. اتصال اینترنت را بررسی کن."
                                info.versionCode > BuildConfig.VERSION_CODE -> "نسخه ${info.versionName} آماده است. ${info.message}"
                                else -> "برنامه شما آخرین نسخه است."
                            }
                        }
                    }
                }
            }
        }
    }
}
