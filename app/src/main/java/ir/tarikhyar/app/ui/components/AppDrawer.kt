// این فایل محتوای منوی همبرگری تاریخ‌یار را نگهداری می‌کند.
package ir.tarikhyar.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ContactMail
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.SupervisorAccount
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.AppScreen

@Composable
fun AppDrawerContent(
    currentScreen: AppScreen,
    onNavigate: (AppScreen) -> Unit,
    onShare: () -> Unit,
) {
    // در RTL، ModalDrawerSheet از سمت راست نمایش داده می‌شود و عرض آن برای گوشی محدود شده است.
    ModalDrawerSheet(
        modifier = Modifier
            .fillMaxHeight()
            .width(310.dp),
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            // عنوان Drawer مشخص می‌کند این منو متعلق به کدام برنامه است.
            Text(
                text = "تاریخ‌یار",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.ExtraBold,
            )
            Text(
                text = "ابزارهای تاریخ و تولد",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )

            Spacer(Modifier.size(8.dp))
            HorizontalDivider()
            Spacer(Modifier.size(4.dp))

            // گزینه تنظیمات به صفحه تنظیمات اختصاصی تاریخ‌یار می‌رود.
            NavigationDrawerItem(
                label = { Text("تنظیمات") },
                selected = currentScreen == AppScreen.SETTINGS,
                onClick = { onNavigate(AppScreen.SETTINGS) },
                icon = { Icon(Icons.Rounded.Settings, contentDescription = null) },
            )

            // معرفی به دوستان Share Sheet استاندارد اندروید را باز می‌کند.
            NavigationDrawerItem(
                label = { Text("معرفی به دوستان") },
                selected = false,
                onClick = onShare,
                icon = { Icon(Icons.Rounded.Share, contentDescription = null) },
            )

            // درباره ما اطلاعات گروه توسعه‌دهنده را نمایش می‌دهد.
            NavigationDrawerItem(
                label = { Text("درباره ما") },
                selected = currentScreen == AppScreen.ABOUT_US,
                onClick = { onNavigate(AppScreen.ABOUT_US) },
                icon = { Icon(Icons.Rounded.SupervisorAccount, contentDescription = null) },
            )

            // تماس با ما ایمیل پشتیبانی را در یک صفحه مستقل نمایش می‌دهد.
            NavigationDrawerItem(
                label = { Text("تماس با ما") },
                selected = currentScreen == AppScreen.CONTACT_US,
                onClick = { onNavigate(AppScreen.CONTACT_US) },
                icon = { Icon(Icons.Rounded.ContactMail, contentDescription = null) },
            )

            // درباره نرم افزار فقط توضیح کوتاه برنامه و نسخه را نشان می‌دهد؛ اطلاعات فنی بسته نمایش داده نمی‌شود.
            NavigationDrawerItem(
                label = { Text("درباره نرم افزار") },
                selected = currentScreen == AppScreen.ABOUT_APP,
                onClick = { onNavigate(AppScreen.ABOUT_APP) },
                icon = { Icon(Icons.Rounded.Info, contentDescription = null) },
            )
        }
    }
}
