package ir.tarikhyar.app.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.tarikhyar.app.core.system.AccentStyle
import ir.tarikhyar.app.core.system.ThemeMode

private fun lightColors(accent: AccentStyle) = lightColorScheme(
    primary = when (accent) {
        AccentStyle.RED -> PrimaryLight
        AccentStyle.ROSE -> Color(0xFFD64379)
        AccentStyle.AMBER -> Color(0xFFDD7B18)
    },
    onPrimary = OnPrimaryLight,
    primaryContainer = PrimaryContainerLight,
    onPrimaryContainer = OnPrimaryContainerLight,
    secondary = SecondaryLight,
    tertiary = TertiaryLight,
    background = BackgroundLight,
    surface = SurfaceLight,
    surfaceVariant = SurfaceVariantLight,
    onSurface = OnSurfaceLight,
    onSurfaceVariant = OnSurfaceVariantLight,
    outline = OutlineLight,
)

private fun darkColors(accent: AccentStyle) = darkColorScheme(
    primary = when (accent) {
        AccentStyle.RED -> PrimaryDark
        AccentStyle.ROSE -> Color(0xFFFFB0CE)
        AccentStyle.AMBER -> Color(0xFFFFC783)
    },
    onPrimary = OnPrimaryDark,
    primaryContainer = PrimaryContainerDark,
    onPrimaryContainer = OnPrimaryContainerDark,
    secondary = SecondaryDark,
    tertiary = TertiaryDark,
    background = BackgroundDark,
    surface = SurfaceDark,
    surfaceVariant = SurfaceVariantDark,
    onSurface = OnSurfaceDark,
    onSurfaceVariant = OnSurfaceVariantDark,
    outline = OutlineDark,
)

private fun typography(scale: Float) = Typography(
    headlineLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.ExtraBold, fontSize = (30 * scale).sp, lineHeight = (39 * scale).sp),
    headlineMedium = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.ExtraBold, fontSize = (24 * scale).sp, lineHeight = (33 * scale).sp),
    titleLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Bold, fontSize = (20 * scale).sp, lineHeight = (29 * scale).sp),
    titleMedium = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Bold, fontSize = (17 * scale).sp, lineHeight = (26 * scale).sp),
    bodyLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Medium, fontSize = (16 * scale).sp, lineHeight = (27 * scale).sp),
    bodyMedium = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Normal, fontSize = (14 * scale).sp, lineHeight = (23 * scale).sp),
    labelLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.SemiBold, fontSize = (14 * scale).sp),
    labelMedium = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Medium, fontSize = (12 * scale).sp),
)

private val AppShapes = Shapes(
    extraSmall = RoundedCornerShape(10.dp),
    small = RoundedCornerShape(15.dp),
    medium = RoundedCornerShape(20.dp),
    large = RoundedCornerShape(27.dp),
    extraLarge = RoundedCornerShape(34.dp),
)

/** تم تاریخ‌یار از تنظیمات کاربر برای حالت روشن/تیره، رنگ و اندازه متن استفاده می‌کند. */
@Composable
fun TarikhYarTheme(
    themeMode: ThemeMode = ThemeMode.SYSTEM,
    accentStyle: AccentStyle = AccentStyle.RED,
    fontScale: Float = 1f,
    content: @Composable () -> Unit,
) {
    val dark = when (themeMode) {
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
    }
    MaterialTheme(
        colorScheme = if (dark) darkColors(accentStyle) else lightColors(accentStyle),
        typography = typography(fontScale.coerceIn(0.9f, 1.2f)),
        shapes = AppShapes,
        content = content,
    )
}
