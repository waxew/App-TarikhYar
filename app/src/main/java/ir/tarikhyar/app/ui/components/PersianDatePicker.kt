package ir.tarikhyar.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.date.PersianDate
import ir.tarikhyar.app.core.format.PersianFormat

private const val MIN_PICKER_YEAR = 1200
private const val MAX_PICKER_YEAR = 1600

/** انتخابگر تاریخ شمسی بدون نیاز به تایپ را با کنترل‌های افزایش و کاهش نمایش می‌دهد. */
@Composable
fun PersianDatePickerDialog(
    initial: PersianDate,
    onDismiss: () -> Unit,
    onSelected: (PersianDate) -> Unit,
) {
    var year by remember { mutableIntStateOf(initial.year) }
    var month by remember { mutableIntStateOf(initial.month) }
    var day by remember { mutableIntStateOf(initial.day) }

    fun normalizeDay() {
        day = day.coerceIn(1, PersianCalendar.monthLength(year, month))
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("انتخاب تاریخ شمسی") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                DateStepper("سال", year, { year = (year - 1).coerceAtLeast(MIN_PICKER_YEAR); normalizeDay() }, { year = (year + 1).coerceAtMost(MAX_PICKER_YEAR); normalizeDay() })
                DateStepper("ماه", month, {
                    month = if (month <= 1) 12 else month - 1
                    normalizeDay()
                }, {
                    month = if (month >= 12) 1 else month + 1
                    normalizeDay()
                })
                DateStepper("روز", day, {
                    day = if (day <= 1) PersianCalendar.monthLength(year, month) else day - 1
                }, {
                    val max = PersianCalendar.monthLength(year, month)
                    day = if (day >= max) 1 else day + 1
                })
            }
        },
        confirmButton = {
            TextButton(onClick = { onSelected(PersianDate(year, month, day)) }) { Text("انتخاب") }
        },
        dismissButton = { TextButton(onClick = onDismiss) { Text("انصراف") } },
    )
}

@Composable
private fun DateStepper(
    label: String,
    value: Int,
    onMinus: () -> Unit,
    onPlus: () -> Unit,
) {
    Surface(shape = MaterialTheme.shapes.medium, color = MaterialTheme.colorScheme.surfaceVariant) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            IconButton(onClick = onPlus) { Icon(Icons.Rounded.Add, contentDescription = "افزایش $label") }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(PersianFormat.digits(value), style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            IconButton(onClick = onMinus) { Icon(Icons.Rounded.Remove, contentDescription = "کاهش $label") }
        }
    }
}
