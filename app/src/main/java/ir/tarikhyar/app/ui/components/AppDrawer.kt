package ir.tarikhyar.app.ui.components

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Backup
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.ContactMail
import androidx.compose.material.icons.rounded.Event
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.SupervisorAccount
import androidx.compose.material.icons.rounded.Tune
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.AppScreen
import ir.tarikhyar.app.core.system.UserSettings

/** منوی همبرگری نسخه ۲ با پروفایل، تصویر کاربر و مسیرهای جدید برنامه. */
@Composable
fun AppDrawerContent(
    currentScreen: AppScreen,
    onNavigate: (AppScreen) -> Unit,
    onShare: () -> Unit,
) {
    val context = LocalContext.current
    var imageUri by remember { mutableStateOf(UserSettings.profileImageUri(context)) }
    val imagePicker = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        if (uri != null) {
            runCatching {
                context.contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            imageUri = uri.toString()
            UserSettings.setProfileImageUri(context, imageUri)
        }
    }
    val bitmap = remember(imageUri) {
        if (imageUri.isBlank()) null else runCatching {
            context.contentResolver.openInputStream(android.net.Uri.parse(imageUri))?.use { stream -> BitmapFactory.decodeStream(stream) }
        }.getOrNull()
    }

    ModalDrawerSheet(modifier = Modifier.fillMaxHeight().width(320.dp)) {
        LazyColumn(
            modifier = Modifier.fillMaxHeight().padding(horizontal = 14.dp, vertical = 18.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            item {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Surface(
                        modifier = Modifier.size(92.dp),
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        onClick = { imagePicker.launch(arrayOf("image/*")) },
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            if (bitmap != null) {
                                Image(bitmap.asImageBitmap(), "تصویر پروفایل", Modifier.size(92.dp).clip(CircleShape))
                            } else {
                                Icon(Icons.Rounded.Person, "انتخاب تصویر پروفایل", Modifier.size(48.dp), tint = MaterialTheme.colorScheme.primary)
                            }
                        }
                    }
                    Spacer(Modifier.size(8.dp))
                    Text(UserSettings.displayName(context), style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Text("تاریخ‌یار • تقویم زندگی شما", color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            item { HorizontalDivider(Modifier.padding(vertical = 8.dp)) }

            item { DrawerItem("خانه", Icons.Rounded.Home, AppScreen.HOME, currentScreen, onNavigate) }
            item { DrawerItem("پروفایل‌ها و تولدها", Icons.Rounded.Person, AppScreen.PROFILES, currentScreen, onNavigate) }
            item { DrawerItem("تقویم و مناسبت‌ها", Icons.Rounded.CalendarMonth, AppScreen.CALENDAR, currentScreen, onNavigate) }
            item { DrawerItem("مناسبت‌های شخصی", Icons.Rounded.Event, AppScreen.PERSONAL_EVENTS, currentScreen, onNavigate) }
            item { DrawerItem("ابزارهای حرفه‌ای", Icons.Rounded.Tune, AppScreen.PRO_TOOLS, currentScreen, onNavigate) }
            item { DrawerItem("علاقه‌مندی‌ها", Icons.Rounded.Favorite, AppScreen.FAVORITES, currentScreen, onNavigate) }
            item { DrawerItem("پشتیبان و همگام‌سازی", Icons.Rounded.Backup, AppScreen.BACKUP, currentScreen, onNavigate) }
            item { DrawerItem("تنظیمات", Icons.Rounded.Settings, AppScreen.SETTINGS, currentScreen, onNavigate) }

            item { HorizontalDivider(Modifier.padding(vertical = 8.dp)) }
            item {
                NavigationDrawerItem(
                    label = { Text("معرفی به دوستان") },
                    selected = false,
                    onClick = onShare,
                    icon = { Icon(Icons.Rounded.Share, null) },
                )
            }
            item { DrawerItem("درباره ما", Icons.Rounded.SupervisorAccount, AppScreen.ABOUT_US, currentScreen, onNavigate) }
            item { DrawerItem("تماس با ما", Icons.Rounded.ContactMail, AppScreen.CONTACT_US, currentScreen, onNavigate) }
            item { DrawerItem("درباره نرم افزار", Icons.Rounded.Info, AppScreen.ABOUT_APP, currentScreen, onNavigate) }
            item {
                HorizontalDivider(Modifier.padding(top = 14.dp, bottom = 10.dp))
                Text(
                    "گروه توسعه فناوری و نرم افزاری as Team",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                )
                Text("AS.Support.info@Gmail.com", modifier = Modifier.padding(horizontal = 8.dp), color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}

@Composable
private fun DrawerItem(
    label: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    target: AppScreen,
    current: AppScreen,
    onNavigate: (AppScreen) -> Unit,
) {
    NavigationDrawerItem(
        label = { Text(label) },
        selected = current == target,
        onClick = { onNavigate(target) },
        icon = { Icon(icon, null) },
    )
}
