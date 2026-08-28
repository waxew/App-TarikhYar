// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.ui.components

// راهنما: این import وابستگی «android.content.Intent» را برای استفاده در این فایل وارد می‌کند.
import android.content.Intent
// راهنما: این import وابستگی «android.graphics.BitmapFactory» را برای استفاده در این فایل وارد می‌کند.
import android.graphics.BitmapFactory
// راهنما: این import وابستگی «androidx.activity.compose.rememberLauncherForActivityResult» را برای استفاده در این فایل وارد می‌کند.
import androidx.activity.compose.rememberLauncherForActivityResult
// راهنما: این import وابستگی «androidx.activity.result.contract.ActivityResultContracts» را برای استفاده در این فایل وارد می‌کند.
import androidx.activity.result.contract.ActivityResultContracts
// راهنما: این import وابستگی «androidx.compose.foundation.Image» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.Image
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Arrangement» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Arrangement
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Box» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Box
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Column» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Column
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Row» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Row
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Spacer» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Spacer
// راهنما: این import وابستگی «androidx.compose.foundation.layout.fillMaxHeight» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.fillMaxHeight
// راهنما: این import وابستگی «androidx.compose.foundation.layout.padding» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.padding
// راهنما: این import وابستگی «androidx.compose.foundation.layout.size» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.size
// راهنما: این import وابستگی «androidx.compose.foundation.layout.width» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.width
// راهنما: این import وابستگی «androidx.compose.foundation.lazy.LazyColumn» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.lazy.LazyColumn
// راهنما: این import وابستگی «androidx.compose.foundation.shape.CircleShape» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.shape.CircleShape
// راهنما: این import وابستگی «androidx.compose.material.icons.Icons» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.Icons
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Backup» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Backup
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.CalendarMonth» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.CalendarMonth
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.ContactMail» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.ContactMail
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Event» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Event
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Favorite» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Favorite
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Home» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Home
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Info» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Info
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Person» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Person
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Settings» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Settings
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Share» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Share
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.SupervisorAccount» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.SupervisorAccount
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Tune» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Tune
// راهنما: این import وابستگی «androidx.compose.material3.AlertDialog» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.AlertDialog
// راهنما: این import وابستگی «androidx.compose.material3.HorizontalDivider» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.HorizontalDivider
// راهنما: این import وابستگی «androidx.compose.material3.Icon» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Icon
// راهنما: این import وابستگی «androidx.compose.material3.MaterialTheme» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.MaterialTheme
// راهنما: این import وابستگی «androidx.compose.material3.ModalDrawerSheet» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.ModalDrawerSheet
// راهنما: این import وابستگی «androidx.compose.material3.NavigationDrawerItem» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.NavigationDrawerItem
// راهنما: این import وابستگی «androidx.compose.material3.Surface» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Surface
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
// راهنما: این import وابستگی «androidx.compose.ui.draw.clip» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.draw.clip
// راهنما: این import وابستگی «androidx.compose.ui.graphics.asImageBitmap» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.graphics.asImageBitmap
// راهنما: این import وابستگی «androidx.compose.ui.platform.LocalContext» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.platform.LocalContext
// راهنما: این import وابستگی «androidx.compose.ui.text.font.FontWeight» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.font.FontWeight
// راهنما: این import وابستگی «androidx.compose.ui.unit.dp» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.unit.dp
// راهنما: این import وابستگی «ir.tarikhyar.app.AppScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.AppScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.core.system.UserSettings» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.system.UserSettings

/** منوی همبرگری نسخه ۲ با پروفایل، تصویر کاربر و مسیرهای جدید برنامه. */
// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun AppDrawerContent(
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    currentScreen: AppScreen,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    onNavigate: (AppScreen) -> Unit,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    onShare: () -> Unit,
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
) {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val context = LocalContext.current
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var imageUri by remember { mutableStateOf(UserSettings.profileImageUri(context)) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var showImageMenu by remember { mutableStateOf(false) }
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val imagePicker = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
        if (uri != null) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            runCatching {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                context.contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            imageUri = uri.toString()
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            UserSettings.setProfileImageUri(context, imageUri)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val bitmap = remember(imageUri) {
        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
        if (imageUri.isBlank()) null else runCatching {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            context.contentResolver.openInputStream(android.net.Uri.parse(imageUri))?.use { stream -> BitmapFactory.decodeStream(stream) }
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        }.getOrNull()
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
    ModalDrawerSheet(modifier = Modifier.fillMaxHeight().width(320.dp)) {
        // راهنما: این LazyColumn فهرست عمودی و قابل اسکرول را به شکل بهینه نمایش می‌دهد.
        LazyColumn(
            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
            modifier = Modifier.fillMaxHeight().padding(horizontal = 14.dp, vertical = 18.dp),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            verticalArrangement = Arrangement.spacedBy(5.dp),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item {
                // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    // راهنما: این سطح بصری برای گروه‌بندی محتوا، شکل، رنگ و Elevation رابط کاربری استفاده می‌شود.
                    Surface(
                        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                        modifier = Modifier.size(92.dp),
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        shape = CircleShape,
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        color = MaterialTheme.colorScheme.primaryContainer,
                        // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                        onClick = { showImageMenu = true },
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    ) {
                        // راهنما: این Box امکان روی‌هم‌گذاری یا ترازکردن اجزای رابط کاربری را فراهم می‌کند.
                        Box(contentAlignment = Alignment.Center) {
                            // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                            if (bitmap != null) {
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                Image(bitmap.asImageBitmap(), "تصویر پروفایل", Modifier.size(92.dp).clip(CircleShape))
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            } else {
                                // راهنما: این Icon نشانه گرافیکی مرتبط با عملکرد این قسمت را نمایش می‌دهد.
                                Icon(Icons.Rounded.Person, "انتخاب تصویر پروفایل", Modifier.size(48.dp), tint = MaterialTheme.colorScheme.primary)
                            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                            }
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        }
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    Spacer(Modifier.size(8.dp))
                    // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                    Row(
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        verticalAlignment = Alignment.CenterVertically,
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    ) {
                        // راهنما: این Icon نشانه گرافیکی مرتبط با عملکرد این قسمت را نمایش می‌دهد.
                        Icon(Icons.Rounded.Person, contentDescription = null, modifier = Modifier.size(20.dp), tint = MaterialTheme.colorScheme.primary)
                        // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                        Text(UserSettings.displayName(context), style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("تاریخ‌یار • تقویم زندگی شما", color = MaterialTheme.colorScheme.onSurfaceVariant)
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
            item { HorizontalDivider(Modifier.padding(vertical = 8.dp)) }

            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item { DrawerItem("خانه", Icons.Rounded.Home, AppScreen.HOME, currentScreen, onNavigate) }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item { DrawerItem("پروفایل‌ها و تولدها", Icons.Rounded.Person, AppScreen.PROFILES, currentScreen, onNavigate) }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item { DrawerItem("تقویم و مناسبت‌ها", Icons.Rounded.CalendarMonth, AppScreen.CALENDAR, currentScreen, onNavigate) }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item { DrawerItem("مناسبت‌های شخصی", Icons.Rounded.Event, AppScreen.PERSONAL_EVENTS, currentScreen, onNavigate) }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item { DrawerItem("ابزارهای حرفه‌ای", Icons.Rounded.Tune, AppScreen.PRO_TOOLS, currentScreen, onNavigate) }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item { DrawerItem("علاقه‌مندی‌ها", Icons.Rounded.Favorite, AppScreen.FAVORITES, currentScreen, onNavigate) }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item { DrawerItem("پشتیبان و همگام‌سازی", Icons.Rounded.Backup, AppScreen.BACKUP, currentScreen, onNavigate) }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item { DrawerItem("تنظیمات", Icons.Rounded.Settings, AppScreen.SETTINGS, currentScreen, onNavigate) }

            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
            item { HorizontalDivider(Modifier.padding(vertical = 8.dp)) }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item { DrawerItem("ارتباط با ما", Icons.Rounded.ContactMail, AppScreen.CONTACT_US, currentScreen, onNavigate) }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                NavigationDrawerItem(
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    label = { Text("معرفی به دوستان") },
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    selected = false,
                    // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                    onClick = onShare,
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    icon = { Icon(Icons.Rounded.Share, null) },
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                )
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item { DrawerItem("درباره ما", Icons.Rounded.SupervisorAccount, AppScreen.ABOUT_US, currentScreen, onNavigate) }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item { DrawerItem("درباره نرم افزار", Icons.Rounded.Info, AppScreen.ABOUT_APP, currentScreen, onNavigate) }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item {
                // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                HorizontalDivider(Modifier.padding(top = 14.dp, bottom = 10.dp))
                // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                Text(
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    "گروه توسعه فناوری و نرم افزاری as Team",
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    modifier = Modifier.padding(horizontal = 8.dp),
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    style = MaterialTheme.typography.labelLarge,
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    fontWeight = FontWeight.Bold,
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                )
                // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                Text("AS.Support.info@Gmail.com", modifier = Modifier.padding(horizontal = 8.dp), color = MaterialTheme.colorScheme.onSurfaceVariant)
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
    if (showImageMenu) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        AlertDialog(
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            onDismissRequest = { showImageMenu = false },
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            title = { Text("تصویر پروفایل") },
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            text = {
                // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("می‌توانی یک تصویر از دستگاه انتخاب کنی یا تصویر فعلی را حذف کنی.")
                    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                    if (imageUri.isNotBlank()) {
                        // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                        TextButton(onClick = {
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            imageUri = ""
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            UserSettings.setProfileImageUri(context, "")
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            showImageMenu = false
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        }) { Text("حذف تصویر فعلی") }
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            },
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            confirmButton = {
                // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                TextButton(onClick = {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    showImageMenu = false
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    imagePicker.launch(arrayOf("image/*"))
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                }) { Text("انتخاب تصویر") }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            },
            // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
            dismissButton = { TextButton(onClick = { showImageMenu = false }) { Text("انصراف") } },
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        )
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
private fun DrawerItem(
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    label: String,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    target: AppScreen,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    current: AppScreen,
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    onNavigate: (AppScreen) -> Unit,
// راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
) {
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    NavigationDrawerItem(
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        label = { Text(label) },
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        selected = current == target,
        // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
        onClick = { onNavigate(target) },
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        icon = { Icon(icon, null) },
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    )
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
