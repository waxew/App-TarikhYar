package ir.tarikhyar.app.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import ir.tarikhyar.app.MainActivity
import ir.tarikhyar.app.R
import ir.tarikhyar.app.core.data.LocalDataRepository
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.format.PersianFormat
import java.time.LocalDate

/** ویجت صفحه اصلی، تاریخ شمسی و نزدیک‌ترین تولد ذخیره‌شده را نمایش می‌دهد. */
class TarikhYarWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(context: Context, manager: AppWidgetManager, ids: IntArray) {
        ids.forEach { updateWidget(context, manager, it) }
    }

    companion object {
        fun updateWidget(context: Context, manager: AppWidgetManager, widgetId: Int) {
            val today = PersianCalendar.fromGregorian(LocalDate.now())
            val nearest = LocalDataRepository.nextBirthday(context, today)
            val views = RemoteViews(context.packageName, R.layout.widget_tarikhyar)
            views.setTextViewText(R.id.widget_date, PersianFormat.persianDate(today))
            views.setTextViewText(
                R.id.widget_birthdays,
                nearest?.let { (profile, days) ->
                    if (days == 0) "امروز تولد ${profile.name} است 🎂"
                    else "${PersianFormat.number(days.toLong())} روز تا تولد ${profile.name}"
                } ?: "برای شمارش تولد، یک پروفایل اضافه کنید",
            )
            val intent = Intent(context, MainActivity::class.java)
            val pending = PendingIntent.getActivity(
                context,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
            )
            views.setOnClickPendingIntent(R.id.widget_root, pending)
            manager.updateAppWidget(widgetId, views)
        }
    }
}
