package ir.tarikhyar.app.ui.components

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.date.PersianDate

@Composable
fun AppTopBar(title: String, onBack: () -> Unit, onShare: (() -> Unit)? = null) {
    val context = LocalContext.current
    val shareAction = onShare ?: { shareText(context, title, "تاریخ‌یار؛ تقویم زندگی، محاسبه سن و ابزارهای تاریخ\nhttps://github.com/waxew/App-TarikhYar") }
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 1.dp,
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 6.dp, vertical = 6.dp),
            contentAlignment = Alignment.Center,
        ) {
            IconButton(onClick = onBack, modifier = Modifier.align(Alignment.CenterStart)) {
                Icon(Icons.Rounded.ArrowBack, contentDescription = "بازگشت", tint = MaterialTheme.colorScheme.onSurface)
            }
            Text(title, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            IconButton(onClick = shareAction, modifier = Modifier.align(Alignment.CenterEnd)) {
                Icon(Icons.Rounded.Share, contentDescription = "اشتراک‌گذاری", tint = MaterialTheme.colorScheme.onSurface)
            }
        }
    }
}

@Composable
fun EmojiBadge(
    emoji: String,
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.primaryContainer,
    size: Int = 54,
) {
    Surface(modifier = modifier.size(size.dp), shape = CircleShape, color = background) {
        Box(contentAlignment = Alignment.Center) {
            Text(emoji, fontSize = (size * 0.52f).sp)
        }
    }
}

@Composable
fun GraphicMenuCard(
    title: String,
    emoji: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
) {
    Card(
        modifier = modifier.clickable(onClick = onClick),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(13.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(7.dp),
        ) {
            EmojiBadge(emoji = emoji, size = 58)
            Text(title, style = MaterialTheme.typography.titleMedium, textAlign = TextAlign.Center)
            if (!subtitle.isNullOrBlank()) {
                Text(subtitle, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun ScreenHeader(title: String, subtitle: String) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
        Text(text = subtitle, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Composable
fun SoftSectionCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) { content() }
    }
}

@Composable
fun FeatureCard(title: String, subtitle: String, icon: ImageVector, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.clickable(onClick = onClick),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(Modifier.size(50.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primaryContainer), contentAlignment = Alignment.Center) {
                Icon(icon, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(27.dp))
            }
            Text(title, style = MaterialTheme.typography.titleMedium, textAlign = TextAlign.Center)
            Text(subtitle, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun DateFields(
    year: String, month: String, day: String,
    onYearChange: (String) -> Unit, onMonthChange: (String) -> Unit, onDayChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        NumericDateField(year, onYearChange, "سال", 4, Modifier.weight(1.35f))
        NumericDateField(month, onMonthChange, "ماه", 2, Modifier.weight(1f))
        NumericDateField(day, onDayChange, "روز", 2, Modifier.weight(1f))
    }
}

@Composable
private fun NumericDateField(value: String, onValueChange: (String) -> Unit, label: String, maxLength: Int, modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = value,
        onValueChange = { raw ->
            val normalized = raw.mapNotNull { it.toLatinDigitOrNull() }.joinToString("")
            if (normalized.length <= maxLength) onValueChange(normalized)
        },
        label = { Text(label) }, singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        textStyle = MaterialTheme.typography.bodyLarge.copy(textAlign = TextAlign.Center),
        modifier = modifier, shape = MaterialTheme.shapes.medium,
    )
}

@Composable
fun PrimaryButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().height(54.dp),
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
    ) { Text(text, style = MaterialTheme.typography.titleMedium, color = Color.White) }
}

@Composable
fun GradientHeroButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().height(56.dp),
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(),
    ) {
        Box(
            Modifier.fillMaxWidth().background(Brush.horizontalGradient(listOf(MaterialTheme.colorScheme.secondary, MaterialTheme.colorScheme.primary))).padding(vertical = 15.dp),
            contentAlignment = Alignment.Center,
        ) { Text(text, style = MaterialTheme.typography.titleMedium, color = Color.White) }
    }
}

@Composable
fun ErrorText(message: String?) {
    if (!message.isNullOrBlank()) Text(message, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodyMedium)
}

@Composable
fun ChoicePill(text: String, selected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.clickable(onClick = onClick), shape = MaterialTheme.shapes.medium,
        color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
        contentColor = if (selected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
    ) {
        Box(Modifier.padding(horizontal = 16.dp, vertical = 12.dp), contentAlignment = Alignment.Center) { Text(text, style = MaterialTheme.typography.labelLarge) }
    }
}

@Composable
fun ResultCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier.fillMaxWidth(), shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) { Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) { content() } }
}

@Composable
fun StatTile(label: String, value: String, modifier: Modifier = Modifier) {
    Surface(modifier = modifier, shape = MaterialTheme.shapes.medium, color = MaterialTheme.colorScheme.surfaceVariant) {
        Column(Modifier.padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
            Spacer(Modifier.height(4.dp))
            Text(label, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, textAlign = TextAlign.Center)
        }
    }
}

fun shareText(context: Context, title: String, text: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, title)
        putExtra(Intent.EXTRA_TEXT, text)
    }
    context.startActivity(Intent.createChooser(intent, "اشتراک‌گذاری"))
}

fun parsePersianDate(year: String, month: String, day: String): PersianDate? {
    val y = year.toIntOrNull() ?: return null; val m = month.toIntOrNull() ?: return null; val d = day.toIntOrNull() ?: return null
    val date = PersianDate(y, m, d); return date.takeIf(PersianCalendar::isValid)
}

private fun Char.toLatinDigitOrNull(): Char? = when (this) {
    in '0'..'9' -> this; '۰' -> '0'; '۱' -> '1'; '۲' -> '2'; '۳' -> '3'; '۴' -> '4'; '۵' -> '5'; '۶' -> '6'; '۷' -> '7'; '۸' -> '8'; '۹' -> '9'; else -> null
}
