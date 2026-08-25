package ir.tarikhyar.app.feature.age

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
import ir.tarikhyar.app.ui.components.PrimaryButton
import ir.tarikhyar.app.ui.components.ResultCard
import ir.tarikhyar.app.ui.components.ScreenHeader
import ir.tarikhyar.app.ui.components.StatTile
import ir.tarikhyar.app.ui.components.parsePersianDate
import java.time.LocalDate

@Composable
fun AgeScreen(modifier: Modifier = Modifier) {
    var year by remember { mutableStateOf("") }; var month by remember { mutableStateOf("") }; var day by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }; var birth by remember { mutableStateOf<PersianDate?>(null) }
    var result by remember { mutableStateOf<DateCalculations.AgeResult?>(null) }
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }

    LazyColumn(modifier.fillMaxSize(), contentPadding = PaddingValues(18.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
        item { ScreenHeader("محاسبه سن", "سن دقیق، شمع تولد، زمان سپری‌شده و تولد بعدی") }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("تاریخ تولد", style = MaterialTheme.typography.titleMedium)
                DateFields(year, month, day, { year = it }, { month = it }, { day = it })
                ErrorText(error)
                PrimaryButton("محاسبه سن") {
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
    val hours = result.totalDays * 24L
    val minutes = hours * 60L
    val seconds = minutes * 60L
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        ResultCard {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("سن دقیق شما")
                Text("${PersianFormat.digits(result.period.years)} سال", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Text("${PersianFormat.digits(result.period.months)} ماه و ${PersianFormat.digits(result.period.days)} روز", style = MaterialTheme.typography.titleMedium)
                Text("🎂 ${PersianFormat.digits(result.period.years)} شمع روی کیک", color = MaterialTheme.colorScheme.primary)
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatTile("ماه کامل", PersianFormat.number(result.completedMonths), Modifier.weight(1f)); StatTile("هفته", PersianFormat.number(result.totalWeeks), Modifier.weight(1f))
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatTile("روز زندگی", PersianFormat.number(result.totalDays), Modifier.weight(1f)); StatTile("تا تولد بعدی", if (result.nextBirthdayDays == 0L) "امروز" else "${PersianFormat.number(result.nextBirthdayDays)} روز", Modifier.weight(1f))
        }
        ResultCard {
            Text("زمان سپری‌شده", style = MaterialTheme.typography.titleLarge)
            Text("${PersianFormat.number(hours)} ساعت")
            Text("${PersianFormat.number(minutes)} دقیقه")
            Text("${PersianFormat.number(seconds)} ثانیه")
        }
        ResultCard {
            Text("تولد شما در تقویم‌های دیگر", style = MaterialTheme.typography.titleLarge)
            Text("میلادی: ${info.gregorian.year}/${info.gregorian.monthValue}/${info.gregorian.dayOfMonth} (${info.gregorianMonthName})")
            Text("قمری: ${info.hijriYear}/${info.hijriMonth}/${info.hijriDay} (${info.hijriMonthName})")
            Text("روز تولد: ${PersianFormat.weekday(result.birthWeekday)}")
            Text("حیوان سال: ${info.iranianAnimal} • چینی: ${info.chineseAnimal}")
        }
        ResultCard {
            Text("سن ۱۸ سال", style = MaterialTheme.typography.titleLarge)
            Text("تاریخ: ${PersianFormat.persianDate(legal)}")
            Text(if (daysToLegal == 0L) "۱۸ سالگی تکمیل شده است." else "${PersianFormat.number(daysToLegal)} روز تا ۱۸ سالگی")
        }
    }
}
