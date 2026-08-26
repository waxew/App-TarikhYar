// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.core.ui.theme

// راهنما: این import وابستگی «androidx.compose.foundation.isSystemInDarkTheme» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.isSystemInDarkTheme
// راهنما: این import وابستگی «androidx.compose.foundation.shape.RoundedCornerShape» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.shape.RoundedCornerShape
// راهنما: این import وابستگی «androidx.compose.material3.MaterialTheme» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.MaterialTheme
// راهنما: این import وابستگی «androidx.compose.material3.Shapes» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Shapes
// راهنما: این import وابستگی «androidx.compose.material3.Typography» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Typography
// راهنما: این import وابستگی «androidx.compose.material3.darkColorScheme» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.darkColorScheme
// راهنما: این import وابستگی «androidx.compose.material3.lightColorScheme» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.lightColorScheme
// راهنما: این import وابستگی «androidx.compose.runtime.Composable» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.Composable
// راهنما: این import وابستگی «androidx.compose.ui.text.TextStyle» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.TextStyle
// راهنما: این import وابستگی «androidx.compose.ui.text.font.FontFamily» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.font.FontFamily
// راهنما: این import وابستگی «androidx.compose.ui.text.font.FontWeight» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.font.FontWeight
// راهنما: این import وابستگی «androidx.compose.ui.unit.dp» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.unit.dp
// راهنما: این import وابستگی «androidx.compose.ui.unit.sp» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.unit.sp

// راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
private val LightColors = lightColorScheme(
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    primary = PrimaryLight, onPrimary = OnPrimaryLight,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    primaryContainer = PrimaryContainerLight, onPrimaryContainer = OnPrimaryContainerLight,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    secondary = SecondaryLight, tertiary = TertiaryLight,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    background = BackgroundLight, surface = SurfaceLight,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    surfaceVariant = SurfaceVariantLight, onSurface = OnSurfaceLight,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    onSurfaceVariant = OnSurfaceVariantLight, outline = OutlineLight,
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
)

// راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
private val DarkColors = darkColorScheme(
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    primary = PrimaryDark, onPrimary = OnPrimaryDark,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    primaryContainer = PrimaryContainerDark, onPrimaryContainer = OnPrimaryContainerDark,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    secondary = SecondaryDark, tertiary = TertiaryDark,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    background = BackgroundDark, surface = SurfaceDark,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    surfaceVariant = SurfaceVariantDark, onSurface = OnSurfaceDark,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    onSurfaceVariant = OnSurfaceVariantDark, outline = OutlineDark,
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
)

// V1.4 removes the cursive Latin font from V1.3. Default Android typography keeps
// English/Latin text clean while Persian remains soft and readable on the device.
// راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
private val AppTypography = Typography(
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    headlineLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.ExtraBold, fontSize = 30.sp, lineHeight = 39.sp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    headlineMedium = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.ExtraBold, fontSize = 24.sp, lineHeight = 33.sp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    titleLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Bold, fontSize = 20.sp, lineHeight = 29.sp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    titleMedium = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Bold, fontSize = 17.sp, lineHeight = 26.sp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    bodyLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Medium, fontSize = 16.sp, lineHeight = 27.sp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    bodyMedium = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 23.sp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    labelLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.SemiBold, fontSize = 14.sp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    labelMedium = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Medium, fontSize = 12.sp),
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
)

// راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
private val AppShapes = Shapes(
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    extraSmall = RoundedCornerShape(10.dp), small = RoundedCornerShape(15.dp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    medium = RoundedCornerShape(20.dp), large = RoundedCornerShape(27.dp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    extraLarge = RoundedCornerShape(34.dp),
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
)

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun TarikhYarTheme(content: @Composable () -> Unit) {
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    MaterialTheme(
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        colorScheme = if (isSystemInDarkTheme()) DarkColors else LightColors,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        typography = AppTypography,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        shapes = AppShapes,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        content = content,
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    )
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
