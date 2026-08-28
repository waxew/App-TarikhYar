package ir.tarikhyar.app.core.system

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

/** یک کارت PNG ساده از نتیجه می‌سازد تا کاربر بدون اسکرین‌شات آن را Share کند. */
object ShareCardRenderer {
    fun share(context: Context, title: String, lines: List<String>) {
        val style = UserSettings.cardTemplate(context)
        val background = when (style) {
            CardTemplate.CLASSIC -> Color.rgb(255, 246, 241)
            CardTemplate.SOFT -> Color.rgb(255, 230, 235)
            CardTemplate.DARK -> Color.rgb(39, 26, 30)
        }
        val foreground = if (style == CardTemplate.DARK) Color.WHITE else Color.rgb(55, 32, 36)
        val accent = when (UserSettings.accentStyle(context)) {
            AccentStyle.RED -> Color.rgb(226, 38, 70)
            AccentStyle.ROSE -> Color.rgb(211, 67, 121)
            AccentStyle.AMBER -> Color.rgb(236, 140, 37)
        }

        val bitmap = Bitmap.createBitmap(1080, 1080, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(background)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            textAlign = Paint.Align.CENTER
            typeface = android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, android.graphics.Typeface.BOLD)
        }
        paint.color = accent
        paint.textSize = 72f
        canvas.drawText(title, 540f, 170f, paint)
        paint.color = foreground
        paint.textSize = 48f
        var y = 290f
        lines.take(9).forEach {
            canvas.drawText(it, 540f, y, paint)
            y += 82f
        }
        paint.color = accent
        paint.textSize = 34f
        canvas.drawText("تاریخ‌یار • نسخه ${ir.tarikhyar.app.BuildConfig.VERSION_NAME}", 540f, 990f, paint)

        val dir = File(context.cacheDir, "shared_cards").apply { mkdirs() }
        val file = File(dir, "tarikhyar-card-${System.currentTimeMillis()}.png")
        FileOutputStream(file).use { bitmap.compress(Bitmap.CompressFormat.PNG, 100, it) }
        val uri = FileProvider.getUriForFile(context, "${context.packageName}.files", file)
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "image/png"
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        context.startActivity(Intent.createChooser(intent, "اشتراک کارت تاریخ‌یار"))
    }
}
