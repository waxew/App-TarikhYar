package ir.tarikhyar.app.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.Cake
import androidx.compose.material.icons.rounded.CompareArrows
import androidx.compose.material.icons.rounded.NotificationsNone
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material.icons.rounded.SwapHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import ir.tarikhyar.app.core.date.PersianDate
import ir.tarikhyar.app.core.format.PersianFormat
import ir.tarikhyar.app.ui.components.FeatureCard
import ir.tarikhyar.app.ui.components.SoftSectionCard
import java.time.LocalDate

@Composable
fun HomeScreen(onNavigate: (AppScreen) -> Unit, modifier: Modifier = Modifier) {
    val g = LocalDate.now(); val today = PersianCalendar.fromGregorian(g)
    LazyColumn(modifier.fillMaxSize(), contentPadding = PaddingValues(18.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                RoundTopIcon(Icons.Rounded.Settings)
                Text("سلام، به تاریخ‌یار خوش اومدی!", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                RoundTopIcon(Icons.Rounded.NotificationsNone)
            }
        }
        item { TodayHero(PersianFormat.weekday(g.dayOfWeek), PersianFormat.persianDate(today), PersianFormat.gregorian(g), dayOfYear(today), daysUntilEndOfYear(today)) }
        item {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                FeatureCard("محاسبه سن", "سن دقیق، شمع و ساعت عمر", Icons.Rounded.Cake, { onNavigate(AppScreen.AGE) }, Modifier.weight(1f))
                FeatureCard("اطلاعات تولد", "قمری، حیوان سال و طالع", Icons.Rounded.Stars, { onNavigate(AppScreen.INSIGHTS) }, Modifier.weight(1f))
            }
        }
        item {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                FeatureCard("اختلاف تاریخ", "فاصله دقیق دو تاریخ", Icons.Rounded.CompareArrows, { onNavigate(AppScreen.DIFFERENCE) }, Modifier.weight(1f))
                FeatureCard("تبدیل تاریخ", "شمسی و میلادی", Icons.Rounded.SwapHoriz, { onNavigate(AppScreen.TOOLS) }, Modifier.weight(1f))
            }
        }
        item {
            SoftSectionCard {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("نسخه ${BuildConfig.VERSION_NAME}", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                        Text("ساده، گرافیکی و بدون تبلیغات", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    Surface(shape = CircleShape, color = MaterialTheme.colorScheme.primaryContainer, modifier = Modifier.size(52.dp)) {
                        Box(contentAlignment = Alignment.Center) { Icon(Icons.Rounded.CalendarMonth, null, tint = MaterialTheme.colorScheme.primary) }
                    }
                }
            }
        }
        item { Spacer(Modifier.height(6.dp)) }
    }
}

@Composable
private fun RoundTopIcon(icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Surface(shape = CircleShape, color = MaterialTheme.colorScheme.surface, tonalElevation = 1.dp, shadowElevation = 2.dp) {
        Box(Modifier.size(42.dp), contentAlignment = Alignment.Center) { Icon(icon, null, tint = MaterialTheme.colorScheme.primary) }
    }
}

@Composable
private fun TodayHero(weekday: String, date: String, gregorian: String, passed: Int, remaining: Int) {
    Box(
        Modifier.fillMaxWidth().clip(MaterialTheme.shapes.extraLarge)
            .background(Brush.linearGradient(listOf(MaterialTheme.colorScheme.secondary, MaterialTheme.colorScheme.primary))).padding(20.dp)
    ) {
        Box(Modifier.align(Alignment.TopStart).size(96.dp).clip(CircleShape).background(Color.White.copy(.10f)))
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(weekday, color = Color.White.copy(.9f), style = MaterialTheme.typography.titleMedium)
            Text(date, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.ExtraBold, color = Color.White)
            Text(gregorian, color = Color.White.copy(.86f))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                HeroMetric("روز سپری‌شده", PersianFormat.number(passed.toLong()), Modifier.weight(1f))
                HeroMetric("روز تا پایان سال", PersianFormat.number(remaining.toLong()), Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun HeroMetric(title: String, value: String, modifier: Modifier = Modifier) {
    Surface(modifier, shape = MaterialTheme.shapes.medium, color = Color.White.copy(.18f)) {
        Column(Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(title, color = Color.White.copy(.84f), style = MaterialTheme.typography.labelMedium)
            Text(value, color = Color.White, style = MaterialTheme.typography.titleMedium)
        }
    }
}

private fun dayOfYear(date: PersianDate): Int {
    var result = date.day
    for (m in 1 until date.month) result += PersianCalendar.monthLength(date.year, m)
    return result
}

private fun daysUntilEndOfYear(date: PersianDate): Int = (if (PersianCalendar.isLeapYear(date.year)) 366 else 365) - dayOfYear(date)
