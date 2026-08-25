package ir.tarikhyar.app.feature.age

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import ir.tarikhyar.app.ui.components.GradientHeroButton
import ir.tarikhyar.app.ui.components.ResultCard
import ir.tarikhyar.app.ui.components.ScreenHeader
import ir.tarikhyar.app.ui.components.SoftSectionCard
import ir.tarikhyar.app.ui.components.StatTile
import ir.tarikhyar.app.ui.components.parsePersianDate
import java.time.LocalDate

@Composable
fun AgeScreen(modifier: Modifier = Modifier) {
    var year by remember { mutableStateOf("") }; var month by remember { mutableStateOf("") }; var day by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }; var birth by remember { mutableStateOf<PersianDate?>(null) }
    var result by remember { mutableStateOf<DateCalculations.AgeResult?>(null) }
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }

    LazyColumn(modifier.fillMaxSize(), contentPadding = PaddingValues(18.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item { ScreenHeader("محاسبه سن", "تاریخ تولد را وارد کن و نتیجه کامل را در کارت‌های گرافیکی ببین") }
        item {
            SoftSectionCard {
                Text("تاریخ تولد", style = MaterialTheme.typography.titleMedium)
                DateFields(year, month, day, { year = it }, { month = it }, { day = it })
                ErrorText(error)
                GradientHeroButton("مشاهده نتیجه") {
                    val b = parsePersianDate(year, month, day)
                    when {
                        b == null -> { error = "تاریخ واردشده معتبر نیست."; result = null; birth = null }
                        PersianCalendar.compare(b, today) > 0 -> { error = "تاریخ تولد نمی‌تواند بعد از امروز باشد."; result = null; birth = null }
                        else -> { error = null; birth = b; result = DateCalculations.calculateAge(b, today) }
                    }
                }
            }
        }
        item { AnimatedVisibility(result != null && birth != null) { if (result != null && birth != null) AgeResultContent(birth!!, today, result!!) } }
    }
}

@Composable
private fun AgeResultContent(birth: PersianDate, today: PersianDate, result: DateCalculations.AgeResult) {
    val info = remember(birth) { BirthInsights.calendarInfo(birth) }
    val legal = remember(birth) { PersianCalendar.addYears(birth, 18) }
    val daysToLegal = if (PersianCalendar.compare(today, legal) >= 0) 0L else PersianCalendar.daysBetween(today, legal)
    val hours = result.totalDays * 24L; val minutes = hours * 60L; val seconds = minutes * 60L
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        ResultCard {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("سن دقیق شما", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    BigAgeNumber("سال", result.period.years); BigAgeNumber("ماه", result.period.months); BigAgeNumber("روز", result.period.days)
                }
                Text("🎂 ${PersianFormat.digits(result.period.years)} شمع روی کیک تولد", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatTile("ماه کامل", PersianFormat.number(result.completedMonths), Modifier.weight(1f)); StatTile("هفته", PersianFormat.number(result.totalWeeks), Modifier.weight(1f))
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatTile("روز زندگی", PersianFormat.number(result.totalDays), Modifier.weight(1f)); StatTile("تا تولد بعدی", if (result.nextBirthdayDays == 0L) "امروز" else "${PersianFormat.number(result.nextBirthdayDays)} روز", Modifier.weight(1f))
        }
        ResultCard {
            Text("تولد شما در تقویم‌های دیگر", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            InfoLine("شمسی", PersianFormat.persianDate(birth))
            InfoLine("میلادی", "${info.gregorian.year}/${info.gregorian.monthValue}/${info.gregorian.dayOfMonth} • ${info.gregorianMonthName}")
            InfoLine("قمری", "${info.hijriYear}/${info.hijriMonth}/${info.hijriDay} • ${info.hijriMonthName}")
            InfoLine("روز هفته تولد", PersianFormat.weekday(result.birthWeekday))
        }
        ResultCard {
            Text("حیوان سال و طالع", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            InfoLine("حیوان سال ایرانی", info.iranianAnimal)
            InfoLine("حیوان سال چینی", info.chineseAnimal)
            InfoLine("نام سال ترکی", info.turkicAnimal)
            InfoLine("برج میلادی", info.westernSign)
        }
        ResultCard {
            Text("ساعت زندگی", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            InfoLine("ساعت", PersianFormat.number(hours)); InfoLine("دقیقه", PersianFormat.number(minutes)); InfoLine("ثانیه", PersianFormat.number(seconds))
        }
        ResultCard {
            Text("سن قانونی", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            InfoLine("تاریخ کامل شدن ۱۸ سال", PersianFormat.persianDate(legal))
            Text(if (daysToLegal == 0L) "۱۸ سالگی تکمیل شده است." else "${PersianFormat.number(daysToLegal)} روز تا ۱۸ سالگی", color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun BigAgeNumber(label: String, value: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(PersianFormat.digits(value), style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.ExtraBold, color = MaterialTheme.colorScheme.primary)
        Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Composable
private fun InfoLine(label: String, value: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(value, style = MaterialTheme.typography.titleMedium)
    }
}
