package ir.tarikhyar.app.feature.backup

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import ir.tarikhyar.app.core.system.BackupManager
import ir.tarikhyar.app.ui.components.AppTopBar
import ir.tarikhyar.app.ui.components.PrimaryButton
import ir.tarikhyar.app.ui.components.ResultCard

/** پشتیبان‌گیری رمزگذاری‌شده و همگام‌سازی اختیاری بین دستگاه‌ها از طریق فایل. */
@Composable
fun BackupScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var password by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("برای خروجی گرفتن یا بازیابی، یک رمز حداقل چهارکاراکتری وارد کنید.") }

    val createLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.CreateDocument("application/octet-stream")
    ) { uri ->
        if (uri != null) {
            status = runCatching {
                val bytes = BackupManager.exportEncrypted(context, password)
                context.contentResolver.openOutputStream(uri)?.use { it.write(bytes) }
                    ?: error("امکان نوشتن فایل وجود ندارد.")
                "پشتیبان رمزگذاری‌شده با موفقیت ذخیره شد."
            }.getOrElse { it.message ?: "ذخیره پشتیبان ناموفق بود." }
        }
    }

    val openLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri ->
        if (uri != null) {
            status = runCatching {
                val bytes = context.contentResolver.openInputStream(uri)?.use { it.readBytes() }
                    ?: error("امکان خواندن فایل وجود ندارد.")
                BackupManager.restoreEncrypted(context, bytes, password)
                "اطلاعات با موفقیت بازیابی شد. برای اعمال همه تنظیمات، برنامه را یک بار باز و بسته کنید."
            }.getOrElse { "بازیابی انجام نشد: ${it.message ?: "رمز یا فایل نادرست است."}" }
        }
    }

    Column(modifier.fillMaxSize()) {
        AppTopBar("پشتیبان‌گیری و همگام‌سازی", onBack)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            item {
                ResultCard {
                    Text("پشتیبان رمزگذاری‌شده", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    Text(
                        "پروفایل‌ها، مناسبت‌ها، علاقه‌مندی‌ها و تنظیمات در یک فایل AES-GCM رمزگذاری می‌شوند.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("رمز پشتیبان") },
                        visualTransformation = PasswordVisualTransformation(),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    PrimaryButton("ذخیره فایل پشتیبان") {
                        if (password.length < 4) status = "رمز باید حداقل ۴ کاراکتر باشد."
                        else createLauncher.launch("TarikhYar-backup.tybk")
                    }
                    PrimaryButton("بازیابی از فایل") {
                        if (password.length < 4) status = "رمز باید حداقل ۴ کاراکتر باشد."
                        else openLauncher.launch(arrayOf("application/octet-stream", "*/*"))
                    }
                }
            }
            item {
                ResultCard {
                    Text("همگام‌سازی اختیاری بین دستگاه‌ها", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
                    Text(
                        "فایل پشتیبان را در فضای ابری دلخواه خود ذخیره کن و روی دستگاه دیگر بازیابی کن. این روش بدون ساخت حساب کاربری و بدون ارسال داده به سرور تاریخ‌یار کار می‌کند.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
            item {
                ResultCard {
                    Text("وضعیت", style = MaterialTheme.typography.titleMedium)
                    Text(status, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }
    }
}
