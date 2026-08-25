package ir.tarikhyar.app.core.date

/**
 * Immutable Solar Hijri (Jalali/Persian) calendar date used across the app.
 * Keeping it independent from Android UI makes the date engine reusable and testable.
 */
data class PersianDate(
    val year: Int,
    val month: Int,
    val day: Int,
) {
    val monthName: String
        get() = MONTH_NAMES.getOrElse(month - 1) { "" }

    companion object {
        val MONTH_NAMES = listOf(
            "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور",
            "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"
        )
    }
}
