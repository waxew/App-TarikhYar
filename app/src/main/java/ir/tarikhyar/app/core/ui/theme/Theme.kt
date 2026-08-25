package ir.tarikhyar.app.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val LightColors = lightColorScheme(
    primary = PrimaryLight, onPrimary = OnPrimaryLight,
    primaryContainer = PrimaryContainerLight, onPrimaryContainer = OnPrimaryContainerLight,
    secondary = SecondaryLight, background = BackgroundLight,
    surface = SurfaceLight, surfaceVariant = SurfaceVariantLight,
    onSurface = OnSurfaceLight, onSurfaceVariant = OnSurfaceVariantLight,
)

private val DarkColors = darkColorScheme(
    primary = PrimaryDark, onPrimary = OnPrimaryDark,
    primaryContainer = PrimaryContainerDark, onPrimaryContainer = OnPrimaryContainerDark,
    secondary = SecondaryDark, background = BackgroundDark,
    surface = SurfaceDark, surfaceVariant = SurfaceVariantDark,
    onSurface = OnSurfaceDark, onSurfaceVariant = OnSurfaceVariantDark,
)

// A softer, friendlier system typeface is preferred for V1.3. Persian glyphs
// gracefully fall back to the device Persian font where a cursive glyph is unavailable.
private val SoftFamily = FontFamily.Cursive
private val AppTypography = Typography(
    headlineLarge = TextStyle(fontFamily = SoftFamily, fontWeight = FontWeight.Bold, fontSize = 32.sp, lineHeight = 42.sp),
    headlineMedium = TextStyle(fontFamily = SoftFamily, fontWeight = FontWeight.Bold, fontSize = 25.sp, lineHeight = 34.sp),
    titleLarge = TextStyle(fontFamily = SoftFamily, fontWeight = FontWeight.Bold, fontSize = 21.sp, lineHeight = 30.sp),
    titleMedium = TextStyle(fontFamily = SoftFamily, fontWeight = FontWeight.SemiBold, fontSize = 17.sp, lineHeight = 26.sp),
    bodyLarge = TextStyle(fontFamily = SoftFamily, fontWeight = FontWeight.Normal, fontSize = 17.sp, lineHeight = 28.sp),
    bodyMedium = TextStyle(fontFamily = SoftFamily, fontWeight = FontWeight.Normal, fontSize = 15.sp, lineHeight = 24.sp),
    labelLarge = TextStyle(fontFamily = SoftFamily, fontWeight = FontWeight.SemiBold, fontSize = 15.sp),
)

private val AppShapes = Shapes(
    extraSmall = RoundedCornerShape(12.dp), small = RoundedCornerShape(16.dp),
    medium = RoundedCornerShape(22.dp), large = RoundedCornerShape(28.dp),
    extraLarge = RoundedCornerShape(34.dp),
)

@Composable
fun TarikhYarTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) DarkColors else LightColors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content,
    )
}
