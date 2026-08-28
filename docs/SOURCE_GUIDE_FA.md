# راهنمای سورس تاریخ‌یار 2.0

این سند مکمل کامنت‌های داخل سورس است و مسئولیت فایل‌های مهم نسخه 2.0 را توضیح می‌دهد.

## قانون کامنت‌گذاری AS Team
- فایل‌های Kotlin و Kotlin Script باید توضیح مسئولیت و راهنمای منطق داشته باشند.
- `tools/apply_source_comments.py` استاندارد آموزشی خط‌به‌خط را به‌صورت idempotent روی `.kt` و `.kts` اعمال می‌کند.
- CI نسخه 2.0 همین اسکریپت را قبل از Unit Test و Build اجرا می‌کند؛ بنابراین سورس کامنت‌گذاری‌شده نیز قابل Build کنترل می‌شود.
- JSON و XML در محل‌هایی که استاندارد فایل Comment را محدود می‌کند بدون Comment مخرب نگهداری می‌شوند و توضیحشان در مستندات قرار می‌گیرد.

## ریشه پروژه
- `VERSION.txt`: نسخه رسمی پروژه.
- `version.json`: متادیتای Update Checker.
- `README.md`: معرفی نسخه و امکانات.
- `info.txt`: اطلاعات فنی عمومی پروژه؛ اطلاعات خصوصی Signing فقط در بسته خصوصی مالک قرار می‌گیرد.
- `.github/workflows/build.yml`: اعمال کامنت‌ها، Unit Test، Release Build و Artifact بدون امضا.
- `tools/apply_source_comments.py`: استاندارد کامنت‌گذاری AS Team.

## ماژول Android
- `app/build.gradle.kts`: SDK، Application ID، versionCode/versionName و Dependencyها.
- `AndroidManifest.xml`: Permissionها، Activity، Receiverها، FileProvider و AppWidget.
- `MainActivity.kt`: راه‌اندازی Channel اعلان، Reminderها، Update Checker و Theme.
- `TarikhYarApp.kt`: Drawer، Bottom Navigation، مقصدها و Back Stack واقعی.

## هسته تاریخ و داده
- `core/date/PersianCalendar.kt`: محاسبات و تبدیل تقویم شمسی.
- `core/date/DateCalculations.kt`: سن و اختلاف تاریخ.
- `core/date/BirthInsights.kt`: اطلاعات تولد و داده‌های فرهنگی/سرگرمی.
- `core/data/LocalData.kt`: پروفایل‌ها، مناسبت‌های شخصی، Favorites و مناسبت‌های ثابت خورشیدی.
- `core/format/PersianFormat.kt`: نمایش اعداد و تاریخ فارسی.

## سرویس‌های سیستم
- `core/system/AppServices.kt`: اعلان و بررسی نسخه جدید.
- `core/system/UserSettings.kt`: تم، رنگ، اندازه متن، قالب کارت و تنظیمات اعلان.
- `core/system/ReminderScheduler.kt`: Alarmهای تولد، مناسبت و رویدادهای سنی و بازسازی پس از Boot.
- `core/system/BackupManager.kt`: Backup رمزگذاری‌شده با PBKDF2 + AES-256-GCM.
- `core/system/ShareCardRenderer.kt`: ساخت کارت PNG برای Share.

## قابلیت‌های رابط
- `feature/home`: داشبورد و میانبرهای اصلی.
- `feature/age`: محاسبه سن و کارت خروجی.
- `feature/birthinfo`: اطلاعات تولد شمسی/میلادی/قمری.
- `feature/calendar`: تقویم ماهانه، تعطیلات ثابت و رویدادها.
- `feature/profiles`: چند پروفایل خانواده/دوستان.
- `feature/personalevents`: CRUD و جست‌وجوی مناسبت‌های شخصی.
- `feature/protools`: روز کاری، Date Math، سن در تاریخ دلخواه، مقایسه و Countdown.
- `feature/favorites`: ابزارها و پروفایل‌های منتخب.
- `feature/backup`: خروجی/بازیابی Backup و انتقال اختیاری بین دستگاه‌ها.
- `feature/settings`: ظاهر، اعلان‌ها، کارت‌ها و Update Checker.
- `feature/chinese` و `feature/events`: طالع چینی و رویدادهای سنی.
- `ui/components/PersianDatePicker.kt`: انتخاب تاریخ شمسی بدون تایپ.
- `ui/components/AppDrawer.kt`: منوی همبرگری جدید، پروفایل و تصویر کاربر.
- `widget/TarikhYarWidgetProvider.kt`: ویجت تاریخ امروز و نزدیک‌ترین تولد.

## Resourceها
- `res/layout/widget_tarikhyar.xml`: Layout ویجت.
- `res/xml/tarikhyar_widget_info.xml`: مشخصات AppWidget.
- `res/xml/file_paths.xml`: مسیر امن Share کارت تصویری.
- `res/drawable/ic_launcher.xml`: آیکن برنامه.

## Signing
Repository عمومی هیچ JKS یا Password خصوصی ندارد. بسته خصوصی کامل تحویلی به مالک پروژه شامل `private-signing/TarikhYar-release.jks` و راهنمای رمزهاست. این بخش نباید دوباره به GitHub عمومی Commit شود.
