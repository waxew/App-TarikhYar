// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.feature.notifications

// راهنما: این import وابستگی «android.Manifest» را برای استفاده در این فایل وارد می‌کند.
import android.Manifest
// راهنما: این import وابستگی «android.os.Build» را برای استفاده در این فایل وارد می‌کند.
import android.os.Build
// راهنما: این import وابستگی «androidx.activity.compose.rememberLauncherForActivityResult» را برای استفاده در این فایل وارد می‌کند.
import androidx.activity.compose.rememberLauncherForActivityResult
// راهنما: این import وابستگی «androidx.activity.result.contract.ActivityResultContracts» را برای استفاده در این فایل وارد می‌کند.
import androidx.activity.result.contract.ActivityResultContracts
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
// راهنما: این import وابستگی «androidx.compose.foundation.lazy.LazyColumn» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.lazy.LazyColumn
// راهنما: این import وابستگی «androidx.compose.material3.MaterialTheme» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.MaterialTheme
// راهنما: این import وابستگی «androidx.compose.material3.Switch» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Switch
// راهنما: این import وابستگی «androidx.compose.material3.Text» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Text
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
// راهنما: این import وابستگی «ir.tarikhyar.app.BuildConfig» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.BuildConfig
// راهنما: این import وابستگی «ir.tarikhyar.app.core.system.AppPreferences» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.system.AppPreferences
// راهنما: این import وابستگی «ir.tarikhyar.app.core.system.NotificationHelper» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.system.NotificationHelper
// راهنما: این import وابستگی «ir.tarikhyar.app.core.system.UpdateChecker» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.system.UpdateChecker
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.AppTopBar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.AppTopBar
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.PrimaryButton» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.PrimaryButton
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.ResultCard» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.ResultCard
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.shareText» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.shareText

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun NotificationsScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val context = LocalContext.current
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var enabled by remember { mutableStateOf(AppPreferences.notificationsEnabled(context)) }
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var status by remember { mutableStateOf("اعلان‌های تاریخ‌یار برای نسخه‌های جدید و یادآوری‌ها استفاده می‌شوند.") }

    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        enabled = granted
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        AppPreferences.setNotificationsEnabled(context, granted)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        status = if (granted) "اجازه اعلان فعال شد." else "اجازه اعلان داده نشد."
        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
        if (granted) NotificationHelper.showTest(context)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
    Column(modifier.fillMaxSize()) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        AppTopBar("اعلان‌ها", onBack) { shareText(context, "تاریخ‌یار", "اعلان‌های نسخه جدید تاریخ‌یار") }
        // راهنما: این LazyColumn فهرست عمودی و قابل اسکرول را به شکل بهینه نمایش می‌دهد.
        LazyColumn(
            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
            modifier = Modifier.fillMaxSize(),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            contentPadding = PaddingValues(18.dp),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            verticalArrangement = Arrangement.spacedBy(14.dp),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ResultCard {
                    // راهنما: این Row اجزای رابط کاربری را در یک ردیف افقی Compose قرار می‌دهد.
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                        // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
                        Column(modifier = Modifier.weight(1f)) {
                            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                            Text("اعلان نسخه جدید", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                            Text(if (enabled) "فعال" else "غیرفعال", color = MaterialTheme.colorScheme.onSurfaceVariant)
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        }
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        Switch(checked = enabled, onCheckedChange = { value ->
                            // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                            if (!value) {
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                enabled = false
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                AppPreferences.setNotificationsEnabled(context, false)
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            } else if (Build.VERSION.SDK_INT >= 33 && !NotificationHelper.canNotify(context)) {
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            } else {
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                enabled = true
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                AppPreferences.setNotificationsEnabled(context, true)
                            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                            }
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        })
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text(status, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    PrimaryButton("اعلان آزمایشی") {
                        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                        if (Build.VERSION.SDK_INT >= 33 && !NotificationHelper.canNotify(context)) {
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        } else {
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            enabled = true
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            AppPreferences.setNotificationsEnabled(context, true)
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            NotificationHelper.showTest(context)
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            status = "یک اعلان آزمایشی ارسال شد."
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        }
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            }
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            item {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                ResultCard {
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("وضعیت بروزرسانی", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
                    Text("نسخه نصب‌شده: ${BuildConfig.VERSION_NAME}", fontWeight = FontWeight.Bold)
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    PrimaryButton("بررسی نسخه جدید") {
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        status = "در حال بررسی نسخه جدید..."
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        UpdateChecker.checkAsync(context) { info ->
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            status = when {
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                info == null -> "بررسی آنلاین انجام نشد. اتصال اینترنت را بررسی کن."
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                info.versionCode > BuildConfig.VERSION_CODE -> "نسخه ${info.versionName} آماده است. ${info.message}"
                                // راهنما: این شاخه زمانی اجرا می‌شود که شرط‌های قبلی برقرار نباشند.
                                else -> "برنامه شما آخرین نسخه است."
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
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
