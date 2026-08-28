package ir.tarikhyar.app.feature.calendar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.core.data.LocalDataRepository
import ir.tarikhyar.app.core.data.OfficialEvents
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.date.PersianDate
import ir.tarikhyar.app.core.format.PersianFormat
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.ResultCard
import java.time.LocalDate

/** تقویم ماهانه شمسی با مناسبت‌های ثابت، تعطیلات و مناسبت‌های شخصی کاربر. */
@Composable
fun CalendarScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }
    var monthCursor by remember { mutableStateOf(PersianDate(today.year, today.month, 1)) }
    var selected by remember { mutableStateOf(today) }
    var query by remember { mutableStateOf("") }
    val personalEvents = LocalDataRepository.events(context)

    Column(modifier.fillMaxSize()) {
        AppTopBar("تقویم و مناسبت‌ها", onBack)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            item {
                OutlinedTextField(
                    value = query,
                    onValueChange = { query = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    leadingIcon = { Icon(Icons.Rounded.Search, null) },
                    label = { Text("جست‌وجوی تاریخ و مناسبت") },
                )
            }

            if (query.isBlank()) {
                item {
                    ResultCard {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            IconButton(onClick = { monthCursor = PersianCalendar.addMonths(monthCursor, -1) }) {
                                Icon(Icons.Rounded.ChevronRight, "ماه قبل")
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(monthCursor.monthName, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                                Text(PersianFormat.digits(monthCursor.year), color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                            IconButton(onClick = { monthCursor = PersianCalendar.addMonths(monthCursor, 1) }) {
                                Icon(Icons.Rounded.ChevronLeft, "ماه بعد")
                            }
                        }

                        CalendarGrid(
                            year = monthCursor.year,
                            month = monthCursor.month,
                            today = today,
                            selected = selected,
                            personalDates = personalEvents.map { it.date }.toSet(),
                            onSelect = { selected = it },
                        )
                    }
                }

                item {
                    val official = OfficialEvents.forDate(selected)
                    val personal = personalEvents.filter { it.date == selected }
                    ResultCard {
                        Text("${PersianFormat.persianDate(selected)}", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                        if (official.isEmpty() && personal.isEmpty()) {
                            Text("برای این روز مناسبت ثبت‌شده‌ای وجود ندارد.", color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        official.forEach {
                            Text("${if (it.holiday) "🔴" else "📌"} ${it.title}", fontWeight = FontWeight.Bold)
                        }
                        personal.forEach {
                            Text("⭐ ${it.title} • ${it.category}")
                            if (it.note.isNotBlank()) Text(it.note, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }

                item {
                    ResultCard {
                        Text("راهنمای تعطیلات", style = MaterialTheme.typography.titleMedium)
                        Text(
                            "تعطیلات ثابت خورشیدی با رنگ قرمز مشخص شده‌اند. مناسبت‌های قمری متغیر به دلیل تغییر سالانه در فهرست ثابت قرار نگرفته‌اند.",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                }
            } else {
                item {
                    val normalized = query.trim()
                    val officialMatches = OfficialEvents.items.filter { it.title.contains(normalized, ignoreCase = true) }
                    val personalMatches = personalEvents.filter {
                        it.title.contains(normalized, ignoreCase = true) ||
                            it.note.contains(normalized, ignoreCase = true) ||
                            PersianFormat.persianNumeric(it.date).contains(normalized)
                    }
                    ResultCard {
                        Text("نتایج جست‌وجو", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                        if (officialMatches.isEmpty() && personalMatches.isEmpty()) {
                            Text("نتیجه‌ای پیدا نشد.", color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        officialMatches.forEach {
                            Text("${if (it.holiday) "🔴" else "📌"} ${it.title} — ${PersianFormat.digits(it.day)} ${PersianDate(1400, it.month, 1).monthName}")
                        }
                        personalMatches.forEach {
                            Text("⭐ ${it.title} — ${PersianFormat.persianDate(it.date)}")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun CalendarGrid(
    year: Int,
    month: Int,
    today: PersianDate,
    selected: PersianDate,
    personalDates: Set<PersianDate>,
    onSelect: (PersianDate) -> Unit,
) {
    val week = listOf("ش", "ی", "د", "س", "چ", "پ", "ج")
    Row(Modifier.fillMaxWidth()) {
        week.forEach { title ->
            Text(
                title,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                color = if (title == "ج") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.Bold,
            )
        }
    }

    val firstGregorian = PersianCalendar.toGregorian(PersianDate(year, month, 1))
    val offset = (firstGregorian.dayOfWeek.value + 1) % 7
    val length = PersianCalendar.monthLength(year, month)
    val cells: List<Int?> = List(offset) { null } + (1..length).toList()
    cells.chunked(7).forEach { row ->
        Row(Modifier.fillMaxWidth()) {
            (row + List(7 - row.size) { null }).forEach { day ->
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    if (day != null) {
                        val date = PersianDate(year, month, day)
                        val isToday = date == today
                        val isSelected = date == selected
                        val isHoliday = OfficialEvents.isHoliday(date) || PersianCalendar.toGregorian(date).dayOfWeek == java.time.DayOfWeek.FRIDAY
                        val hasPersonal = date in personalDates
                        Surface(
                            modifier = Modifier.size(42.dp).clickable { onSelect(date) },
                            shape = CircleShape,
                            color = when {
                                isSelected -> MaterialTheme.colorScheme.primary
                                isToday -> MaterialTheme.colorScheme.primaryContainer
                                else -> Color.Transparent
                            },
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        PersianFormat.digits(day),
                                        color = when {
                                            isSelected -> Color.White
                                            isHoliday -> MaterialTheme.colorScheme.primary
                                            else -> MaterialTheme.colorScheme.onSurface
                                        },
                                        fontWeight = if (isToday || isSelected) FontWeight.Bold else FontWeight.Normal,
                                    )
                                    if (hasPersonal) Text("•", color = if (isSelected) Color.White else MaterialTheme.colorScheme.secondary)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
