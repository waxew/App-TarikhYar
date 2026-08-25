package ir.tarikhyar.app.feature.age

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import ir.tarikhyar.app.core.date.DateCalculations
import ir.tarikhyar.app.core.date.PersianCalendar
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
    var year by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var result by remember { mutableStateOf<DateCalculations.AgeResult?>(null) }

    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(18.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
    ) {
        item {
            ScreenHeader(
                title = "محاسبه سن",
                subtitle = "تاریخ تولد شمسی را وارد کن تا سن دقیق تا امروز محاسبه شود.",
            )
        }

        item {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(text = "تاریخ تولد", style = MaterialTheme.typography.titleMedium)
                DateFields(
                    year = year,
                    month = month,
                    day = day,
                    onYearChange = { year = it },
                    onMonthChange = { month = it },
                    onDayChange = { day = it },
                )
                ErrorText(error)
                PrimaryButton(text = "محاسبه سن") {
                    val birthDate = parsePersianDate(year, month, day)
                    when {
                        birthDate == null -> {
                            error = "تاریخ واردشده معتبر نیست."
                            result = null
                        }
                        PersianCalendar.compare(birthDate, today) > 0 -> {
                            error = "تاریخ تولد نمی‌تواند بعد از امروز باشد."
                            result = null
                        }
                        else -> {
                            error = null
                            result = DateCalculations.calculateAge(birthDate, today)
                        }
                    }
                }
            }
        }

        item {
            AnimatedVisibility(visible = result != null) {
                result?.let { AgeResultContent(it) }
            }
        }
    }
}

@Composable
private fun AgeResultContent(result: DateCalculations.AgeResult) {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        ResultCard {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Text(text = "سن دقیق شما", style = MaterialTheme.typography.bodyLarge)
                Text(
                    text = "${PersianFormat.digits(result.period.years)} سال",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                )
                Text(
                    text = "${PersianFormat.digits(result.period.months)} ماه و ${PersianFormat.digits(result.period.days)} روز",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatTile(
                label = "ماه کامل",
                value = PersianFormat.number(result.completedMonths),
                modifier = Modifier.weight(1f),
            )
            StatTile(
                label = "هفته",
                value = PersianFormat.number(result.totalWeeks),
                modifier = Modifier.weight(1f),
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatTile(
                label = "روز زندگی",
                value = PersianFormat.number(result.totalDays),
                modifier = Modifier.weight(1f),
            )
            StatTile(
                label = "تا تولد بعدی",
                value = if (result.nextBirthdayDays == 0L) "امروز" else "${PersianFormat.number(result.nextBirthdayDays)} روز",
                modifier = Modifier.weight(1f),
            )
        }

        ResultCard {
            Text(text = "روز تولد شما", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = PersianFormat.weekday(result.birthWeekday),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 4.dp),
            )
        }
    }
}
