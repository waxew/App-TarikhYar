// این فایل پوسته اصلی برنامه، ناوبری، Back Stack و Drawer سراسری تاریخ‌یار را مدیریت می‌کند.
package ir.tarikhyar.app

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Apps
import androidx.compose.material.icons.rounded.Cake
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.EventAvailable
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import ir.tarikhyar.app.feature.about.AboutAppScreen
import ir.tarikhyar.app.feature.about.AboutUsScreen
import ir.tarikhyar.app.feature.about.ContactUsScreen
import ir.tarikhyar.app.feature.age.AgeScreen
import ir.tarikhyar.app.feature.birthinfo.BirthInfoScreen
import ir.tarikhyar.app.feature.chinese.ChineseAstrologyScreen
import ir.tarikhyar.app.feature.difference.DifferenceScreen
import ir.tarikhyar.app.feature.events.AgeEventsScreen
import ir.tarikhyar.app.feature.home.HomeScreen
import ir.tarikhyar.app.feature.notifications.NotificationsScreen
import ir.tarikhyar.app.feature.settings.SettingsScreen
import ir.tarikhyar.app.feature.tools.ToolsScreen
import ir.tarikhyar.app.ui.components.AppDrawerContent
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.shareText
import kotlinx.coroutines.launch

// تمام مقصدهای قابل نمایش برنامه در این enum تعریف می‌شوند تا ناوبری یک نقطه کنترل مشخص داشته باشد.
enum class AppScreen(val label: String) {
    HOME("خانه"),
    AGE("سن"),
    BIRTH_INFO("اطلاعات تولد"),
    AGE_EVENTS("رویدادها"),
    CHINESE("طالع چینی"),
    DIFFERENCE("اختلاف تاریخ"),
    TOOLS("ابزارها"),
    SETTINGS("تنظیمات"),
    NOTIFICATIONS("اعلان‌ها"),
    ABOUT_US("درباره ما"),
    CONTACT_US("تماس با ما"),
    ABOUT_APP("درباره نرم افزار"),
}

@Composable
fun TarikhYarApp() {
    // صفحه فعلی با rememberSaveable نگهداری می‌شود تا در بازسازی Activity از بین نرود.
    var currentScreen by rememberSaveable { mutableStateOf(AppScreen.HOME) }

    // این لیست تاریخچه واقعی صفحات را نگهداری می‌کند تا Back به صفحه قبلی برگردد، نه اینکه برنامه را ببندد.
    val backStack = remember { mutableStateListOf<AppScreen>() }

    // Context برای Share و سایر عملیات اندرویدی مورد نیاز است.
    val context = LocalContext.current

    // Drawer از سمت Start باز می‌شود؛ چون کل برنامه RTL است Start همان سمت راست صفحه است.
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // هر بار که به صفحه جدید می‌رویم، صفحه فعلی قبل از تغییر داخل Back Stack ثبت می‌شود.
    val navigate: (AppScreen) -> Unit = { target ->
        if (target != currentScreen) {
            backStack.add(currentScreen)
            currentScreen = target
        }
    }

    // این تابع برای دکمه Back خود صفحات و Back سخت‌افزاری گوشی استفاده می‌شود.
    val goBack: () -> Unit = {
        if (backStack.isNotEmpty()) {
            currentScreen = backStack.removeAt(backStack.lastIndex)
        } else if (currentScreen != AppScreen.HOME) {
            currentScreen = AppScreen.HOME
        }
    }

    // اگر Drawer باز باشد، Back ابتدا Drawer را می‌بندد و هیچ صفحه‌ای را تغییر نمی‌دهد.
    BackHandler(enabled = drawerState.isOpen) {
        scope.launch { drawerState.close() }
    }

    // اگر داخل صفحه‌ای غیر از خانه باشیم، Back صفحه قبلی را از تاریخچه بازیابی می‌کند.
    BackHandler(enabled = !drawerState.isOpen && (currentScreen != AppScreen.HOME || backStack.isNotEmpty())) {
        goBack()
    }

    // تمام UI برنامه راست‌چین است؛ این Provider جهت Layout را برای تمام فرزندان مشخص می‌کند.
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            gesturesEnabled = true,
            drawerContent = {
                AppDrawerContent(
                    currentScreen = currentScreen,
                    onNavigate = { target ->
                        scope.launch {
                            drawerState.close()
                            navigate(target)
                        }
                    },
                    onShare = {
                        scope.launch { drawerState.close() }
                        shareText(
                            context = context,
                            title = "تاریخ‌یار",
                            text = "تاریخ‌یار؛ محاسبه سن، تبدیل تاریخ و ابزارهای کاربردی تاریخ\nhttps://github.com/waxew/App-TarikhYar",
                        )
                    },
                )
            },
        ) {
            Scaffold(
                containerColor = MaterialTheme.colorScheme.background,
                bottomBar = {
                    // Bottom Navigation فعلاً فقط در خانه نمایش داده می‌شود تا صفحات محاسباتی فضای کامل داشته باشند.
                    if (currentScreen == AppScreen.HOME) {
                        NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                            val items = listOf(
                                Triple(AppScreen.HOME, Icons.Rounded.Home, "خانه"),
                                Triple(AppScreen.AGE, Icons.Rounded.Cake, "سن"),
                                Triple(AppScreen.BIRTH_INFO, Icons.Rounded.CalendarMonth, "تولد"),
                                Triple(AppScreen.AGE_EVENTS, Icons.Rounded.EventAvailable, "رویدادها"),
                                Triple(AppScreen.TOOLS, Icons.Rounded.Apps, "بیشتر"),
                            )

                            items.forEach { (screen, icon, label) ->
                                NavigationBarItem(
                                    selected = screen == currentScreen,
                                    onClick = { navigate(screen) },
                                    icon = { Icon(icon, contentDescription = label) },
                                    label = { Text(label) },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = MaterialTheme.colorScheme.primary,
                                        selectedTextColor = MaterialTheme.colorScheme.primary,
                                        indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                    ),
                                )
                            }
                        }
                    }
                },
            ) { innerPadding ->
                // هر مقصد به Composable مستقل خودش متصل است؛ همه Backها از یک Back Stack مشترک استفاده می‌کنند.
                when (currentScreen) {
                    AppScreen.HOME -> HomeScreen(
                        onNavigate = navigate,
                        onMenuClick = { scope.launch { drawerState.open() } },
                        modifier = Modifier.padding(innerPadding),
                    )

                    AppScreen.AGE -> AgeScreen(goBack, Modifier.padding(innerPadding))
                    AppScreen.BIRTH_INFO -> BirthInfoScreen(goBack, Modifier.padding(innerPadding))
                    AppScreen.AGE_EVENTS -> AgeEventsScreen(goBack, Modifier.padding(innerPadding))
                    AppScreen.CHINESE -> ChineseAstrologyScreen(goBack, Modifier.padding(innerPadding))
                    AppScreen.SETTINGS -> SettingsScreen(goBack, Modifier.padding(innerPadding))
                    AppScreen.NOTIFICATIONS -> NotificationsScreen(goBack, Modifier.padding(innerPadding))
                    AppScreen.ABOUT_US -> AboutUsScreen(goBack, Modifier.padding(innerPadding))
                    AppScreen.CONTACT_US -> ContactUsScreen(goBack, Modifier.padding(innerPadding))
                    AppScreen.ABOUT_APP -> AboutAppScreen(goBack, Modifier.padding(innerPadding))

                    AppScreen.DIFFERENCE -> {
                        Column(Modifier.padding(innerPadding)) {
                            AppTopBar("اختلاف تاریخ", goBack) {
                                shareText(context, "اختلاف تاریخ", "محاسبه فاصله دو تاریخ با تاریخ‌یار")
                            }
                            DifferenceScreen(Modifier.weight(1f))
                        }
                    }

                    AppScreen.TOOLS -> {
                        Column(Modifier.padding(innerPadding)) {
                            AppTopBar("ابزارهای تاریخ", goBack) {
                                shareText(context, "ابزارهای تاریخ‌یار", "تبدیل و محاسبه تاریخ با تاریخ‌یار")
                            }
                            ToolsScreen(Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}
