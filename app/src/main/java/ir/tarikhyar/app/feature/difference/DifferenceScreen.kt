package ir.tarikhyar.app.feature.difference

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
fun DifferenceScreen(modifier: Modifier = Modifier) {
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }
    val defaultEnd = remember { PersianCalendar.addDays(today, 30) }

    var y1 by remember { mutableStateOf(today.year.toString()) }
    var m1 by remember { mutableStateOf(today.month.toString()) }
    var d1 by remember { mutableStateOf(today.day.toString()) }
    var y2 by remember { mutableStateOf(defaultEnd.year.toString()) }
    var m2 by remember { mutableStateOf(defaultEnd.month.toString()) }
    var d2 by remember { mutableStateOf(defaultEnd.day.toString()) }
    var error by remember { mutableStateOf<String?>(null) }
    var result by remember { mutableStateOf<DateCalculations.DifferenceResult?>(null) }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(18.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
    ) {
        item {
            ScreenHeader(
                title = "اختلاف دو تاریخ",
                subtitle = "فاصله تقویمی و تعداد دقیق روزهای بین دو تاریخ شمسی را ببین.",
            )
        }

        item {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(text = "از تاریخ", style = MaterialTheme.typography.titleMedium)
                DateFields(y1, m1, d1, { y1 = it }, { m1 = it }, { d1 = it })
                Text(text = "تا تاریخ", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(top = 4.dp))
                DateFields(y2, m2, d2, { y2 = it }, { m2 = it }, { d2 = it })
                ErrorText(error)
                PrimaryButton(text = "محاسبه اختلاف") {
                    val first = parsePersianDate(y1, m1, d1)
                    val second = parsePersianDate(y2, m2, d2)
                    if (first == null || second == null) {
                        error = "یکی از تاریخ‌ها معتبر نیست."
                        result = null
                    } else {
                        error = null
                        result = DateCalculations.difference(first, second)
                    }
                }
            }
        }

        item {
            AnimatedVisibility(visible = result != null) {
                result?.let { DifferenceResultContent(it) }
            }
        }
    }
}

@Composable
private fun DifferenceResultContent(result: DateCalculations.DifferenceResult) {
    val p = result.period
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        ResultCard {
            Text(text = "فاصله دقیق", style = MaterialTheme.typography.bodyLarge)
            Text(
                text = "${PersianFormat.digits(p.years)} سال، ${PersianFormat.digits(p.months)} ماه، ${PersianFormat.digits(p.days)} روز",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 6.dp),
            )
            if (result.reversedInput) {
                Text(
                    text = "ترتیب دو تاریخ برای محاسبه به‌صورت خودکار اصلاح شد.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 10.dp),
                )
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatTile("روز", PersianFormat.number(result.totalDays), Modifier.weight(1f))
            StatTile("هفته کامل", PersianFormat.number(result.totalDays / 7), Modifier.weight(1f))
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatTile("ساعت", PersianFormat.number(result.totalDays * 24), Modifier.weight(1f))
            StatTile("دقیقه", PersianFormat.number(result.totalDays * 24 * 60), Modifier.weight(1f))
        }
    }
}
