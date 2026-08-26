// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.core.date

// راهنما: این import وابستگی «org.junit.Assert.assertEquals» را برای استفاده در این فایل وارد می‌کند.
import org.junit.Assert.assertEquals
// راهنما: این import وابستگی «org.junit.Assert.assertFalse» را برای استفاده در این فایل وارد می‌کند.
import org.junit.Assert.assertFalse
// راهنما: این import وابستگی «org.junit.Assert.assertTrue» را برای استفاده در این فایل وارد می‌کند.
import org.junit.Assert.assertTrue
// راهنما: این import وابستگی «org.junit.Test» را برای استفاده در این فایل وارد می‌کند.
import org.junit.Test
// راهنما: این import وابستگی «java.time.LocalDate» را برای استفاده در این فایل وارد می‌کند.
import java.time.LocalDate

// راهنما: این خط یک کلاس و مسئولیت مشخص آن را در معماری برنامه تعریف می‌کند.
class PersianCalendarTest {
    // راهنما: این Annotation رفتار یا متادیتای declaration بعدی را برای کامپایلر مشخص می‌کند.
    @Test
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun currentReferenceDateConvertsBothWays() {
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val persian = PersianCalendar.fromGregorian(LocalDate.of(2026, 8, 25))
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        assertEquals(PersianDate(1405, 6, 3), persian)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        assertEquals(LocalDate.of(2026, 8, 25), PersianCalendar.toGregorian(persian))
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این Annotation رفتار یا متادیتای declaration بعدی را برای کامپایلر مشخص می‌کند.
    @Test
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun nowruzReferenceDatesAreCorrect() {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        assertEquals(PersianDate(1403, 1, 1), PersianCalendar.fromGregorian(LocalDate.of(2024, 3, 20)))
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        assertEquals(PersianDate(1400, 1, 1), PersianCalendar.fromGregorian(LocalDate.of(2021, 3, 21)))
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این Annotation رفتار یا متادیتای declaration بعدی را برای کامپایلر مشخص می‌کند.
    @Test
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun leapYearValidationWorks() {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        assertTrue(PersianCalendar.isValid(PersianDate(1399, 12, 30)))
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        assertFalse(PersianCalendar.isValid(PersianDate(1400, 12, 30)))
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این Annotation رفتار یا متادیتای declaration بعدی را برای کامپایلر مشخص می‌کند.
    @Test
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun dateDifferenceUsesExactDays() {
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val result = DateCalculations.difference(
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            PersianDate(1405, 1, 1),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            PersianDate(1405, 2, 1),
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        )
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        assertEquals(31L, result.totalDays)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        assertEquals(DateCalculations.PersianPeriod(0, 1, 0), result.period)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این Annotation رفتار یا متادیتای declaration بعدی را برای کامپایلر مشخص می‌کند.
    @Test
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun dateArithmeticClampsEsfandLeapDay() {
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val result = PersianCalendar.addYears(PersianDate(1399, 12, 30), 1)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        assertEquals(PersianDate(1400, 12, 29), result)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
