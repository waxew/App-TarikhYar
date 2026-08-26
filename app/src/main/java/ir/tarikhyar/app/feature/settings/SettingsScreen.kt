// این فایل صفحه تنظیمات تاریخ‌یار را پیاده‌سازی می‌کند و فقط گزینه‌های قابل تنظیم را نمایش می‌دهد.
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
    // Context برای دسترسی به SharedPreferences، اعلان‌ها و Share لازم است.
    val context = LocalContext.current

    // وضعیت Switch اعلان از تنظیمات ذخیره‌شده کاربر خوانده می‌شود.
    var notifications by remember {
        mutableStateOf(AppPreferences.notificationsEnabled(context))
    }

    // متن وضعیت بروزرسانی بعد از هر بررسی تغییر می‌کند.
    var updateStatus by remember {
        mutableStateOf("برای بررسی نسخه جدید، دکمه زیر را بزن.")
    }

    // در Android 13 به بالا باید مجوز POST_NOTIFICATIONS در زمان اجرا درخواست شود.
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        notifications = granted
        AppPreferences.setNotificationsEnabled(context, granted)
        if (granted) {
            NotificationHelper.showTest(context)
        }
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
                // کارت اعلان‌ها وظیفه روشن/خاموش کردن اعلان و تست مجوز را دارد.
                ResultCard {
                    Text(
                        "اعلان‌ها",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("اعلان نسخه جدید", fontWeight = FontWeight.Bold)
                            Text(
                                "وقتی نسخه جدید منتشر شود، تاریخ‌یار می‌تواند به شما اطلاع بدهد.",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        }
                        Switch(
                            checked = notifications,
                            onCheckedChange = { enabled ->
                                if (!enabled) {
                                    notifications = false
                                    AppPreferences.setNotificationsEnabled(context, false)
                                } else if (
                                    Build.VERSION.SDK_INT >= 33 &&
                                    !NotificationHelper.canNotify(context)
                                ) {
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
                        if (
                            Build.VERSION.SDK_INT >= 33 &&
                            !NotificationHelper.canNotify(context)
                        ) {
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
                // کارت بروزرسانی نسخه فعلی را با version.json مخزن مقایسه می‌کند.
                ResultCard {
                    Text(
                        "بررسی بروزرسانی",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Text(updateStatus, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    PrimaryButton("بررسی آخرین نسخه") {
                        updateStatus = "در حال بررسی..."
                        UpdateChecker.checkAsync(context) { info ->
                            updateStatus = when {
                                info == null -> "ارتباط با سرویس بروزرسانی برقرار نشد."
                                info.versionCode > BuildConfig.VERSION_CODE -> {
                                    "نسخه ${info.versionName} منتشر شده است. ${info.message}"
                                }
                                else -> "نسخه ${BuildConfig.VERSION_NAME} آخرین نسخه است."
                            }
                        }
                    }
                }
            }

            item {
                // درباره نرم افزار در Drawer صفحه مستقل دارد؛ این متن کاربر را به همان بخش راهنمایی می‌کند.
                ResultCard {
                    Text(
                        "اطلاعات برنامه",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Text(
                        "توضیحات برنامه و شماره نسخه از بخش «درباره نرم افزار» در منوی همبرگری قابل مشاهده است.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
        }
    }
}
