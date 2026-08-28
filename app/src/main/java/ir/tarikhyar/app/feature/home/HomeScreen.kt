// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// این فایل داشبورد اصلی تاریخ‌یار و کارت‌های دسترسی سریع به ابزارها را نمایش می‌دهد.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.feature.home

// راهنما: این import وابستگی «androidx.compose.foundation.background» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.background
// راهنما: این import وابستگی «androidx.compose.foundation.clickable» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.clickable
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
// راهنما: این import وابستگی «androidx.compose.material.icons.Icons» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.Icons
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Menu» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Menu
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.NotificationsNone» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.NotificationsNone
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Settings» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Settings
// راهنما: این import وابستگی «androidx.compose.material3.Icon» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Icon
// راهنما: این import وابستگی «androidx.compose.material3.MaterialTheme» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.MaterialTheme
// راهنما: این import وابستگی «androidx.compose.material3.Surface» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Surface
// راهنما: این import وابستگی «androidx.compose.material3.Text» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Text
// راهنما: این import وابستگی «androidx.compose.runtime.Composable» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.Composable
// راهنما: این import وابستگی «androidx.compose.ui.Alignment» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.Alignment
// راهنما: این import وابستگی «androidx.compose.ui.Modifier» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.Modifier
// راهنما: این import وابستگی «androidx.compose.ui.draw.clip» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.draw.clip
// راهنما: این import وابستگی «androidx.compose.ui.graphics.Brush» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.graphics.Brush
// راهنما: این import وابستگی «androidx.compose.ui.graphics.Color» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.graphics.Color
// راهنما: این import وابستگی «androidx.compose.ui.text.font.FontWeight» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.font.FontWeight
// راهنما: این import وابستگی «androidx.compose.ui.text.style.TextAlign» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.style.TextAlign
// راهنما: این import وابستگی «androidx.compose.ui.unit.dp» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.unit.dp
// راهنما: این import وابستگی «ir.tarikhyar.app.AppScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.AppScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.core.data.LocalDataRepository» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.data.LocalDataRepository
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianCalendar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianCalendar
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianDate» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianDate
// راهنما: این import وابستگی «ir.tarikhyar.app.core.format.PersianFormat» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.format.PersianFormat
// راهنما: این import وابستگی «ir.tarikhyar.app.core.system.IconStyle» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.system.IconStyle
// راهنما: این import وابستگی «ir.tarikhyar.app.core.system.UserSettings» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.system.UserSettings
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.GraphicMenuCard» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.GraphicMenuCard
// راهنما: این import وابستگی «java.time.LocalDate» را برای استفاده در این فایل وارد می‌کند.
import java.time.LocalDate

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun HomeScreen(
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    onNavigate: (AppScreen) -> Unit,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    onMenuClick: () -> Unit,
    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
    modifier: Modifier = Modifier,
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
) {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val gregorian = LocalDate.now()
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val today = PersianCalendar.fromGregorian(gregorian)
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val context = androidx.compose.ui.platform.LocalContext.current
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val iconStyle = UserSettings.iconStyle(context)
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val nextBirthday = LocalDataRepository.nextBirthday(context, today)
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun icon(graphic: String, minimal: String) = if (iconStyle == IconStyle.GRAPHIC) graphic else minimal

    // راهنما: این LazyColumn فهرست عمودی و قابل اسکرول را به شکل بهینه نمایش می‌دهد.
    LazyColumn(
        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
        modifier = modifier.fillMaxSize(),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        contentPadding = PaddingValues(bottom = 24.dp),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        verticalArrangement = Arrangement.spacedBy(14.dp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        item {
            // راهنما: این Box امکان روی‌هم‌گذاری یا ترازکردن اجزای رابط کاربری را فراهم می‌کند.
            Box(
                // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                modifier = Modifier.fillMaxWidth().clip(MaterialTheme.shapes.extraLarge)
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    .background(Brush.verticalGradient(listOf(Color(0xFFFF4861), Color(0xFFD81334))))
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    .padding(horizontal = 16.dp, vertical = 14.dp),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            ) {
                // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                Row(
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    modifier = Modifier.fillMaxWidth(),
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    horizontalArrangement = Arrangement.SpaceBetween,
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    verticalAlignment = Alignment.CenterVertically,
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ) {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    TopIcon(Icons.Rounded.Menu, "منوی برنامه") { onMenuClick() }
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("سلام! خوش اومدی 👋", style = MaterialTheme.typography.titleLarge, color = Color.White, fontWeight = FontWeight.ExtraBold)
                    // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        TopIcon(Icons.Rounded.NotificationsNone, "اعلان‌ها") { onNavigate(AppScreen.NOTIFICATIONS) }
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        TopIcon(Icons.Rounded.Settings, "تنظیمات") { onNavigate(AppScreen.SETTINGS) }
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }

                // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
                Surface(
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    modifier = Modifier.fillMaxWidth().padding(top = 58.dp),
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    shape = MaterialTheme.shapes.large,
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    color = Color.White,
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    shadowElevation = 4.dp,
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ) {
                    // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                        // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
                        Surface(shape = CircleShape, color = Color(0xFFEAF9EC), modifier = Modifier.size(56.dp)) {
                            // راهنما: این Box امکان روی‌هم‌گذاری یا ترازکردن اجزای رابط کاربری را فراهم می‌کند.
                            Box(contentAlignment = Alignment.Center) { Text(icon("🗓️", "▦"), style = MaterialTheme.typography.headlineMedium) }
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        }
                        // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
                        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                            Text(PersianFormat.weekday(gregorian.dayOfWeek), color = Color(0xFFE31F43), fontWeight = FontWeight.Bold)
                            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                            Text(PersianFormat.persianDate(today), style = MaterialTheme.typography.titleLarge, color = Color(0xFF182248))
                            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                            Text(PersianFormat.gregorian(gregorian), color = Color(0xFF58617C), style = MaterialTheme.typography.bodyMedium)
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            Spacer(Modifier.height(5.dp))
                            // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                HomeMetric("روز گذشته", PersianFormat.number(dayOfYear(today).toLong()), Modifier.weight(1f))
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                HomeMetric("تا پایان سال", PersianFormat.number(daysUntilEndOfYear(today).toLong()), Modifier.weight(1f))
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

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        item {
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text("ابزارهای تاریخ‌یار", Modifier.fillMaxWidth().padding(horizontal = 18.dp), style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary, textAlign = TextAlign.Center)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        item {
            // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
            Column(modifier = Modifier.padding(horizontal = 18.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    GraphicMenuCard("محاسبه سن", icon("🎂", "●"), { onNavigate(AppScreen.AGE) }, Modifier.weight(1f), "سن دقیق و تولد بعدی")
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    GraphicMenuCard("اطلاعات تولد", icon("🌸", "◇"), { onNavigate(AppScreen.BIRTH_INFO) }, Modifier.weight(1f), "شمسی، میلادی و قمری")
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
                // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    GraphicMenuCard("اختلاف تاریخ", icon("🗓️", "▣"), { onNavigate(AppScreen.DIFFERENCE) }, Modifier.weight(1f), "فاصله دقیق دو تاریخ")
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    GraphicMenuCard("تبدیل تاریخ", icon("🎁", "↔"), { onNavigate(AppScreen.TOOLS) }, Modifier.weight(1f), "شمسی و میلادی")
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
                // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    GraphicMenuCard("رویدادهای سنی", icon("🎯", "◎"), { onNavigate(AppScreen.AGE_EVENTS) }, Modifier.weight(1f), "مدرسه، ۱۸ سال و بیشتر")
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    GraphicMenuCard("طالع‌بینی چینی", icon("🐭", "☆"), { onNavigate(AppScreen.CHINESE) }, Modifier.weight(1f), "حیوان سال و ویژگی‌ها")
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
                // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    GraphicMenuCard("تقویم و مناسبت‌ها", icon("📅", "▣"), { onNavigate(AppScreen.CALENDAR) }, Modifier.weight(1f), "تقویم ماهانه و تعطیلات")
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    GraphicMenuCard("پروفایل‌ها", icon("👨‍👩‍👧", "○"), { onNavigate(AppScreen.PROFILES) }, Modifier.weight(1f), "خانواده، دوستان و یادآوری")
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
                // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    GraphicMenuCard("مناسبت شخصی", icon("💝", "+"), { onNavigate(AppScreen.PERSONAL_EVENTS) }, Modifier.weight(1f), "سالگرد و تاریخ دلخواه")
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    GraphicMenuCard("ابزارهای حرفه‌ای", icon("🚀", "≡"), { onNavigate(AppScreen.PRO_TOOLS) }, Modifier.weight(1f), "روز کاری، مقایسه و Countdown")
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
        if (nextBirthday != null) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item {
                // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
                val (profile, days) = nextBirthday
                // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
                Surface(modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp), shape = MaterialTheme.shapes.large, color = MaterialTheme.colorScheme.primaryContainer) {
                    // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                    Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                        Text(icon("🎂", "●"), style = MaterialTheme.typography.headlineMedium)
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        Column {
                            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                            Text("نزدیک‌ترین تولد: ${profile.name}", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                            Text(if (days == 0) "امروز تولدش است" else "${PersianFormat.number(days.toLong())} روز دیگر", color = MaterialTheme.colorScheme.onSurfaceVariant)
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

        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        item {
            // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
            Surface(modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp), shape = MaterialTheme.shapes.large, color = Color(0xFFFFEEF0)) {
                // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("⭐", style = MaterialTheme.typography.headlineMedium)
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    Column {
                        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                        Text("بیش از ده‌ها محاسبه کاربردی", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                        Text("محیط فارسی، سریع، ساده و قابل استفاده بدون تایپ زیاد", color = MaterialTheme.colorScheme.onSurfaceVariant)
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
private fun TopIcon(icon: androidx.compose.ui.graphics.vector.ImageVector, description: String, onClick: () -> Unit) {
    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
    Surface(modifier = Modifier.size(42.dp).clickable(onClick = onClick), shape = CircleShape, color = Color.White.copy(alpha = 0.97f)) {
        // راهنما: این Box امکان روی‌هم‌گذاری یا ترازکردن اجزای رابط کاربری را فراهم می‌کند.
        Box(contentAlignment = Alignment.Center) { Icon(icon, contentDescription = description, tint = Color(0xFFE31F43)) }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun HomeMetric(title: String, value: String, modifier: Modifier = Modifier) {
    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
    Surface(modifier = modifier, shape = MaterialTheme.shapes.small, color = Color(0xFFFFF4EA)) {
        // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
        Column(Modifier.padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(title, style = MaterialTheme.typography.labelMedium, color = Color(0xFF77717A))
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(value, style = MaterialTheme.typography.titleMedium, color = Color(0xFF17204A), fontWeight = FontWeight.Bold)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun dayOfYear(date: PersianDate): Int {
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var result = date.day
    // راهنما: این حلقه مجموعه‌ای از مقادیر را پیمایش و دستورهای داخل خود را تکرار می‌کند.
    for (month in 1 until date.month) result += PersianCalendar.monthLength(date.year, month)
    // راهنما: این return نتیجه تابع را برمی‌گرداند و اجرای همان تابع را پایان می‌دهد.
    return result
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun daysUntilEndOfYear(date: PersianDate): Int {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val yearLength = if (PersianCalendar.isLeapYear(date.year)) 366 else 365
    // راهنما: این return نتیجه تابع را برمی‌گرداند و اجرای همان تابع را پایان می‌دهد.
    return yearLength - dayOfYear(date)
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
