# راهنمای سورس تاریخ‌یار

این سند مکمل کامنت‌های داخل سورس است و توضیح می‌دهد هر فایل اصلی پروژه چه مسئولیتی دارد.

## قانون کامنت‌گذاری AS Team
- هر فایل سورس باید در ابتدای فایل توضیح مسئولیت داشته باشد.
- قبل از منطق‌های مهم، Stateها، شرط‌ها، حلقه‌ها، callbackها و بخش‌های UI باید توضیح فارسی نوشته شود.
- هدف کامنت توضیح «چرا این کد وجود دارد و چه کاری انجام می‌دهد» است، نه تکرار بی‌فایده همان دستور.
- فایل `tools/apply_source_comments.py` برای نسخه 1.6 روی همه فایل‌های Kotlin/KTS اجرا می‌شود و توضیح آموزشی خط‌به‌خط اضافه می‌کند.
- JSON استاندارد اجازه Comment ندارد؛ بنابراین فایل `version.json` در README و همین سند توضیح داده شده است.

## فایل‌های ریشه
- `settings.gradle.kts`: نام پروژه و Repositoryهای Gradle را مشخص می‌کند.
- `build.gradle.kts`: نسخه Pluginهای Android/Kotlin را در سطح پروژه تعریف می‌کند.
- `gradle.properties`: تنظیمات عمومی Gradle و AndroidX.
- `version.json`: نسخه آخر قابل انتشار برای UpdateChecker.
- `.github/workflows/build.yml`: تست و Build خودکار پروژه.
- `README.md`: معرفی قابلیت‌ها، ساختار و روش انتشار.

## ماژول app
- `app/build.gradle.kts`: SDKها، versionCode/versionName، Build Typeها و Dependencyها.
- `app/proguard-rules.pro`: قوانین R8/ProGuard نسخه Release.
- `app/src/main/AndroidManifest.xml`: Permissionها، Application و MainActivity.

## هسته برنامه
- `MainActivity.kt`: نقطه ورود Android، ساخت Notification Channel، بررسی بروزرسانی و راه‌اندازی Compose.
- `TarikhYarApp.kt`: پوسته اصلی، صفحه فعلی، Back Stack، Drawer و اتصال Screenها.

### core/date
- `PersianDate.kt`: مدل ساده تاریخ شمسی.
- `PersianCalendar.kt`: تبدیل و محاسبات تقویم جلالی.
- `DateCalculations.kt`: محاسبه اختلاف سن و فاصله تاریخ‌ها.
- `BirthInsights.kt`: داده‌ها و محاسبات مرتبط با تولد و محتوای فرهنگی/سرگرمی.

### core/format
- `PersianFormat.kt`: تبدیل ارقام و قالب‌بندی نمایش تاریخ و عدد فارسی.

### core/system
- `AppServices.kt`: SharedPreferences، Notification و UpdateChecker.

### core/ui/theme
- `Color.kt`: پالت رنگی تاریخ‌یار.
- `Theme.kt`: Material 3 Theme، Typography و Shapeها.

## Featureها
- `feature/home/HomeScreen.kt`: داشبورد، منوی همبرگری و کارت‌های ورود به ابزارها.
- `feature/age/AgeScreen.kt`: ورود تاریخ تولد و نمایش محاسبات کامل سن.
- `feature/birthinfo/BirthInfoScreen.kt`: اطلاعات شمسی/میلادی/قمری تولد.
- `feature/chinese/ChineseAstrologyScreen.kt`: حیوان سال و محتوای فرهنگی چینی.
- `feature/difference/DifferenceScreen.kt`: اختلاف دو تاریخ.
- `feature/events/AgeEventsScreen.kt`: نقاط عطف و رویدادهای سنی.
- `feature/insights/InsightsScreen.kt`: اطلاعات تکمیلی و Insightهای تولد.
- `feature/tools/ToolsScreen.kt`: ابزارهای تبدیل و محاسبات تاریخ.
- `feature/settings/SettingsScreen.kt`: تنظیم اعلان و بررسی بروزرسانی.
- `feature/notifications/NotificationsScreen.kt`: مرکز اعلان‌ها.
- `feature/about/AboutScreens.kt`: درباره ما، تماس با ما و درباره نرم افزار.

## UI مشترک
- `ui/components/CommonComponents.kt`: AppBar، Cardها، DateFields، Buttonها و Share helper.
- `ui/components/AppDrawer.kt`: محتوای Drawer و گزینه‌های نوار همبرگری.

## تست‌ها و ابزار توسعه
- `app/src/test/.../PersianCalendarTest.kt`: تست‌های موتور تقویم.
- `tools/CoreSmokeTest.kt`: Smoke Test ساده برای منطق اصلی.
- `tools/apply_source_comments.py`: اعمال استاندارد توضیحات خط‌به‌خط روی Kotlin/KTS.

## فایل‌های Resource
- `res/drawable/ic_launcher.xml`: آیکن برداری برنامه.
- `res/values/strings.xml`: نام برنامه و String Resourceهای XML.
- `res/values/themes.xml`: Theme سطح Android برای حالت روشن.
- `res/values-night/themes.xml`: Theme سطح Android برای حالت شب.

## نکته امنیتی امضا
کلید خصوصی Signing و رمز آن بخشی از سورس نیستند و نباید به GitHub عمومی یا ZIP سورس اضافه شوند. برای شناسایی کلید درست، Fingerprint گواهی Release در `info.txt` بسته تحویلی ثبت می‌شود.
