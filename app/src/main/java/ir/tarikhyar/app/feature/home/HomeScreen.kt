package ir.tarikhyar.app.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.rounded.Cake
import androidx.compose.material.icons.rounded.Calculate
import androidx.compose.material.icons.rounded.CompareArrows
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
import ir.tarikhyar.app.core.format.PersianFormat
import ir.tarikhyar.app.ui.components.FeatureCard
import java.time.LocalDate

@Composable
fun HomeScreen(
    onNavigate: (AppScreen) -> Unit,
    modifier: Modifier = Modifier,
) {
    val todayGregorian = LocalDate.now()
    val today = PersianCalendar.fromGregorian(todayGregorian)

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(18.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
    ) {
        item {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "تاریخ‌یار",
                    style = MaterialTheme.typography.headlineLarge,
                )
                Text(
                    text = "سن، تاریخ و فاصله زمانی؛ سریع و آفلاین",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }

        item {
            TodayHero(
                weekday = PersianFormat.weekday(todayGregorian.dayOfWeek),
                date = PersianFormat.persianDate(today),
                gregorian = PersianFormat.gregorian(todayGregorian),
            )
        }

        item {
            Text(text = "چه کاری می‌خواهی انجام بدهی؟", style = MaterialTheme.typography.titleLarge)
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                FeatureCard(
                    title = "محاسبه سن",
                    subtitle = "سن دقیق تا امروز",
                    icon = Icons.Rounded.Cake,
                    onClick = { onNavigate(AppScreen.AGE) },
                    modifier = Modifier.weight(1f),
                )
                FeatureCard(
                    title = "اختلاف تاریخ",
                    subtitle = "فاصله دو تاریخ",
                    icon = Icons.Rounded.CompareArrows,
                    onClick = { onNavigate(AppScreen.DIFFERENCE) },
                    modifier = Modifier.weight(1f),
                )
            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                FeatureCard(
                    title = "تبدیل تاریخ",
                    subtitle = "شمسی و میلادی",
                    icon = Icons.Rounded.SwapHoriz,
                    onClick = { onNavigate(AppScreen.TOOLS) },
                    modifier = Modifier.weight(1f),
                )
                FeatureCard(
                    title = "محاسبه تاریخ",
                    subtitle = "روز، ماه یا سال بعد",
                    icon = Icons.Rounded.Calculate,
                    onClick = { onNavigate(AppScreen.TOOLS) },
                    modifier = Modifier.weight(1f),
                )
            }
        }

        item {
            Surface(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = MaterialTheme.shapes.large,
            ) {
                Column(modifier = Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(text = "نسخه ${BuildConfig.VERSION_NAME}", style = MaterialTheme.typography.titleMedium)
                    Text(
                        text = "تمام محاسبات این نسخه روی خود گوشی انجام می‌شود و به اینترنت نیاز ندارد.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
        }

        item { Spacer(modifier = Modifier.height(6.dp)) }
    }
}

@Composable
private fun TodayHero(weekday: String, date: String, gregorian: String) {
    val primary = MaterialTheme.colorScheme.primary
    val secondary = MaterialTheme.colorScheme.secondary

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.extraLarge)
            .background(Brush.linearGradient(listOf(primary, secondary)))
            .padding(22.dp),
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(88.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.10f)),
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(52.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.12f)),
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(text = "امروز $weekday", color = Color.White.copy(alpha = 0.88f))
                Text(
                    text = date,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Text(text = gregorian, color = Color.White.copy(alpha = 0.80f))
            }

            Surface(
                shape = CircleShape,
                color = Color.White.copy(alpha = 0.16f),
                modifier = Modifier.size(58.dp),
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Rounded.Cake,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(28.dp),
                    )
                }
            }
        }
    }
}
