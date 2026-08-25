package ir.tarikhyar.app.feature.chinese

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
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.DateFields
import ir.tarikhyar.app.ui.components.ErrorText
import ir.tarikhyar.app.ui.components.PrimaryButton
import ir.tarikhyar.app.ui.components.ResultCard
import ir.tarikhyar.app.ui.components.parsePersianDate
import ir.tarikhyar.app.ui.components.shareText
import java.time.LocalDate

@Composable
fun ChineseAstrologyScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }
    var year by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var birth by remember { mutableStateOf<PersianDate?>(null) }

    val shareValue = birth?.let {
        val info = BirthInsights.calendarInfo(it)
        "حیوان سال تولد من در طالع چینی: ${info.chineseAnimal} — تاریخ‌یار"
    } ?: "طالع‌بینی چینی تاریخ‌یار"

    Column(modifier.fillMaxSize()) {
        AppTopBar("طالع‌بینی چینی", onBack) { shareText(context, "طالع‌بینی چینی", shareValue) }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            item {
                ResultCard {
                    Text("تاریخ تولد", style = MaterialTheme.typography.titleMedium)
                    DateFields(year, month, day, { year = it }, { month = it }, { day = it })
                    ErrorText(error)
                    PrimaryButton("نمایش طالع چینی") {
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
                    birth?.let { ChineseResult(it) }
                }
            }
        }
    }
}

@Composable
private fun ChineseResult(birth: PersianDate) {
    val info = remember(birth) { BirthInsights.calendarInfo(birth) }
    val profile = remember(birth) { BirthInsights.profile(birth) }
    val animalEmoji = animalEmoji(info.chineseAnimal)
    val birthYear = info.gregorian.year
    val years = (-4..4).map { birthYear + it * 12 }.filter { it > 1900 }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        ResultCard {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(7.dp),
            ) {
                Surface(shape = CircleShape, color = Color(0xFFFFE0C8), modifier = Modifier.size(104.dp)) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(animalEmoji, style = MaterialTheme.typography.headlineLarge)
                    }
                }
                Text(info.chineseAnimal, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.ExtraBold)
                Text(
                    years.joinToString(" - "),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF52608E),
                    textAlign = TextAlign.Center,
                )
            }
        }

        ResultCard {
            Text("ویژگی‌ها", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            val traits = profile.traits.split("،").map { it.trim() }.filter { it.isNotBlank() }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                traits.take(3).forEach { TraitChip(it, Modifier.weight(1f)) }
            }
            if (traits.size > 3) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                    traits.drop(3).take(3).forEach { TraitChip(it, Modifier.weight(1f)) }
                }
            }
        }

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            MiniInfo("رنگ شانس", profile.color, "🎨", Modifier.weight(1f))
            MiniInfo("عدد شانس", profile.luckyNumber, "🪬", Modifier.weight(1f))
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            MiniInfo("درخت", profile.tree, "🌳", Modifier.weight(1f))
            MiniInfo("گل", profile.flower, "🌸", Modifier.weight(1f))
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            MiniInfo("گیاه", profile.plant, "🪴", Modifier.weight(1f))
            MiniInfo("عنصر", profile.metal, "🪙", Modifier.weight(1f))
        }

        Surface(shape = MaterialTheme.shapes.large, color = Color(0xFFFFE8EB)) {
            Text(
                "این بخش جنبه سرگرمی و فرهنگی دارد و پیش‌بینی علمی شخصیت نیست.",
                modifier = Modifier.fillMaxWidth().padding(14.dp),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
private fun TraitChip(text: String, modifier: Modifier = Modifier) {
    Surface(modifier = modifier, shape = MaterialTheme.shapes.large, color = Color(0xFFF1F3FA)) {
        Text(text, modifier = Modifier.padding(horizontal = 8.dp, vertical = 9.dp), textAlign = TextAlign.Center, color = Color(0xFF26325F))
    }
}

@Composable
private fun MiniInfo(title: String, value: String, emoji: String, modifier: Modifier = Modifier) {
    Surface(modifier = modifier, shape = MaterialTheme.shapes.medium, color = MaterialTheme.colorScheme.surface, shadowElevation = 1.dp) {
        Column(Modifier.padding(13.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(emoji, style = MaterialTheme.typography.titleLarge)
            Text(title, color = MaterialTheme.colorScheme.onSurfaceVariant, style = MaterialTheme.typography.labelMedium)
            Text(value, color = Color(0xFF182248), fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }
    }
}

private fun animalEmoji(name: String): String = when (name) {
    "موش" -> "🐭"
    "گاو" -> "🐮"
    "ببر" -> "🐯"
    "خرگوش" -> "🐰"
    "اژدها" -> "🐲"
    "مار" -> "🐍"
    "اسب" -> "🐴"
    "بز" -> "🐐"
    "میمون" -> "🐵"
    "خروس" -> "🐔"
    "سگ" -> "🐶"
    "خوک" -> "🐷"
    else -> "🐾"
}
