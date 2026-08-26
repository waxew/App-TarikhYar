# معماری تاریخ‌یار

## هدف معماری نسخه 1.6

تاریخ‌یار به شکلی توسعه داده می‌شود که موتور محاسبات تاریخ از UI و سرویس‌های سیستمی مستقل بماند. این جداسازی باعث می‌شود اضافه شدن Widget، تقویم کامل، Backup، تبلیغات یا پرداخت در نسخه‌های بعدی نیازی به بازنویسی منطق اصلی تاریخ نداشته باشد.

## لایه‌ها

### App Shell
- `MainActivity.kt`: نقطه ورود Android، ساخت Notification Channel و شروع بررسی بروزرسانی.
- `TarikhYarApp.kt`: مدیریت Screenها، Back Stack، Drawer و اتصال Featureها.

### Core
- `core/date`: مدل تاریخ شمسی، تبدیل تقویم، کبیسه، اختلاف سن و داده‌های مرتبط با تولد.
- `core/format`: ارقام فارسی و قالب‌بندی تاریخ/عدد.
- `core/system`: SharedPreferences، Notification و UpdateChecker.
- `core/ui/theme`: Theme، Color، Typography و Shapeهای Material 3.

### Feature
هر قابلیت اصلی صفحه و State مخصوص خود را دارد:
- `feature/home`: داشبورد و ورود به ابزارها.
- `feature/age`: محاسبه سن.
- `feature/birthinfo`: اطلاعات تولد در تقویم‌های مختلف.
- `feature/difference`: اختلاف دو تاریخ.
- `feature/events`: رویدادها و نقاط عطف سنی.
- `feature/chinese`: محتوای فرهنگی طالع چینی.
- `feature/tools`: تبدیل و محاسبات تکمیلی تاریخ.
- `feature/settings`: تنظیم اعلان و بررسی بروزرسانی.
- `feature/notifications`: مرکز اعلان‌ها.
- `feature/about`: درباره ما، تماس با ما و درباره نرم افزار.

### UI Components
- `ui/components/CommonComponents.kt`: AppBar، ورودی تاریخ، Button، Card و Share helper.
- `ui/components/AppDrawer.kt`: منوی همبرگری راست‌چین.

## ناوبری و Back Stack

نسخه 1.6 از Back Stack داخلی در `TarikhYarApp.kt` استفاده می‌کند. هنگام Navigation، Screen فعلی قبل از تغییر ذخیره می‌شود. Back سخت‌افزاری و Back داخل AppBar از همان تاریخچه استفاده می‌کنند. اگر Drawer باز باشد، Back ابتدا Drawer را می‌بندد. در صفحه Home و تاریخچه خالی، رفتار استاندارد Android اجازه خروج از برنامه را دارد.

## جهت رابط کاربری

کل App Shell با `LayoutDirection.Rtl` اجرا می‌شود. Drawer از `Start` باز می‌شود که در RTL سمت راست نمایشگر است. متن‌ها و ترتیب گزینه‌ها برای زبان فارسی طراحی شده‌اند.

## بروزرسانی

`version.json` در Repository نسخه آخر را اعلام می‌کند. `UpdateChecker` با timeout محدود آن را می‌خواند و اگر versionCode جدیدتر باشد، در صورت فعال بودن مجوز، Notification نشان می‌دهد. آخرین versionCode اعلان‌شده ذخیره می‌شود تا اعلان نسخه واحد تکرار نشود.

## داده و حریم خصوصی

نسخه 1.6 حساب کاربری یا دیتابیس ابری ندارد. تنظیمات کوچک مانند وضعیت اعلان در SharedPreferences ذخیره می‌شوند. اینترنت فقط برای بررسی نسخه جدید استفاده می‌شود. در نسخه‌های بعدی اگر Sync یا Crash Reporting اضافه شود، باید اختیاری و با اطلاع کاربر باشد.

## توسعه آینده

قابلیت‌های Widget، تقویم کامل، مناسبت شخصی، Backup، Sync و Monetization باید در لایه‌های مستقل اضافه شوند. SDK تبلیغ یا پرداخت نباید وارد `core/date` شود و منطق محاسبات پایه باید مستقل و قابل تست باقی بماند.
