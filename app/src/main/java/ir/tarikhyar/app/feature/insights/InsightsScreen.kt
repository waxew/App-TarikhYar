package ir.tarikhyar.app.feature.insights

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.core.date.BirthInsights
import ir.tarikhyar.app.core.date.DateCalculations
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.date.PersianDate
import ir.tarikhyar.app.core.format.PersianFormat
import ir.tarikhyar.app.ui.components.DateFields
import ir.tarikhyar.app.ui.components.ErrorText
import ir.tarikhyar.app.ui.components.PrimaryButton
import ir.tarikhyar.app.ui.components.ResultCard
import ir.tarikhyar.app.ui.components.ScreenHeader
import ir.tarikhyar.app.ui.components.StatTile
import ir.tarikhyar.app.ui.components.parsePersianDate
import java.time.LocalDate

@Composable
fun InsightsScreen(modifier: Modifier = Modifier) {
    var year by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var birth by remember { mutableStateOf<PersianDate?>(null) }
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(18.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item { ScreenHeader("اطلاعات تولد و زندگی", "یک تاریخ وارد کن؛ تبدیل‌ها، حیوان سال، طالع سرگرمی و نقاط عطف را یکجا ببین.") }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text("تاریخ تولد یا شروع رویداد", style = MaterialTheme.typography.titleMedium)
                DateFields(year, month, day, { year = it }, { month = it }, { day = it })
                ErrorText(error)
                PrimaryButton("نمایش همه جزئیات") {
                    val parsed = parsePersianDate(year, month, day)
                    if (parsed == null || PersianCalendar.compare(parsed, today) > 0) {
                        error = "یک تاریخ معتبر و گذشته وارد کن."
                        birth = null
                    } else { error = null; birth = parsed }
                }
            }
        }
        item {
            AnimatedVisibility(birth != null) {
                birth?.let { BirthDetails(it, today) }
            }
        }
    }
}

@Composable
private fun BirthDetails(birth: PersianDate, today: PersianDate) {
    val info = remember(birth) { BirthInsights.calendarInfo(birth) }
    val profile = remember(birth) { BirthInsights.profile(birth) }
    val milestones = remember(birth) { BirthInsights.milestones(birth) }
    val age = remember(birth, today) { DateCalculations.calculateAge(birth, today) }

    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        ResultCard {
            Text("معادل تاریخ تولد", style = MaterialTheme.typography.titleLarge)
            DetailLine("شمسی", PersianFormat.persianDate(birth))
            DetailLine("میلادی", "${info.gregorian.year}/${info.gregorian.monthValue}/${info.gregorian.dayOfMonth} — ${info.gregorianMonthName}")
            DetailLine("قمری", "${info.hijriYear}/${info.hijriMonth}/${info.hijriDay} — ${info.hijriMonthName}")
        }

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatTile("حیوان سال", info.iranianAnimal, Modifier.weight(1f))
            StatTile("چینی", info.chineseAnimal, Modifier.weight(1f))
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatTile("نام ترکی سال", info.turkicAnimal, Modifier.weight(1f))
            StatTile("برج میلادی", info.westernSign, Modifier.weight(1f))
        }

        SectionCard("خصوصیات ماه تولد ${profile.monthTitle} — سرگرمی") {
            Text(profile.traits)
            DetailLine("رنگ", profile.color); DetailLine("گل", profile.flower)
            DetailLine("بو", profile.scent); DetailLine("طعم", profile.flavor)
            DetailLine("جواهر", profile.jewel); DetailLine("حیوان", profile.favoriteAnimal)
            DetailLine("درخت", profile.tree); DetailLine("گیاه", profile.plant)
            DetailLine("ادویه", profile.spice); DetailLine("فلز", profile.metal)
            DetailLine("عدد شانس", profile.luckyNumber); DetailLine("شعار", profile.motto)
            DetailLine("بهترین جفت", profile.bestMatch); DetailLine("جفت چالش‌برانگیز", profile.challengingMatch)
            Text("این بخش جنبه سرگرمی و فرهنگی دارد و پیش‌بینی علمی شخصیت نیست.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }

        SectionCard("سن نوزاد، کودک و هر رویداد") {
            DetailLine("سال", PersianFormat.number(age.period.years.toLong()))
            DetailLine("ماه کامل", PersianFormat.number(age.completedMonths))
            DetailLine("هفته کامل", PersianFormat.number(age.totalWeeks))
            DetailLine("روز کامل", PersianFormat.number(age.totalDays))
            DetailLine("ساعت", PersianFormat.number(age.totalDays * 24L))
            DetailLine("دقیقه", PersianFormat.number(age.totalDays * 24L * 60L))
            Text("همین محاسبه برای سن ازدواج، عقد، پاکی، اشتغال، شرکت یا حیوان خانگی قابل استفاده است: تاریخ شروع همان رویداد را بالا وارد کن.", style = MaterialTheme.typography.bodyMedium)
        }

        SectionCard("نقاط عطف سنی") {
            milestones.forEach { m ->
                DetailLine(m.title, PersianFormat.persianDate(m.date))
                Text(m.note, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}

@Composable
private fun SectionCard(title: String, content: @Composable () -> Unit) {
    Surface(color = MaterialTheme.colorScheme.surface, shape = MaterialTheme.shapes.large, tonalElevation = 2.dp) {
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(title, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            content()
        }
    }
}

@Composable
private fun DetailLine(label: String, value: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(value, fontWeight = FontWeight.Bold)
    }
}
