package ir.tarikhyar.app.feature.age

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.core.date.BirthInsights
import ir.tarikhyar.app.core.date.DateCalculations
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.date.PersianDate
import ir.tarikhyar.app.core.format.PersianFormat
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.DateFields
import ir.tarikhyar.app.ui.components.ErrorText
import ir.tarikhyar.app.ui.components.GradientHeroButton
import ir.tarikhyar.app.ui.components.ResultCard
import ir.tarikhyar.app.ui.components.StatTile
import ir.tarikhyar.app.ui.components.parsePersianDate
import ir.tarikhyar.app.ui.components.shareText
import java.time.LocalDate
import kotlin.math.max

@Composable
fun AgeScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var year by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var birth by remember { mutableStateOf<PersianDate?>(null) }
    var result by remember { mutableStateOf<DateCalculations.AgeResult?>(null) }
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }

    val shareValue = result?.let {
        "سن دقیق من در تاریخ‌یار: ${it.period.years} سال، ${it.period.months} ماه و ${it.period.days} روز."
    } ?: "تاریخ‌یار؛ محاسبه دقیق سن، تاریخ و رویدادهای سنی"

    Column(modifier.fillMaxSize()) {
        AppTopBar("محاسبه سن", onBack) { shareText(context, "محاسبه سن", shareValue) }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Surface(modifier = Modifier.weight(1f), shape = MaterialTheme.shapes.medium, color = Color(0xFFEAF2FF)) {
                        Text("از سن", modifier = Modifier.padding(11.dp), textAlign = TextAlign.Center, color = Color(0xFF496B9F))
                    }
                    Surface(modifier = Modifier.weight(1f), shape = MaterialTheme.shapes.medium, color = Color(0xFF3F7FE7)) {
                        Text("از تاریخ تولد", modifier = Modifier.padding(11.dp), textAlign = TextAlign.Center, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }

            item {
                ResultCard {
                    Text("تاریخ تولد 🎂", style = MaterialTheme.typography.titleMedium)
                    DateFields(year, month, day, { year = it }, { month = it }, { day = it })
                    ErrorText(error)
                    GradientHeroButton("محاسبه سن") {
                        val parsed = parsePersianDate(year, month, day)
                        when {
                            parsed == null -> { error = "تاریخ واردشده معتبر نیست."; birth = null; result = null }
                            PersianCalendar.compare(parsed, today) > 0 -> { error = "تاریخ تولد نمی‌تواند بعد از امروز باشد."; birth = null; result = null }
                            else -> { error = null; birth = parsed; result = DateCalculations.calculateAge(parsed, today) }
                        }
                    }
                }
            }

            item {
                AnimatedVisibility(result != null && birth != null) {
                    if (result != null && birth != null) AgeResultCard(birth!!, today, result!!)
                }
            }
        }
    }
}

@Composable
private fun AgeResultCard(birth: PersianDate, today: PersianDate, result: DateCalculations.AgeResult) {
    val info = remember(birth) { BirthInsights.calendarInfo(birth) }
    val legal = remember(birth) { PersianCalendar.addYears(birth, 18) }
    val daysToLegal = if (PersianCalendar.compare(today, legal) >= 0) 0 else PersianCalendar.daysBetween(today, legal).toInt()
    val yearDays = if (PersianCalendar.isLeapYear(today.year)) 366f else 365f
    val progress = (1f - (result.nextBirthdayDays.toFloat() / yearDays)).coerceIn(0f, 1f)

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        ResultCard {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                Surface(shape = CircleShape, color = Color(0xFF8DE6F4), modifier = Modifier.size(78.dp)) {
                    Box(contentAlignment = Alignment.Center) { Text("👦", style = MaterialTheme.typography.headlineLarge) }
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("سن شما", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text(
                        "${PersianFormat.digits(result.period.years)} سال",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.ExtraBold,
                    )
                    Text("${PersianFormat.digits(result.period.months)} ماه و ${PersianFormat.digits(result.period.days)} روز", color = Color(0xFF182248))
                }
            }

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CompactStat("سال", PersianFormat.digits(result.period.years), Modifier.weight(1f))
                CompactStat("ماه", PersianFormat.number(result.completedMonths), Modifier.weight(1f))
                CompactStat("هفته", PersianFormat.number(result.totalWeeks), Modifier.weight(1f))
                CompactStat("روز", PersianFormat.number(result.totalDays), Modifier.weight(1f))
            }

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.size(76.dp)) {
                    CircularProgressIndicator(
                        progress = { progress },
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = Color(0xFFFFD8DE),
                        strokeWidth = 7.dp,
                    )
                    Text("${(progress * 100).toInt()}%", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("تا تولد بعدی شما", color = Color(0xFF182248), fontWeight = FontWeight.Bold)
                    Text(
                        if (result.nextBirthdayDays == 0L) "امروز 🎉" else "${PersianFormat.number(result.nextBirthdayDays)} روز",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
                Text("🌙", style = MaterialTheme.typography.headlineMedium)
            }
        }

        ResultCard {
            Text("جزئیات تولد", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            DetailLine("تقویم شمسی", PersianFormat.persianDate(birth), "🗓️")
            DetailLine("تقویم میلادی", "${info.gregorian.year}/${info.gregorian.monthValue}/${info.gregorian.dayOfMonth} • ${info.gregorianMonthName}", "📅")
            DetailLine("تقویم قمری", "${info.hijriYear}/${info.hijriMonth}/${info.hijriDay} • ${info.hijriMonthName}", "🌙")
            DetailLine("حیوان سال", info.iranianAnimal, "🐾")
            DetailLine("شماره شمع", PersianFormat.digits(max(1, result.period.years)), "🕯️")
            DetailLine("روز هفته تولد", PersianFormat.weekday(result.birthWeekday), "🎈")
        }

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            StatTile("ساعت زندگی", PersianFormat.number(result.totalDays * 24L), Modifier.weight(1f))
            StatTile("دقیقه زندگی", PersianFormat.number(result.totalDays * 24L * 60L), Modifier.weight(1f))
        }

        ResultCard {
            Text("سن قانونی", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            Text("تاریخ کامل شدن ۱۸ سال: ${PersianFormat.persianDate(legal)}")
            Text(
                if (daysToLegal <= 0) "۱۸ سالگی کامل شده است." else "${PersianFormat.number(daysToLegal.toLong())} روز تا ۱۸ سالگی",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun CompactStat(label: String, value: String, modifier: Modifier = Modifier) {
    Surface(modifier = modifier, shape = MaterialTheme.shapes.small, color = Color(0xFFF4F6FC)) {
        Column(Modifier.padding(vertical = 9.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, fontWeight = FontWeight.Bold, color = Color(0xFF15204B))
            Text(label, style = MaterialTheme.typography.labelMedium, color = Color(0xFF77809A))
        }
    }
}

@Composable
private fun DetailLine(label: String, value: String, emoji: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(emoji)
            Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        Text(value, fontWeight = FontWeight.Bold, color = Color(0xFF182248), textAlign = TextAlign.End)
    }
}
