// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.DateCalculations» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.DateCalculations
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianCalendar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianCalendar
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianDate» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianDate
// راهنما: این import وابستگی «java.time.LocalDate» را برای استفاده در این فایل وارد می‌کند.
import java.time.LocalDate

// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun main() {
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    check(PersianCalendar.fromGregorian(LocalDate.of(2026, 8, 25)) == PersianDate(1405, 6, 3))
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    check(PersianCalendar.toGregorian(PersianDate(1405, 6, 3)) == LocalDate.of(2026, 8, 25))
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    check(PersianCalendar.isValid(PersianDate(1399, 12, 30)))
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    check(!PersianCalendar.isValid(PersianDate(1400, 12, 30)))

    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val diff = DateCalculations.difference(PersianDate(1405, 1, 1), PersianDate(1405, 2, 1))
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    check(diff.totalDays == 31L)
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    check(diff.period == DateCalculations.PersianPeriod(0, 1, 0))

    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val clamped = PersianCalendar.addYears(PersianDate(1399, 12, 30), 1)
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    check(clamped == PersianDate(1400, 12, 29))

    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    println("Core smoke tests passed.")
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
