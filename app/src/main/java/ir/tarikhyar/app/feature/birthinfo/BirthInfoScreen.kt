// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.feature.birthinfo

// راهنما: این import وابستگی «androidx.compose.animation.AnimatedVisibility» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.animation.AnimatedVisibility
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Arrangement» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Arrangement
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Box» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Box
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Column» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Column
// راهنما: این import وابستگی «androidx.compose.foundation.layout.PaddingValues» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.PaddingValues
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Row» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Row
// راهنما: این import وابستگی «androidx.compose.foundation.layout.fillMaxSize» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.fillMaxSize
// راهنما: این import وابستگی «androidx.compose.foundation.layout.fillMaxWidth» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.fillMaxWidth
// راهنما: این import وابستگی «androidx.compose.foundation.layout.size» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.size
// راهنما: این import وابستگی «androidx.compose.foundation.lazy.LazyColumn» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.lazy.LazyColumn
// راهنما: این import وابستگی «androidx.compose.material3.MaterialTheme» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.MaterialTheme
// راهنما: این import وابستگی «androidx.compose.material3.Surface» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Surface
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
// راهنما: این import وابستگی «androidx.compose.ui.Alignment» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.Alignment
// راهنما: این import وابستگی «androidx.compose.ui.Modifier» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.Modifier
// راهنما: این import وابستگی «androidx.compose.ui.graphics.Color» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.graphics.Color
// راهنما: این import وابستگی «androidx.compose.ui.platform.LocalContext» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.platform.LocalContext
// راهنما: این import وابستگی «androidx.compose.ui.text.font.FontWeight» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.font.FontWeight
// راهنما: این import وابستگی «androidx.compose.ui.text.style.TextAlign» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.style.TextAlign
// راهنما: این import وابستگی «androidx.compose.ui.unit.dp» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.unit.dp
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.BirthInsights» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.BirthInsights
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianCalendar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianCalendar
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianDate» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianDate
// راهنما: این import وابستگی «ir.tarikhyar.app.core.format.PersianFormat» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.format.PersianFormat
// راهنما: این import وابستگی «ir.tarikhyar.app.core.system.ShareCardRenderer» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.system.ShareCardRenderer
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.AppTopBar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.AppTopBar
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.ChoicePill» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.ChoicePill
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.DateFields» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.DateFields
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.ErrorText» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.ErrorText
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.PrimaryButton» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.PrimaryButton
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.PersianDatePickerDialog» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.PersianDatePickerDialog
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.ResultCard» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.ResultCard
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.parsePersianDate» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.parsePersianDate
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.shareText» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.shareText
// راهنما: این import وابستگی «java.time.LocalDate» را برای استفاده در این فایل وارد می‌کند.
import java.time.LocalDate

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun BirthInfoScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val context = LocalContext.current
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var year by remember { mutableStateOf("") }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var month by remember { mutableStateOf("") }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var day by remember { mutableStateOf("") }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var error by remember { mutableStateOf<String?>(null) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var birth by remember { mutableStateOf<PersianDate?>(null) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var selectedTab by remember { mutableStateOf(0) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var showPicker by remember { mutableStateOf(false) }

    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val shareValue = birth?.let { "اطلاعات تولد من: ${PersianFormat.persianDate(it)} — تاریخ‌یار" }
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ?: "تاریخ‌یار؛ اطلاعات کامل تولد در تقویم‌های شمسی، میلادی و قمری"

    // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
    Column(modifier.fillMaxSize()) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        AppTopBar("اطلاعات تولد", onBack) { shareText(context, "اطلاعات تولد", shareValue) }
        // راهنما: این LazyColumn فهرست عمودی و قابل اسکرول را به شکل بهینه نمایش می‌دهد.
        LazyColumn(
            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
            modifier = Modifier.fillMaxSize(),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            contentPadding = PaddingValues(18.dp),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            verticalArrangement = Arrangement.spacedBy(14.dp),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item {
                // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    ChoicePill("شمسی", selectedTab == 0, { selectedTab = 0 }, Modifier.weight(1f))
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    ChoicePill("میلادی", selectedTab == 1, { selectedTab = 1 }, Modifier.weight(1f))
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    ChoicePill("قمری", selectedTab == 2, { selectedTab = 2 }, Modifier.weight(1f))
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ResultCard {
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("تاریخ تولد", style = MaterialTheme.typography.titleMedium)
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    DateFields(year, month, day, { year = it }, { month = it }, { day = it })
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    PrimaryButton("انتخاب تاریخ بدون تایپ") { showPicker = true }
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    ErrorText(error)
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    PrimaryButton("نمایش اطلاعات") {
                        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
                        val parsed = parsePersianDate(year, month, day)
                        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                        if (parsed == null || PersianCalendar.compare(parsed, today) > 0) {
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            error = "تاریخ تولد معتبر وارد کن."
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            birth = null
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        } else {
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            error = null
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            birth = parsed
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        }
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                AnimatedVisibility(birth != null) {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    birth?.let { BirthCards(it, selectedTab, context) }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
    if (showPicker) {
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val initial = parsePersianDate(year, month, day) ?: PersianCalendar.addYears(today, -25)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        PersianDatePickerDialog(initial, { showPicker = false }) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            year = it.year.toString(); month = it.month.toString(); day = it.day.toString(); showPicker = false
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun BirthCards(birth: PersianDate, selectedTab: Int, context: android.content.Context) {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val info = remember(birth) { BirthInsights.calendarInfo(birth) }
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val profile = remember(birth) { BirthInsights.profile(birth) }
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val gregorianText = "${info.gregorian.dayOfMonth} ${info.gregorianMonthName} ${info.gregorian.year}"
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val hijriText = "${info.hijriDay} ${info.hijriMonthName} ${info.hijriYear}"

    // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        // راهنما: این when بر اساس مقدار ورودی یکی از مسیرهای مشخص را انتخاب می‌کند.
        when (selectedTab) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            0 -> CalendarHighlight("معادل شمسی تولد", PersianFormat.persianDate(birth), PersianFormat.persianNumeric(birth), "🗓️", Color(0xFFFFE7EA))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            1 -> CalendarHighlight("معادل میلادی تولد", gregorianText, PersianFormat.weekday(info.gregorian.dayOfWeek), "📅", Color(0xFFE6F1FF))
            // راهنما: این شاخه زمانی اجرا می‌شود که شرط‌های قبلی برقرار نباشند.
            else -> CalendarHighlight("معادل قمری تولد", hijriText, info.hijriMonthName, "🌙", Color(0xFFE7F0FF))
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        CalendarHighlight("معادل میلادی تولد", gregorianText, PersianFormat.weekday(info.gregorian.dayOfWeek), "📅", Color(0xFFE6F1FF))
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        CalendarHighlight("معادل قمری تولد", hijriText, info.hijriMonthName, "🌙", Color(0xFFE7F0FF))

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ResultCard {
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text("کارت تصویری اطلاعات تولد", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            PrimaryButton("ساخت و اشتراک کارت") {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ShareCardRenderer.share(
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    context,
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    "اطلاعات تولد",
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    listOf(PersianFormat.persianDate(birth), "میلادی: $gregorianText", "قمری: $hijriText", "حیوان سال: ${info.iranianAnimal}"),
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                )
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ResultCard {
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text("اطلاعات بیشتر", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            InfoLine("ماه میلادی", info.gregorianMonthName, "☀️")
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            InfoLine("ماه قمری", info.hijriMonthName, "🌙")
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            InfoLine("حیوان سال ایرانی", info.iranianAnimal, animalEmoji(info.iranianAnimal))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            InfoLine("نام سال ترکی", info.turkicAnimal, "🏳️")
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            InfoLine("حیوان سال چینی", info.chineseAnimal, animalEmoji(info.chineseAnimal))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            InfoLine("برج میلادی", info.westernSign, "♈")
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            InfoLine("گل ماه تولد", profile.flower, "🌸")
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            InfoLine("رنگ مرتبط", profile.color, "🎨")
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun CalendarHighlight(title: String, main: String, subtitle: String, emoji: String, badgeColor: Color) {
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ResultCard {
        // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
            // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
            Surface(shape = MaterialTheme.shapes.medium, color = badgeColor, modifier = Modifier.size(66.dp)) {
                // راهنما: این Box امکان روی‌هم‌گذاری یا ترازکردن اجزای رابط کاربری را فراهم می‌کند.
                Box(contentAlignment = Alignment.Center) { Text(emoji, style = MaterialTheme.typography.headlineMedium) }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
            // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                Text(title, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurface)
                // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                Text(main, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                Text(subtitle, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
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
private fun InfoLine(label: String, value: String, emoji: String) {
    // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(emoji)
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
        Text(value, fontWeight = FontWeight.Bold, textAlign = TextAlign.End, color = MaterialTheme.colorScheme.onSurface)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun animalEmoji(name: String): String = when (name) {
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    "موش" -> "🐭"
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    "گاو" -> "🐮"
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    "ببر", "پلنگ" -> "🐯"
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    "خرگوش" -> "🐰"
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    "اژدها", "نهنگ" -> "🐲"
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    "مار" -> "🐍"
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    "اسب" -> "🐴"
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    "بز", "گوسفند" -> "🐐"
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    "میمون" -> "🐵"
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    "خروس", "مرغ" -> "🐔"
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    "سگ" -> "🐶"
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    "خوک" -> "🐷"
    // راهنما: این شاخه زمانی اجرا می‌شود که شرط‌های قبلی برقرار نباشند.
    else -> "🐾"
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
