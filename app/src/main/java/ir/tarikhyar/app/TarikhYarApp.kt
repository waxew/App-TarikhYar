package ir.tarikhyar.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Apps
import androidx.compose.material.icons.rounded.Cake
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Stars
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import ir.tarikhyar.app.feature.age.AgeScreen
import ir.tarikhyar.app.feature.difference.DifferenceScreen
import ir.tarikhyar.app.feature.home.HomeScreen
import ir.tarikhyar.app.feature.insights.InsightsScreen
import ir.tarikhyar.app.feature.tools.ToolsScreen

enum class AppScreen(val label: String) { HOME("خانه"), AGE("سن"), INSIGHTS("تولد"), DIFFERENCE("تاریخ‌ها"), TOOLS("بیشتر") }

@Composable
fun TarikhYarApp() {
    var currentScreen by rememberSaveable { mutableStateOf(AppScreen.HOME) }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            bottomBar = {
                NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                    AppScreen.entries.forEach { screen ->
                        val icon = when (screen) {
                            AppScreen.HOME -> Icons.Rounded.Home
                            AppScreen.AGE -> Icons.Rounded.Cake
                            AppScreen.INSIGHTS -> Icons.Rounded.Stars
                            AppScreen.DIFFERENCE -> Icons.Rounded.DateRange
                            AppScreen.TOOLS -> Icons.Rounded.Apps
                        }
                        NavigationBarItem(
                            selected = currentScreen == screen,
                            onClick = { currentScreen = screen },
                            icon = { Icon(icon, screen.label) },
                            label = { Text(screen.label) },
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
            },
        ) { innerPadding ->
            when (currentScreen) {
                AppScreen.HOME -> HomeScreen({ currentScreen = it }, Modifier.padding(innerPadding))
                AppScreen.AGE -> AgeScreen(Modifier.padding(innerPadding))
                AppScreen.INSIGHTS -> InsightsScreen(Modifier.padding(innerPadding))
                AppScreen.DIFFERENCE -> DifferenceScreen(Modifier.padding(innerPadding))
                AppScreen.TOOLS -> ToolsScreen(Modifier.padding(innerPadding))
            }
        }
    }
}
