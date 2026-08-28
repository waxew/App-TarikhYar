#!/usr/bin/env python3
"""Apply TarikhYar 2.0 final QA fixes before the public release.

The script is idempotent. It exists so GitHub Actions can apply the same set of
reviewed source changes on the repository itself, then run the project-wide
AS Team explanatory-comment pass.
"""
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]


def replace_once(path: str, old: str, new: str) -> None:
    p = ROOT / path
    text = p.read_text(encoding="utf-8")
    if new in text:
        return
    if old not in text:
        raise RuntimeError(f"Expected source block was not found in {path}")
    p.write_text(text.replace(old, new, 1), encoding="utf-8")


def replace_all(path: str, old: str, new: str) -> None:
    p = ROOT / path
    text = p.read_text(encoding="utf-8")
    if old not in text:
        return
    p.write_text(text.replace(old, new), encoding="utf-8")


def finalize_reminders() -> None:
    path = "app/src/main/java/ir/tarikhyar/app/core/system/ReminderScheduler.kt"
    old = '''        val thisYearDay = profile.birthDate.day.coerceAtMost(PersianCalendar.monthLength(today.year, profile.birthDate.month))
        var target = PersianDate(today.year, profile.birthDate.month, thisYearDay)
        if (PersianCalendar.compare(target, today) < 0) {
            val nextYear = today.year + 1
            target = PersianDate(
                nextYear,
                profile.birthDate.month,
                profile.birthDate.day.coerceAtMost(PersianCalendar.monthLength(nextYear, profile.birthDate.month)),
            )
        }
'''
    new = '''        val thisYearDay = profile.birthDate.day.coerceAtMost(PersianCalendar.monthLength(today.year, profile.birthDate.month))
        var target = PersianDate(today.year, profile.birthDate.month, thisYearDay)

        // اگر تاریخ تولد امروز است ولی ساعت یادآوری گذشته، Alarm باید برای سال بعد ساخته شود.
        val targetGregorian = PersianCalendar.toGregorian(target)
        val targetDateTime = LocalDateTime.of(
            targetGregorian.year,
            targetGregorian.monthValue,
            targetGregorian.dayOfMonth,
            UserSettings.reminderHour(context),
            0,
        )
        val reminderMomentPassed = targetDateTime
            .atZone(ZoneId.systemDefault())
            .toInstant()
            .toEpochMilli() <= System.currentTimeMillis()

        if (PersianCalendar.compare(target, today) < 0 || reminderMomentPassed) {
            val nextYear = today.year + 1
            target = PersianDate(
                nextYear,
                profile.birthDate.month,
                profile.birthDate.day.coerceAtMost(PersianCalendar.monthLength(nextYear, profile.birthDate.month)),
            )
        }
'''
    replace_once(path, old, new)


def finalize_settings() -> None:
    path = "app/src/main/java/ir/tarikhyar/app/feature/settings/SettingsScreen.kt"
    replace_all(
        path,
        'SettingSwitch("رویدادهای مهم سنی", milestones) { milestones = it; UserSettings.setMilestoneNotifications(context, it) }',
        'SettingSwitch("رویدادهای مهم سنی", milestones) { milestones = it; UserSettings.setMilestoneNotifications(context, it); ReminderScheduler.scheduleAll(context) }',
    )
    replace_once(
        path,
        '''ChoicePill("-", false, { reminderHour = (reminderHour - 1).coerceAtLeast(7); UserSettings.setReminderHour(context, reminderHour) }, Modifier.weight(1f))
                        ChoicePill("+", false, { reminderHour = (reminderHour + 1).coerceAtMost(22); UserSettings.setReminderHour(context, reminderHour) }, Modifier.weight(1f))''',
        '''ChoicePill("-", false, {
                            reminderHour = (reminderHour - 1).coerceAtLeast(7)
                            UserSettings.setReminderHour(context, reminderHour)
                            ReminderScheduler.scheduleAll(context)
                        }, Modifier.weight(1f))
                        ChoicePill("+", false, {
                            reminderHour = (reminderHour + 1).coerceAtMost(22)
                            UserSettings.setReminderHour(context, reminderHour)
                            ReminderScheduler.scheduleAll(context)
                        }, Modifier.weight(1f))''',
    )


def finalize_professional_tools() -> None:
    path = "app/src/main/java/ir/tarikhyar/app/feature/protools/ProfessionalToolsScreen.kt"
    replace_all(
        path,
        'onValueChange = { amountText = it.filter(Char::isDigit).take(6) },',
        'onValueChange = { amountText = normalizeNumericInput(it).take(6) },',
    )
    p = ROOT / path
    text = p.read_text(encoding="utf-8")
    helper = '''private fun normalizeNumericInput(value: String): String = buildString {
    value.forEach { ch ->
        when (ch) {
            in '0'..'9' -> append(ch)
            in '۰'..'۹' -> append(('0'.code + (ch.code - '۰'.code)).toChar())
            in '٠'..'٩' -> append(('0'.code + (ch.code - '٠'.code)).toChar())
        }
    }
}

'''
    if helper.strip() not in text:
        anchor = "private fun countWorkingDays(first: PersianDate, second: PersianDate): Int {"
        if anchor not in text:
            raise RuntimeError("Professional tools insertion anchor missing")
        p.write_text(text.replace(anchor, helper + anchor, 1), encoding="utf-8")


def finalize_widget_and_backup() -> None:
    widget_path = "app/src/main/java/ir/tarikhyar/app/widget/TarikhYarWidgetProvider.kt"
    p = ROOT / widget_path
    text = p.read_text(encoding="utf-8")
    if "import android.content.ComponentName" not in text:
        text = text.replace("import android.appwidget.AppWidgetProvider\n", "import android.appwidget.AppWidgetProvider\nimport android.content.ComponentName\n", 1)
    helper = '''        /** تمام نمونه‌های فعال ویجت را پس از تغییر داده‌های کاربر فوراً تازه می‌کند. */
        fun refreshAll(context: Context) {
            val manager = AppWidgetManager.getInstance(context)
            val component = ComponentName(context, TarikhYarWidgetProvider::class.java)
            manager.getAppWidgetIds(component).forEach { updateWidget(context, manager, it) }
        }

'''
    if "fun refreshAll(context: Context)" not in text:
        anchor = "    companion object {\n"
        if anchor not in text:
            raise RuntimeError("Widget companion object anchor missing")
        text = text.replace(anchor, anchor + helper, 1)
    p.write_text(text, encoding="utf-8")

    profiles_path = "app/src/main/java/ir/tarikhyar/app/feature/profiles/ProfilesScreen.kt"
    p = ROOT / profiles_path
    text = p.read_text(encoding="utf-8")
    if "import ir.tarikhyar.app.widget.TarikhYarWidgetProvider" not in text:
        text = text.replace(
            "import ir.tarikhyar.app.ui.components.shareText\n",
            "import ir.tarikhyar.app.ui.components.shareText\nimport ir.tarikhyar.app.widget.TarikhYarWidgetProvider\n",
            1,
        )
    text = text.replace(
        """    fun refresh() {
        profiles = LocalDataRepository.profiles(context)
    }""",
        """    fun refresh() {
        profiles = LocalDataRepository.profiles(context)
        TarikhYarWidgetProvider.refreshAll(context)
    }""",
    )
    p.write_text(text, encoding="utf-8")

    backup_path = "app/src/main/java/ir/tarikhyar/app/feature/backup/BackupScreen.kt"
    p = ROOT / backup_path
    text = p.read_text(encoding="utf-8")
    if "import ir.tarikhyar.app.core.system.ReminderScheduler" not in text:
        text = text.replace(
            "import ir.tarikhyar.app.core.system.BackupManager\n",
            "import ir.tarikhyar.app.core.system.BackupManager\nimport ir.tarikhyar.app.core.system.ReminderScheduler\n",
            1,
        )
    if "import ir.tarikhyar.app.widget.TarikhYarWidgetProvider" not in text:
        text = text.replace(
            "import ir.tarikhyar.app.ui.components.ResultCard\n",
            "import ir.tarikhyar.app.ui.components.ResultCard\nimport ir.tarikhyar.app.widget.TarikhYarWidgetProvider\n",
            1,
        )
    text = text.replace(
        '''                BackupManager.restoreEncrypted(context, bytes, password)
                "اطلاعات با موفقیت بازیابی شد. برای اعمال همه تنظیمات، برنامه را یک بار باز و بسته کنید."''',
        '''                BackupManager.restoreEncrypted(context, bytes, password)
                ReminderScheduler.scheduleAll(context)
                TarikhYarWidgetProvider.refreshAll(context)
                "اطلاعات با موفقیت بازیابی شد. تنظیمات ظاهری پس از بازکردن دوباره برنامه کاملاً اعمال می‌شوند."''',
    )
    p.write_text(text, encoding="utf-8")


def finalize_drawer() -> None:
    path = "app/src/main/java/ir/tarikhyar/app/ui/components/AppDrawer.kt"
    p = ROOT / path
    text = p.read_text(encoding="utf-8")
    if "import androidx.compose.foundation.layout.Row" not in text:
        text = text.replace("import androidx.compose.foundation.layout.Column\n", "import androidx.compose.foundation.layout.Column\nimport androidx.compose.foundation.layout.Row\n", 1)
    if "import androidx.compose.material3.AlertDialog" not in text:
        text = text.replace("import androidx.compose.material3.HorizontalDivider\n", "import androidx.compose.material3.AlertDialog\nimport androidx.compose.material3.HorizontalDivider\n", 1)
    if "import androidx.compose.material3.TextButton" not in text:
        text = text.replace("import androidx.compose.material3.Text\n", "import androidx.compose.material3.Text\nimport androidx.compose.material3.TextButton\n", 1)
    text = text.replace(
        "    var imageUri by remember { mutableStateOf(UserSettings.profileImageUri(context)) }\n    val imagePicker",
        "    var imageUri by remember { mutableStateOf(UserSettings.profileImageUri(context)) }\n    var showImageMenu by remember { mutableStateOf(false) }\n    val imagePicker",
    )
    text = text.replace(
        'onClick = { imagePicker.launch(arrayOf("image/*")) },',
        'onClick = { showImageMenu = true },',
    )
    text = text.replace(
        '''                    Spacer(Modifier.size(8.dp))
                    Text(UserSettings.displayName(context), style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Text("تاریخ‌یار • تقویم زندگی شما", color = MaterialTheme.colorScheme.onSurfaceVariant)''',
        '''                    Spacer(Modifier.size(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                    ) {
                        Icon(Icons.Rounded.Person, contentDescription = null, modifier = Modifier.size(20.dp), tint = MaterialTheme.colorScheme.primary)
                        Text(UserSettings.displayName(context), style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    }
                    Text("تاریخ‌یار • تقویم زندگی شما", color = MaterialTheme.colorScheme.onSurfaceVariant)''',
    )
    text = text.replace(
        '''            item { HorizontalDivider(Modifier.padding(vertical = 8.dp)) }
            item {
                NavigationDrawerItem(
                    label = { Text("معرفی به دوستان") },
                    selected = false,
                    onClick = onShare,
                    icon = { Icon(Icons.Rounded.Share, null) },
                )
            }
            item { DrawerItem("درباره ما", Icons.Rounded.SupervisorAccount, AppScreen.ABOUT_US, currentScreen, onNavigate) }
            item { DrawerItem("تماس با ما", Icons.Rounded.ContactMail, AppScreen.CONTACT_US, currentScreen, onNavigate) }
            item { DrawerItem("درباره نرم افزار", Icons.Rounded.Info, AppScreen.ABOUT_APP, currentScreen, onNavigate) }''',
        '''            item { HorizontalDivider(Modifier.padding(vertical = 8.dp)) }
            item { DrawerItem("ارتباط با ما", Icons.Rounded.ContactMail, AppScreen.CONTACT_US, currentScreen, onNavigate) }
            item {
                NavigationDrawerItem(
                    label = { Text("معرفی به دوستان") },
                    selected = false,
                    onClick = onShare,
                    icon = { Icon(Icons.Rounded.Share, null) },
                )
            }
            item { DrawerItem("درباره ما", Icons.Rounded.SupervisorAccount, AppScreen.ABOUT_US, currentScreen, onNavigate) }
            item { DrawerItem("درباره نرم افزار", Icons.Rounded.Info, AppScreen.ABOUT_APP, currentScreen, onNavigate) }''',
    )
    popup = '''
    if (showImageMenu) {
        AlertDialog(
            onDismissRequest = { showImageMenu = false },
            title = { Text("تصویر پروفایل") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("می‌توانی یک تصویر از دستگاه انتخاب کنی یا تصویر فعلی را حذف کنی.")
                    if (imageUri.isNotBlank()) {
                        TextButton(onClick = {
                            imageUri = ""
                            UserSettings.setProfileImageUri(context, "")
                            showImageMenu = false
                        }) { Text("حذف تصویر فعلی") }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    showImageMenu = false
                    imagePicker.launch(arrayOf("image/*"))
                }) { Text("انتخاب تصویر") }
            },
            dismissButton = { TextButton(onClick = { showImageMenu = false }) { Text("انصراف") } },
        )
    }
'''
    if "if (showImageMenu)" not in text:
        anchor = "    }\n}\n\n@Composable\nprivate fun DrawerItem("
        if anchor not in text:
            raise RuntimeError("Drawer popup insertion anchor missing")
        text = text.replace(anchor, "    }\n" + popup + "}\n\n@Composable\nprivate fun DrawerItem(", 1)
    p.write_text(text, encoding="utf-8")


def finalize_about() -> None:
    path = "app/src/main/java/ir/tarikhyar/app/feature/about/AboutScreens.kt"
    p = ROOT / path
    text = p.read_text(encoding="utf-8")
    if "import androidx.compose.foundation.layout.Spacer" not in text:
        text = text.replace("import androidx.compose.foundation.layout.PaddingValues\n", "import androidx.compose.foundation.layout.PaddingValues\nimport androidx.compose.foundation.layout.Spacer\n", 1)
    if "import androidx.compose.foundation.layout.height" not in text:
        text = text.replace("import androidx.compose.foundation.layout.fillMaxWidth\n", "import androidx.compose.foundation.layout.fillMaxWidth\nimport androidx.compose.foundation.layout.height\n", 1)
    if "import androidx.compose.material3.HorizontalDivider" not in text:
        text = text.replace("import androidx.compose.material3.MaterialTheme\n", "import androidx.compose.material3.HorizontalDivider\nimport androidx.compose.material3.MaterialTheme\n", 1)
    text = text.replace("گروه توسعه و برنامه نویسی AS Team", "گروه توسعه فناوری و نرم افزاری as Team")
    text = text.replace('val supportEmail = "as.team.support@gmail.com"', 'val supportEmail = "AS.Support.info@Gmail.com"')
    old = '''        InfoList {
            Text(
                text = "گروه توسعه فناوری و نرم افزاری as Team",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "ایمیل پشتیبانی",
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
            Text(
                text = supportEmail,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            PrimaryButton("ارسال ایمیل") {
                // ACTION_SENDTO فقط برنامه‌های ایمیل را برای آدرس پشتیبانی پیشنهاد می‌کند.
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:$supportEmail")
                    putExtra(Intent.EXTRA_SUBJECT, "پشتیبانی تاریخ‌یار")
                }
                try {
                    context.startActivity(intent)
                } catch (_: ActivityNotFoundException) {
                    // اگر برنامه ایمیل روی دستگاه نصب نباشد، صفحه بدون Crash باقی می‌ماند.
                }
            }
        }'''
    new = '''        InfoList {
            Text(
                text = "برای پیشنهاد، گزارش خطا یا ارتباط با پشتیبانی تاریخ‌یار از ایمیل زیر استفاده کنید.",
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
            Text(
                text = supportEmail,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            PrimaryButton("ارسال ایمیل") {
                // ACTION_SENDTO فقط برنامه‌های ایمیل را برای آدرس پشتیبانی پیشنهاد می‌کند.
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:$supportEmail")
                    putExtra(Intent.EXTRA_SUBJECT, "پشتیبانی تاریخ‌یار")
                }
                try {
                    context.startActivity(intent)
                } catch (_: ActivityNotFoundException) {
                    // اگر برنامه ایمیل روی دستگاه نصب نباشد، صفحه بدون Crash باقی می‌ماند.
                }
            }
            Spacer(Modifier.height(48.dp))
            HorizontalDivider()
            Text(
                text = "گروه توسعه فناوری و نرم افزاری as Team",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                text = supportEmail,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        }'''
    if old in text:
        text = text.replace(old, new, 1)
    p.write_text(text, encoding="utf-8")


def main() -> None:
    finalize_reminders()
    finalize_settings()
    finalize_professional_tools()
    finalize_widget_and_backup()
    finalize_drawer()
    finalize_about()
    print("TarikhYar 2.0 final QA fixes applied.")


if __name__ == "__main__":
    main()
