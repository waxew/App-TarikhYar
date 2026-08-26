// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.feature.tools

// راهنما: این import وابستگی «androidx.compose.animation.AnimatedVisibility» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.animation.AnimatedVisibility
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Arrangement» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Arrangement
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Column» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Column
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Row» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Row
// راهنما: این import وابستگی «androidx.compose.foundation.layout.fillMaxSize» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.fillMaxSize
// راهنما: این import وابستگی «androidx.compose.foundation.layout.fillMaxWidth» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.fillMaxWidth
// راهنما: این import وابستگی «androidx.compose.foundation.layout.padding» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.padding
// راهنما: این import وابستگی «androidx.compose.foundation.lazy.LazyColumn» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.lazy.LazyColumn
// راهنما: این import وابستگی «androidx.compose.foundation.text.KeyboardOptions» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.text.KeyboardOptions
// راهنما: این import وابستگی «androidx.compose.material3.MaterialTheme» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.MaterialTheme
// راهنما: این import وابستگی «androidx.compose.material3.OutlinedTextField» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.OutlinedTextField
// راهنما: این import وابستگی «androidx.compose.material3.Text» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Text
// راهنما: این import وابستگی «androidx.compose.runtime.Composable» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.Composable
// راهنما: این import وابستگی «androidx.compose.runtime.getValue» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.getValue
// راهنما: این import وابستگی «androidx.compose.runtime.mutableStateOf» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.mutableStateOf
// راهنما: این import وابستگی «androidx.compose.runtime.remember» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.remember
// راهنما: این import وابستگی «androidx.compose.runtime.setValue» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.setValue
// راهنما: این import وابستگی «androidx.compose.ui.Modifier» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.Modifier
// راهنما: این import وابستگی «androidx.compose.ui.text.input.KeyboardType» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.input.KeyboardType
// راهنما: این import وابستگی «androidx.compose.ui.unit.dp» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.unit.dp
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.DateCalculations» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.DateCalculations
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianCalendar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianCalendar
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianDate» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianDate
// راهنما: این import وابستگی «ir.tarikhyar.app.core.format.PersianFormat» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.format.PersianFormat
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.ChoicePill» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.ChoicePill
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.DateFields» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.DateFields
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.ErrorText» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.ErrorText
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.PrimaryButton» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.PrimaryButton
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.ResultCard» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.ResultCard
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.ScreenHeader» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.ScreenHeader
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.parsePersianDate» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.parsePersianDate
// راهنما: این import وابستگی «java.time.LocalDate» را برای استفاده در این فایل وارد می‌کند.
import java.time.LocalDate

// راهنما: این enum مجموعه محدود و مشخصی از حالت‌های قابل استفاده را تعریف می‌کند.
enum class ToolsTab { CONVERTER, ARITHMETIC }
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
private enum class CalendarInput { PERSIAN, GREGORIAN }

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun ToolsScreen(modifier: Modifier = Modifier) {
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var tab by remember { mutableStateOf(ToolsTab.CONVERTER) }

    // راهنما: این LazyColumn فهرست عمودی و قابل اسکرول را به شکل بهینه نمایش می‌دهد.
    LazyColumn(
        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
        modifier = modifier.fillMaxSize(),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        contentPadding = androidx.compose.foundation.layout.PaddingValues(18.dp),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        verticalArrangement = Arrangement.spacedBy(18.dp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        item {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            ScreenHeader(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                title = "ابزارهای تاریخ",
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                subtitle = "تبدیل تاریخ یا محاسبه یک تاریخ جدید بدون نیاز به اینترنت.",
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            )
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        item {
            // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ChoicePill(
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    text = "تبدیل تاریخ",
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    selected = tab == ToolsTab.CONVERTER,
                    // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                    onClick = { tab = ToolsTab.CONVERTER },
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    modifier = Modifier.weight(1f),
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                )
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ChoicePill(
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    text = "محاسبه تاریخ",
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    selected = tab == ToolsTab.ARITHMETIC,
                    // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                    onClick = { tab = ToolsTab.ARITHMETIC },
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    modifier = Modifier.weight(1f),
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                )
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        item {
            // راهنما: این when بر اساس مقدار ورودی یکی از مسیرهای مشخص را انتخاب می‌کند.
            when (tab) {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ToolsTab.CONVERTER -> ConverterContent()
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ToolsTab.ARITHMETIC -> ArithmeticContent()
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun ConverterContent() {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val todayGregorian = remember { LocalDate.now() }
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val todayPersian = remember { PersianCalendar.fromGregorian(todayGregorian) }

    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var inputCalendar by remember { mutableStateOf(CalendarInput.PERSIAN) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var year by remember { mutableStateOf(todayPersian.year.toString()) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var month by remember { mutableStateOf(todayPersian.month.toString()) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var day by remember { mutableStateOf(todayPersian.day.toString()) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var error by remember { mutableStateOf<String?>(null) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var persianResult by remember { mutableStateOf<PersianDate?>(null) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var gregorianResult by remember { mutableStateOf<LocalDate?>(null) }

    // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
        Text(text = "نوع تاریخ ورودی", style = MaterialTheme.typography.titleMedium)
        // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            ChoicePill(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                text = "شمسی",
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                selected = inputCalendar == CalendarInput.PERSIAN,
                // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                onClick = {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    inputCalendar = CalendarInput.PERSIAN
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    year = todayPersian.year.toString()
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    month = todayPersian.month.toString()
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    day = todayPersian.day.toString()
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    error = null
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    persianResult = null
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    gregorianResult = null
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                },
                // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                modifier = Modifier.weight(1f),
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            )
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            ChoicePill(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                text = "میلادی",
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                selected = inputCalendar == CalendarInput.GREGORIAN,
                // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                onClick = {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    inputCalendar = CalendarInput.GREGORIAN
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    year = todayGregorian.year.toString()
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    month = todayGregorian.monthValue.toString()
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    day = todayGregorian.dayOfMonth.toString()
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    error = null
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    persianResult = null
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    gregorianResult = null
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                },
                // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                modifier = Modifier.weight(1f),
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            )
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        DateFields(year, month, day, { year = it }, { month = it }, { day = it })
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ErrorText(error)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        PrimaryButton(text = "تبدیل تاریخ") {
            // راهنما: این when بر اساس مقدار ورودی یکی از مسیرهای مشخص را انتخاب می‌کند.
            when (inputCalendar) {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                CalendarInput.PERSIAN -> {
                    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
                    val persian = parsePersianDate(year, month, day)
                    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                    if (persian == null) {
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        error = "تاریخ شمسی واردشده معتبر نیست."
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        persianResult = null
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        gregorianResult = null
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    } else {
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        error = null
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        persianResult = persian
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        gregorianResult = PersianCalendar.toGregorian(persian)
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                CalendarInput.GREGORIAN -> {
                    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
                    val gregorian = parseGregorian(year, month, day)
                    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                    if (gregorian == null) {
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        error = "تاریخ میلادی واردشده معتبر نیست."
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        persianResult = null
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        gregorianResult = null
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    } else {
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        error = null
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        gregorianResult = gregorian
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        persianResult = PersianCalendar.fromGregorian(gregorian)
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        AnimatedVisibility(visible = persianResult != null && gregorianResult != null) {
            // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
            if (persianResult != null && gregorianResult != null) {
                // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    ResultCard {
                        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                        Text(text = "شمسی", style = MaterialTheme.typography.bodyMedium)
                        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                        Text(
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            text = PersianFormat.persianDate(persianResult!!),
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            style = MaterialTheme.typography.titleLarge,
                            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                            modifier = Modifier.padding(top = 4.dp),
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        )
                        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                        Text(
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            text = PersianFormat.persianNumeric(persianResult!!),
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            style = MaterialTheme.typography.bodyMedium,
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                            modifier = Modifier.padding(top = 4.dp),
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        )
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    ResultCard {
                        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                        Text(text = "میلادی", style = MaterialTheme.typography.bodyMedium)
                        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                        Text(
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            text = PersianFormat.gregorian(gregorianResult!!),
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            style = MaterialTheme.typography.titleLarge,
                            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                            modifier = Modifier.padding(top = 4.dp),
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        )
                        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                        Text(
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            text = PersianFormat.weekday(gregorianResult!!.dayOfWeek),
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            style = MaterialTheme.typography.bodyMedium,
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                            modifier = Modifier.padding(top = 4.dp),
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        )
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun ArithmeticContent() {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var year by remember { mutableStateOf(today.year.toString()) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var month by remember { mutableStateOf(today.month.toString()) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var day by remember { mutableStateOf(today.day.toString()) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var amount by remember { mutableStateOf("30") }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var addMode by remember { mutableStateOf(true) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var unit by remember { mutableStateOf(DateCalculations.Unit.DAYS) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var error by remember { mutableStateOf<String?>(null) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var result by remember { mutableStateOf<PersianDate?>(null) }

    // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
        Text(text = "تاریخ مبنا", style = MaterialTheme.typography.titleMedium)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        DateFields(year, month, day, { year = it }, { month = it }, { day = it })

        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
        Text(text = "عملیات", style = MaterialTheme.typography.titleMedium)
        // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            ChoicePill("اضافه کردن", addMode, { addMode = true }, Modifier.weight(1f))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            ChoicePill("کم کردن", !addMode, { addMode = false }, Modifier.weight(1f))
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        OutlinedTextField(
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            value = amount,
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            onValueChange = { raw ->
                // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
                val normalized = normalizeDigits(raw)
                // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                if (normalized.length <= 7) amount = normalized
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            },
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            label = { Text("تعداد") },
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            singleLine = true,
            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
            modifier = Modifier.fillMaxWidth(),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            shape = MaterialTheme.shapes.medium,
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        )

        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
        Text(text = "واحد", style = MaterialTheme.typography.titleMedium)
        // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            ChoicePill("روز", unit == DateCalculations.Unit.DAYS, { unit = DateCalculations.Unit.DAYS }, Modifier.weight(1f))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            ChoicePill("هفته", unit == DateCalculations.Unit.WEEKS, { unit = DateCalculations.Unit.WEEKS }, Modifier.weight(1f))
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
        // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            ChoicePill("ماه", unit == DateCalculations.Unit.MONTHS, { unit = DateCalculations.Unit.MONTHS }, Modifier.weight(1f))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            ChoicePill("سال", unit == DateCalculations.Unit.YEARS, { unit = DateCalculations.Unit.YEARS }, Modifier.weight(1f))
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ErrorText(error)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        PrimaryButton(text = "محاسبه تاریخ جدید") {
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val baseDate = parsePersianDate(year, month, day)
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val rawAmount = amount.toLongOrNull()
            // راهنما: این when بر اساس مقدار ورودی یکی از مسیرهای مشخص را انتخاب می‌کند.
            when {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                baseDate == null -> {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    error = "تاریخ مبنا معتبر نیست."
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    result = null
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                rawAmount == null -> {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    error = "تعداد را به‌صورت عدد وارد کن."
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    result = null
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
                // راهنما: این شاخه زمانی اجرا می‌شود که شرط‌های قبلی برقرار نباشند.
                else -> {
                    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
                    val signed = if (addMode) rawAmount else -rawAmount
                    // راهنما: این بلوک عملیاتی را اجرا می‌کند که ممکن است Exception ایجاد کند.
                    try {
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        result = DateCalculations.add(baseDate, signed, unit)
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        error = null
                    // راهنما: این بخش خطای احتمالی بلوک try را کنترل می‌کند تا برنامه Crash نکند.
                    } catch (_: IllegalArgumentException) {
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        result = null
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        error = "نتیجه خارج از بازه پشتیبانی‌شده تقویم است."
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        AnimatedVisibility(visible = result != null) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            result?.let { calculated ->
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ResultCard {
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text(text = "تاریخ جدید", style = MaterialTheme.typography.bodyMedium)
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text(
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        text = PersianFormat.persianDate(calculated),
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        style = MaterialTheme.typography.titleLarge,
                        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                        modifier = Modifier.padding(top = 4.dp),
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    )
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text(
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        text = "میلادی: ${PersianFormat.gregorian(PersianCalendar.toGregorian(calculated))}",
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        style = MaterialTheme.typography.bodyMedium,
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                        modifier = Modifier.padding(top = 6.dp),
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    )
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun parseGregorian(year: String, month: String, day: String): LocalDate? = try {
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    LocalDate.of(year.toInt(), month.toInt(), day.toInt())
// راهنما: این بخش خطای احتمالی بلوک try را کنترل می‌کند تا برنامه Crash نکند.
} catch (_: Exception) {
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    null
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun normalizeDigits(input: String): String = input.mapNotNull { ch ->
    // راهنما: این when بر اساس مقدار ورودی یکی از مسیرهای مشخص را انتخاب می‌کند.
    when (ch) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        in '0'..'9' -> ch
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        '۰' -> '0'
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        '۱' -> '1'
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        '۲' -> '2'
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        '۳' -> '3'
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        '۴' -> '4'
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        '۵' -> '5'
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        '۶' -> '6'
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        '۷' -> '7'
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        '۸' -> '8'
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        '۹' -> '9'
        // راهنما: این شاخه زمانی اجرا می‌شود که شرط‌های قبلی برقرار نباشند.
        else -> null
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
}.joinToString("")
