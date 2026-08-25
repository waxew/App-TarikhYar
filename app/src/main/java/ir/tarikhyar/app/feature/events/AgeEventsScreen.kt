package ir.tarikhyar.app.feature.events

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
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.date.PersianDate
import ir.tarikhyar.app.core.format.PersianFormat
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.DateFields
import ir.tarikhyar.app.ui.components.ErrorText
import ir.tarikhyar.app.ui.components.PrimaryButton
import ir.tarikhyar.app.ui.components.ResultCard
import ir.tarikhyar.app.ui.components.parsePersianDate
import ir.tarikhyar.app.ui.components.shareText
import java.time.LocalDate

private data class EventItem(val title: String, val age: Int, val emoji: String, val color: Color)

@Composable
fun AgeEventsScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }
    var year by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }
    var birth by remember { mutableStateOf<PersianDate?>(null) }
    var error by remember { mutableStateOf<String?>(null) }

    Column(modifier.fillMaxSize()) {
        AppTopBar("رویدادهای سنی", onBack) {
            shareText(context, "رویدادهای سنی", "رویدادهای مهم سنی من در تاریخ‌یار")
        }
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
                    PrimaryButton("نمایش رویدادهای سنی") {
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
                    birth?.let { EventsList(it) }
                }
            }
        }
    }
}

@Composable
private fun EventsList(birth: PersianDate) {
    val extra = listOf(
        EventItem("سن قانونی (۱۸ سالگی)", 18, "⚖️", Color(0xFFFFB62F)),
        EventItem("پیش‌دبستانی یک", 4, "🏫", Color(0xFFFFA641)),
        EventItem("پیش‌دبستانی دو", 5, "🎒", Color(0xFFFF8F3D)),
        EventItem("کلاس اول", 6, "🏫", Color(0xFF4B8BFF)),
        EventItem("سن گواهینامه", 18, "🚗", Color(0xFF52C76D)),
        EventItem("سن ازدواج - نمونه محاسباتی", 24, "💍", Color(0xFFFF6A9B)),
        EventItem("سن عقد - نمونه محاسباتی", 22, "💍", Color(0xFFFF8B4B)),
        EventItem("خرید خودرو - نمونه برنامه‌ریزی", 27, "🚘", Color(0xFFFF5B5B)),
        EventItem("خرید خانه - نمونه برنامه‌ریزی", 30, "🏠", Color(0xFFFF8D43)),
        EventItem("بازنشستگی - نمونه زمانی", 60, "🧓", Color(0xFF5D8DFF)),
    )

    Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
        extra.forEach { item ->
            val date = PersianCalendar.addYears(birth, item.age.toLong())
            EventRow(
                item = item,
                date = date,
                isPast = PersianCalendar.compare(date, PersianCalendar.fromGregorian(LocalDate.now())) <= 0,
            )
        }

        Surface(shape = MaterialTheme.shapes.large, color = Color(0xFFFFEEF0)) {
            Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text("توضیح", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Text(
                    "موارد مدرسه و گواهینامه صرفاً بر اساس سن محاسبه می‌شوند. قوانین واقعی ثبت‌نام و صدور مجوز ممکن است تغییر کنند.",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}

@Composable
private fun EventRow(item: EventItem, date: PersianDate, isPast: Boolean) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 1.dp,
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 13.dp, vertical = 11.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(11.dp),
        ) {
            Surface(shape = CircleShape, color = item.color.copy(alpha = .14f), modifier = Modifier.size(50.dp)) {
                Box(contentAlignment = Alignment.Center) { Text(item.emoji, style = MaterialTheme.typography.titleLarge) }
            }
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(item.title, fontWeight = FontWeight.Bold, color = Color(0xFF182248))
                Text("${PersianFormat.digits(item.age)} سالگی", color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text(PersianFormat.persianNumeric(date), color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.labelLarge)
            }
            Surface(shape = CircleShape, color = if (isPast) Color(0xFFE5F7EA) else Color(0xFFFFF0DF), modifier = Modifier.size(28.dp)) {
                Box(contentAlignment = Alignment.Center) {
                    Text(if (isPast) "✓" else "•", color = if (isPast) Color(0xFF27A84B) else Color(0xFFFF9B26), fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
