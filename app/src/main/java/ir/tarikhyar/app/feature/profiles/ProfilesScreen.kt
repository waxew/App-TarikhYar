package ir.tarikhyar.app.feature.profiles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.NotificationsOff
import androidx.compose.material.icons.rounded.PersonAdd
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
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
import ir.tarikhyar.app.core.data.PersonProfile
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.date.PersianDate
import ir.tarikhyar.app.core.format.PersianFormat
import ir.tarikhyar.app.core.system.ReminderScheduler
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.PersianDatePickerDialog
import ir.tarikhyar.app.ui.components.PrimaryButton
import ir.tarikhyar.app.ui.components.ResultCard
import ir.tarikhyar.app.ui.components.shareText
import java.time.LocalDate

/** مدیریت چند پروفایل تولد برای خود کاربر، خانواده و دوستان. */
@Composable
fun ProfilesScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var profiles by remember { mutableStateOf(LocalDataRepository.profiles(context)) }
    var editing by remember { mutableStateOf<PersonProfile?>(null) }
    var showEditor by remember { mutableStateOf(false) }

    fun refresh() {
        profiles = LocalDataRepository.profiles(context)
    }

    Column(modifier.fillMaxSize()) {
        AppTopBar("پروفایل‌ها", onBack) {
            shareText(context, "پروفایل‌های تاریخ‌یار", "تولدهای مهم را در تاریخ‌یار نگهداری کنید.")
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item {
                ResultCard {
                    Text("خانواده و دوستان", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    Text(
                        "برای هر شخص تاریخ تولد، نسبت، علاقه‌مندی و یادآوری جداگانه ذخیره می‌شود.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    PrimaryButton("افزودن پروفایل") {
                        editing = null
                        showEditor = true
                    }
                }
            }

            if (profiles.isEmpty()) {
                item {
                    ResultCard {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            Icon(Icons.Rounded.PersonAdd, null, tint = MaterialTheme.colorScheme.primary)
                            Text("هنوز پروفایلی اضافه نشده است.")
                        }
                    }
                }
            } else {
                items(profiles.size) { index ->
                    val profile = profiles[index]
                    ResultCard {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(profile.name, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                                Text(profile.relation.ifBlank { "بدون نسبت" }, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                Text(PersianFormat.persianDate(profile.birthDate), color = MaterialTheme.colorScheme.primary)
                            }
                            IconButton(onClick = {
                                LocalDataRepository.saveProfile(context, profile.copy(favorite = !profile.favorite))
                                refresh()
                            }) {
                                Icon(if (profile.favorite) Icons.Rounded.Star else Icons.Rounded.StarBorder, "علاقه‌مندی")
                            }
                            IconButton(onClick = {
                                val updated = profile.copy(reminderEnabled = !profile.reminderEnabled)
                                LocalDataRepository.saveProfile(context, updated)
                                if (updated.reminderEnabled) ReminderScheduler.scheduleProfile(context, updated)
                                refresh()
                            }) {
                                Icon(if (profile.reminderEnabled) Icons.Rounded.Notifications else Icons.Rounded.NotificationsOff, "یادآوری")
                            }
                            IconButton(onClick = {
                                editing = profile
                                showEditor = true
                            }) { Icon(Icons.Rounded.Edit, "ویرایش") }
                            IconButton(onClick = {
                                LocalDataRepository.deleteProfile(context, profile.id)
                                refresh()
                            }) { Icon(Icons.Rounded.Delete, "حذف") }
                        }
                    }
                }
            }
        }
    }

    if (showEditor) {
        ProfileEditorDialog(
            profile = editing,
            onDismiss = { showEditor = false },
            onSave = { profile ->
                LocalDataRepository.saveProfile(context, profile)
                if (profile.reminderEnabled) ReminderScheduler.scheduleProfile(context, profile)
                refresh()
                showEditor = false
            },
        )
    }
}

@Composable
private fun ProfileEditorDialog(
    profile: PersonProfile?,
    onDismiss: () -> Unit,
    onSave: (PersonProfile) -> Unit,
) {
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }
    var name by remember(profile?.id) { mutableStateOf(profile?.name.orEmpty()) }
    var relation by remember(profile?.id) { mutableStateOf(profile?.relation.orEmpty()) }
    var date by remember(profile?.id) { mutableStateOf(profile?.birthDate ?: PersianDate(today.year - 20, today.month, today.day.coerceAtMost(PersianCalendar.monthLength(today.year - 20, today.month)))) }
    var pickDate by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(if (profile == null) "پروفایل جدید" else "ویرایش پروفایل") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                OutlinedTextField(name, { name = it }, label = { Text("نام") }, singleLine = true)
                OutlinedTextField(relation, { relation = it }, label = { Text("نسبت؛ مثال: خواهر") }, singleLine = true)
                Text("تاریخ تولد: ${PersianFormat.persianDate(date)}", fontWeight = FontWeight.Bold)
                TextButton(onClick = { pickDate = true }) { Text("انتخاب تاریخ بدون تایپ") }
            }
        },
        confirmButton = {
            TextButton(
                enabled = name.isNotBlank(),
                onClick = {
                    onSave(
                        PersonProfile(
                            id = profile?.id ?: java.util.UUID.randomUUID().toString(),
                            name = name.trim(),
                            relation = relation.trim(),
                            birthDate = date,
                            favorite = profile?.favorite ?: false,
                            reminderEnabled = profile?.reminderEnabled ?: true,
                        )
                    )
                },
            ) { Text("ذخیره") }
        },
        dismissButton = { TextButton(onClick = onDismiss) { Text("انصراف") } },
    )

    if (pickDate) {
        PersianDatePickerDialog(
            initial = date,
            onDismiss = { pickDate = false },
            onSelected = {
                date = it
                pickDate = false
            },
        )
    }
}
