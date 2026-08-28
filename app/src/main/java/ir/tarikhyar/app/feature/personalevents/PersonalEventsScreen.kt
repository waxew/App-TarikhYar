package ir.tarikhyar.app.feature.personalevents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.NotificationsOff
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.core.data.LocalDataRepository
import ir.tarikhyar.app.core.data.PersonalEvent
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.format.PersianFormat
import ir.tarikhyar.app.core.system.ReminderScheduler
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.PersianDatePickerDialog
import ir.tarikhyar.app.ui.components.PrimaryButton
import ir.tarikhyar.app.ui.components.ResultCard
import java.time.LocalDate
import java.util.UUID

/** ساخت، ویرایش، جست‌وجو و یادآوری مناسبت‌های شخصی کاربر. */
@Composable
fun PersonalEventsScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var events by remember { mutableStateOf(LocalDataRepository.events(context)) }
    var query by remember { mutableStateOf("") }
    var editor by remember { mutableStateOf<PersonalEvent?>(null) }
    var showEditor by remember { mutableStateOf(false) }

    fun refresh() { events = LocalDataRepository.events(context) }
    val filtered = events.filter {
        query.isBlank() || it.title.contains(query, true) || it.category.contains(query, true) || it.note.contains(query, true)
    }.sortedWith(compareBy({ it.date.year }, { it.date.month }, { it.date.day }))

    Column(modifier.fillMaxSize()) {
        AppTopBar("مناسبت‌های شخصی", onBack)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item {
                ResultCard {
                    Text("رویدادهای خودت را بساز", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    Text("سالگرد ازدواج، شروع کار، تولد حیوان خانگی، ترک عادت یا هر تاریخ دیگری را ذخیره کن.", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    PrimaryButton("افزودن مناسبت") {
                        editor = null
                        showEditor = true
                    }
                }
            }
            item {
                OutlinedTextField(
                    value = query,
                    onValueChange = { query = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    leadingIcon = { Icon(Icons.Rounded.Search, null) },
                    label = { Text("جست‌وجو") },
                )
            }
            if (filtered.isEmpty()) {
                item { ResultCard { Text("مناسبتی برای نمایش وجود ندارد.") } }
            } else {
                items(filtered.size) { index ->
                    val event = filtered[index]
                    ResultCard {
                        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Column(Modifier.weight(1f)) {
                                Text(event.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                                Text("${event.category} • ${PersianFormat.persianDate(event.date)}", color = MaterialTheme.colorScheme.primary)
                                if (event.note.isNotBlank()) Text(event.note, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                            IconButton(onClick = {
                                val updated = event.copy(reminderEnabled = !event.reminderEnabled)
                                LocalDataRepository.saveEvent(context, updated)
                                if (updated.reminderEnabled) ReminderScheduler.scheduleEvent(context, updated)
                                refresh()
                            }) {
                                Icon(if (event.reminderEnabled) Icons.Rounded.Notifications else Icons.Rounded.NotificationsOff, "یادآوری")
                            }
                            IconButton(onClick = {
                                editor = event
                                showEditor = true
                            }) { Icon(Icons.Rounded.Edit, "ویرایش") }
                            IconButton(onClick = {
                                LocalDataRepository.deleteEvent(context, event.id)
                                refresh()
                            }) { Icon(Icons.Rounded.Delete, "حذف") }
                        }
                    }
                }
            }
        }
    }

    if (showEditor) {
        EventEditorDialog(
            event = editor,
            onDismiss = { showEditor = false },
            onSave = {
                LocalDataRepository.saveEvent(context, it)
                if (it.reminderEnabled) ReminderScheduler.scheduleEvent(context, it)
                refresh()
                showEditor = false
            },
        )
    }
}

@Composable
private fun EventEditorDialog(
    event: PersonalEvent?,
    onDismiss: () -> Unit,
    onSave: (PersonalEvent) -> Unit,
) {
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }
    var title by remember(event?.id) { mutableStateOf(event?.title.orEmpty()) }
    var category by remember(event?.id) { mutableStateOf(event?.category ?: "شخصی") }
    var note by remember(event?.id) { mutableStateOf(event?.note.orEmpty()) }
    var date by remember(event?.id) { mutableStateOf(event?.date ?: today) }
    var picker by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(if (event == null) "مناسبت جدید" else "ویرایش مناسبت") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(title, { title = it }, label = { Text("عنوان") }, singleLine = true)
                OutlinedTextField(category, { category = it }, label = { Text("دسته‌بندی") }, singleLine = true)
                OutlinedTextField(note, { note = it }, label = { Text("یادداشت") })
                Text(PersianFormat.persianDate(date), fontWeight = FontWeight.Bold)
                TextButton(onClick = { picker = true }) { Text("انتخاب تاریخ بدون تایپ") }
            }
        },
        confirmButton = {
            TextButton(
                enabled = title.isNotBlank(),
                onClick = {
                    onSave(
                        PersonalEvent(
                            id = event?.id ?: UUID.randomUUID().toString(),
                            title = title.trim(),
                            date = date,
                            category = category.trim().ifBlank { "شخصی" },
                            note = note.trim(),
                            reminderEnabled = event?.reminderEnabled ?: true,
                        )
                    )
                },
            ) { Text("ذخیره") }
        },
        dismissButton = { TextButton(onClick = onDismiss) { Text("انصراف") } },
    )

    if (picker) {
        PersianDatePickerDialog(initial = date, onDismiss = { picker = false }) {
            date = it
            picker = false
        }
    }
}
