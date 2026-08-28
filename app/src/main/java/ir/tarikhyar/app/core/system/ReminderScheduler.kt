package ir.tarikhyar.app.core.system

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import ir.tarikhyar.app.core.data.LocalDataRepository
import ir.tarikhyar.app.core.data.PersonProfile
import ir.tarikhyar.app.core.data.PersonalEvent
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.date.PersianDate
import java.time.LocalDateTime
import java.time.ZoneId

/** زمان‌بندی یادآوری‌های محلی تولد و مناسبت بدون نیاز به سرور انجام می‌شود. */
object ReminderScheduler {
    private const val ACTION = "ir.tarikhyar.app.REMINDER"

    fun scheduleAll(context: Context) {
        if (UserSettings.birthdayNotifications(context)) {
            LocalDataRepository.profiles(context)
                .filter { it.reminderEnabled }
                .forEach { scheduleProfile(context, it) }
        }
        if (UserSettings.eventNotifications(context)) {
            LocalDataRepository.events(context)
                .filter { it.reminderEnabled }
                .forEach { scheduleEvent(context, it) }
        }
        if (UserSettings.milestoneNotifications(context)) {
            LocalDataRepository.profiles(context).forEach { scheduleMilestone(context, it) }
        }
    }

    fun scheduleProfile(context: Context, profile: PersonProfile) {
        if (!UserSettings.birthdayNotifications(context)) return
        val today = PersianCalendar.fromGregorian(java.time.LocalDate.now())
        val thisYearDay = profile.birthDate.day.coerceAtMost(PersianCalendar.monthLength(today.year, profile.birthDate.month))
        var target = PersianDate(today.year, profile.birthDate.month, thisYearDay)
        if (PersianCalendar.compare(target, today) < 0) {
            val nextYear = today.year + 1
            target = PersianDate(
                nextYear,
                profile.birthDate.month,
                profile.birthDate.day.coerceAtMost(PersianCalendar.monthLength(nextYear, profile.birthDate.month)),
            )
        }
        schedule(
            context = context,
            requestCode = stableCode("profile:${profile.id}"),
            target = target,
            title = "یادآوری تولد ${profile.name}",
            text = "امروز تولد ${profile.name} است 🎂",
            type = "profile",
            itemId = profile.id,
        )
    }

    fun scheduleEvent(context: Context, event: PersonalEvent) {
        if (!UserSettings.eventNotifications(context)) return
        val today = PersianCalendar.fromGregorian(java.time.LocalDate.now())
        if (PersianCalendar.compare(event.date, today) < 0) return
        schedule(
            context = context,
            requestCode = stableCode("event:${event.id}"),
            target = event.date,
            title = "یادآوری ${event.title}",
            text = event.note.ifBlank { "امروز ${event.title} است." },
            type = "event",
            itemId = event.id,
        )
    }

    private fun scheduleMilestone(context: Context, profile: PersonProfile) {
        val today = PersianCalendar.fromGregorian(java.time.LocalDate.now())
        val milestones = listOf(
            4 to "آمادگی پیش‌دبستانی ۱",
            5 to "آمادگی پیش‌دبستانی ۲",
            6 to "رسیدن به سن شروع دبستان",
            18 to "رسیدن به ۱۸ سالگی",
        )
        val next = milestones
            .map { (age, title) -> Triple(age, title, PersianCalendar.addYears(profile.birthDate, age.toLong())) }
            .firstOrNull { (_, _, date) -> PersianCalendar.compare(date, today) >= 0 }
            ?: return
        val (age, title, date) = next
        schedule(
            context = context,
            requestCode = stableCode("milestone:${profile.id}:$age"),
            target = date,
            title = "رویداد سنی ${profile.name}",
            text = "$title برای ${profile.name} فرا رسیده است.",
            type = "milestone",
            itemId = profile.id,
        )
    }

    private fun schedule(
        context: Context,
        requestCode: Int,
        target: PersianDate,
        title: String,
        text: String,
        type: String,
        itemId: String,
    ) {
        if (!AppPreferences.notificationsEnabled(context)) return
        val gregorian = PersianCalendar.toGregorian(target)
        val dateTime = LocalDateTime.of(
            gregorian.year,
            gregorian.monthValue,
            gregorian.dayOfMonth,
            UserSettings.reminderHour(context),
            0,
        )
        val millis = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
        if (millis <= System.currentTimeMillis()) return

        val intent = Intent(context, ReminderReceiver::class.java).apply {
            action = ACTION
            putExtra("title", title)
            putExtra("text", text)
            putExtra("type", type)
            putExtra("itemId", itemId)
        }
        val pending = PendingIntent.getBroadcast(
            context,
            requestCode,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
        )
        val alarmManager = context.getSystemService(AlarmManager::class.java)
        alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, millis, pending)
    }

    private fun stableCode(value: String): Int = value.hashCode() and 0x7fffffff
}

/** Receiver یادآوری را نمایش می‌دهد و تولد سالانه را برای سال بعد دوباره زمان‌بندی می‌کند. */
class ReminderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val type = intent.getStringExtra("type").orEmpty()
        val id = intent.getStringExtra("itemId").orEmpty()
        val allowed = when (type) {
            "profile" -> UserSettings.birthdayNotifications(context) &&
                LocalDataRepository.profiles(context).any { it.id == id && it.reminderEnabled }
            "event" -> UserSettings.eventNotifications(context) &&
                LocalDataRepository.events(context).any { it.id == id && it.reminderEnabled }
            "milestone" -> UserSettings.milestoneNotifications(context)
            else -> true
        }
        if (!allowed) return

        val title = intent.getStringExtra("title") ?: "یادآوری تاریخ‌یار"
        val text = intent.getStringExtra("text") ?: "یک رویداد برای امروز دارید."
        NotificationHelper.showReminder(context, title, text)

        if (type == "profile") {
            LocalDataRepository.profiles(context).firstOrNull { it.id == id }?.let {
                ReminderScheduler.scheduleProfile(context, it)
            }
        }
    }
}

/** پس از روشن‌شدن مجدد دستگاه، Alarmهای محلی از روی داده‌های ذخیره‌شده بازسازی می‌شوند. */
class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            ReminderScheduler.scheduleAll(context)
        }
    }
}
