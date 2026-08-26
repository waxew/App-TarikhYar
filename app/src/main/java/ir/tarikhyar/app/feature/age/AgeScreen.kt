// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.feature.age

// راهنما: این import وابستگی «androidx.compose.animation.AnimatedVisibility» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.animation.AnimatedVisibility
// راهنما: این import وابستگی «androidx.compose.foundation.background» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.background
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
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Spacer» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Spacer
// راهنما: این import وابستگی «androidx.compose.foundation.layout.fillMaxSize» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.fillMaxSize
// راهنما: این import وابستگی «androidx.compose.foundation.layout.fillMaxWidth» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.fillMaxWidth
// راهنما: این import وابستگی «androidx.compose.foundation.layout.height» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.height
// راهنما: این import وابستگی «androidx.compose.foundation.layout.padding» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.padding
// راهنما: این import وابستگی «androidx.compose.foundation.layout.size» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.size
// راهنما: این import وابستگی «androidx.compose.foundation.lazy.LazyColumn» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.lazy.LazyColumn
// راهنما: این import وابستگی «androidx.compose.foundation.shape.CircleShape» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.shape.CircleShape
// راهنما: این import وابستگی «androidx.compose.material3.CircularProgressIndicator» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.CircularProgressIndicator
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
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.DateCalculations» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.DateCalculations
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianCalendar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianCalendar
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianDate» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianDate
// راهنما: این import وابستگی «ir.tarikhyar.app.core.format.PersianFormat» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.format.PersianFormat
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.AppTopBar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.AppTopBar
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.DateFields» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.DateFields
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.ErrorText» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.ErrorText
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.GradientHeroButton» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.GradientHeroButton
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.ResultCard» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.ResultCard
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.StatTile» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.StatTile
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.parsePersianDate» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.parsePersianDate
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.shareText» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.shareText
// راهنما: این import وابستگی «java.time.LocalDate» را برای استفاده در این فایل وارد می‌کند.
import java.time.LocalDate
// راهنما: این import وابستگی «kotlin.math.max» را برای استفاده در این فایل وارد می‌کند.
import kotlin.math.max

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun AgeScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val context = LocalContext.current
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
    var result by remember { mutableStateOf<DateCalculations.AgeResult?>(null) }
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }

    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val shareValue = result?.let {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        "سن دقیق من در تاریخ‌یار: ${it.period.years} سال، ${it.period.months} ماه و ${it.period.days} روز."
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    } ?: "تاریخ‌یار؛ محاسبه دقیق سن، تاریخ و رویدادهای سنی"

    // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
    Column(modifier.fillMaxSize()) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        AppTopBar("محاسبه سن", onBack) { shareText(context, "محاسبه سن", shareValue) }
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
                Row(
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    modifier = Modifier.fillMaxWidth(),
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ) {
                    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
                    Surface(modifier = Modifier.weight(1f), shape = MaterialTheme.shapes.medium, color = Color(0xFFEAF2FF)) {
                        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                        Text("از سن", modifier = Modifier.padding(11.dp), textAlign = TextAlign.Center, color = Color(0xFF496B9F))
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
                    Surface(modifier = Modifier.weight(1f), shape = MaterialTheme.shapes.medium, color = Color(0xFF3F7FE7)) {
                        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                        Text("از تاریخ تولد", modifier = Modifier.padding(11.dp), textAlign = TextAlign.Center, color = Color.White, fontWeight = FontWeight.Bold)
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }

            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ResultCard {
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("تاریخ تولد 🎂", style = MaterialTheme.typography.titleMedium)
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    DateFields(year, month, day, { year = it }, { month = it }, { day = it })
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    ErrorText(error)
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    GradientHeroButton("محاسبه سن") {
                        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
                        val parsed = parsePersianDate(year, month, day)
                        // راهنما: این when بر اساس مقدار ورودی یکی از مسیرهای مشخص را انتخاب می‌کند.
                        when {
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            parsed == null -> { error = "تاریخ واردشده معتبر نیست."; birth = null; result = null }
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            PersianCalendar.compare(parsed, today) > 0 -> { error = "تاریخ تولد نمی‌تواند بعد از امروز باشد."; birth = null; result = null }
                            // راهنما: این شاخه زمانی اجرا می‌شود که شرط‌های قبلی برقرار نباشند.
                            else -> { error = null; birth = parsed; result = DateCalculations.calculateAge(parsed, today) }
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
                AnimatedVisibility(result != null && birth != null) {
                    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                    if (result != null && birth != null) AgeResultCard(birth!!, today, result!!)
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
private fun AgeResultCard(birth: PersianDate, today: PersianDate, result: DateCalculations.AgeResult) {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val info = remember(birth) { BirthInsights.calendarInfo(birth) }
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val legal = remember(birth) { PersianCalendar.addYears(birth, 18) }
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val daysToLegal = if (PersianCalendar.compare(today, legal) >= 0) 0 else PersianCalendar.daysBetween(today, legal).toInt()
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val yearDays = if (PersianCalendar.isLeapYear(today.year)) 366f else 365f
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val progress = (1f - (result.nextBirthdayDays.toFloat() / yearDays)).coerceIn(0f, 1f)

    // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ResultCard {
            // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
                Surface(shape = CircleShape, color = Color(0xFF8DE6F4), modifier = Modifier.size(78.dp)) {
                    // راهنما: این Box امکان روی‌هم‌گذاری یا ترازکردن اجزای رابط کاربری را فراهم می‌کند.
                    Box(contentAlignment = Alignment.Center) { Text("👦", style = MaterialTheme.typography.headlineLarge) }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
                // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
                Column(modifier = Modifier.weight(1f)) {
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("سن شما", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text(
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        "${PersianFormat.digits(result.period.years)} سال",
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        style = MaterialTheme.typography.headlineLarge,
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        color = MaterialTheme.colorScheme.primary,
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        fontWeight = FontWeight.ExtraBold,
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    )
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("${PersianFormat.digits(result.period.months)} ماه و ${PersianFormat.digits(result.period.days)} روز", color = Color(0xFF182248))
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }

            // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                CompactStat("سال", PersianFormat.digits(result.period.years), Modifier.weight(1f))
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                CompactStat("ماه", PersianFormat.number(result.completedMonths), Modifier.weight(1f))
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                CompactStat("هفته", PersianFormat.number(result.totalWeeks), Modifier.weight(1f))
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                CompactStat("روز", PersianFormat.number(result.totalDays), Modifier.weight(1f))
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }

            // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                // راهنما: این Box امکان روی‌هم‌گذاری یا ترازکردن اجزای رابط کاربری را فراهم می‌کند.
                Box(contentAlignment = Alignment.Center, modifier = Modifier.size(76.dp)) {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    CircularProgressIndicator(
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        progress = { progress },
                        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                        modifier = Modifier.fillMaxSize(),
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        color = MaterialTheme.colorScheme.primary,
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        trackColor = Color(0xFFFFD8DE),
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        strokeWidth = 7.dp,
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    )
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("${(progress * 100).toInt()}%", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
                // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
                Column(modifier = Modifier.weight(1f)) {
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("تا تولد بعدی شما", color = Color(0xFF182248), fontWeight = FontWeight.Bold)
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text(
                        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                        if (result.nextBirthdayDays == 0L) "امروز 🎉" else "${PersianFormat.number(result.nextBirthdayDays)} روز",
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        style = MaterialTheme.typography.titleLarge,
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        color = MaterialTheme.colorScheme.primary,
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    )
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
                // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                Text("🌙", style = MaterialTheme.typography.headlineMedium)
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ResultCard {
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text("جزئیات تولد", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("تقویم شمسی", PersianFormat.persianDate(birth), "🗓️")
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("تقویم میلادی", "${info.gregorian.year}/${info.gregorian.monthValue}/${info.gregorian.dayOfMonth} • ${info.gregorianMonthName}", "📅")
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("تقویم قمری", "${info.hijriYear}/${info.hijriMonth}/${info.hijriDay} • ${info.hijriMonthName}", "🌙")
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("حیوان سال", info.iranianAnimal, "🐾")
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("شماره شمع", PersianFormat.digits(max(1, result.period.years)), "🕯️")
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            DetailLine("روز هفته تولد", PersianFormat.weekday(result.birthWeekday), "🎈")
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            StatTile("ساعت زندگی", PersianFormat.number(result.totalDays * 24L), Modifier.weight(1f))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            StatTile("دقیقه زندگی", PersianFormat.number(result.totalDays * 24L * 60L), Modifier.weight(1f))
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ResultCard {
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text("سن قانونی", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text("تاریخ کامل شدن ۱۸ سال: ${PersianFormat.persianDate(legal)}")
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(
                // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                if (daysToLegal <= 0) "۱۸ سالگی کامل شده است." else "${PersianFormat.number(daysToLegal.toLong())} روز تا ۱۸ سالگی",
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            )
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun CompactStat(label: String, value: String, modifier: Modifier = Modifier) {
    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
    Surface(modifier = modifier, shape = MaterialTheme.shapes.small, color = Color(0xFFF4F6FC)) {
        // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
        Column(Modifier.padding(vertical = 9.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(value, fontWeight = FontWeight.Bold, color = Color(0xFF15204B))
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(label, style = MaterialTheme.typography.labelMedium, color = Color(0xFF77809A))
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun DetailLine(label: String, value: String, emoji: String) {
    // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(emoji)
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
        Text(value, fontWeight = FontWeight.Bold, color = Color(0xFF182248), textAlign = TextAlign.End)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
