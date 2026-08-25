import ir.tarikhyar.app.core.date.DateCalculations
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.date.PersianDate
import java.time.LocalDate

fun main() {
    check(PersianCalendar.fromGregorian(LocalDate.of(2026, 8, 25)) == PersianDate(1405, 6, 3))
    check(PersianCalendar.toGregorian(PersianDate(1405, 6, 3)) == LocalDate.of(2026, 8, 25))
    check(PersianCalendar.isValid(PersianDate(1399, 12, 30)))
    check(!PersianCalendar.isValid(PersianDate(1400, 12, 30)))

    val diff = DateCalculations.difference(PersianDate(1405, 1, 1), PersianDate(1405, 2, 1))
    check(diff.totalDays == 31L)
    check(diff.period == DateCalculations.PersianPeriod(0, 1, 0))

    val clamped = PersianCalendar.addYears(PersianDate(1399, 12, 30), 1)
    check(clamped == PersianDate(1400, 12, 29))

    println("Core smoke tests passed.")
}
