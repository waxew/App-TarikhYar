package ir.tarikhyar.app.core.date

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.LocalDate

class PersianCalendarTest {
    @Test
    fun currentReferenceDateConvertsBothWays() {
        val persian = PersianCalendar.fromGregorian(LocalDate.of(2026, 8, 25))
        assertEquals(PersianDate(1405, 6, 3), persian)
        assertEquals(LocalDate.of(2026, 8, 25), PersianCalendar.toGregorian(persian))
    }

    @Test
    fun nowruzReferenceDatesAreCorrect() {
        assertEquals(PersianDate(1403, 1, 1), PersianCalendar.fromGregorian(LocalDate.of(2024, 3, 20)))
        assertEquals(PersianDate(1400, 1, 1), PersianCalendar.fromGregorian(LocalDate.of(2021, 3, 21)))
    }

    @Test
    fun leapYearValidationWorks() {
        assertTrue(PersianCalendar.isValid(PersianDate(1399, 12, 30)))
        assertFalse(PersianCalendar.isValid(PersianDate(1400, 12, 30)))
    }

    @Test
    fun dateDifferenceUsesExactDays() {
        val result = DateCalculations.difference(
            PersianDate(1405, 1, 1),
            PersianDate(1405, 2, 1),
        )
        assertEquals(31L, result.totalDays)
        assertEquals(DateCalculations.PersianPeriod(0, 1, 0), result.period)
    }

    @Test
    fun dateArithmeticClampsEsfandLeapDay() {
        val result = PersianCalendar.addYears(PersianDate(1399, 12, 30), 1)
        assertEquals(PersianDate(1400, 12, 29), result)
    }
}
