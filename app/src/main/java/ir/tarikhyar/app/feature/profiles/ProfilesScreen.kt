// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.feature.profiles

// راهنما: این import وابستگی «androidx.compose.foundation.layout.Arrangement» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Arrangement
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Column» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Column
// راهنما: این import وابستگی «androidx.compose.foundation.layout.PaddingValues» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.PaddingValues
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Row» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Row
// راهنما: این import وابستگی «androidx.compose.foundation.layout.fillMaxSize» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.fillMaxSize
// راهنما: این import وابستگی «androidx.compose.foundation.layout.fillMaxWidth» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.fillMaxWidth
// راهنما: این import وابستگی «androidx.compose.foundation.layout.padding» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.padding
// راهنما: این import وابستگی «androidx.compose.foundation.lazy.LazyColumn» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.lazy.LazyColumn
// راهنما: این import وابستگی «androidx.compose.material.icons.Icons» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.Icons
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Delete» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Delete
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Edit» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Edit
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Notifications» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Notifications
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.NotificationsOff» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.NotificationsOff
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.PersonAdd» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.PersonAdd
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Star» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Star
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.StarBorder» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.StarBorder
// راهنما: این import وابستگی «androidx.compose.material3.AlertDialog» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.AlertDialog
// راهنما: این import وابستگی «androidx.compose.material3.Icon» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Icon
// راهنما: این import وابستگی «androidx.compose.material3.IconButton» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.IconButton
// راهنما: این import وابستگی «androidx.compose.material3.MaterialTheme» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.MaterialTheme
// راهنما: این import وابستگی «androidx.compose.material3.OutlinedTextField» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.OutlinedTextField
// راهنما: این import وابستگی «androidx.compose.material3.Text» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Text
// راهنما: این import وابستگی «androidx.compose.material3.TextButton» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.TextButton
// راهنما: این import وابستگی «androidx.compose.runtime.Composable» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.Composable
// راهنما: این import وابستگی «androidx.compose.runtime.getValue» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.getValue
// راهنما: این import وابستگی «androidx.compose.runtime.mutableStateOf» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.mutableStateOf
// راهنما: این import وابستگی «androidx.compose.runtime.remember» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.remember
// راهنما: این import وابستگی «androidx.compose.runtime.setValue» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.setValue
// راهنما: این import وابستگی «androidx.compose.ui.Alignment» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.Alignment
// راهنما: این import وابستگی «androidx.compose.ui.Modifier» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.Modifier
// راهنما: این import وابستگی «androidx.compose.ui.platform.LocalContext» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.platform.LocalContext
// راهنما: این import وابستگی «androidx.compose.ui.text.font.FontWeight» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.font.FontWeight
// راهنما: این import وابستگی «androidx.compose.ui.unit.dp» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.unit.dp
// راهنما: این import وابستگی «ir.tarikhyar.app.core.data.LocalDataRepository» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.data.LocalDataRepository
// راهنما: این import وابستگی «ir.tarikhyar.app.core.data.PersonProfile» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.data.PersonProfile
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianCalendar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianCalendar
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianDate» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianDate
// راهنما: این import وابستگی «ir.tarikhyar.app.core.format.PersianFormat» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.format.PersianFormat
// راهنما: این import وابستگی «ir.tarikhyar.app.core.system.ReminderScheduler» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.system.ReminderScheduler
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.AppTopBar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.AppTopBar
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.PersianDatePickerDialog» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.PersianDatePickerDialog
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.PrimaryButton» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.PrimaryButton
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.ResultCard» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.ResultCard
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.shareText» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.shareText
// راهنما: این import وابستگی «ir.tarikhyar.app.widget.TarikhYarWidgetProvider» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.widget.TarikhYarWidgetProvider
// راهنما: این import وابستگی «java.time.LocalDate» را برای استفاده در این فایل وارد می‌کند.
import java.time.LocalDate

/** مدیریت چند پروفایل تولد برای خود کاربر، خانواده و دوستان. */
// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun ProfilesScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val context = LocalContext.current
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var profiles by remember { mutableStateOf(LocalDataRepository.profiles(context)) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var editing by remember { mutableStateOf<PersonProfile?>(null) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var showEditor by remember { mutableStateOf(false) }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun refresh() {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        profiles = LocalDataRepository.profiles(context)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        TarikhYarWidgetProvider.refreshAll(context)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
    Column(modifier.fillMaxSize()) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        AppTopBar("پروفایل‌ها", onBack) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            shareText(context, "پروفایل‌های تاریخ‌یار", "تولدهای مهم را در تاریخ‌یار نگهداری کنید.")
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
        // راهنما: این LazyColumn فهرست عمودی و قابل اسکرول را به شکل بهینه نمایش می‌دهد.
        LazyColumn(
            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
            modifier = Modifier.fillMaxSize(),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            contentPadding = PaddingValues(18.dp),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            verticalArrangement = Arrangement.spacedBy(12.dp),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ResultCard {
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("خانواده و دوستان", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text(
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        "برای هر شخص تاریخ تولد، نسبت، علاقه‌مندی و یادآوری جداگانه ذخیره می‌شود.",
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    )
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    PrimaryButton("افزودن پروفایل") {
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        editing = null
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        showEditor = true
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }

            // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
            if (profiles.isEmpty()) {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                item {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    ResultCard {
                        // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            // راهنما: این Icon نشانه گرافیکی مرتبط با عملکرد این قسمت را نمایش می‌دهد.
                            Icon(Icons.Rounded.PersonAdd, null, tint = MaterialTheme.colorScheme.primary)
                            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                            Text("هنوز پروفایلی اضافه نشده است.")
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        }
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            } else {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                items(profiles.size) { index ->
                    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
                    val profile = profiles[index]
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    ResultCard {
                        // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                        Row(
                            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                            modifier = Modifier.fillMaxWidth(),
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            verticalAlignment = Alignment.CenterVertically,
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            horizontalArrangement = Arrangement.SpaceBetween,
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        ) {
                            // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
                            Column(modifier = Modifier.weight(1f)) {
                                // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                                Text(profile.name, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                                // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                                Text(profile.relation.ifBlank { "بدون نسبت" }, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                                Text(PersianFormat.persianDate(profile.birthDate), color = MaterialTheme.colorScheme.primary)
                            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                            }
                            // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                            IconButton(onClick = {
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                LocalDataRepository.saveProfile(context, profile.copy(favorite = !profile.favorite))
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                refresh()
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            }) {
                                // راهنما: این Icon نشانه گرافیکی مرتبط با عملکرد این قسمت را نمایش می‌دهد.
                                Icon(if (profile.favorite) Icons.Rounded.Star else Icons.Rounded.StarBorder, "علاقه‌مندی")
                            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                            }
                            // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                            IconButton(onClick = {
                                // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
                                val updated = profile.copy(reminderEnabled = !profile.reminderEnabled)
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                LocalDataRepository.saveProfile(context, updated)
                                // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                                if (updated.reminderEnabled) ReminderScheduler.scheduleProfile(context, updated)
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                refresh()
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            }) {
                                // راهنما: این Icon نشانه گرافیکی مرتبط با عملکرد این قسمت را نمایش می‌دهد.
                                Icon(if (profile.reminderEnabled) Icons.Rounded.Notifications else Icons.Rounded.NotificationsOff, "یادآوری")
                            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                            }
                            // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                            IconButton(onClick = {
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                editing = profile
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                showEditor = true
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            }) { Icon(Icons.Rounded.Edit, "ویرایش") }
                            // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                            IconButton(onClick = {
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                LocalDataRepository.deleteProfile(context, profile.id)
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                refresh()
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            }) { Icon(Icons.Rounded.Delete, "حذف") }
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        }
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
    if (showEditor) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ProfileEditorDialog(
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            profile = editing,
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            onDismiss = { showEditor = false },
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            onSave = { profile ->
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                LocalDataRepository.saveProfile(context, profile)
                // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                if (profile.reminderEnabled) ReminderScheduler.scheduleProfile(context, profile)
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                refresh()
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                showEditor = false
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            },
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        )
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun ProfileEditorDialog(
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    profile: PersonProfile?,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    onDismiss: () -> Unit,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    onSave: (PersonProfile) -> Unit,
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
) {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val today = remember { PersianCalendar.fromGregorian(LocalDate.now()) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var name by remember(profile?.id) { mutableStateOf(profile?.name.orEmpty()) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var relation by remember(profile?.id) { mutableStateOf(profile?.relation.orEmpty()) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var date by remember(profile?.id) { mutableStateOf(profile?.birthDate ?: PersianDate(today.year - 20, today.month, today.day.coerceAtMost(PersianCalendar.monthLength(today.year - 20, today.month)))) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var pickDate by remember { mutableStateOf(false) }

    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    AlertDialog(
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        onDismissRequest = onDismiss,
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        title = { Text(if (profile == null) "پروفایل جدید" else "ویرایش پروفایل") },
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        text = {
            // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                OutlinedTextField(name, { name = it }, label = { Text("نام") }, singleLine = true)
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                OutlinedTextField(relation, { relation = it }, label = { Text("نسبت؛ مثال: خواهر") }, singleLine = true)
                // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                Text("تاریخ تولد: ${PersianFormat.persianDate(date)}", fontWeight = FontWeight.Bold)
                // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                TextButton(onClick = { pickDate = true }) { Text("انتخاب تاریخ بدون تایپ") }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        },
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        confirmButton = {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            TextButton(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                enabled = name.isNotBlank(),
                // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                onClick = {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    onSave(
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        PersonProfile(
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            id = profile?.id ?: java.util.UUID.randomUUID().toString(),
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            name = name.trim(),
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            relation = relation.trim(),
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            birthDate = date,
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            favorite = profile?.favorite ?: false,
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            reminderEnabled = profile?.reminderEnabled ?: true,
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        )
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    )
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                },
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            ) { Text("ذخیره") }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        },
        // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
        dismissButton = { TextButton(onClick = onDismiss) { Text("انصراف") } },
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    )

    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
    if (pickDate) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        PersianDatePickerDialog(
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            initial = date,
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            onDismiss = { pickDate = false },
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            onSelected = {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                date = it
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                pickDate = false
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            },
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        )
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
