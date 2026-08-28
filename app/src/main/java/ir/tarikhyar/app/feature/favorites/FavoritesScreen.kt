package ir.tarikhyar.app.feature.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.AppScreen
import ir.tarikhyar.app.core.data.LocalDataRepository
import ir.tarikhyar.app.core.format.PersianFormat
import ir.tarikhyar.app.feature.protools.ProfessionalToolCatalog
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.PrimaryButton
import ir.tarikhyar.app.ui.components.ResultCard

/** ابزارها و پروفایل‌هایی را که کاربر ستاره‌دار کرده یکجا نمایش می‌دهد. */
@Composable
fun FavoritesScreen(
    onBack: () -> Unit,
    onNavigate: (AppScreen) -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val tools = LocalDataRepository.favoriteTools(context)
    val profiles = LocalDataRepository.profiles(context).filter { it.favorite }

    Column(modifier.fillMaxSize()) {
        AppTopBar("علاقه‌مندی‌ها", onBack)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item {
                ResultCard {
                    Text("ابزارهای محبوب", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    if (tools.isEmpty()) Text("هنوز ابزاری ستاره‌دار نشده است.", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    tools.forEach { id ->
                        Text("⭐ ${ProfessionalToolCatalog.items[id] ?: id}", fontWeight = FontWeight.Bold)
                    }
                    if (tools.isNotEmpty()) PrimaryButton("باز کردن ابزارهای حرفه‌ای") { onNavigate(AppScreen.PRO_TOOLS) }
                }
            }
            item {
                ResultCard {
                    Text("پروفایل‌های محبوب", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    if (profiles.isEmpty()) Text("هنوز پروفایلی ستاره‌دار نشده است.", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    profiles.forEach {
                        Text("⭐ ${it.name} — ${PersianFormat.persianDate(it.birthDate)}")
                    }
                    if (profiles.isNotEmpty()) PrimaryButton("مدیریت پروفایل‌ها") { onNavigate(AppScreen.PROFILES) }
                }
            }
        }
    }
}
