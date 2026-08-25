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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import ir.tarikhyar.app.feature.age.AgeScreen
import ir.tarikhyar.app.feature.birthinfo.BirthInfoScreen
import ir.tarikhyar.app.feature.chinese.ChineseAstrologyScreen
import ir.tarikhyar.app.feature.difference.DifferenceScreen
import ir.tarikhyar.app.feature.events.AgeEventsScreen
import ir.tarikhyar.app.feature.home.HomeScreen
import ir.tarikhyar.app.feature.notifications.NotificationsScreen
import ir.tarikhyar.app.feature.settings.SettingsScreen
import ir.tarikhyar.app.feature.tools.ToolsScreen
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.shareText

enum class AppScreen(val label: String) {
    HOME("خانه"),
    AGE("سن"),
    BIRTH_INFO("اطلاعات"),
    AGE_EVENTS("رویدادها"),
    CHINESE("طالع چینی"),
    DIFFERENCE("اختلاف تاریخ"),
    TOOLS("بیشتر"),
    SETTINGS("تنظیمات"),
    NOTIFICATIONS("اعلان‌ها"),
}

@Composable
fun TarikhYarApp() {
    var currentScreen by rememberSaveable { mutableStateOf(AppScreen.HOME) }
    val context = LocalContext.current
    val goHome = { currentScreen = AppScreen.HOME }

    BackHandler(enabled = currentScreen != AppScreen.HOME) { goHome() }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            bottomBar = {
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
                                selected = screen == AppScreen.HOME,
                                onClick = { currentScreen = screen },
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
            when (currentScreen) {
                AppScreen.HOME -> HomeScreen({ currentScreen = it }, Modifier.padding(innerPadding))
                AppScreen.AGE -> AgeScreen(goHome, Modifier.padding(innerPadding))
                AppScreen.BIRTH_INFO -> BirthInfoScreen(goHome, Modifier.padding(innerPadding))
                AppScreen.AGE_EVENTS -> AgeEventsScreen(goHome, Modifier.padding(innerPadding))
                AppScreen.CHINESE -> ChineseAstrologyScreen(goHome, Modifier.padding(innerPadding))
                AppScreen.SETTINGS -> SettingsScreen(goHome, Modifier.padding(innerPadding))
                AppScreen.NOTIFICATIONS -> NotificationsScreen(goHome, Modifier.padding(innerPadding))
                AppScreen.DIFFERENCE -> {
                    Column(Modifier.padding(innerPadding)) {
                        AppTopBar("اختلاف تاریخ", goHome) {
                            shareText(context, "اختلاف تاریخ", "محاسبه فاصله دو تاریخ با تاریخ‌یار")
                        }
                        DifferenceScreen(Modifier.weight(1f))
                    }
                }
                AppScreen.TOOLS -> {
                    Column(Modifier.padding(innerPadding)) {
                        AppTopBar("ابزارهای تاریخ", goHome) {
                            shareText(context, "ابزارهای تاریخ‌یار", "تبدیل و محاسبه تاریخ با تاریخ‌یار")
                        }
                        ToolsScreen(Modifier.weight(1f))
                    }
                }
            }
        }
    }
}
