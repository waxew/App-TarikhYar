package ir.tarikhyar.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Apps
import androidx.compose.material.icons.rounded.Cake
import androidx.compose.material.icons.rounded.DateRange
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
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import ir.tarikhyar.app.feature.age.AgeScreen
import ir.tarikhyar.app.feature.difference.DifferenceScreen
import ir.tarikhyar.app.feature.home.HomeScreen
import ir.tarikhyar.app.feature.tools.ToolsScreen

enum class AppScreen(val label: String) {
    HOME("خانه"),
    AGE("سن"),
    DIFFERENCE("اختلاف"),
    TOOLS("ابزارها"),
}

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
                            AppScreen.DIFFERENCE -> Icons.Rounded.DateRange
                            AppScreen.TOOLS -> Icons.Rounded.Apps
                        }
                        NavigationBarItem(
                            selected = currentScreen == screen,
                            onClick = { currentScreen = screen },
                            icon = { Icon(icon, contentDescription = screen.label) },
                            label = { Text(screen.label) },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                            ),
                        )
                    }
                }
            },
        ) { innerPadding ->
            when (currentScreen) {
                AppScreen.HOME -> HomeScreen(
                    modifier = Modifier.padding(innerPadding),
                    onNavigate = { currentScreen = it },
                )
                AppScreen.AGE -> AgeScreen(modifier = Modifier.padding(innerPadding))
                AppScreen.DIFFERENCE -> DifferenceScreen(modifier = Modifier.padding(innerPadding))
                AppScreen.TOOLS -> ToolsScreen(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}
