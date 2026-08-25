package ir.tarikhyar.app.feature.tools

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.core.date.DateCalculations
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.date.PersianDate
import ir.tarikhyar.app.core.format.PersianFormat
import ir.tarikhyar.app.ui.components.ChoicePill
import ir.tarikhyar.app.ui.components.DateFields
import ir.tarikhyar.app.ui.components.ErrorText
import ir.tarikhyar.app.ui.components.PrimaryButton
import ir.tarikhyar.app.ui.components.ResultCard
import ir.tarikhyar.app.ui.components.ScreenHeader
import ir.tarikhyar.app.ui.components.parsePersianDate
import java.time.LocalDate

enum class ToolsTab { CONVERTER, ARITHMETIC }
private enum class CalendarInput { PERSIAN, GREGORIAN }

@Composable
fun ToolsScreen(modifier: Modifier = Modifier) {
    var tab by remember { mutableStateOf(ToolsTab.CONVERTER) }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(18.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
    ) {
        item {
            ScreenHeader(
                title = "ابزارهای تاریخ",
                subtitle = "تبدیل تاریخ یا محاسبه یک تاریخ جدید بدون نیاز به اینترنت.",
            )
        }

        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                ChoicePill(
                    text = "تبدیل تاریخ",
                    selected = tab == ToolsTab.CONVERTER,
                    onClick = { tab = ToolsTab.CONVERTER },
                    modifier = Modifier.weight(1f),
                )
                ChoicePill(
                    text = "محاسبه تاریخ",
                    selected = tab == ToolsTab.ARITHMETIC,
                    onClick = { tab = ToolsTab.ARITHMETIC },
                    modifier = Modifier.weight(1f),
                )
            }
        }

        item {
            when (tab) {
                ToolsTab.CONVERTER -> ConverterContent()
                ToolsTab.ARITHMETIC -> ArithmeticContent()
            }
        }
    }
}

@Composable
private fun ConverterContent() {
    val todayGregorian = remember { LocalDate.now() }
    val todayPersian = remember { PersianCalendar.fromGregorian(todayGregorian) }

    var inputCalendar by remember { mutableStateOf(CalendarInput.PERSIAN) }
    var year by remember { mutableStateOf(todayPersian.year.toString()) }
    var month by remember { mutableStateOf(todayPersian.month.toString()) }
    var day by remember { mutableStateOf(todayPersian.day.toString()) }
    var error by remember { mutableStateOf<String?>(null) }
    var persianResult by remember { mutableStateOf<PersianDate?>(null) }
    var gregorianResult by remember { mutableStateOf<LocalDate?>(null) }

    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Text(text = "نوع تاریخ ورودی", style = MaterialTheme.typography.titleMedium)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            ChoicePill(
                text = "شمسی",
                selected = inputCalendar == CalendarInput.PERSIAN,
                onClick = {
                    inputCalendar = CalendarInput.PERSIAN
                    year = todayPersian.year.toString()
                    month = todayPersian.month.toString()
                    day = todayPersian.day.toString()
                    error = null
                    persianResult = null
                    gregorianResult = null
                },
                modifier = Modifier.weight(1f),
            )
            ChoicePill(
                text = "میلادی",
                selected = inputCalendar == CalendarInput.GREGORIAN,
                onClick = {
                    inputCalendar = CalendarInput.GREGORIAN
                    year = todayGregorian.year.toString()
                    month = todayGregorian.monthValue.toString()
                    day = todayGregorian.dayOfMonth.toString()
                    error = null
                    persianResult = null
                    gregorianResult = null
                },
                modifier = Modifier.weight(1f),
            )
        }

        DateFields(year, month, day, { year = it }, { month = it }, { day = it })
        ErrorText(error)
        PrimaryButton(text = "تبدیل تاریخ") {
            when (inputCalendar) {
                CalendarInput.PERSIAN -> {
                    val persian = parsePersianDate(year, month, day)
                    if (persian == null) {
                        error = "تاریخ شمسی واردشده معتبر نیست."
                        persianResult = null
                        gregorianResult = null
                    } else {
                        error = null
                        persianResult = persian
                        gregorianResult = PersianCalendar.toGregorian(persian)
                    }
                }
                CalendarInput.GREGORIAN -> {
                    val gregorian = parseGregorian(year, month, day)
                    if (gregorian == null) {
                        error = "تاریخ میلادی واردشده معتبر نیست."
                        persianResult = null
                        gregorianResult = null
                    } else {
                        error = null
                        gregorianResult = gregorian
                        persianResult = PersianCalendar.fromGregorian(gregorian)
                    }
                }
            }
        }

        AnimatedVisibility(visible = persianResult != null && gregorianResult != null) {
            if (persianResult != null && gregorianResult != null) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    ResultCard {
                        Text(text = "شمسی", style = MaterialTheme.typography.bodyMedium)
                        Text(
                            text = PersianFormat.persianDate(persianResult!!),
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(top = 4.dp),
                        )
                        Text(
                            text = PersianFormat.persianNumeric(persianResult!!),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(top = 4.dp),
                        )
                    }
                    ResultCard {
                        Text(text = "میلادی", style = MaterialTheme.typography.bodyMedium)
                        Text(
                            text = PersianFormat.gregorian(gregorianResult!!),
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(top = 4.dp),
                        )
                        Text(
                            text = PersianFormat.weekday(gregorianResult!!.dayOfWeek),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(top = 4.dp),
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ArithmeticContent() {
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }
    var year by remember { mutableStateOf(today.year.toString()) }
    var month by remember { mutableStateOf(today.month.toString()) }
    var day by remember { mutableStateOf(today.day.toString()) }
    var amount by remember { mutableStateOf("30") }
    var addMode by remember { mutableStateOf(true) }
    var unit by remember { mutableStateOf(DateCalculations.Unit.DAYS) }
    var error by remember { mutableStateOf<String?>(null) }
    var result by remember { mutableStateOf<PersianDate?>(null) }

    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Text(text = "تاریخ مبنا", style = MaterialTheme.typography.titleMedium)
        DateFields(year, month, day, { year = it }, { month = it }, { day = it })

        Text(text = "عملیات", style = MaterialTheme.typography.titleMedium)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            ChoicePill("اضافه کردن", addMode, { addMode = true }, Modifier.weight(1f))
            ChoicePill("کم کردن", !addMode, { addMode = false }, Modifier.weight(1f))
        }

        OutlinedTextField(
            value = amount,
            onValueChange = { raw ->
                val normalized = normalizeDigits(raw)
                if (normalized.length <= 7) amount = normalized
            },
            label = { Text("تعداد") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
        )

        Text(text = "واحد", style = MaterialTheme.typography.titleMedium)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ChoicePill("روز", unit == DateCalculations.Unit.DAYS, { unit = DateCalculations.Unit.DAYS }, Modifier.weight(1f))
            ChoicePill("هفته", unit == DateCalculations.Unit.WEEKS, { unit = DateCalculations.Unit.WEEKS }, Modifier.weight(1f))
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ChoicePill("ماه", unit == DateCalculations.Unit.MONTHS, { unit = DateCalculations.Unit.MONTHS }, Modifier.weight(1f))
            ChoicePill("سال", unit == DateCalculations.Unit.YEARS, { unit = DateCalculations.Unit.YEARS }, Modifier.weight(1f))
        }

        ErrorText(error)
        PrimaryButton(text = "محاسبه تاریخ جدید") {
            val baseDate = parsePersianDate(year, month, day)
            val rawAmount = amount.toLongOrNull()
            when {
                baseDate == null -> {
                    error = "تاریخ مبنا معتبر نیست."
                    result = null
                }
                rawAmount == null -> {
                    error = "تعداد را به‌صورت عدد وارد کن."
                    result = null
                }
                else -> {
                    val signed = if (addMode) rawAmount else -rawAmount
                    try {
                        result = DateCalculations.add(baseDate, signed, unit)
                        error = null
                    } catch (_: IllegalArgumentException) {
                        result = null
                        error = "نتیجه خارج از بازه پشتیبانی‌شده تقویم است."
                    }
                }
            }
        }

        AnimatedVisibility(visible = result != null) {
            result?.let { calculated ->
                ResultCard {
                    Text(text = "تاریخ جدید", style = MaterialTheme.typography.bodyMedium)
                    Text(
                        text = PersianFormat.persianDate(calculated),
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(top = 4.dp),
                    )
                    Text(
                        text = "میلادی: ${PersianFormat.gregorian(PersianCalendar.toGregorian(calculated))}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = 6.dp),
                    )
                }
            }
        }
    }
}

private fun parseGregorian(year: String, month: String, day: String): LocalDate? = try {
    LocalDate.of(year.toInt(), month.toInt(), day.toInt())
} catch (_: Exception) {
    null
}

private fun normalizeDigits(input: String): String = input.mapNotNull { ch ->
    when (ch) {
        in '0'..'9' -> ch
        '۰' -> '0'
        '۱' -> '1'
        '۲' -> '2'
        '۳' -> '3'
        '۴' -> '4'
        '۵' -> '5'
        '۶' -> '6'
        '۷' -> '7'
        '۸' -> '8'
        '۹' -> '9'
        else -> null
    }
}.joinToString("")
