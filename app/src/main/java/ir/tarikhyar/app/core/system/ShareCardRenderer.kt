// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.core.system

// راهنما: این import وابستگی «android.content.Context» را برای استفاده در این فایل وارد می‌کند.
import android.content.Context
// راهنما: این import وابستگی «android.content.Intent» را برای استفاده در این فایل وارد می‌کند.
import android.content.Intent
// راهنما: این import وابستگی «android.graphics.Bitmap» را برای استفاده در این فایل وارد می‌کند.
import android.graphics.Bitmap
// راهنما: این import وابستگی «android.graphics.Canvas» را برای استفاده در این فایل وارد می‌کند.
import android.graphics.Canvas
// راهنما: این import وابستگی «android.graphics.Color» را برای استفاده در این فایل وارد می‌کند.
import android.graphics.Color
// راهنما: این import وابستگی «android.graphics.Paint» را برای استفاده در این فایل وارد می‌کند.
import android.graphics.Paint
// راهنما: این import وابستگی «androidx.core.content.FileProvider» را برای استفاده در این فایل وارد می‌کند.
import androidx.core.content.FileProvider
// راهنما: این import وابستگی «java.io.File» را برای استفاده در این فایل وارد می‌کند.
import java.io.File
// راهنما: این import وابستگی «java.io.FileOutputStream» را برای استفاده در این فایل وارد می‌کند.
import java.io.FileOutputStream

/** یک کارت PNG ساده از نتیجه می‌سازد تا کاربر بدون اسکرین‌شات آن را Share کند. */
// راهنما: این object یک نمونه Singleton برای سرویس یا داده مشترک برنامه ایجاد می‌کند.
object ShareCardRenderer {
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun share(context: Context, title: String, lines: List<String>) {
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val style = UserSettings.cardTemplate(context)
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val background = when (style) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            CardTemplate.CLASSIC -> Color.rgb(255, 246, 241)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            CardTemplate.SOFT -> Color.rgb(255, 230, 235)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            CardTemplate.DARK -> Color.rgb(39, 26, 30)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val foreground = if (style == CardTemplate.DARK) Color.WHITE else Color.rgb(55, 32, 36)
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val accent = when (UserSettings.accentStyle(context)) {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            AccentStyle.RED -> Color.rgb(226, 38, 70)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            AccentStyle.ROSE -> Color.rgb(211, 67, 121)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            AccentStyle.AMBER -> Color.rgb(236, 140, 37)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val bitmap = Bitmap.createBitmap(1080, 1080, Bitmap.Config.ARGB_8888)
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val canvas = Canvas(bitmap)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        canvas.drawColor(background)
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            textAlign = Paint.Align.CENTER
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            typeface = android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, android.graphics.Typeface.BOLD)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        paint.color = accent
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        paint.textSize = 72f
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        canvas.drawText(title, 540f, 170f, paint)
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        paint.color = foreground
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        paint.textSize = 48f
        // راهنما: این var یک مقدار قابل تغییر را نگهداری می‌کند که در ادامه منطق به‌روزرسانی می‌شود.
        var y = 290f
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        lines.take(9).forEach {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            canvas.drawText(it, 540f, y, paint)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            y += 82f
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        paint.color = accent
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        paint.textSize = 34f
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        canvas.drawText("تاریخ‌یار • نسخه ${ir.tarikhyar.app.BuildConfig.VERSION_NAME}", 540f, 990f, paint)

        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val dir = File(context.cacheDir, "shared_cards").apply { mkdirs() }
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val file = File(dir, "tarikhyar-card-${System.currentTimeMillis()}.png")
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        FileOutputStream(file).use { bitmap.compress(Bitmap.CompressFormat.PNG, 100, it) }
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val uri = FileProvider.getUriForFile(context, "${context.packageName}.files", file)
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val intent = Intent(Intent.ACTION_SEND).apply {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            type = "image/png"
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            putExtra(Intent.EXTRA_STREAM, uri)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        context.startActivity(Intent.createChooser(intent, "اشتراک کارت تاریخ‌یار"))
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
