# معماری تاریخ‌یار 2.0

## لایه‌ها
- `core/date`: موتور تقویم شمسی و محاسبات تاریخ
- `core/data`: مدل پروفایل، مناسبت و مخزن محلی JSON/SharedPreferences
- `core/system`: اعلان، Reminder، Update Checker، تنظیمات، Backup و ساخت کارت Share
- `core/ui`: Theme و شخصی‌سازی ظاهر
- `feature/*`: صفحات مستقل Compose
- `widget`: AppWidget تاریخ شمسی و نزدیک‌ترین تولد

## داده‌ها
برنامه به‌صورت Local-first طراحی شده است. پروفایل‌ها و رویدادها در `tarikhyar_data` و تنظیمات در `tarikhyar_settings` ذخیره می‌شوند. Backup نسخه 2 با PBKDF2-HMAC-SHA256 و AES-256-GCM رمزگذاری می‌شود.

## ناوبری
`TarikhYarApp.kt` مقصدهای صفحه را در `AppScreen` نگهداری می‌کند. Back Stack داخلی باعث می‌شود Back به صفحه قبلی برگردد و Drawer در اولویت بسته‌شدن قرار داشته باشد.

## اعلان
AlarmManager برای تولد و مناسبت‌های شخصی استفاده می‌شود. پس از Boot، Receiver زمان‌بندی‌ها را بازسازی می‌کند. اعلان Update از `version.json` GitHub به‌صورت اختیاری بررسی می‌شود.

## انتشار
CI عمومی فقط Build و تست را انجام می‌دهد و Signing Key خصوصی در GitHub قرار نمی‌گیرد. Artifact بدون امضا پس از CI می‌تواند در محیط امن با Keystore ثابت امضا شود.
