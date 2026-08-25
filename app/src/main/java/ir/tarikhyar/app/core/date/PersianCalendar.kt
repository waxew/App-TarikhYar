package ir.tarikhyar.app.core.date

import java.time.LocalDate
import kotlin.math.min

/**
 * Pure offline Jalali <-> Gregorian conversion engine.
 *
 * The algorithm uses the established Jalali leap-year breakpoints and Julian-day
 * conversion, so it does not depend on a server, locale package or third-party SDK.
 */
object PersianCalendar {
    private val breaks = intArrayOf(
        -61, 9, 38, 199, 426, 686, 756, 818, 1111, 1181,
        1210, 1635, 2060, 2097, 2192, 2262, 2324, 2394, 2456, 3178
    )

    private data class JalCalResult(val leap: Int, val gregorianYear: Int, val marchDay: Int)
    private data class GregorianParts(val year: Int, val month: Int, val day: Int)

    fun isValid(date: PersianDate): Boolean {
        if (date.year < breaks.first() || date.year >= breaks.last()) return false
        if (date.month !in 1..12) return false
        return date.day in 1..monthLength(date.year, date.month)
    }

    fun isLeapYear(year: Int): Boolean = jalCal(year).leap == 0

    fun monthLength(year: Int, month: Int): Int = when (month) {
        in 1..6 -> 31
        in 7..11 -> 30
        12 -> if (isLeapYear(year)) 30 else 29
        else -> 0
    }

    fun toGregorian(date: PersianDate): LocalDate {
        require(isValid(date)) { "Invalid Persian date: $date" }
        val parts = d2g(j2d(date.year, date.month, date.day))
        return LocalDate.of(parts.year, parts.month, parts.day)
    }

    fun fromGregorian(date: LocalDate): PersianDate {
        return d2j(g2d(date.year, date.monthValue, date.dayOfMonth))
    }

    fun compare(first: PersianDate, second: PersianDate): Int {
        require(isValid(first) && isValid(second))
        return j2d(first.year, first.month, first.day)
            .compareTo(j2d(second.year, second.month, second.day))
    }

    fun daysBetween(start: PersianDate, end: PersianDate): Long {
        require(isValid(start) && isValid(end))
        return (j2d(end.year, end.month, end.day) - j2d(start.year, start.month, start.day)).toLong()
    }

    fun addDays(date: PersianDate, days: Long): PersianDate {
        require(isValid(date))
        val targetJdn = j2d(date.year, date.month, date.day).toLong() + days
        require(targetJdn in Int.MIN_VALUE.toLong()..Int.MAX_VALUE.toLong())
        return d2j(targetJdn.toInt())
    }

    fun addMonths(date: PersianDate, months: Long): PersianDate {
        require(isValid(date))
        val totalMonths = date.year.toLong() * 12L + (date.month - 1) + months
        val targetYear = Math.floorDiv(totalMonths, 12L).toInt()
        val targetMonth = Math.floorMod(totalMonths, 12L).toInt() + 1
        require(targetYear >= breaks.first() && targetYear < breaks.last())
        val targetDay = min(date.day, monthLength(targetYear, targetMonth))
        return PersianDate(targetYear, targetMonth, targetDay)
    }

    fun addYears(date: PersianDate, years: Long): PersianDate {
        require(isValid(date))
        val targetYearLong = date.year.toLong() + years
        require(targetYearLong in breaks.first().toLong() until breaks.last().toLong())
        val targetYear = targetYearLong.toInt()
        val targetDay = min(date.day, monthLength(targetYear, date.month))
        return PersianDate(targetYear, date.month, targetDay)
    }

    private fun jalCal(jy: Int): JalCalResult {
        val bl = breaks.size
        val gy = jy + 621
        var leapJ = -14
        var jp = breaks[0]
        var jump = 0

        require(jy >= jp && jy < breaks[bl - 1]) { "Invalid Jalali year: $jy" }

        for (j in 1 until bl) {
            val jm = breaks[j]
            jump = jm - jp
            if (jy < jm) break
            leapJ += div(jump, 33) * 8 + div(mod(jump, 33), 4)
            jp = jm
        }

        var n = jy - jp
        leapJ += div(n, 33) * 8 + div(mod(n, 33) + 3, 4)
        if (mod(jump, 33) == 4 && jump - n == 4) leapJ += 1

        val leapG = div(gy, 4) - div((div(gy, 100) + 1) * 3, 4) - 150
        val march = 20 + leapJ - leapG

        if (jump - n < 6) {
            n = n - jump + div(jump + 4, 33) * 33
        }

        var leap = mod(mod(n + 1, 33) - 1, 4)
        if (leap == -1) leap = 4

        return JalCalResult(leap, gy, march)
    }

    private fun j2d(jy: Int, jm: Int, jd: Int): Int {
        val r = jalCal(jy)
        return g2d(r.gregorianYear, 3, r.marchDay) +
            (jm - 1) * 31 - div(jm, 7) * (jm - 7) + jd - 1
    }

    private fun d2j(jdn: Int): PersianDate {
        val g = d2g(jdn)
        var jy = g.year - 621
        val r = jalCal(jy)
        val jdn1f = g2d(g.year, 3, r.marchDay)
        var k = jdn - jdn1f

        if (k >= 0) {
            if (k <= 185) {
                val jm = 1 + div(k, 31)
                val jd = mod(k, 31) + 1
                return PersianDate(jy, jm, jd)
            }
            k -= 186
        } else {
            jy -= 1
            k += 179
            if (r.leap == 1) k += 1
        }

        val jm = 7 + div(k, 30)
        val jd = mod(k, 30) + 1
        return PersianDate(jy, jm, jd)
    }

    private fun g2d(gy: Int, gm: Int, gd: Int): Int {
        var d = div(
            (gy + div(gm - 8, 6) + 100100) * 1461,
            4
        ) + div(153 * mod(gm + 9, 12) + 2, 5) + gd - 34840408

        d = d - div(div(gy + 100100 + div(gm - 8, 6), 100) * 3, 4) + 752
        return d
    }

    private fun d2g(jdn: Int): GregorianParts {
        var j = 4 * jdn + 139361631
        j = j + div(div(4 * jdn + 183187720, 146097) * 3, 4) * 4 - 3908
        val i = div(mod(j, 1461), 4) * 5 + 308
        val gd = div(mod(i, 153), 5) + 1
        val gm = mod(div(i, 153), 12) + 1
        val gy = div(j, 1461) - 100100 + div(8 - gm, 6)
        return GregorianParts(gy, gm, gd)
    }

    // Kotlin integer division truncates toward zero, matching the original arithmetic rules.
    private fun div(a: Int, b: Int): Int = a / b
    private fun mod(a: Int, b: Int): Int = a - (a / b) * b
}
