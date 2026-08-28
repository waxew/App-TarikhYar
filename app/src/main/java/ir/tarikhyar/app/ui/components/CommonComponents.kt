// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.ui.components

// راهنما: این import وابستگی «android.content.Context» را برای استفاده در این فایل وارد می‌کند.
import android.content.Context
// راهنما: این import وابستگی «android.content.Intent» را برای استفاده در این فایل وارد می‌کند.
import android.content.Intent
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
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Row» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Row
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Spacer» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Spacer
// راهنما: این import وابستگی «androidx.compose.foundation.layout.fillMaxWidth» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.fillMaxWidth
// راهنما: این import وابستگی «androidx.compose.foundation.layout.height» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.height
// راهنما: این import وابستگی «androidx.compose.foundation.layout.padding» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.padding
// راهنما: این import وابستگی «androidx.compose.foundation.layout.size» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.size
// راهنما: این import وابستگی «androidx.compose.foundation.shape.CircleShape» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.shape.CircleShape
// راهنما: این import وابستگی «androidx.compose.foundation.text.KeyboardOptions» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.text.KeyboardOptions
// راهنما: این import وابستگی «androidx.compose.material.icons.Icons» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.Icons
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.ArrowBack» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.ArrowBack
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Share» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Share
// راهنما: این import وابستگی «androidx.compose.material3.Button» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Button
// راهنما: این import وابستگی «androidx.compose.material3.ButtonDefaults» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.ButtonDefaults
// راهنما: این import وابستگی «androidx.compose.material3.Card» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Card
// راهنما: این import وابستگی «androidx.compose.material3.CardDefaults» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.CardDefaults
// راهنما: این import وابستگی «androidx.compose.material3.Icon» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Icon
// راهنما: این import وابستگی «androidx.compose.material3.IconButton» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.IconButton
// راهنما: این import وابستگی «androidx.compose.material3.MaterialTheme» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.MaterialTheme
// راهنما: این import وابستگی «androidx.compose.material3.OutlinedTextField» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.OutlinedTextField
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
// راهنما: این import وابستگی «androidx.compose.ui.platform.LocalContext» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.platform.LocalContext
// راهنما: این import وابستگی «androidx.compose.ui.draw.clip» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.draw.clip
// راهنما: این import وابستگی «androidx.compose.ui.graphics.Brush» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.graphics.Brush
// راهنما: این import وابستگی «androidx.compose.ui.graphics.Color» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.graphics.Color
// راهنما: این import وابستگی «androidx.compose.ui.graphics.vector.ImageVector» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.graphics.vector.ImageVector
// راهنما: این import وابستگی «androidx.compose.ui.text.font.FontWeight» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.font.FontWeight
// راهنما: این import وابستگی «androidx.compose.ui.text.input.KeyboardType» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.input.KeyboardType
// راهنما: این import وابستگی «androidx.compose.ui.text.style.TextAlign» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.style.TextAlign
// راهنما: این import وابستگی «androidx.compose.ui.unit.dp» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.unit.dp
// راهنما: این import وابستگی «androidx.compose.ui.unit.sp» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.unit.sp
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianCalendar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianCalendar
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianDate» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianDate

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun AppTopBar(title: String, onBack: () -> Unit, onShare: (() -> Unit)? = null) {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val context = LocalContext.current
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val shareAction = onShare ?: { shareText(context, title, "تاریخ‌یار؛ تقویم زندگی، محاسبه سن و ابزارهای تاریخ\nhttps://github.com/waxew/App-TarikhYar") }
    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
    Surface(
        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
        modifier = Modifier.fillMaxWidth(),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        color = MaterialTheme.colorScheme.surface,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        shadowElevation = 1.dp,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ) {
        // راهنما: این Box امکان روی‌هم‌گذاری یا ترازکردن اجزای رابط کاربری را فراهم می‌کند.
        Box(
            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
            modifier = Modifier.fillMaxWidth().padding(horizontal = 6.dp, vertical = 6.dp),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            contentAlignment = Alignment.Center,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ) {
            // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
            IconButton(onClick = onBack, modifier = Modifier.align(Alignment.CenterStart)) {
                // راهنما: این Icon نشانه گرافیکی مرتبط با عملکرد این قسمت را نمایش می‌دهد.
                Icon(Icons.Rounded.ArrowBack, contentDescription = "بازگشت", tint = MaterialTheme.colorScheme.onSurface)
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(title, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
            IconButton(onClick = shareAction, modifier = Modifier.align(Alignment.CenterEnd)) {
                // راهنما: این Icon نشانه گرافیکی مرتبط با عملکرد این قسمت را نمایش می‌دهد.
                Icon(Icons.Rounded.Share, contentDescription = "اشتراک‌گذاری", tint = MaterialTheme.colorScheme.onSurface)
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
fun EmojiBadge(
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    emoji: String,
    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
    modifier: Modifier = Modifier,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    background: Color = MaterialTheme.colorScheme.primaryContainer,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    size: Int = 54,
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
) {
    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
    Surface(modifier = modifier.size(size.dp), shape = CircleShape, color = background) {
        // راهنما: این Box امکان روی‌هم‌گذاری یا ترازکردن اجزای رابط کاربری را فراهم می‌کند.
        Box(contentAlignment = Alignment.Center) {
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(emoji, fontSize = (size * 0.52f).sp)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun GraphicMenuCard(
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    title: String,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    emoji: String,
    // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
    onClick: () -> Unit,
    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
    modifier: Modifier = Modifier,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    subtitle: String? = null,
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
) {
    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
    Card(
        // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
        modifier = modifier.clickable(onClick = onClick),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        shape = MaterialTheme.shapes.large,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ) {
        // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
        Column(
            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
            modifier = Modifier.fillMaxWidth().padding(13.dp),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            horizontalAlignment = Alignment.CenterHorizontally,
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            verticalArrangement = Arrangement.spacedBy(7.dp),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            EmojiBadge(emoji = emoji, size = 58)
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(title, style = MaterialTheme.typography.titleMedium, textAlign = TextAlign.Center)
            // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
            if (!subtitle.isNullOrBlank()) {
                // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                Text(subtitle, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, textAlign = TextAlign.Center)
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
fun ScreenHeader(title: String, subtitle: String) {
    // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
        Text(text = title, style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
        Text(text = subtitle, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun SoftSectionCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
    Card(
        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
        modifier = modifier.fillMaxWidth(),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        shape = MaterialTheme.shapes.large,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ) {
        // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) { content() }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun FeatureCard(title: String, subtitle: String, icon: ImageVector, onClick: () -> Unit, modifier: Modifier = Modifier) {
    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
    Card(
        // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
        modifier = modifier.clickable(onClick = onClick),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        shape = MaterialTheme.shapes.large,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ) {
        // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            // راهنما: این Box امکان روی‌هم‌گذاری یا ترازکردن اجزای رابط کاربری را فراهم می‌کند.
            Box(Modifier.size(50.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primaryContainer), contentAlignment = Alignment.Center) {
                // راهنما: این Icon نشانه گرافیکی مرتبط با عملکرد این قسمت را نمایش می‌دهد.
                Icon(icon, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(27.dp))
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(title, style = MaterialTheme.typography.titleMedium, textAlign = TextAlign.Center)
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(subtitle, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, textAlign = TextAlign.Center)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun DateFields(
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    year: String, month: String, day: String,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    onYearChange: (String) -> Unit, onMonthChange: (String) -> Unit, onDayChange: (String) -> Unit,
    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
    modifier: Modifier = Modifier,
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
) {
    // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        NumericDateField(year, onYearChange, "سال", 4, Modifier.weight(1.35f))
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        NumericDateField(month, onMonthChange, "ماه", 2, Modifier.weight(1f))
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        NumericDateField(day, onDayChange, "روز", 2, Modifier.weight(1f))
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun NumericDateField(value: String, onValueChange: (String) -> Unit, label: String, maxLength: Int, modifier: Modifier = Modifier) {
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    OutlinedTextField(
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        value = value,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        onValueChange = { raw ->
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val normalized = raw.mapNotNull { it.toLatinDigitOrNull() }.joinToString("")
            // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
            if (normalized.length <= maxLength) onValueChange(normalized)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        },
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        label = { Text(label) }, singleLine = true,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        textStyle = MaterialTheme.typography.bodyLarge.copy(textAlign = TextAlign.Center),
        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
        modifier = modifier, shape = MaterialTheme.shapes.medium,
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    )
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun PrimaryButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    Button(
        // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
        onClick = onClick,
        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
        modifier = modifier.fillMaxWidth().height(54.dp),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        shape = MaterialTheme.shapes.large,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ) { Text(text, style = MaterialTheme.typography.titleMedium, color = Color.White) }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun GradientHeroButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    Button(
        // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
        onClick = onClick,
        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
        modifier = modifier.fillMaxWidth().height(56.dp),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        shape = MaterialTheme.shapes.large,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        contentPadding = androidx.compose.foundation.layout.PaddingValues(),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ) {
        // راهنما: این Box امکان روی‌هم‌گذاری یا ترازکردن اجزای رابط کاربری را فراهم می‌کند.
        Box(
            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
            Modifier.fillMaxWidth().background(Brush.horizontalGradient(listOf(MaterialTheme.colorScheme.secondary, MaterialTheme.colorScheme.primary))).padding(vertical = 15.dp),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            contentAlignment = Alignment.Center,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ) { Text(text, style = MaterialTheme.typography.titleMedium, color = Color.White) }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun ErrorText(message: String?) {
    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
    if (!message.isNullOrBlank()) Text(message, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodyMedium)
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun ChoicePill(text: String, selected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
    Surface(
        // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
        modifier = modifier.clickable(onClick = onClick), shape = MaterialTheme.shapes.medium,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        contentColor = if (selected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ) {
        // راهنما: این Box امکان روی‌هم‌گذاری یا ترازکردن اجزای رابط کاربری را فراهم می‌کند.
        Box(Modifier.padding(horizontal = 16.dp, vertical = 12.dp), contentAlignment = Alignment.Center) { Text(text, style = MaterialTheme.typography.labelLarge) }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun ResultCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
    Card(
        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
        modifier = modifier.fillMaxWidth(), shape = MaterialTheme.shapes.large,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
    ) { Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) { content() } }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun StatTile(label: String, value: String, modifier: Modifier = Modifier) {
    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
    Surface(modifier = modifier, shape = MaterialTheme.shapes.medium, color = MaterialTheme.colorScheme.surfaceVariant) {
        // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
        Column(Modifier.padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(value, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            Spacer(Modifier.height(4.dp))
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(label, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, textAlign = TextAlign.Center)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun shareText(context: Context, title: String, text: String) {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val intent = Intent(Intent.ACTION_SEND).apply {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        type = "text/plain"
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        putExtra(Intent.EXTRA_SUBJECT, title)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        putExtra(Intent.EXTRA_TEXT, text)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    context.startActivity(Intent.createChooser(intent, "اشتراک‌گذاری"))
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun parsePersianDate(year: String, month: String, day: String): PersianDate? {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val y = year.toIntOrNull() ?: return null; val m = month.toIntOrNull() ?: return null; val d = day.toIntOrNull() ?: return null
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val date = PersianDate(y, m, d); return date.takeIf(PersianCalendar::isValid)
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun Char.toLatinDigitOrNull(): Char? = when (this) {
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    in '0'..'9' -> this; '۰' -> '0'; '۱' -> '1'; '۲' -> '2'; '۳' -> '3'; '۴' -> '4'; '۵' -> '5'; '۶' -> '6'; '۷' -> '7'; '۸' -> '8'; '۹' -> '9'; else -> null
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
