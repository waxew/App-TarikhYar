package ir.tarikhyar.app.feature.settings

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
import androidx.compose.foundation.layout.padding
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
fun SettingsScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var notifications by remember { mutableStateOf(AppPreferences.notificationsEnabled(context)) }
    var updateStatus by remember { mutableStateOf("برای بررسی نسخه جدید، دکمه زیر را بزن.") }

    val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        notifications = granted
        AppPreferences.setNotificationsEnabled(context, granted)
        if (granted) NotificationHelper.showTest(context)
    }

    Column(modifier.fillMaxSize()) {
        AppTopBar("تنظیمات", onBack) {
            shareText(context, "تاریخ‌یار", "تاریخ‌یار نسخه ${BuildConfig.VERSION_NAME}")
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            item {
                ResultCard {
                    Text("اعلان‌ها", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("اعلان نسخه جدید", fontWeight = FontWeight.Bold)
                            Text("وقتی نسخه جدید منتشر شود، تاریخ‌یار می‌تواند به شما اطلاع بدهد.", color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        Switch(
                            checked = notifications,
                            onCheckedChange = { enabled ->
                                if (!enabled) {
                                    notifications = false
                                    AppPreferences.setNotificationsEnabled(context, false)
                                } else if (Build.VERSION.SDK_INT >= 33 && !NotificationHelper.canNotify(context)) {
                                    permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                                } else {
                                    notifications = true
                                    AppPreferences.setNotificationsEnabled(context, true)
                                    NotificationHelper.showTest(context)
                                }
                            },
                        )
                    }
                    PrimaryButton("ارسال اعلان آزمایشی") {
                        if (Build.VERSION.SDK_INT >= 33 && !NotificationHelper.canNotify(context)) {
                            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        } else {
                            AppPreferences.setNotificationsEnabled(context, true)
                            notifications = true
                            NotificationHelper.showTest(context)
                        }
                    }
                }
            }

            item {
                ResultCard {
                    Text("بررسی بروزرسانی", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    Text(updateStatus, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    PrimaryButton("بررسی آخرین نسخه") {
                        updateStatus = "در حال بررسی..."
                        UpdateChecker.checkAsync(context) { info ->
                            updateStatus = when {
                                info == null -> "ارتباط با سرویس بروزرسانی برقرار نشد."
                                info.versionCode > BuildConfig.VERSION_CODE -> "نسخه ${info.versionName} منتشر شده است. ${info.message}"
                                else -> "نسخه ${BuildConfig.VERSION_NAME} آخرین نسخه است."
                            }
                        }
                    }
                }
            }

            item {
                ResultCard {
                    Text("درباره برنامه", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    SettingLine("نسخه برنامه", BuildConfig.VERSION_NAME)
                    SettingLine("کد نسخه", BuildConfig.VERSION_CODE.toString())
                    SettingLine("نام بسته", "ir.tarikhyar.app")
                    SettingLine("زبان", "فارسی / راست‌چین")
                }
            }
        }
    }
}

@Composable
private fun SettingLine(label: String, value: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(value, fontWeight = FontWeight.Bold)
    }
}
