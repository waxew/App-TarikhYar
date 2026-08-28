package ir.tarikhyar.app

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Apps
import androidx.compose.material.icons.rounded.Cake
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
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
import ir.tarikhyar.app.feature.backup.BackupScreen
import ir.tarikhyar.app.feature.birthinfo.BirthInfoScreen
import ir.tarikhyar.app.feature.calendar.CalendarScreen
import ir.tarikhyar.app.feature.chinese.ChineseAstrologyScreen
import ir.tarikhyar.app.feature.difference.DifferenceScreen
import ir.tarikhyar.app.feature.events.AgeEventsScreen
import ir.tarikhyar.app.feature.favorites.FavoritesScreen
import ir.tarikhyar.app.feature.home.HomeScreen
import ir.tarikhyar.app.feature.notifications.NotificationsScreen
import ir.tarikhyar.app.feature.personalevents.PersonalEventsScreen
import ir.tarikhyar.app.feature.profiles.ProfilesScreen
import ir.tarikhyar.app.feature.protools.ProfessionalToolsScreen
import ir.tarikhyar.app.feature.settings.SettingsScreen
import ir.tarikhyar.app.feature.tools.ToolsScreen
import ir.tarikhyar.app.ui.components.AppDrawerContent
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.shareText
import kotlinx.coroutines.launch

/** تمام مقصدهای قابل نمایش برنامه در یک enum نگهداری می‌شوند تا Back Stack قابل پیش‌بینی باشد. */
enum class AppScreen(val label: String) {
    HOME("خانه"),
    AGE("سن"),
    BIRTH_INFO("اطلاعات تولد"),
    AGE_EVENTS("رویدادهای سنی"),
    CHINESE("طالع چینی"),
    DIFFERENCE("اختلاف تاریخ"),
    TOOLS("تبدیل تاریخ"),
    PROFILES("پروفایل‌ها"),
    CALENDAR("تقویم"),
    PERSONAL_EVENTS("مناسبت‌های شخصی"),
    PRO_TOOLS("ابزارهای حرفه‌ای"),
    FAVORITES("علاقه‌مندی‌ها"),
    BACKUP("پشتیبان‌گیری"),
    SETTINGS("تنظیمات"),
    NOTIFICATIONS("اعلان‌ها"),
    ABOUT_US("درباره ما"),
    CONTACT_US("تماس با ما"),
    ABOUT_APP("درباره نرم افزار"),
}

/** پوسته اصلی Compose شامل Drawer، ناوبری پایین، Back Stack و تمام صفحات برنامه است. */
@Composable
fun TarikhYarApp() {
    var currentScreen by rememberSaveable { mutableStateOf(AppScreen.HOME) }
    val backStack = remember { mutableStateListOf<AppScreen>() }
    val context = LocalContext.current
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navigate: (AppScreen) -> Unit = { target ->
        if (target != currentScreen) {
            backStack.add(currentScreen)
            currentScreen = target
        }
    }
    val goBack: () -> Unit = {
        if (backStack.isNotEmpty()) currentScreen = backStack.removeAt(backStack.lastIndex)
        else if (currentScreen != AppScreen.HOME) currentScreen = AppScreen.HOME
    }

    BackHandler(enabled = drawerState.isOpen) { scope.launch { drawerState.close() } }
    BackHandler(enabled = !drawerState.isOpen && (currentScreen != AppScreen.HOME || backStack.isNotEmpty())) { goBack() }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            gesturesEnabled = true,
            drawerContent = {
                AppDrawerContent(
                    currentScreen = currentScreen,
                    onNavigate = { target -> scope.launch { drawerState.close(); navigate(target) } },
                    onShare = {
                        scope.launch { drawerState.close() }
                        shareText(context, "تاریخ‌یار", "تاریخ‌یار؛ تقویم زندگی، محاسبه سن و ابزارهای تاریخ\nhttps://github.com/waxew/App-TarikhYar")
                    },
                )
            },
        ) {
            Scaffold(
                containerColor = MaterialTheme.colorScheme.background,
                bottomBar = {
                    if (currentScreen == AppScreen.HOME) {
                        NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                            listOf(
                                Triple(AppScreen.HOME, Icons.Rounded.Home, "خانه"),
                                Triple(AppScreen.AGE, Icons.Rounded.Cake, "سن"),
                                Triple(AppScreen.CALENDAR, Icons.Rounded.CalendarMonth, "تقویم"),
                                Triple(AppScreen.PROFILES, Icons.Rounded.Person, "پروفایل"),
                                Triple(AppScreen.PRO_TOOLS, Icons.Rounded.Apps, "بیشتر"),
                            ).forEach { (screen, icon, label) ->
                                NavigationBarItem(
                                    selected = currentScreen == screen,
                                    onClick = { navigate(screen) },
                                    icon = { Icon(icon, label) },
                                    label = { Text(label) },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = MaterialTheme.colorScheme.primary,
                                        selectedTextColor = MaterialTheme.colorScheme.primary,
                                        indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),
                                )
                            }
                        }
                    }
                },
            ) { innerPadding ->
                val pageModifier = Modifier.padding(innerPadding)
                when (currentScreen) {
                    AppScreen.HOME -> HomeScreen(navigate, { scope.launch { drawerState.open() } }, pageModifier)
                    AppScreen.AGE -> AgeScreen(goBack, pageModifier)
                    AppScreen.BIRTH_INFO -> BirthInfoScreen(goBack, pageModifier)
                    AppScreen.AGE_EVENTS -> AgeEventsScreen(goBack, pageModifier)
                    AppScreen.CHINESE -> ChineseAstrologyScreen(goBack, pageModifier)
                    AppScreen.PROFILES -> ProfilesScreen(goBack, pageModifier)
                    AppScreen.CALENDAR -> CalendarScreen(goBack, pageModifier)
                    AppScreen.PERSONAL_EVENTS -> PersonalEventsScreen(goBack, pageModifier)
                    AppScreen.PRO_TOOLS -> ProfessionalToolsScreen(goBack, pageModifier)
                    AppScreen.FAVORITES -> FavoritesScreen(goBack, navigate, pageModifier)
                    AppScreen.BACKUP -> BackupScreen(goBack, pageModifier)
                    AppScreen.SETTINGS -> SettingsScreen(goBack, pageModifier)
                    AppScreen.NOTIFICATIONS -> NotificationsScreen(goBack, pageModifier)
                    AppScreen.ABOUT_US -> AboutUsScreen(goBack, pageModifier)
                    AppScreen.CONTACT_US -> ContactUsScreen(goBack, pageModifier)
                    AppScreen.ABOUT_APP -> AboutAppScreen(goBack, pageModifier)
                    AppScreen.DIFFERENCE -> WrappedToolScreen("اختلاف تاریخ", goBack, pageModifier) { DifferenceScreen(Modifier.weight(1f)) }
                    AppScreen.TOOLS -> WrappedToolScreen("تبدیل تاریخ", goBack, pageModifier) { ToolsScreen(Modifier.weight(1f)) }
                }
            }
        }
    }
}

@Composable
private fun WrappedToolScreen(
    title: String,
    onBack: () -> Unit,
    modifier: Modifier,
    content: @Composable androidx.compose.foundation.layout.ColumnScope.() -> Unit,
) {
    Column(modifier) {
        AppTopBar(title, onBack)
        content()
    }
}
