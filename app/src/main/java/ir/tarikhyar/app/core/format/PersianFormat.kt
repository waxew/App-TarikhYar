package ir.tarikhyar.app.core.format

import ir.tarikhyar.app.core.date.PersianDate
import java.text.DecimalFormat
import java.time.DayOfWeek
import java.time.LocalDate

object PersianFormat {
    private const val latinDigits = "0123456789"
    private const val persianDigits = "۰۱۲۳۴۵۶۷۸۹"

    fun digits(value: Any): String = value.toString().map { ch ->
        val index = latinDigits.indexOf(ch)
        if (index >= 0) persianDigits[index] else ch
    }.joinToString("")

    fun number(value: Long): String = digits(DecimalFormat("#,###").format(value))

    fun persianDate(date: PersianDate): String =
        "${digits(date.day)} ${date.monthName} ${digits(date.year)}"

    fun persianNumeric(date: PersianDate): String =
        "${digits(date.year)}/${digits(date.month.toString().padStart(2, '0'))}/${digits(date.day.toString().padStart(2, '0'))}"

    fun gregorian(date: LocalDate): String =
        "${date.year}/${date.monthValue.toString().padStart(2, '0')}/${date.dayOfMonth.toString().padStart(2, '0')}"

    fun weekday(day: DayOfWeek): String = when (day) {
        DayOfWeek.SATURDAY -> "شنبه"
        DayOfWeek.SUNDAY -> "یکشنبه"
        DayOfWeek.MONDAY -> "دوشنبه"
        DayOfWeek.TUESDAY -> "سه‌شنبه"
        DayOfWeek.WEDNESDAY -> "چهارشنبه"
        DayOfWeek.THURSDAY -> "پنجشنبه"
        DayOfWeek.FRIDAY -> "جمعه"
    }
}
