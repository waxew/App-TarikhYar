// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.widget

// راهنما: این import وابستگی «android.app.PendingIntent» را برای استفاده در این فایل وارد می‌کند.
import android.app.PendingIntent
// راهنما: این import وابستگی «android.appwidget.AppWidgetManager» را برای استفاده در این فایل وارد می‌کند.
import android.appwidget.AppWidgetManager
// راهنما: این import وابستگی «android.appwidget.AppWidgetProvider» را برای استفاده در این فایل وارد می‌کند.
import android.appwidget.AppWidgetProvider
// راهنما: این import وابستگی «android.content.ComponentName» را برای استفاده در این فایل وارد می‌کند.
import android.content.ComponentName
// راهنما: این import وابستگی «android.content.Context» را برای استفاده در این فایل وارد می‌کند.
import android.content.Context
// راهنما: این import وابستگی «android.content.Intent» را برای استفاده در این فایل وارد می‌کند.
import android.content.Intent
// راهنما: این import وابستگی «android.widget.RemoteViews» را برای استفاده در این فایل وارد می‌کند.
import android.widget.RemoteViews
// راهنما: این import وابستگی «ir.tarikhyar.app.MainActivity» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.MainActivity
// راهنما: این import وابستگی «ir.tarikhyar.app.R» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.R
// راهنما: این import وابستگی «ir.tarikhyar.app.core.data.LocalDataRepository» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.data.LocalDataRepository
// راهنما: این import وابستگی «ir.tarikhyar.app.core.date.PersianCalendar» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.date.PersianCalendar
// راهنما: این import وابستگی «ir.tarikhyar.app.core.format.PersianFormat» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.format.PersianFormat
// راهنما: این import وابستگی «java.time.LocalDate» را برای استفاده در این فایل وارد می‌کند.
import java.time.LocalDate

/** ویجت صفحه اصلی، تاریخ شمسی و نزدیک‌ترین تولد ذخیره‌شده را نمایش می‌دهد. */
// راهنما: این خط یک کلاس و مسئولیت مشخص آن را در معماری برنامه تعریف می‌کند.
class TarikhYarWidgetProvider : AppWidgetProvider() {
    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    override fun onUpdate(context: Context, manager: AppWidgetManager, ids: IntArray) {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ids.forEach { updateWidget(context, manager, it) }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    companion object {
        /** تمام نمونه‌های فعال ویجت را پس از تغییر داده‌های کاربر فوراً تازه می‌کند. */
        // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
        fun refreshAll(context: Context) {
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val manager = AppWidgetManager.getInstance(context)
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val component = ComponentName(context, TarikhYarWidgetProvider::class.java)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            manager.getAppWidgetIds(component).forEach { updateWidget(context, manager, it) }
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }

        // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
        fun updateWidget(context: Context, manager: AppWidgetManager, widgetId: Int) {
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val today = PersianCalendar.fromGregorian(LocalDate.now())
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val nearest = LocalDataRepository.nextBirthday(context, today)
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val views = RemoteViews(context.packageName, R.layout.widget_tarikhyar)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            views.setTextViewText(R.id.widget_date, PersianFormat.persianDate(today))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            views.setTextViewText(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                R.id.widget_birthdays,
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                nearest?.let { (profile, days) ->
                    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                    if (days == 0) "امروز تولد ${profile.name} است 🎂"
                    // راهنما: این شاخه زمانی اجرا می‌شود که شرط‌های قبلی برقرار نباشند.
                    else "${PersianFormat.number(days.toLong())} روز تا تولد ${profile.name}"
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                } ?: "برای شمارش تولد، یک پروفایل اضافه کنید",
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            )
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val intent = Intent(context, MainActivity::class.java)
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val pending = PendingIntent.getActivity(
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                context,
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                0,
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                intent,
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
            // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
            )
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            views.setOnClickPendingIntent(R.id.widget_root, pending)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            manager.updateAppWidget(widgetId, views)
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
