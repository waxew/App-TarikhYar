package ir.tarikhyar.app.core.date

import java.time.DayOfWeek

/** Centralized business rules for age, date difference and date arithmetic. */
object DateCalculations {
    data class PersianPeriod(val years: Int, val months: Int, val days: Long)

    data class AgeResult(
        val period: PersianPeriod,
        val totalDays: Long,
        val totalWeeks: Long,
        val completedMonths: Long,
        val nextBirthdayDays: Long,
        val birthWeekday: DayOfWeek,
    )

    data class DifferenceResult(
        val period: PersianPeriod,
        val totalDays: Long,
        val reversedInput: Boolean,
    )

    enum class Unit { DAYS, WEEKS, MONTHS, YEARS }

    fun calculateAge(birthDate: PersianDate, today: PersianDate): AgeResult {
        require(PersianCalendar.isValid(birthDate) && PersianCalendar.isValid(today))
        require(PersianCalendar.compare(birthDate, today) <= 0) { "Birth date cannot be in the future" }

        val period = periodBetween(birthDate, today)
        val totalDays = PersianCalendar.daysBetween(birthDate, today)
        val nextBirthday = nextBirthday(birthDate, today)
        val nextBirthdayDays = PersianCalendar.daysBetween(today, nextBirthday)

        return AgeResult(
            period = period,
            totalDays = totalDays,
            totalWeeks = totalDays / 7,
            completedMonths = period.years.toLong() * 12L + period.months,
            nextBirthdayDays = nextBirthdayDays,
            birthWeekday = PersianCalendar.toGregorian(birthDate).dayOfWeek,
        )
    }

    fun difference(first: PersianDate, second: PersianDate): DifferenceResult {
        require(PersianCalendar.isValid(first) && PersianCalendar.isValid(second))
        val reversed = PersianCalendar.compare(first, second) > 0
        val start = if (reversed) second else first
        val end = if (reversed) first else second
        val totalDays = PersianCalendar.daysBetween(start, end)

        return DifferenceResult(
            period = periodBetween(start, end),
            totalDays = totalDays,
            reversedInput = reversed,
        )
    }

    fun add(date: PersianDate, amount: Long, unit: Unit): PersianDate = when (unit) {
        Unit.DAYS -> PersianCalendar.addDays(date, amount)
        Unit.WEEKS -> PersianCalendar.addDays(date, amount * 7L)
        Unit.MONTHS -> PersianCalendar.addMonths(date, amount)
        Unit.YEARS -> PersianCalendar.addYears(date, amount)
    }

    /**
     * Returns a calendar-aware Persian period by finding the largest whole year/month
     * anchors and then measuring the remaining exact number of days.
     */
    fun periodBetween(start: PersianDate, end: PersianDate): PersianPeriod {
        require(PersianCalendar.compare(start, end) <= 0)

        var years = end.year - start.year
        var yearAnchor = PersianCalendar.addYears(start, years.toLong())
        if (PersianCalendar.compare(yearAnchor, end) > 0) {
            years -= 1
            yearAnchor = PersianCalendar.addYears(start, years.toLong())
        }

        var months = (end.year - yearAnchor.year) * 12 + (end.month - yearAnchor.month)
        var monthAnchor = PersianCalendar.addMonths(yearAnchor, months.toLong())
        if (PersianCalendar.compare(monthAnchor, end) > 0) {
            months -= 1
            monthAnchor = PersianCalendar.addMonths(yearAnchor, months.toLong())
        }

        val days = PersianCalendar.daysBetween(monthAnchor, end)
        return PersianPeriod(years, months, days)
    }

    private fun nextBirthday(birthDate: PersianDate, today: PersianDate): PersianDate {
        fun candidate(year: Int): PersianDate {
            val validDay = birthDate.day.coerceAtMost(PersianCalendar.monthLength(year, birthDate.month))
            return PersianDate(year, birthDate.month, validDay)
        }

        val thisYear = candidate(today.year)
        return if (PersianCalendar.compare(thisYear, today) >= 0) {
            thisYear
        } else {
            candidate(today.year + 1)
        }
    }
}
