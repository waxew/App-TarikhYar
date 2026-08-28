// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.core.system

// راهنما: این import وابستگی «android.content.Context» را برای استفاده در این فایل وارد می‌کند.
import android.content.Context

/** حالت رنگ برنامه را بین سیستم، روشن و تیره مشخص می‌کند. */
// راهنما: این enum مجموعه محدود و مشخصی از حالت‌های قابل استفاده را تعریف می‌کند.
enum class ThemeMode { SYSTEM, LIGHT, DARK }

/** سبک رنگی کارت خروجی و UI را مشخص می‌کند. */
// راهنما: این enum مجموعه محدود و مشخصی از حالت‌های قابل استفاده را تعریف می‌کند.
enum class AccentStyle { RED, ROSE, AMBER }

/** قالب کارت تصویری قابل اشتراک را مشخص می‌کند. */
// راهنما: این enum مجموعه محدود و مشخصی از حالت‌های قابل استفاده را تعریف می‌کند.
enum class CardTemplate { CLASSIC, SOFT, DARK }

/** مجموعه آیکن‌های رابط را بین گرافیکی و مینیمال تغییر می‌دهد. */
// راهنما: این enum مجموعه محدود و مشخصی از حالت‌های قابل استفاده را تعریف می‌کند.
enum class IconStyle { GRAPHIC, MINIMAL }

/** تنظیمات شخصی‌سازی و اعلان را در SharedPreferences نگهداری می‌کند. */
// راهنما: این object یک نمونه Singleton برای سرویس یا داده مشترک برنامه ایجاد می‌کند.
object UserSettings {
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    private const val PREFS = "tarikhyar_settings"

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun themeMode(context: Context): ThemeMode = enumValue(
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        context,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        "theme_mode",
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ThemeMode.SYSTEM,
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    )

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun setThemeMode(context: Context, value: ThemeMode) = putString(context, "theme_mode", value.name)

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun accentStyle(context: Context): AccentStyle = enumValue(context, "accent_style", AccentStyle.RED)
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun setAccentStyle(context: Context, value: AccentStyle) = putString(context, "accent_style", value.name)

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun cardTemplate(context: Context): CardTemplate = enumValue(context, "card_template", CardTemplate.CLASSIC)
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun iconStyle(context: Context): IconStyle = enumValue(context, "icon_style", IconStyle.GRAPHIC)
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun setIconStyle(context: Context, value: IconStyle) = putString(context, "icon_style", value.name)
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun setCardTemplate(context: Context, value: CardTemplate) = putString(context, "card_template", value.name)

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun fontScale(context: Context): Float = prefs(context).getFloat("font_scale", 1f).coerceIn(0.9f, 1.2f)
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun setFontScale(context: Context, value: Float) = prefs(context).edit().putFloat("font_scale", value.coerceIn(0.9f, 1.2f)).apply()

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun displayName(context: Context): String = prefs(context).getString("display_name", "کاربر تاریخ‌یار") ?: "کاربر تاریخ‌یار"
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun setDisplayName(context: Context, value: String) = putString(context, "display_name", value.trim().ifBlank { "کاربر تاریخ‌یار" })

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun profileImageUri(context: Context): String = prefs(context).getString("profile_image_uri", "") ?: ""
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun setProfileImageUri(context: Context, value: String) = putString(context, "profile_image_uri", value)

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun birthdayNotifications(context: Context): Boolean = prefs(context).getBoolean("birthday_notifications", true)
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun setBirthdayNotifications(context: Context, value: Boolean) = prefs(context).edit().putBoolean("birthday_notifications", value).apply()

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun eventNotifications(context: Context): Boolean = prefs(context).getBoolean("event_notifications", true)
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun setEventNotifications(context: Context, value: Boolean) = prefs(context).edit().putBoolean("event_notifications", value).apply()

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun milestoneNotifications(context: Context): Boolean = prefs(context).getBoolean("milestone_notifications", true)
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun setMilestoneNotifications(context: Context, value: Boolean) = prefs(context).edit().putBoolean("milestone_notifications", value).apply()

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun updateNotifications(context: Context): Boolean = prefs(context).getBoolean("update_notifications", true)
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun setUpdateNotifications(context: Context, value: Boolean) = prefs(context).edit().putBoolean("update_notifications", value).apply()

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun reminderHour(context: Context): Int = prefs(context).getInt("reminder_hour", 9).coerceIn(7, 22)
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun setReminderHour(context: Context, value: Int) = prefs(context).edit().putInt("reminder_hour", value.coerceIn(7, 22)).apply()

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun settingsSnapshot(context: Context): Map<String, *> = prefs(context).all

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun restoreSettings(context: Context, values: Map<String, Any?>) {
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val editor = prefs(context).edit().clear()
        // راهنما: این حلقه مجموعه‌ای از مقادیر را پیمایش و دستورهای داخل خود را تکرار می‌کند.
        for ((key, value) in values) {
            // راهنما: این when بر اساس مقدار ورودی یکی از مسیرهای مشخص را انتخاب می‌کند.
            when (value) {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                is Boolean -> editor.putBoolean(key, value)
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                is Int -> editor.putInt(key, value)
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                is Long -> editor.putLong(key, value)
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                is Float -> editor.putFloat(key, value)
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                is String -> editor.putString(key, value)
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        editor.apply()
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    private inline fun <reified T : Enum<T>> enumValue(context: Context, key: String, fallback: T): T {
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val raw = prefs(context).getString(key, fallback.name) ?: fallback.name
        // راهنما: این return نتیجه تابع را برمی‌گرداند و اجرای همان تابع را پایان می‌دهد.
        return enumValues<T>().firstOrNull { it.name == raw } ?: fallback
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    private fun putString(context: Context, key: String, value: String) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        prefs(context).edit().putString(key, value).apply()
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    private fun prefs(context: Context) = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
