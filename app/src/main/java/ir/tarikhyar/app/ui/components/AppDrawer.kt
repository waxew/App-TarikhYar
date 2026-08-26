// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// این فایل محتوای منوی همبرگری تاریخ‌یار را نگهداری می‌کند.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.ui.components

// راهنما: این import وابستگی «androidx.compose.foundation.layout.Arrangement» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Arrangement
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Column» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Column
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
// راهنما: این import وابستگی «androidx.compose.material.icons.Icons» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.Icons
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.ContactMail» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.ContactMail
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Info» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Info
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Settings» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Settings
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Share» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Share
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.SupervisorAccount» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.SupervisorAccount
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
// راهنما: این import وابستگی «androidx.compose.material3.Text» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Text
// راهنما: این import وابستگی «androidx.compose.runtime.Composable» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.Composable
// راهنما: این import وابستگی «androidx.compose.ui.Modifier» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.Modifier
// راهنما: این import وابستگی «androidx.compose.ui.text.font.FontWeight» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.text.font.FontWeight
// راهنما: این import وابستگی «androidx.compose.ui.unit.dp» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.unit.dp
// راهنما: این import وابستگی «ir.tarikhyar.app.AppScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.AppScreen

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
    // در RTL، ModalDrawerSheet از سمت راست نمایش داده می‌شود و عرض آن برای گوشی محدود شده است.
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ModalDrawerSheet(
        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
        modifier = Modifier
            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
            .fillMaxHeight()
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            .width(310.dp),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ) {
        // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
        Column(
            // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 20.dp),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            verticalArrangement = Arrangement.spacedBy(6.dp),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ) {
            // عنوان Drawer مشخص می‌کند این منو متعلق به کدام برنامه است.
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                text = "تاریخ‌یار",
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                style = MaterialTheme.typography.headlineSmall,
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                color = MaterialTheme.colorScheme.primary,
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                fontWeight = FontWeight.ExtraBold,
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            )
            // راهنما: این Text متن مورد نیاز رابط کاربری را نمایش می‌دهد.
            Text(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                text = "ابزارهای تاریخ و تولد",
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                style = MaterialTheme.typography.bodyMedium,
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            )

            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            Spacer(Modifier.size(8.dp))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            HorizontalDivider()
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            Spacer(Modifier.size(4.dp))

            // گزینه تنظیمات به صفحه تنظیمات اختصاصی تاریخ‌یار می‌رود.
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            NavigationDrawerItem(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                label = { Text("تنظیمات") },
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                selected = currentScreen == AppScreen.SETTINGS,
                // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                onClick = { onNavigate(AppScreen.SETTINGS) },
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                icon = { Icon(Icons.Rounded.Settings, contentDescription = null) },
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            )

            // معرفی به دوستان Share Sheet استاندارد اندروید را باز می‌کند.
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            NavigationDrawerItem(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                label = { Text("معرفی به دوستان") },
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                selected = false,
                // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                onClick = onShare,
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                icon = { Icon(Icons.Rounded.Share, contentDescription = null) },
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            )

            // درباره ما اطلاعات گروه توسعه‌دهنده را نمایش می‌دهد.
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            NavigationDrawerItem(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                label = { Text("درباره ما") },
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                selected = currentScreen == AppScreen.ABOUT_US,
                // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                onClick = { onNavigate(AppScreen.ABOUT_US) },
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                icon = { Icon(Icons.Rounded.SupervisorAccount, contentDescription = null) },
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            )

            // تماس با ما ایمیل پشتیبانی را در یک صفحه مستقل نمایش می‌دهد.
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            NavigationDrawerItem(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                label = { Text("تماس با ما") },
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                selected = currentScreen == AppScreen.CONTACT_US,
                // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                onClick = { onNavigate(AppScreen.CONTACT_US) },
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                icon = { Icon(Icons.Rounded.ContactMail, contentDescription = null) },
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            )

            // درباره نرم افزار فقط توضیح کوتاه برنامه و نسخه را نشان می‌دهد؛ اطلاعات فنی بسته نمایش داده نمی‌شود.
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            NavigationDrawerItem(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                label = { Text("درباره نرم افزار") },
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                selected = currentScreen == AppScreen.ABOUT_APP,
                // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                onClick = { onNavigate(AppScreen.ABOUT_APP) },
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                icon = { Icon(Icons.Rounded.Info, contentDescription = null) },
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            )
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
