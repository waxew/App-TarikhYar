package ir.tarikhyar.app.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.AppScreen
import ir.tarikhyar.app.BuildConfig
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.format.PersianFormat
import ir.tarikhyar.app.ui.components.FeatureCard
import java.time.LocalDate

@Composable
fun HomeScreen(onNavigate: (AppScreen) -> Unit, modifier: Modifier = Modifier) {
    val g = LocalDate.now(); val today = PersianCalendar.fromGregorian(g)
    LazyColumn(modifier.fillMaxSize(), contentPadding = PaddingValues(18.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
        item { Column(verticalArrangement = Arrangement.spacedBy(5.dp)) { Text("تاریخ‌یار", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary); Text("تقویم زندگی شما؛ ساده، رنگی و کاملاً آفلاین", color = MaterialTheme.colorScheme.onSurfaceVariant) } }
        item { TodayHero(PersianFormat.weekday(g.dayOfWeek), PersianFormat.persianDate(today), PersianFormat.gregorian(g)) }
        item { Text("از کجا شروع کنیم؟", style = MaterialTheme.typography.titleLarge) }
        item { Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            FeatureCard("محاسبه سن", "سن، شمع و ساعت عمر", Icons.Rounded.Cake, { onNavigate(AppScreen.AGE) }, Modifier.weight(1f))
            FeatureCard("اطلاعات تولد", "قمری، حیوان سال و طالع", Icons.Rounded.Stars, { onNavigate(AppScreen.INSIGHTS) }, Modifier.weight(1f))
        } }
        item { Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            FeatureCard("اختلاف تاریخ", "فاصله دقیق دو تاریخ", Icons.Rounded.CompareArrows, { onNavigate(AppScreen.DIFFERENCE) }, Modifier.weight(1f))
            FeatureCard("تبدیل تاریخ", "شمسی و میلادی", Icons.Rounded.SwapHoriz, { onNavigate(AppScreen.TOOLS) }, Modifier.weight(1f))
        } }
        item { Surface(color = MaterialTheme.colorScheme.primaryContainer, shape = MaterialTheme.shapes.large) { Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) { Text("نسخه ${BuildConfig.VERSION_NAME}", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary); Text("محاسبات اصلی روی گوشی انجام می‌شوند؛ بدون تبلیغ و بدون نیاز به اینترنت.", color = MaterialTheme.colorScheme.onSurfaceVariant) } } }
    }
}

@Composable
private fun TodayHero(weekday: String, date: String, gregorian: String) {
    Box(Modifier.fillMaxWidth().clip(MaterialTheme.shapes.extraLarge).background(Brush.linearGradient(listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary))).padding(23.dp)) {
        Box(Modifier.align(Alignment.TopStart).size(90.dp).clip(CircleShape).background(Color.White.copy(.10f)))
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) { Text("امروز $weekday", color = Color.White.copy(.9f)); Text(date, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = Color.White); Text(gregorian, color = Color.White.copy(.82f)) }
            Surface(shape = CircleShape, color = Color.White.copy(.18f), modifier = Modifier.size(62.dp)) { Box(contentAlignment = Alignment.Center) { Icon(Icons.Rounded.CalendarMonth, null, tint = Color.White, modifier = Modifier.size(31.dp)) } }
        }
    }
}
