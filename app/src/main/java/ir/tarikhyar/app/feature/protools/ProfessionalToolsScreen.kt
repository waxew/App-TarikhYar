package ir.tarikhyar.app.feature.protools

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.core.data.LocalDataRepository
import ir.tarikhyar.app.core.data.OfficialEvents
import ir.tarikhyar.app.core.date.DateCalculations
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.date.PersianDate
import ir.tarikhyar.app.core.format.PersianFormat
import ir.tarikhyar.app.core.system.ShareCardRenderer
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.ChoicePill
import ir.tarikhyar.app.ui.components.PersianDatePickerDialog
import ir.tarikhyar.app.ui.components.PrimaryButton
import ir.tarikhyar.app.ui.components.ResultCard
import kotlinx.coroutines.delay
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

/** شناسه و عنوان ابزارهای حرفه‌ای برای Favorites و نمایش در چند صفحه. */
object ProfessionalToolCatalog {
    val items = linkedMapOf(
        "workdays" to "محاسبه روز کاری",
        "date_math" to "جمع و تفریق تاریخ",
        "age_on_date" to "سن در تاریخ دلخواه",
        "compare_age" to "مقایسه سن دو نفر",
        "countdown" to "شمارش معکوس رویداد",
    )
}

/** مجموعه ابزارهای حرفه‌ای تاریخ‌یار در یک صفحه اسکرولی و آفلاین. */
@Composable
fun ProfessionalToolsScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }
    var favorites by remember { mutableStateOf(LocalDataRepository.favoriteTools(context)) }

    fun toggle(id: String) {
        LocalDataRepository.toggleFavoriteTool(context, id)
        favorites = LocalDataRepository.favoriteTools(context)
    }

    Column(modifier.fillMaxSize()) {
        AppTopBar("ابزارهای حرفه‌ای", onBack)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            item { WorkdayTool(today, "workdays" in favorites) { toggle("workdays") } }
            item { DateMathTool(today, "date_math" in favorites) { toggle("date_math") } }
            item { AgeOnDateTool(today, "age_on_date" in favorites) { toggle("age_on_date") } }
            item { CompareAgeTool(today, "compare_age" in favorites) { toggle("compare_age") } }
            item { CountdownTool(today, "countdown" in favorites) { toggle("countdown") } }
        }
    }
}

@Composable
private fun ToolHeader(title: String, favorite: Boolean, onFavorite: () -> Unit) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Text(title, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
        IconButton(onClick = onFavorite) {
            Icon(if (favorite) Icons.Rounded.Star else Icons.Rounded.StarBorder, "علاقه‌مندی")
        }
    }
}

@Composable
private fun DateChoice(label: String, date: PersianDate, onClick: () -> Unit) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
            Text(label, fontWeight = FontWeight.Bold)
            Text(PersianFormat.persianDate(date), color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        TextButton(onClick = onClick) { Text("انتخاب") }
    }
}

@Composable
private fun WorkdayTool(today: PersianDate, favorite: Boolean, onFavorite: () -> Unit) {
    var start by remember { mutableStateOf(today) }
    var end by remember { mutableStateOf(PersianCalendar.addDays(today, 30)) }
    var picker by remember { mutableStateOf<String?>(null) }
    var result by remember { mutableStateOf<Int?>(null) }

    ResultCard {
        ToolHeader("روزهای کاری بین دو تاریخ", favorite, onFavorite)
        DateChoice("شروع", start) { picker = "start" }
        DateChoice("پایان", end) { picker = "end" }
        PrimaryButton("محاسبه روز کاری") { result = countWorkingDays(start, end) }
        result?.let {
            Text("${PersianFormat.number(it.toLong())} روز کاری", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
            Text("جمعه‌ها و تعطیلات ثابت خورشیدی از شمارش حذف می‌شوند.", color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
    picker?.let { target ->
        PersianDatePickerDialog(
            initial = if (target == "start") start else end,
            onDismiss = { picker = null },
            onSelected = {
                if (target == "start") start = it else end = it
                picker = null
            },
        )
    }
}

@Composable
private fun DateMathTool(today: PersianDate, favorite: Boolean, onFavorite: () -> Unit) {
    var base by remember { mutableStateOf(today) }
    var picker by remember { mutableStateOf(false) }
    var amountText by remember { mutableStateOf("1") }
    var unit by remember { mutableStateOf("روز") }
    var positive by remember { mutableStateOf(true) }
    var result by remember { mutableStateOf<PersianDate?>(null) }

    ResultCard {
        ToolHeader("جمع و تفریق تاریخ", favorite, onFavorite)
        DateChoice("تاریخ پایه", base) { picker = true }
        OutlinedTextField(
            value = amountText,
            onValueChange = { amountText = it.filter(Char::isDigit).take(6) },
            label = { Text("مقدار") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf("روز", "هفته", "ماه", "سال").forEach {
                ChoicePill(it, unit == it, { unit = it }, Modifier.weight(1f))
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ChoicePill("اضافه", positive, { positive = true }, Modifier.weight(1f))
            ChoicePill("کم کن", !positive, { positive = false }, Modifier.weight(1f))
        }
        PrimaryButton("محاسبه تاریخ جدید") {
            val amount = (amountText.toLongOrNull() ?: 0L) * if (positive) 1 else -1
            result = runCatching {
                when (unit) {
                    "روز" -> PersianCalendar.addDays(base, amount)
                    "هفته" -> PersianCalendar.addDays(base, amount * 7)
                    "ماه" -> PersianCalendar.addMonths(base, amount)
                    else -> PersianCalendar.addYears(base, amount)
                }
            }.getOrNull()
        }
        result?.let { Text(PersianFormat.persianDate(it), style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary) }
    }
    if (picker) PersianDatePickerDialog(base, { picker = false }) { base = it; picker = false }
}

@Composable
private fun AgeOnDateTool(today: PersianDate, favorite: Boolean, onFavorite: () -> Unit) {
    val context = LocalContext.current
    var birth by remember { mutableStateOf(PersianCalendar.addYears(today, -25)) }
    var target by remember { mutableStateOf(today) }
    var picker by remember { mutableStateOf<String?>(null) }
    var result by remember { mutableStateOf<DateCalculations.AgeResult?>(null) }

    ResultCard {
        ToolHeader("سن در تاریخ دلخواه", favorite, onFavorite)
        DateChoice("تاریخ تولد", birth) { picker = "birth" }
        DateChoice("تاریخ محاسبه", target) { picker = "target" }
        PrimaryButton("محاسبه") {
            result = if (PersianCalendar.compare(birth, target) <= 0) DateCalculations.calculateAge(birth, target) else null
        }
        result?.let {
            val text = "${PersianFormat.digits(it.period.years)} سال، ${PersianFormat.digits(it.period.months)} ماه و ${PersianFormat.digits(it.period.days)} روز"
            Text(text, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            TextButton(onClick = {
                ShareCardRenderer.share(context, "سن در تاریخ دلخواه", listOf(text, "تولد: ${PersianFormat.persianDate(birth)}", "تاریخ: ${PersianFormat.persianDate(target)}"))
            }) { Text("ساخت و اشتراک کارت تصویری") }
        }
    }
    picker?.let { key ->
        PersianDatePickerDialog(if (key == "birth") birth else target, { picker = null }) {
            if (key == "birth") birth = it else target = it
            picker = null
        }
    }
}

@Composable
private fun CompareAgeTool(today: PersianDate, favorite: Boolean, onFavorite: () -> Unit) {
    val context = LocalContext.current
    var first by remember { mutableStateOf(PersianCalendar.addYears(today, -30)) }
    var second by remember { mutableStateOf(PersianCalendar.addYears(today, -25)) }
    var picker by remember { mutableStateOf<String?>(null) }
    var result by remember { mutableStateOf<String?>(null) }

    ResultCard {
        ToolHeader("مقایسه سن دو نفر", favorite, onFavorite)
        DateChoice("تولد نفر اول", first) { picker = "first" }
        DateChoice("تولد نفر دوم", second) { picker = "second" }
        PrimaryButton("مقایسه") {
            val days = kotlin.math.abs(PersianCalendar.daysBetween(first, second))
            result = when {
                first == second -> "هر دو دقیقاً هم‌سن هستند."
                PersianCalendar.compare(first, second) < 0 -> "نفر اول ${PersianFormat.number(days)} روز بزرگ‌تر است."
                else -> "نفر دوم ${PersianFormat.number(days)} روز بزرگ‌تر است."
            }
        }
        result?.let { text ->
            Text(text, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            TextButton(onClick = { ShareCardRenderer.share(context, "مقایسه سن", listOf(text)) }) { Text("اشتراک کارت تصویری") }
        }
    }
    picker?.let { key ->
        PersianDatePickerDialog(if (key == "first") first else second, { picker = null }) {
            if (key == "first") first = it else second = it
            picker = null
        }
    }
}

@Composable
private fun CountdownTool(today: PersianDate, favorite: Boolean, onFavorite: () -> Unit) {
    var target by remember { mutableStateOf(PersianCalendar.addDays(today, 30)) }
    var picker by remember { mutableStateOf(false) }
    var secondsLeft by remember { mutableLongStateOf(0L) }

    LaunchedEffect(target) {
        while (true) {
            val gregorian = PersianCalendar.toGregorian(target)
            val targetTime = LocalDateTime.of(gregorian, LocalTime.of(23, 59, 59))
            secondsLeft = Duration.between(LocalDateTime.now(), targetTime).seconds.coerceAtLeast(0)
            delay(1000)
        }
    }

    ResultCard {
        ToolHeader("شمارش معکوس زنده", favorite, onFavorite)
        DateChoice("رویداد آینده", target) { picker = true }
        val days = secondsLeft / 86_400
        val hours = (secondsLeft % 86_400) / 3_600
        val minutes = (secondsLeft % 3_600) / 60
        val seconds = secondsLeft % 60
        Text(
            "${PersianFormat.number(days)} روز • ${PersianFormat.digits(hours)}:${PersianFormat.digits(minutes.toString().padStart(2, '0'))}:${PersianFormat.digits(seconds.toString().padStart(2, '0'))}",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
        )
    }
    if (picker) PersianDatePickerDialog(target, { picker = false }) { target = it; picker = false }
}

private fun countWorkingDays(first: PersianDate, second: PersianDate): Int {
    val (start, end) = if (PersianCalendar.compare(first, second) <= 0) first to second else second to first
    var date = start
    var count = 0
    while (PersianCalendar.compare(date, end) <= 0) {
        val gregorian = PersianCalendar.toGregorian(date)
        if (gregorian.dayOfWeek != DayOfWeek.FRIDAY && !OfficialEvents.isHoliday(date)) count++
        date = PersianCalendar.addDays(date, 1)
    }
    return count
}
