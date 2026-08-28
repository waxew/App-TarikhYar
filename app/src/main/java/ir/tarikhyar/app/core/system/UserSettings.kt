package ir.tarikhyar.app.core.system

import android.content.Context

/** حالت رنگ برنامه را بین سیستم، روشن و تیره مشخص می‌کند. */
enum class ThemeMode { SYSTEM, LIGHT, DARK }

/** سبک رنگی کارت خروجی و UI را مشخص می‌کند. */
enum class AccentStyle { RED, ROSE, AMBER }

/** قالب کارت تصویری قابل اشتراک را مشخص می‌کند. */
enum class CardTemplate { CLASSIC, SOFT, DARK }

/** مجموعه آیکن‌های رابط را بین گرافیکی و مینیمال تغییر می‌دهد. */
enum class IconStyle { GRAPHIC, MINIMAL }

/** تنظیمات شخصی‌سازی و اعلان را در SharedPreferences نگهداری می‌کند. */
object UserSettings {
    private const val PREFS = "tarikhyar_settings"

    fun themeMode(context: Context): ThemeMode = enumValue(
        context,
        "theme_mode",
        ThemeMode.SYSTEM,
    )

    fun setThemeMode(context: Context, value: ThemeMode) = putString(context, "theme_mode", value.name)

    fun accentStyle(context: Context): AccentStyle = enumValue(context, "accent_style", AccentStyle.RED)
    fun setAccentStyle(context: Context, value: AccentStyle) = putString(context, "accent_style", value.name)

    fun cardTemplate(context: Context): CardTemplate = enumValue(context, "card_template", CardTemplate.CLASSIC)
    fun iconStyle(context: Context): IconStyle = enumValue(context, "icon_style", IconStyle.GRAPHIC)
    fun setIconStyle(context: Context, value: IconStyle) = putString(context, "icon_style", value.name)
    fun setCardTemplate(context: Context, value: CardTemplate) = putString(context, "card_template", value.name)

    fun fontScale(context: Context): Float = prefs(context).getFloat("font_scale", 1f).coerceIn(0.9f, 1.2f)
    fun setFontScale(context: Context, value: Float) = prefs(context).edit().putFloat("font_scale", value.coerceIn(0.9f, 1.2f)).apply()

    fun displayName(context: Context): String = prefs(context).getString("display_name", "کاربر تاریخ‌یار") ?: "کاربر تاریخ‌یار"
    fun setDisplayName(context: Context, value: String) = putString(context, "display_name", value.trim().ifBlank { "کاربر تاریخ‌یار" })

    fun profileImageUri(context: Context): String = prefs(context).getString("profile_image_uri", "") ?: ""
    fun setProfileImageUri(context: Context, value: String) = putString(context, "profile_image_uri", value)

    fun birthdayNotifications(context: Context): Boolean = prefs(context).getBoolean("birthday_notifications", true)
    fun setBirthdayNotifications(context: Context, value: Boolean) = prefs(context).edit().putBoolean("birthday_notifications", value).apply()

    fun eventNotifications(context: Context): Boolean = prefs(context).getBoolean("event_notifications", true)
    fun setEventNotifications(context: Context, value: Boolean) = prefs(context).edit().putBoolean("event_notifications", value).apply()

    fun milestoneNotifications(context: Context): Boolean = prefs(context).getBoolean("milestone_notifications", true)
    fun setMilestoneNotifications(context: Context, value: Boolean) = prefs(context).edit().putBoolean("milestone_notifications", value).apply()

    fun updateNotifications(context: Context): Boolean = prefs(context).getBoolean("update_notifications", true)
    fun setUpdateNotifications(context: Context, value: Boolean) = prefs(context).edit().putBoolean("update_notifications", value).apply()

    fun reminderHour(context: Context): Int = prefs(context).getInt("reminder_hour", 9).coerceIn(7, 22)
    fun setReminderHour(context: Context, value: Int) = prefs(context).edit().putInt("reminder_hour", value.coerceIn(7, 22)).apply()

    fun settingsSnapshot(context: Context): Map<String, *> = prefs(context).all

    fun restoreSettings(context: Context, values: Map<String, Any?>) {
        val editor = prefs(context).edit().clear()
        for ((key, value) in values) {
            when (value) {
                is Boolean -> editor.putBoolean(key, value)
                is Int -> editor.putInt(key, value)
                is Long -> editor.putLong(key, value)
                is Float -> editor.putFloat(key, value)
                is String -> editor.putString(key, value)
            }
        }
        editor.apply()
    }

    private inline fun <reified T : Enum<T>> enumValue(context: Context, key: String, fallback: T): T {
        val raw = prefs(context).getString(key, fallback.name) ?: fallback.name
        return enumValues<T>().firstOrNull { it.name == raw } ?: fallback
    }

    private fun putString(context: Context, key: String, value: String) {
        prefs(context).edit().putString(key, value).apply()
    }

    private fun prefs(context: Context) = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
}
