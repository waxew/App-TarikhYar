// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// این فایل پوسته اصلی برنامه، ناوبری، Back Stack و Drawer سراسری تاریخ‌یار را مدیریت می‌کند.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app

// راهنما: این import وابستگی «androidx.activity.compose.BackHandler» را برای استفاده در این فایل وارد می‌کند.
import androidx.activity.compose.BackHandler
// راهنما: این import وابستگی «androidx.compose.foundation.layout.Column» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.Column
// راهنما: این import وابستگی «androidx.compose.foundation.layout.padding» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.foundation.layout.padding
// راهنما: این import وابستگی «androidx.compose.material.icons.Icons» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.Icons
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Apps» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Apps
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Cake» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Cake
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.CalendarMonth» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.CalendarMonth
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.EventAvailable» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.EventAvailable
// راهنما: این import وابستگی «androidx.compose.material.icons.rounded.Home» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material.icons.rounded.Home
// راهنما: این import وابستگی «androidx.compose.material3.DrawerValue» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.DrawerValue
// راهنما: این import وابستگی «androidx.compose.material3.Icon» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Icon
// راهنما: این import وابستگی «androidx.compose.material3.MaterialTheme» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.MaterialTheme
// راهنما: این import وابستگی «androidx.compose.material3.ModalNavigationDrawer» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.ModalNavigationDrawer
// راهنما: این import وابستگی «androidx.compose.material3.NavigationBar» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.NavigationBar
// راهنما: این import وابستگی «androidx.compose.material3.NavigationBarItem» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.NavigationBarItem
// راهنما: این import وابستگی «androidx.compose.material3.NavigationBarItemDefaults» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.NavigationBarItemDefaults
// راهنما: این import وابستگی «androidx.compose.material3.Scaffold» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Scaffold
// راهنما: این import وابستگی «androidx.compose.material3.Text» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.Text
// راهنما: این import وابستگی «androidx.compose.material3.rememberDrawerState» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.material3.rememberDrawerState
// راهنما: این import وابستگی «androidx.compose.runtime.Composable» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.Composable
// راهنما: این import وابستگی «androidx.compose.runtime.CompositionLocalProvider» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.CompositionLocalProvider
// راهنما: این import وابستگی «androidx.compose.runtime.getValue» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.getValue
// راهنما: این import وابستگی «androidx.compose.runtime.mutableStateListOf» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.mutableStateListOf
// راهنما: این import وابستگی «androidx.compose.runtime.mutableStateOf» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.mutableStateOf
// راهنما: این import وابستگی «androidx.compose.runtime.remember» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.remember
// راهنما: این import وابستگی «androidx.compose.runtime.rememberCoroutineScope» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.rememberCoroutineScope
// راهنما: این import وابستگی «androidx.compose.runtime.saveable.rememberSaveable» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.saveable.rememberSaveable
// راهنما: این import وابستگی «androidx.compose.runtime.setValue» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.runtime.setValue
// راهنما: این import وابستگی «androidx.compose.ui.Modifier» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.Modifier
// راهنما: این import وابستگی «androidx.compose.ui.platform.LocalContext» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.platform.LocalContext
// راهنما: این import وابستگی «androidx.compose.ui.platform.LocalLayoutDirection» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.platform.LocalLayoutDirection
// راهنما: این import وابستگی «androidx.compose.ui.unit.LayoutDirection» را برای استفاده در این فایل وارد می‌کند.
import androidx.compose.ui.unit.LayoutDirection
// راهنما: این import وابستگی «ir.tarikhyar.app.feature.about.AboutAppScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.feature.about.AboutAppScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.feature.about.AboutUsScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.feature.about.AboutUsScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.feature.about.ContactUsScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.feature.about.ContactUsScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.feature.age.AgeScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.feature.age.AgeScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.feature.birthinfo.BirthInfoScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.feature.birthinfo.BirthInfoScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.feature.chinese.ChineseAstrologyScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.feature.chinese.ChineseAstrologyScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.feature.difference.DifferenceScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.feature.difference.DifferenceScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.feature.events.AgeEventsScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.feature.events.AgeEventsScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.feature.home.HomeScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.feature.home.HomeScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.feature.notifications.NotificationsScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.feature.notifications.NotificationsScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.feature.settings.SettingsScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.feature.settings.SettingsScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.feature.tools.ToolsScreen» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.feature.tools.ToolsScreen
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.AppDrawerContent» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.AppDrawerContent
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.AppTopBar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.AppTopBar
// راهنما: این import وابستگی «ir.tarikhyar.app.ui.components.shareText» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.ui.components.shareText
// راهنما: این import وابستگی «kotlinx.coroutines.launch» را برای استفاده در این فایل وارد می‌کند.
import kotlinx.coroutines.launch

// تمام مقصدهای قابل نمایش برنامه در این enum تعریف می‌شوند تا ناوبری یک نقطه کنترل مشخص داشته باشد.
// راهنما: این enum مجموعه محدود و مشخصی از حالت‌های قابل استفاده را تعریف می‌کند.
enum class AppScreen(val label: String) {
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    HOME("خانه"),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    AGE("سن"),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    BIRTH_INFO("اطلاعات تولد"),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    AGE_EVENTS("رویدادها"),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    CHINESE("طالع چینی"),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    DIFFERENCE("اختلاف تاریخ"),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    TOOLS("ابزارها"),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    SETTINGS("تنظیمات"),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    NOTIFICATIONS("اعلان‌ها"),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ABOUT_US("درباره ما"),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    CONTACT_US("تماس با ما"),
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    ABOUT_APP("درباره نرم افزار"),
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}

// راهنما: این Annotation مشخص می‌کند تابع بعدی بخشی از رابط کاربری Jetpack Compose است.
@Composable
// راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
fun TarikhYarApp() {
    // صفحه فعلی با rememberSaveable نگهداری می‌شود تا در بازسازی Activity از بین نرود.
    // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
    var currentScreen by rememberSaveable { mutableStateOf(AppScreen.HOME) }

    // این لیست تاریخچه واقعی صفحات را نگهداری می‌کند تا Back به صفحه قبلی برگردد، نه اینکه برنامه را ببندد.
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val backStack = remember { mutableStateListOf<AppScreen>() }

    // Context برای Share و سایر عملیات اندرویدی مورد نیاز است.
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val context = LocalContext.current

    // Drawer از سمت Start باز می‌شود؛ چون کل برنامه RTL است Start همان سمت راست صفحه است.
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val scope = rememberCoroutineScope()

    // هر بار که به صفحه جدید می‌رویم، صفحه فعلی قبل از تغییر داخل Back Stack ثبت می‌شود.
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val navigate: (AppScreen) -> Unit = { target ->
        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
        if (target != currentScreen) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            backStack.add(currentScreen)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            currentScreen = target
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // این تابع برای دکمه Back خود صفحات و Back سخت‌افزاری گوشی استفاده می‌شود.
    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
    val goBack: () -> Unit = {
        // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
        if (backStack.isNotEmpty()) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            currentScreen = backStack.removeAt(backStack.lastIndex)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        } else if (currentScreen != AppScreen.HOME) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            currentScreen = AppScreen.HOME
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // اگر Drawer باز باشد، Back ابتدا Drawer را می‌بندد و هیچ صفحه‌ای را تغییر نمی‌دهد.
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    BackHandler(enabled = drawerState.isOpen) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        scope.launch { drawerState.close() }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // اگر داخل صفحه‌ای غیر از خانه باشیم، Back صفحه قبلی را از تاریخچه بازیابی می‌کند.
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    BackHandler(enabled = !drawerState.isOpen && (currentScreen != AppScreen.HOME || backStack.isNotEmpty())) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        goBack()
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // تمام UI برنامه راست‌چین است؛ این Provider جهت Layout را برای تمام فرزندان مشخص می‌کند.
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ModalNavigationDrawer(
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            drawerState = drawerState,
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            gesturesEnabled = true,
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            drawerContent = {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                AppDrawerContent(
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    currentScreen = currentScreen,
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    onNavigate = { target ->
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        scope.launch {
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            drawerState.close()
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            navigate(target)
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        }
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    },
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    onShare = {
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        scope.launch { drawerState.close() }
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        shareText(
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            context = context,
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            title = "تاریخ‌یار",
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            text = "تاریخ‌یار؛ محاسبه سن، تبدیل تاریخ و ابزارهای کاربردی تاریخ\nhttps://github.com/waxew/App-TarikhYar",
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        )
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    },
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                )
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            },
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            Scaffold(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                containerColor = MaterialTheme.colorScheme.background,
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                bottomBar = {
                    // Bottom Navigation فعلاً فقط در خانه نمایش داده می‌شود تا صفحات محاسباتی فضای کامل داشته باشند.
                    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                    if (currentScreen == AppScreen.HOME) {
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
                            val items = listOf(
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                Triple(AppScreen.HOME, Icons.Rounded.Home, "خانه"),
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                Triple(AppScreen.AGE, Icons.Rounded.Cake, "سن"),
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                Triple(AppScreen.BIRTH_INFO, Icons.Rounded.CalendarMonth, "تولد"),
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                Triple(AppScreen.AGE_EVENTS, Icons.Rounded.EventAvailable, "رویدادها"),
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                Triple(AppScreen.TOOLS, Icons.Rounded.Apps, "بیشتر"),
                            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                            )

                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            items.forEach { (screen, icon, label) ->
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                NavigationBarItem(
                                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                    selected = screen == currentScreen,
                                    // راهنما: این callback عملیاتی را که پس از لمس کاربر باید اجرا شود مشخص می‌کند.
                                    onClick = { navigate(screen) },
                                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                    icon = { Icon(icon, contentDescription = label) },
                                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                    label = { Text(label) },
                                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                    colors = NavigationBarItemDefaults.colors(
                                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                        selectedIconColor = MaterialTheme.colorScheme.primary,
                                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                        selectedTextColor = MaterialTheme.colorScheme.primary,
                                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                        indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                                    ),
                                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                                )
                            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                            }
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        }
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                },
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            ) { innerPadding ->
                // هر مقصد به Composable مستقل خودش متصل است؛ همه Backها از یک Back Stack مشترک استفاده می‌کنند.
                // راهنما: این when بر اساس مقدار ورودی یکی از مسیرهای مشخص را انتخاب می‌کند.
                when (currentScreen) {
                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    AppScreen.HOME -> HomeScreen(
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        onNavigate = navigate,
                        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                        onMenuClick = { scope.launch { drawerState.open() } },
                        // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                        modifier = Modifier.padding(innerPadding),
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    )

                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    AppScreen.AGE -> AgeScreen(goBack, Modifier.padding(innerPadding))
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    AppScreen.BIRTH_INFO -> BirthInfoScreen(goBack, Modifier.padding(innerPadding))
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    AppScreen.AGE_EVENTS -> AgeEventsScreen(goBack, Modifier.padding(innerPadding))
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    AppScreen.CHINESE -> ChineseAstrologyScreen(goBack, Modifier.padding(innerPadding))
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    AppScreen.SETTINGS -> SettingsScreen(goBack, Modifier.padding(innerPadding))
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    AppScreen.NOTIFICATIONS -> NotificationsScreen(goBack, Modifier.padding(innerPadding))
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    AppScreen.ABOUT_US -> AboutUsScreen(goBack, Modifier.padding(innerPadding))
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    AppScreen.CONTACT_US -> ContactUsScreen(goBack, Modifier.padding(innerPadding))
                    // راهنما: این Modifier اندازه، فاصله، چیدمان یا رفتار ظاهری مؤلفه Compose را تنظیم می‌کند.
                    AppScreen.ABOUT_APP -> AboutAppScreen(goBack, Modifier.padding(innerPadding))

                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    AppScreen.DIFFERENCE -> {
                        // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
                        Column(Modifier.padding(innerPadding)) {
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            AppTopBar("اختلاف تاریخ", goBack) {
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                shareText(context, "اختلاف تاریخ", "محاسبه فاصله دو تاریخ با تاریخ‌یار")
                            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                            }
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            DifferenceScreen(Modifier.weight(1f))
                        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                        }
                    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                    }

                    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                    AppScreen.TOOLS -> {
                        // راهنما: این Column اجزای رابط کاربری را به صورت عمودی کنار هم قرار می‌دهد.
                        Column(Modifier.padding(innerPadding)) {
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            AppTopBar("ابزارهای تاریخ", goBack) {
                                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                                shareText(context, "ابزارهای تاریخ‌یار", "تبدیل و محاسبه تاریخ با تاریخ‌یار")
                            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                            }
                            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                            ToolsScreen(Modifier.weight(1f))
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
