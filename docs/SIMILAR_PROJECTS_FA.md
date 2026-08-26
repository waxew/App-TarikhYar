# پروژه‌های مشابه و منابع الهام برای تاریخ‌یار

این فهرست برای بررسی معماری، تجربه کاربری و قابلیت‌های نسخه‌های بعدی تهیه شده است. هدف، الگوبرداری فنی و بررسی ایده‌هاست؛ کپی مستقیم سورس یا UI توصیه نمی‌شود.

## 1) jalali-datepicker-compose
Repository: https://github.com/hamooo90/jalali-datepicker-compose

یک Date Picker جلالی برای Android با Jetpack Compose است. از شخصی‌سازی رنگ، فونت، تاریخ اولیه و محدودکردن بازه انتخاب تاریخ پشتیبانی می‌کند.

کاربرد برای تاریخ‌یار: می‌تواند مرجع مناسبی برای طراحی Date Picker شمسی بهتر در نسخه‌های بعدی باشد، مخصوصاً به‌جای ورود دستی سال/ماه/روز.

## 2) PersianCalendar
Repository: https://github.com/AmirSinaRZ/PersianCalendar

یک کامپوننت تقویم فارسی برای Jetpack Compose است و امکان نمایش رویدادها، شخصی‌سازی رنگ/فونت، انتخاب تاریخ و انیمیشن را ارائه می‌کند.

کاربرد برای تاریخ‌یار: مرجع خوب برای اضافه کردن صفحه تقویم ماهانه شمسی، نمایش Event روی روزها و انتخاب تاریخ مستقیم از تقویم.

## 3) ZamanakCalendar
Repository: https://github.com/SeyyedAliTabatabaei/ZamanakCalendar

یک کتابخانه Kotlin برای Jalali، Hijri و Gregorian است که Core مستقل برای تبدیل/محاسبات و یک ماژول Compose Date Picker دارد. ساختار تفکیک Core از UI با معماری تاریخ‌یار هم‌جهت است.

کاربرد برای تاریخ‌یار: بررسی تبدیل سه تقویم، Date Arithmetic، Formatting و طراحی ماژولار برای قابلیت‌های تاریخ پیشرفته.

## 4) AgeCalculator-TrackDates
Repository: https://github.com/kotlang-dev/AgeCalculator-TrackDates

یک برنامه Offline-first برای محاسبه سن و نگهداری رویدادهای مهم زندگی است. امکاناتی مانند چند رویداد، نمایش جزئی سن، تم پویا، بروزرسانی داخل برنامه و معماری چندسکویی دارد.

کاربرد برای تاریخ‌یار: ایده مناسب برای پروفایل چند نفر، ذخیره تولد/سالگردها، Reminder، تم روشن/تیره، Room/DataStore و توسعه نسخه Desktop در آینده.

## نتیجه پیشنهادی

برای توسعه تاریخ‌یار، ترکیب ایده‌های زیر بیشترین ارزش را دارد:
- Date Picker و تقویم ماهانه قابل لمس از پروژه‌های Persian Calendar.
- جداسازی Core محاسبات از UI مشابه ZamanakCalendar.
- ذخیره چند رویداد و پروفایل، Reminder و Theme مشابه AgeCalculator-TrackDates.
- حفظ موتور فعلی تاریخ‌یار به‌عنوان منبع اصلی محاسبات و اضافه کردن قابلیت‌ها به‌صورت ماژولار، بدون وابسته کردن Core به کتابخانه‌های UI.
