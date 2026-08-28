// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.feature.favorites

// راهنما: این import وابستگی «androidx.compose.foundation.layout.Arrangement» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Arrangement
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Column» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Column
// راهنما: این import وابستگی «androidx.compose.foundation.layout.PaddingValues» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.PaddingValues
// راهنما: این import وابستگی «androidx.compose.foundation.layout.fillMaxSize» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.fillMaxSize
// راهنما: این import وابستگی «androidx.compose.foundation.lazy.LazyColumn» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.lazy.LazyColumn
// راهنما: این import وابستگی «androidx.compose.material3.MaterialTheme» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.MaterialTheme
// راهنما: این import وابستگی «androidx.compose.material3.Text» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Text
// راهنما: این import وابستگی «androidx.compose.runtime.Composable» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.Composable
// راهنما: این import وابستگی «androidx.compose.ui.Modifier» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.Modifier
// راهنما: این import وابستگی «androidx.compose.ui.platform.LocalContext» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.platform.LocalContext
// راهنما: این import وابستگی «androidx.compose.ui.text.font.FontWeight» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.font.FontWeight
// راهنما: این import وابستگی «androidx.compose.ui.unit.dp» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.unit.dp
// راهنما: این import وابستگی «ir.tarikhyar.app.AppScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.AppScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.core.data.LocalDataRepository» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.data.LocalDataRepository
// راهنما: این import وابستگی «ir.tarikhyar.app.core.format.PersianFormat» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.format.PersianFormat
// راهنما: این import وابستگی «ir.tarikhyar.app.feature.protools.ProfessionalToolCatalog» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.feature.protools.ProfessionalToolCatalog
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.AppTopBar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.AppTopBar
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.PrimaryButton» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.PrimaryButton
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.ResultCard» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.ResultCard

/** ابزارها و پروفایل‌هایی را که کاربر ستاره‌دار کرده یکجا نمایش می‌دهد. */
// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun FavoritesScreen(
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    onBack: () -> Unit,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    onNavigate: (AppScreen) -> Unit,
    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
    modifier: Modifier = Modifier,
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
) {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val context = LocalContext.current
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val tools = LocalDataRepository.favoriteTools(context)
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val profiles = LocalDataRepository.profiles(context).filter { it.favorite }

    // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
    Column(modifier.fillMaxSize()) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        AppTopBar("علاقه‌مندی‌ها", onBack)
        // راهنما: این LazyColumn فهرست عمودی و قابل اسکرول را به شکل بهینه نمایش می‌دهد.
        LazyColumn(
            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
            modifier = Modifier.fillMaxSize(),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            contentPadding = PaddingValues(18.dp),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            verticalArrangement = Arrangement.spacedBy(12.dp),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ResultCard {
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("ابزارهای محبوب", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                    if (tools.isEmpty()) Text("هنوز ابزاری ستاره‌دار نشده است.", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    tools.forEach { id ->
                        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                        Text("⭐ ${ProfessionalToolCatalog.items[id] ?: id}", fontWeight = FontWeight.Bold)
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                    if (tools.isNotEmpty()) PrimaryButton("باز کردن ابزارهای حرفه‌ای") { onNavigate(AppScreen.PRO_TOOLS) }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ResultCard {
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("پروفایل‌های محبوب", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                    if (profiles.isEmpty()) Text("هنوز پروفایلی ستاره‌دار نشده است.", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    profiles.forEach {
                        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                        Text("⭐ ${it.name} — ${PersianFormat.persianDate(it.birthDate)}")
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                    if (profiles.isNotEmpty()) PrimaryButton("مدیریت پروفایل‌ها") { onNavigate(AppScreen.PROFILES) }
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
