// این فایل سه صفحه اطلاعاتی Drawer شامل درباره ما، تماس با ما و درباره نرم افزار را پیاده‌سازی می‌کند.
package ir.tarikhyar.app.feature.about

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.BuildConfig
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.PrimaryButton
import ir.tarikhyar.app.ui.components.ResultCard
import ir.tarikhyar.app.ui.components.shareText

@Composable
fun AboutUsScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    // Context برای Share این صفحه استفاده می‌شود.
    val context = LocalContext.current

    Column(modifier.fillMaxSize()) {
        AppTopBar("درباره ما", onBack) {
            shareText(context, "درباره تاریخ‌یار", "گروه توسعه و برنامه نویسی AS Team")
        }
        InfoList {
            Text(
                text = "گروه توسعه و برنامه نویسی AS Team",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "تمامی حقوق مربوط به این برنامه انحصاری میباشد",
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun ContactUsScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    // Context برای بازکردن برنامه ایمیل و Share مورد نیاز است.
    val context = LocalContext.current
    val supportEmail = "as.team.support@gmail.com"

    Column(modifier.fillMaxSize()) {
        AppTopBar("تماس با ما", onBack) {
            shareText(context, "پشتیبانی تاریخ‌یار", supportEmail)
        }
        InfoList {
            Text(
                text = "گروه توسعه و برنامه نویسی AS Team",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "ایمیل پشتیبانی",
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
            Text(
                text = supportEmail,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            PrimaryButton("ارسال ایمیل") {
                // ACTION_SENDTO فقط برنامه‌های ایمیل را برای آدرس پشتیبانی پیشنهاد می‌کند.
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:$supportEmail")
                    putExtra(Intent.EXTRA_SUBJECT, "پشتیبانی تاریخ‌یار")
                }
                try {
                    context.startActivity(intent)
                } catch (_: ActivityNotFoundException) {
                    // اگر برنامه ایمیل روی دستگاه نصب نباشد، صفحه بدون Crash باقی می‌ماند.
                }
            }
        }
    }
}

@Composable
fun AboutAppScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    // این صفحه طبق نیاز محصول فقط توضیح کوتاه و نسخه را نمایش می‌دهد؛ package name و versionCode عمداً نمایش داده نمی‌شوند.
    val context = LocalContext.current

    Column(modifier.fillMaxSize()) {
        AppTopBar("درباره نرم افزار", onBack) {
            shareText(context, "تاریخ‌یار", "تاریخ‌یار نسخه ${BuildConfig.VERSION_NAME}")
        }
        InfoList {
            Text(
                text = "تاریخ‌یار",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "تاریخ‌یار یک ابزار فارسی برای محاسبه سن، تبدیل و مقایسه تاریخ، اطلاعات تولد و رویدادهای سنی است. بیشتر محاسبات اصلی برنامه بدون نیاز به اینترنت انجام می‌شوند.",
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "نسخه ${BuildConfig.VERSION_NAME}",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
private fun InfoList(content: @Composable () -> Unit) {
    // LazyColumn باعث می‌شود صفحات اطلاعاتی روی نمایشگرهای کوچک نیز قابل اسکرول باشند.
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            ResultCard {
                content()
            }
        }
    }
}
