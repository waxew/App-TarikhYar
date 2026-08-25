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
    secondary = SecondaryLight, tertiary = TertiaryLight,
    background = BackgroundLight, surface = SurfaceLight,
    surfaceVariant = SurfaceVariantLight, onSurface = OnSurfaceLight,
    onSurfaceVariant = OnSurfaceVariantLight, outline = OutlineLight,
)

private val DarkColors = darkColorScheme(
    primary = PrimaryDark, onPrimary = OnPrimaryDark,
    primaryContainer = PrimaryContainerDark, onPrimaryContainer = OnPrimaryContainerDark,
    secondary = SecondaryDark, tertiary = TertiaryDark,
    background = BackgroundDark, surface = SurfaceDark,
    surfaceVariant = SurfaceVariantDark, onSurface = OnSurfaceDark,
    onSurfaceVariant = OnSurfaceVariantDark, outline = OutlineDark,
)

// V1.4 removes the cursive Latin font from V1.3. Default Android typography keeps
// English/Latin text clean while Persian remains soft and readable on the device.
private val AppTypography = Typography(
    headlineLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.ExtraBold, fontSize = 30.sp, lineHeight = 39.sp),
    headlineMedium = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.ExtraBold, fontSize = 24.sp, lineHeight = 33.sp),
    titleLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Bold, fontSize = 20.sp, lineHeight = 29.sp),
    titleMedium = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Bold, fontSize = 17.sp, lineHeight = 26.sp),
    bodyLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Medium, fontSize = 16.sp, lineHeight = 27.sp),
    bodyMedium = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 23.sp),
    labelLarge = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.SemiBold, fontSize = 14.sp),
    labelMedium = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Medium, fontSize = 12.sp),
)

private val AppShapes = Shapes(
    extraSmall = RoundedCornerShape(10.dp), small = RoundedCornerShape(15.dp),
    medium = RoundedCornerShape(20.dp), large = RoundedCornerShape(27.dp),
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
