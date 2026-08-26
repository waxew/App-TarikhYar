// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.feature.insights

// راهنما: این import وابستگی «androidx.compose.animation.AnimatedVisibility» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.animation.AnimatedVisibility
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Arrangement» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Arrangement
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
// راهنما: این import وابستگی «androidx.compose.foundation.layout.padding» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.padding
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
// راهنما: این import وابستگی «androidx.compose.ui.Modifier» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.Modifier
// راهنما: این import وابستگی «androidx.compose.ui.text.font.FontWeight» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.font.FontWeight
// راهنما: این import وابستگی «androidx.compose.ui.unit.dp» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.unit.dp
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.BirthInsights» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.BirthInsights
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.DateCalculations» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.DateCalculations
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianCalendar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianCalendar
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianDate» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianDate
// راهنما: این import وابستگی «ir.tarikhyar.app.core.format.PersianFormat» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.format.PersianFormat
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
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.StatTile» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.StatTile
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.parsePersianDate» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.parsePersianDate
// راهنما: این import وابستگی «java.time.LocalDate» را برای استفاده در این فایل وارد می‌کند.
import java.time.LocalDate

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun InsightsScreen(modifier: Modifier = Modifier) {
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
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }

    // راهنما: این LazyColumn فهرست عمودی و قابل اسکرول را به شکل بهینه نمایش می‌دهد.
    LazyColumn(
        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
        modifier = modifier.fillMaxSize(),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        contentPadding = PaddingValues(18.dp),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        verticalArrangement = Arrangement.spacedBy(16.dp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        item { ScreenHeader("اطلاعات تولد و زندگی", "یک تاریخ وارد کن؛ تبدیل‌ها، حیوان سال، طالع سرگرمی و نقاط عطف را یکجا ببین.") }
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        item {
            // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                Text("تاریخ تولد یا شروع رویداد", style = MaterialTheme.typography.titleMedium)
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                DateFields(year, month, day, { year = it }, { month = it }, { day = it })
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ErrorText(error)
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                PrimaryButton("نمایش همه جزئیات") {
                    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
                    val parsed = parsePersianDate(year, month, day)
                    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                    if (parsed == null || PersianCalendar.compare(parsed, today) > 0) {
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        error = "یک تاریخ معتبر و گذشته وارد کن."
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        birth = null
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    } else { error = null; birth = parsed }
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
                birth?.let { BirthDetails(it, today) }
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
private fun BirthDetails(birth: PersianDate, today: PersianDate) {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val info = remember(birth) { BirthInsights.calendarInfo(birth) }
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val profile = remember(birth) { BirthInsights.profile(birth) }
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val milestones = remember(birth) { BirthInsights.milestones(birth) }
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val age = remember(birth, today) { DateCalculations.calculateAge(birth, today) }

    // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ResultCard {
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text("معادل تاریخ تولد", style = MaterialTheme.typography.titleLarge)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("شمسی", PersianFormat.persianDate(birth))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("میلادی", "${info.gregorian.year}/${info.gregorian.monthValue}/${info.gregorian.dayOfMonth} — ${info.gregorianMonthName}")
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("قمری", "${info.hijriYear}/${info.hijriMonth}/${info.hijriDay} — ${info.hijriMonthName}")
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            StatTile("حیوان سال", info.iranianAnimal, Modifier.weight(1f))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            StatTile("چینی", info.chineseAnimal, Modifier.weight(1f))
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
        // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            StatTile("نام ترکی سال", info.turkicAnimal, Modifier.weight(1f))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            StatTile("برج میلادی", info.westernSign, Modifier.weight(1f))
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        SectionCard("خصوصیات ماه تولد ${profile.monthTitle} — سرگرمی") {
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(profile.traits)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("رنگ", profile.color); DetailLine("گل", profile.flower)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("بو", profile.scent); DetailLine("طعم", profile.flavor)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("جواهر", profile.jewel); DetailLine("حیوان", profile.favoriteAnimal)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("درخت", profile.tree); DetailLine("گیاه", profile.plant)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("ادویه", profile.spice); DetailLine("فلز", profile.metal)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("عدد شانس", profile.luckyNumber); DetailLine("شعار", profile.motto)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("بهترین جفت", profile.bestMatch); DetailLine("جفت چالش‌برانگیز", profile.challengingMatch)
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text("این بخش جنبه سرگرمی و فرهنگی دارد و پیش‌بینی علمی شخصیت نیست.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        SectionCard("سن نوزاد، کودک و هر رویداد") {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("سال", PersianFormat.number(age.period.years.toLong()))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("ماه کامل", PersianFormat.number(age.completedMonths))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("هفته کامل", PersianFormat.number(age.totalWeeks))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("روز کامل", PersianFormat.number(age.totalDays))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("ساعت", PersianFormat.number(age.totalDays * 24L))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("دقیقه", PersianFormat.number(age.totalDays * 24L * 60L))
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text("همین محاسبه برای سن ازدواج، عقد، پاکی، اشتغال، شرکت یا حیوان خانگی قابل استفاده است: تاریخ شروع همان رویداد را بالا وارد کن.", style = MaterialTheme.typography.bodyMedium)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        SectionCard("نقاط عطف سنی") {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            milestones.forEach { m ->
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                DetailLine(m.title, PersianFormat.persianDate(m.date))
                // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                Text(m.note, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
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
private fun SectionCard(title: String, content: @Composable () -> Unit) {
    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
    Surface(color = MaterialTheme.colorScheme.surface, shape = MaterialTheme.shapes.large, tonalElevation = 2.dp) {
        // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(title, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            content()
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun DetailLine(label: String, value: String) {
    // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
        Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant)
        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
        Text(value, fontWeight = FontWeight.Bold)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
