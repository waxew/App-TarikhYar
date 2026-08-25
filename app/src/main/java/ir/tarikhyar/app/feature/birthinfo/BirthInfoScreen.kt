package ir.tarikhyar.app.feature.birthinfo

import androidx.compose.animation.AnimatedVisibility
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
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.date.PersianDate
import ir.tarikhyar.app.core.format.PersianFormat
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.ChoicePill
import ir.tarikhyar.app.ui.components.DateFields
import ir.tarikhyar.app.ui.components.ErrorText
import ir.tarikhyar.app.ui.components.PrimaryButton
import ir.tarikhyar.app.ui.components.ResultCard
import ir.tarikhyar.app.ui.components.parsePersianDate
import ir.tarikhyar.app.ui.components.shareText
import java.time.LocalDate

@Composable
fun BirthInfoScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }
    var year by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var birth by remember { mutableStateOf<PersianDate?>(null) }
    var selectedTab by remember { mutableStateOf(0) }

    val shareValue = birth?.let { "اطلاعات تولد من: ${PersianFormat.persianDate(it)} — تاریخ‌یار" }
        ?: "تاریخ‌یار؛ اطلاعات کامل تولد در تقویم‌های شمسی، میلادی و قمری"

    Column(modifier.fillMaxSize()) {
        AppTopBar("اطلاعات تولد", onBack) { shareText(context, "اطلاعات تولد", shareValue) }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            item {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    ChoicePill("شمسی", selectedTab == 0, { selectedTab = 0 }, Modifier.weight(1f))
                    ChoicePill("میلادی", selectedTab == 1, { selectedTab = 1 }, Modifier.weight(1f))
                    ChoicePill("قمری", selectedTab == 2, { selectedTab = 2 }, Modifier.weight(1f))
                }
            }
            item {
                ResultCard {
                    Text("تاریخ تولد", style = MaterialTheme.typography.titleMedium)
                    DateFields(year, month, day, { year = it }, { month = it }, { day = it })
                    ErrorText(error)
                    PrimaryButton("نمایش اطلاعات") {
                        val parsed = parsePersianDate(year, month, day)
                        if (parsed == null || PersianCalendar.compare(parsed, today) > 0) {
                            error = "تاریخ تولد معتبر وارد کن."
                            birth = null
                        } else {
                            error = null
                            birth = parsed
                        }
                    }
                }
            }
            item {
                AnimatedVisibility(birth != null) {
                    birth?.let { BirthCards(it, selectedTab) }
                }
            }
        }
    }
}

@Composable
private fun BirthCards(birth: PersianDate, selectedTab: Int) {
    val info = remember(birth) { BirthInsights.calendarInfo(birth) }
    val profile = remember(birth) { BirthInsights.profile(birth) }
    val gregorianText = "${info.gregorian.dayOfMonth} ${info.gregorianMonthName} ${info.gregorian.year}"
    val hijriText = "${info.hijriDay} ${info.hijriMonthName} ${info.hijriYear}"

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        when (selectedTab) {
            0 -> CalendarHighlight("معادل شمسی تولد", PersianFormat.persianDate(birth), PersianFormat.persianNumeric(birth), "🗓️", Color(0xFFFFE7EA))
            1 -> CalendarHighlight("معادل میلادی تولد", gregorianText, PersianFormat.weekday(info.gregorian.dayOfWeek), "📅", Color(0xFFE6F1FF))
            else -> CalendarHighlight("معادل قمری تولد", hijriText, info.hijriMonthName, "🌙", Color(0xFFE7F0FF))
        }

        CalendarHighlight("معادل میلادی تولد", gregorianText, PersianFormat.weekday(info.gregorian.dayOfWeek), "📅", Color(0xFFE6F1FF))
        CalendarHighlight("معادل قمری تولد", hijriText, info.hijriMonthName, "🌙", Color(0xFFE7F0FF))

        ResultCard {
            Text("اطلاعات بیشتر", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            InfoLine("ماه میلادی", info.gregorianMonthName, "☀️")
            InfoLine("ماه قمری", info.hijriMonthName, "🌙")
            InfoLine("حیوان سال ایرانی", info.iranianAnimal, animalEmoji(info.iranianAnimal))
            InfoLine("نام سال ترکی", info.turkicAnimal, "🏳️")
            InfoLine("حیوان سال چینی", info.chineseAnimal, animalEmoji(info.chineseAnimal))
            InfoLine("برج میلادی", info.westernSign, "♈")
            InfoLine("گل ماه تولد", profile.flower, "🌸")
            InfoLine("رنگ مرتبط", profile.color, "🎨")
        }
    }
}

@Composable
private fun CalendarHighlight(title: String, main: String, subtitle: String, emoji: String, badgeColor: Color) {
    ResultCard {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
            Surface(shape = MaterialTheme.shapes.medium, color = badgeColor, modifier = Modifier.size(66.dp)) {
                Box(contentAlignment = Alignment.Center) { Text(emoji, style = MaterialTheme.typography.headlineMedium) }
            }
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(title, style = MaterialTheme.typography.titleMedium, color = Color(0xFF182248))
                Text(main, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = Color(0xFF182248))
                Text(subtitle, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}

@Composable
private fun InfoLine(label: String, value: String, emoji: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(emoji)
            Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        Text(value, fontWeight = FontWeight.Bold, textAlign = TextAlign.End, color = Color(0xFF182248))
    }
}

private fun animalEmoji(name: String): String = when (name) {
    "موش" -> "🐭"
    "گاو" -> "🐮"
    "ببر", "پلنگ" -> "🐯"
    "خرگوش" -> "🐰"
    "اژدها", "نهنگ" -> "🐲"
    "مار" -> "🐍"
    "اسب" -> "🐴"
    "بز", "گوسفند" -> "🐐"
    "میمون" -> "🐵"
    "خروس", "مرغ" -> "🐔"
    "سگ" -> "🐶"
    "خوک" -> "🐷"
    else -> "🐾"
}
