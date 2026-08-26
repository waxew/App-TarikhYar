// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.core.date

// راهنما: این import وابستگی «java.time.DayOfWeek» را برای استفاده در این فایل وارد می‌کند.
import java.time.DayOfWeek

/** Centralized business rules for age, date difference and date arithmetic. */
// راهنما: این object یک نمونه Singleton برای سرویس یا داده مشترک برنامه ایجاد می‌کند.
object DateCalculations {
    // راهنما: این data class یک مدل داده سبک برای نگهداری مقادیر مرتبط تعریف می‌کند.
    data class PersianPeriod(val years: Int, val months: Int, val days: Long)

    // راهنما: این data class یک مدل داده سبک برای نگهداری مقادیر مرتبط تعریف می‌کند.
    data class AgeResult(
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val period: PersianPeriod,
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val totalDays: Long,
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val totalWeeks: Long,
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val completedMonths: Long,
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val nextBirthdayDays: Long,
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val birthWeekday: DayOfWeek,
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    )

    // راهنما: این data class یک مدل داده سبک برای نگهداری مقادیر مرتبط تعریف می‌کند.
    data class DifferenceResult(
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val period: PersianPeriod,
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val totalDays: Long,
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val reversedInput: Boolean,
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    )

    // راهنما: این enum مجموعه محدود و مشخصی از حالت‌های قابل استفاده را تعریف می‌کند.
    enum class Unit { DAYS, WEEKS, MONTHS, YEARS }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun calculateAge(birthDate: PersianDate, today: PersianDate): AgeResult {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        require(PersianCalendar.isValid(birthDate) && PersianCalendar.isValid(today))
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        require(PersianCalendar.compare(birthDate, today) <= 0) { "Birth date cannot be in the future" }

        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val period = periodBetween(birthDate, today)
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val totalDays = PersianCalendar.daysBetween(birthDate, today)
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val nextBirthday = nextBirthday(birthDate, today)
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val nextBirthdayDays = PersianCalendar.daysBetween(today, nextBirthday)

        // راهنما: این return نتیجه تابع را برمی‌گرداند و اجرای همان تابع را پایان می‌دهد.
        return AgeResult(
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            period = period,
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            totalDays = totalDays,
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            totalWeeks = totalDays / 7,
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            completedMonths = period.years.toLong() * 12L + period.months,
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            nextBirthdayDays = nextBirthdayDays,
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            birthWeekday = PersianCalendar.toGregorian(birthDate).dayOfWeek,
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        )
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun difference(first: PersianDate, second: PersianDate): DifferenceResult {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        require(PersianCalendar.isValid(first) && PersianCalendar.isValid(second))
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val reversed = PersianCalendar.compare(first, second) > 0
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val start = if (reversed) second else first
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val end = if (reversed) first else second
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val totalDays = PersianCalendar.daysBetween(start, end)

        // راهنما: این return نتیجه تابع را برمی‌گرداند و اجرای همان تابع را پایان می‌دهد.
        return DifferenceResult(
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            period = periodBetween(start, end),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            totalDays = totalDays,
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            reversedInput = reversed,
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        )
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun add(date: PersianDate, amount: Long, unit: Unit): PersianDate = when (unit) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        Unit.DAYS -> PersianCalendar.addDays(date, amount)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        Unit.WEEKS -> PersianCalendar.addDays(date, amount * 7L)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        Unit.MONTHS -> PersianCalendar.addMonths(date, amount)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        Unit.YEARS -> PersianCalendar.addYears(date, amount)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    /**
     * Returns a calendar-aware Persian period by finding the largest whole year/month
     * anchors and then measuring the remaining exact number of days.
     */
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun periodBetween(start: PersianDate, end: PersianDate): PersianPeriod {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        require(PersianCalendar.compare(start, end) <= 0)

        // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
        var years = end.year - start.year
        // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
        var yearAnchor = PersianCalendar.addYears(start, years.toLong())
        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
        if (PersianCalendar.compare(yearAnchor, end) > 0) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            years -= 1
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            yearAnchor = PersianCalendar.addYears(start, years.toLong())
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
        var months = (end.year - yearAnchor.year) * 12 + (end.month - yearAnchor.month)
        // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
        var monthAnchor = PersianCalendar.addMonths(yearAnchor, months.toLong())
        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
        if (PersianCalendar.compare(monthAnchor, end) > 0) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            months -= 1
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            monthAnchor = PersianCalendar.addMonths(yearAnchor, months.toLong())
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val days = PersianCalendar.daysBetween(monthAnchor, end)
        // راهنما: این return نتیجه تابع را برمی‌گرداند و اجرای همان تابع را پایان می‌دهد.
        return PersianPeriod(years, months, days)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    private fun nextBirthday(birthDate: PersianDate, today: PersianDate): PersianDate {
        // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
        fun candidate(year: Int): PersianDate {
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val validDay = birthDate.day.coerceAtMost(PersianCalendar.monthLength(year, birthDate.month))
            // راهنما: این return نتیجه تابع را برمی‌گرداند و اجرای همان تابع را پایان می‌دهد.
            return PersianDate(year, birthDate.month, validDay)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val thisYear = candidate(today.year)
        // راهنما: این return نتیجه تابع را برمی‌گرداند و اجرای همان تابع را پایان می‌دهد.
        return if (PersianCalendar.compare(thisYear, today) >= 0) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            thisYear
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        } else {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            candidate(today.year + 1)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
