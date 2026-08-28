// این فایل داشبورد اصلی تاریخ‌یار و کارت‌های دسترسی سریع به ابزارها را نمایش می‌دهد.
package ir.tarikhyar.app.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.NotificationsNone
import androidx.compose.material.icons.rounded.Settings
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.AppScreen
import ir.tarikhyar.app.core.data.LocalDataRepository
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.date.PersianDate
import ir.tarikhyar.app.core.format.PersianFormat
import ir.tarikhyar.app.core.system.IconStyle
import ir.tarikhyar.app.core.system.UserSettings
import ir.tarikhyar.app.ui.components.GraphicMenuCard
import java.time.LocalDate

@Composable
fun HomeScreen(
    onNavigate: (AppScreen) -> Unit,
    onMenuClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val gregorian = LocalDate.now()
    val today = PersianCalendar.fromGregorian(gregorian)
    val context = androidx.compose.ui.platform.LocalContext.current
    val iconStyle = UserSettings.iconStyle(context)
    val nextBirthday = LocalDataRepository.nextBirthday(context, today)
    fun icon(graphic: String, minimal: String) = if (iconStyle == IconStyle.GRAPHIC) graphic else minimal

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth().clip(MaterialTheme.shapes.extraLarge)
                    .background(Brush.verticalGradient(listOf(Color(0xFFFF4861), Color(0xFFD81334))))
                    .padding(horizontal = 16.dp, vertical = 14.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TopIcon(Icons.Rounded.Menu, "منوی برنامه") { onMenuClick() }
                    Text("سلام! خوش اومدی 👋", style = MaterialTheme.typography.titleLarge, color = Color.White, fontWeight = FontWeight.ExtraBold)
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        TopIcon(Icons.Rounded.NotificationsNone, "اعلان‌ها") { onNavigate(AppScreen.NOTIFICATIONS) }
                        TopIcon(Icons.Rounded.Settings, "تنظیمات") { onNavigate(AppScreen.SETTINGS) }
                    }
                }

                Surface(
                    modifier = Modifier.fillMaxWidth().padding(top = 58.dp),
                    shape = MaterialTheme.shapes.large,
                    color = Color.White,
                    shadowElevation = 4.dp,
                ) {
                    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                        Surface(shape = CircleShape, color = Color(0xFFEAF9EC), modifier = Modifier.size(56.dp)) {
                            Box(contentAlignment = Alignment.Center) { Text(icon("🗓️", "▦"), style = MaterialTheme.typography.headlineMedium) }
                        }
                        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                            Text(PersianFormat.weekday(gregorian.dayOfWeek), color = Color(0xFFE31F43), fontWeight = FontWeight.Bold)
                            Text(PersianFormat.persianDate(today), style = MaterialTheme.typography.titleLarge, color = Color(0xFF182248))
                            Text(PersianFormat.gregorian(gregorian), color = Color(0xFF58617C), style = MaterialTheme.typography.bodyMedium)
                            Spacer(Modifier.height(5.dp))
                            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                HomeMetric("روز گذشته", PersianFormat.number(dayOfYear(today).toLong()), Modifier.weight(1f))
                                HomeMetric("تا پایان سال", PersianFormat.number(daysUntilEndOfYear(today).toLong()), Modifier.weight(1f))
                            }
                        }
                    }
                }
            }
        }

        item {
            Text("ابزارهای تاریخ‌یار", Modifier.fillMaxWidth().padding(horizontal = 18.dp), style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary, textAlign = TextAlign.Center)
        }

        item {
            Column(modifier = Modifier.padding(horizontal = 18.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    GraphicMenuCard("محاسبه سن", icon("🎂", "●"), { onNavigate(AppScreen.AGE) }, Modifier.weight(1f), "سن دقیق و تولد بعدی")
                    GraphicMenuCard("اطلاعات تولد", icon("🌸", "◇"), { onNavigate(AppScreen.BIRTH_INFO) }, Modifier.weight(1f), "شمسی، میلادی و قمری")
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    GraphicMenuCard("اختلاف تاریخ", icon("🗓️", "▣"), { onNavigate(AppScreen.DIFFERENCE) }, Modifier.weight(1f), "فاصله دقیق دو تاریخ")
                    GraphicMenuCard("تبدیل تاریخ", icon("🎁", "↔"), { onNavigate(AppScreen.TOOLS) }, Modifier.weight(1f), "شمسی و میلادی")
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    GraphicMenuCard("رویدادهای سنی", icon("🎯", "◎"), { onNavigate(AppScreen.AGE_EVENTS) }, Modifier.weight(1f), "مدرسه، ۱۸ سال و بیشتر")
                    GraphicMenuCard("طالع‌بینی چینی", icon("🐭", "☆"), { onNavigate(AppScreen.CHINESE) }, Modifier.weight(1f), "حیوان سال و ویژگی‌ها")
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    GraphicMenuCard("تقویم و مناسبت‌ها", icon("📅", "▣"), { onNavigate(AppScreen.CALENDAR) }, Modifier.weight(1f), "تقویم ماهانه و تعطیلات")
                    GraphicMenuCard("پروفایل‌ها", icon("👨‍👩‍👧", "○"), { onNavigate(AppScreen.PROFILES) }, Modifier.weight(1f), "خانواده، دوستان و یادآوری")
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    GraphicMenuCard("مناسبت شخصی", icon("💝", "+"), { onNavigate(AppScreen.PERSONAL_EVENTS) }, Modifier.weight(1f), "سالگرد و تاریخ دلخواه")
                    GraphicMenuCard("ابزارهای حرفه‌ای", icon("🚀", "≡"), { onNavigate(AppScreen.PRO_TOOLS) }, Modifier.weight(1f), "روز کاری، مقایسه و Countdown")
                }
            }
        }

        if (nextBirthday != null) {
            item {
                val (profile, days) = nextBirthday
                Surface(modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp), shape = MaterialTheme.shapes.large, color = MaterialTheme.colorScheme.primaryContainer) {
                    Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Text(icon("🎂", "●"), style = MaterialTheme.typography.headlineMedium)
                        Column {
                            Text("نزدیک‌ترین تولد: ${profile.name}", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                            Text(if (days == 0) "امروز تولدش است" else "${PersianFormat.number(days.toLong())} روز دیگر", color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }
        }

        item {
            Surface(modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp), shape = MaterialTheme.shapes.large, color = Color(0xFFFFEEF0)) {
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("⭐", style = MaterialTheme.typography.headlineMedium)
                    Column {
                        Text("بیش از ده‌ها محاسبه کاربردی", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                        Text("محیط فارسی، سریع، ساده و قابل استفاده بدون تایپ زیاد", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
        }
    }
}

@Composable
private fun TopIcon(icon: androidx.compose.ui.graphics.vector.ImageVector, description: String, onClick: () -> Unit) {
    Surface(modifier = Modifier.size(42.dp).clickable(onClick = onClick), shape = CircleShape, color = Color.White.copy(alpha = 0.97f)) {
        Box(contentAlignment = Alignment.Center) { Icon(icon, contentDescription = description, tint = Color(0xFFE31F43)) }
    }
}

@Composable
private fun HomeMetric(title: String, value: String, modifier: Modifier = Modifier) {
    Surface(modifier = modifier, shape = MaterialTheme.shapes.small, color = Color(0xFFFFF4EA)) {
        Column(Modifier.padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(title, style = MaterialTheme.typography.labelMedium, color = Color(0xFF77717A))
            Text(value, style = MaterialTheme.typography.titleMedium, color = Color(0xFF17204A), fontWeight = FontWeight.Bold)
        }
    }
}

private fun dayOfYear(date: PersianDate): Int {
    var result = date.day
    for (month in 1 until date.month) result += PersianCalendar.monthLength(date.year, month)
    return result
}

private fun daysUntilEndOfYear(date: PersianDate): Int {
    val yearLength = if (PersianCalendar.isLeapYear(date.year)) 366 else 365
    return yearLength - dayOfYear(date)
}
