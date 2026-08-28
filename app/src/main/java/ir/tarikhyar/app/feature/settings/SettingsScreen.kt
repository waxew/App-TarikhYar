package ir.tarikhyar.app.feature.settings

import android.Manifest
import android.app.Activity
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.BuildConfig
import ir.tarikhyar.app.core.system.AccentStyle
import ir.tarikhyar.app.core.system.AppPreferences
import ir.tarikhyar.app.core.system.CardTemplate
import ir.tarikhyar.app.core.system.IconStyle
import ir.tarikhyar.app.core.system.NotificationHelper
import ir.tarikhyar.app.core.system.ReminderScheduler
import ir.tarikhyar.app.core.system.ThemeMode
import ir.tarikhyar.app.core.system.UpdateChecker
import ir.tarikhyar.app.core.system.UserSettings
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.ChoicePill
import ir.tarikhyar.app.ui.components.PrimaryButton
import ir.tarikhyar.app.ui.components.ResultCard

/** تنظیمات کامل ظاهر، دسترس‌پذیری، اعلان‌ها، کارت‌ها و بروزرسانی برنامه. */
@Composable
fun SettingsScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var notifications by remember { mutableStateOf(AppPreferences.notificationsEnabled(context)) }
    var birthday by remember { mutableStateOf(UserSettings.birthdayNotifications(context)) }
    var events by remember { mutableStateOf(UserSettings.eventNotifications(context)) }
    var milestones by remember { mutableStateOf(UserSettings.milestoneNotifications(context)) }
    var updates by remember { mutableStateOf(UserSettings.updateNotifications(context)) }
    var reminderHour by remember { mutableIntStateOf(UserSettings.reminderHour(context)) }
    var displayName by remember { mutableStateOf(UserSettings.displayName(context)) }
    var status by remember { mutableStateOf("نسخه فعلی ${BuildConfig.VERSION_NAME}") }

    val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        notifications = granted
        AppPreferences.setNotificationsEnabled(context, granted)
        if (granted) NotificationHelper.showTest(context)
    }

    fun recreate() { (context as? Activity)?.recreate() }

    Column(modifier.fillMaxSize()) {
        AppTopBar("تنظیمات", onBack)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            item {
                ResultCard {
                    Text("پروفایل من", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    OutlinedTextField(displayName, { displayName = it }, modifier = Modifier.fillMaxWidth(), label = { Text("نام نمایشی") }, singleLine = true)
                    PrimaryButton("ذخیره نام") { UserSettings.setDisplayName(context, displayName) }
                }
            }

            item {
                ResultCard {
                    Text("ظاهر برنامه", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    Text("حالت نمایش", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        listOf(ThemeMode.SYSTEM to "خودکار", ThemeMode.LIGHT to "روشن", ThemeMode.DARK to "تیره").forEach { (mode, label) ->
                            ChoicePill(label, UserSettings.themeMode(context) == mode, {
                                UserSettings.setThemeMode(context, mode); recreate()
                            }, Modifier.weight(1f))
                        }
                    }
                    Text("رنگ اصلی", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        listOf(AccentStyle.RED to "قرمز", AccentStyle.ROSE to "رز", AccentStyle.AMBER to "کهربایی").forEach { (style, label) ->
                            ChoicePill(label, UserSettings.accentStyle(context) == style, {
                                UserSettings.setAccentStyle(context, style); recreate()
                            }, Modifier.weight(1f))
                        }
                    }
                    Text("اندازه متن", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        listOf(0.9f to "کوچک", 1f to "معمولی", 1.15f to "درشت").forEach { (scale, label) ->
                            ChoicePill(label, kotlin.math.abs(UserSettings.fontScale(context) - scale) < 0.01f, {
                                UserSettings.setFontScale(context, scale); recreate()
                            }, Modifier.weight(1f))
                        }
                    }
                    Text("مجموعه آیکن", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        ChoicePill("گرافیکی", UserSettings.iconStyle(context) == IconStyle.GRAPHIC, {
                            UserSettings.setIconStyle(context, IconStyle.GRAPHIC); recreate()
                        }, Modifier.weight(1f))
                        ChoicePill("مینیمال", UserSettings.iconStyle(context) == IconStyle.MINIMAL, {
                            UserSettings.setIconStyle(context, IconStyle.MINIMAL); recreate()
                        }, Modifier.weight(1f))
                    }
                }
            }

            item {
                ResultCard {
                    Text("قالب کارت اشتراک", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        listOf(CardTemplate.CLASSIC to "کلاسیک", CardTemplate.SOFT to "نرم", CardTemplate.DARK to "تیره").forEach { (template, label) ->
                            ChoicePill(label, UserSettings.cardTemplate(context) == template, {
                                UserSettings.setCardTemplate(context, template); recreate()
                            }, Modifier.weight(1f))
                        }
                    }
                }
            }

            item {
                ResultCard {
                    Text("اعلان‌ها", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    SettingSwitch("فعال بودن اعلان‌ها", notifications) { enabled ->
                        if (enabled && Build.VERSION.SDK_INT >= 33 && !NotificationHelper.canNotify(context)) permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        else { notifications = enabled; AppPreferences.setNotificationsEnabled(context, enabled) }
                    }
                    SettingSwitch("یادآوری تولدها", birthday) { birthday = it; UserSettings.setBirthdayNotifications(context, it); ReminderScheduler.scheduleAll(context) }
                    SettingSwitch("یادآوری مناسبت‌های شخصی", events) { events = it; UserSettings.setEventNotifications(context, it); ReminderScheduler.scheduleAll(context) }
                    SettingSwitch("رویدادهای مهم سنی", milestones) { milestones = it; UserSettings.setMilestoneNotifications(context, it) }
                    SettingSwitch("اعلان نسخه جدید", updates) { updates = it; UserSettings.setUpdateNotifications(context, it) }
                    Text("ساعت یادآوری: ${reminderHour}:00", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        ChoicePill("-", false, { reminderHour = (reminderHour - 1).coerceAtLeast(7); UserSettings.setReminderHour(context, reminderHour) }, Modifier.weight(1f))
                        ChoicePill("+", false, { reminderHour = (reminderHour + 1).coerceAtMost(22); UserSettings.setReminderHour(context, reminderHour) }, Modifier.weight(1f))
                    }
                    PrimaryButton("ارسال اعلان آزمایشی") { NotificationHelper.showTest(context) }
                }
            }

            item {
                ResultCard {
                    Text("بروزرسانی", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    Text(status, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    PrimaryButton("بررسی آخرین نسخه") {
                        status = "در حال بررسی..."
                        UpdateChecker.checkAsync(context) { info ->
                            status = when {
                                info == null -> "ارتباط با سرویس بروزرسانی برقرار نشد."
                                info.versionCode > BuildConfig.VERSION_CODE -> "نسخه ${info.versionName} منتشر شده است. ${info.message}"
                                else -> "نسخه ${BuildConfig.VERSION_NAME} آخرین نسخه است."
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SettingSwitch(label: String, checked: Boolean, onChange: (Boolean) -> Unit) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, modifier = Modifier.weight(1f))
        Switch(checked = checked, onCheckedChange = onChange)
    }
}
