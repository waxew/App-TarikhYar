package ir.tarikhyar.app.core.date

import java.time.LocalDate
import java.time.chrono.HijrahDate
import java.time.temporal.ChronoField
import kotlin.math.floorMod

object BirthInsights {
    data class CalendarInfo(
        val gregorian: LocalDate,
        val hijriYear: Int,
        val hijriMonth: Int,
        val hijriDay: Int,
        val gregorianMonthName: String,
        val hijriMonthName: String,
        val chineseAnimal: String,
        val iranianAnimal: String,
        val turkicAnimal: String,
        val westernSign: String,
    )

    data class FunProfile(
        val monthTitle: String,
        val traits: String,
        val luckyNumber: String,
        val color: String,
        val flower: String,
        val scent: String,
        val flavor: String,
        val jewel: String,
        val favoriteAnimal: String,
        val tree: String,
        val plant: String,
        val spice: String,
        val metal: String,
        val motto: String,
        val bestMatch: String,
        val challengingMatch: String,
    )

    data class Milestone(val title: String, val date: PersianDate, val note: String)

    private val gregorianMonths = listOf("ژانویه", "فوریه", "مارس", "آوریل", "مه", "ژوئن", "ژوئیه", "آگوست", "سپتامبر", "اکتبر", "نوامبر", "دسامبر")
    private val hijriMonths = listOf("محرم", "صفر", "ربیع‌الاول", "ربیع‌الثانی", "جمادی‌الاول", "جمادی‌الثانی", "رجب", "شعبان", "رمضان", "شوال", "ذی‌القعده", "ذی‌الحجه")
    private val chinese = listOf("موش", "گاو", "ببر", "خرگوش", "اژدها", "مار", "اسب", "بز", "میمون", "خروس", "سگ", "خوک")
    private val iranian = listOf("موش", "گاو", "پلنگ", "خرگوش", "نهنگ", "مار", "اسب", "گوسفند", "میمون", "مرغ", "سگ", "خوک")
    private val turkic = listOf("سیچان", "اود", "بارس", "تاوشان", "لو", "ییلان", "آت", "قویون", "می‌مون", "تاووق", "ایت", "دونگوز")

    fun calendarInfo(birth: PersianDate): CalendarInfo {
        val g = PersianCalendar.toGregorian(birth)
        val h = HijrahDate.from(g)
        val hm = h.get(ChronoField.MONTH_OF_YEAR)
        return CalendarInfo(
            gregorian = g,
            hijriYear = h.get(ChronoField.YEAR_OF_ERA),
            hijriMonth = hm,
            hijriDay = h.get(ChronoField.DAY_OF_MONTH),
            gregorianMonthName = gregorianMonths[g.monthValue - 1],
            hijriMonthName = hijriMonths[hm - 1],
            chineseAnimal = chinese[floorMod(g.year - 2020, 12)],
            iranianAnimal = iranian[floorMod(birth.year - 1399, 12)],
            turkicAnimal = turkic[floorMod(birth.year - 1399, 12)],
            westernSign = westernSign(g.monthValue, g.dayOfMonth),
        )
    }

    fun profile(birth: PersianDate): FunProfile {
        val month = birth.month.coerceIn(1, 12)
        val monthNames = listOf("فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند")
        val traits = listOf(
            "پرانرژی، آغازگر و صریح", "صبور، باثبات و اهل زیبایی", "کنجکاو، اجتماعی و سریع‌الذهن", "احساساتی، حمایتگر و خانواده‌دوست",
            "گرم، خلاق و اعتمادبه‌نفس‌دار", "منظم، دقیق و مسئولیت‌پذیر", "متعادل، خوش‌برخورد و صلح‌جو", "عمیق، مصمم و رازدار",
            "آزاداندیش، ماجراجو و رک", "هدفمند، جدی و قابل‌اتکا", "مستقل، نوآور و متفاوت", "خیال‌پرداز، همدل و لطیف"
        )
        val colors = listOf("قرمز", "سبز", "زرد", "سفید", "طلایی", "سرمه‌ای", "صورتی", "زرشکی", "بنفش", "قهوه‌ای", "آبی", "فیروزه‌ای")
        val flowers = listOf("لاله", "رز", "یاس", "نیلوفر", "آفتابگردان", "نرگس", "رز صورتی", "داوودی", "میخک", "کاملیا", "ارکیده", "بنفشه")
        val jewels = listOf("الماس", "زمرد", "عقیق", "مروارید", "یاقوت", "یاقوت کبود", "اوپال", "توپاز", "فیروزه", "گارنت", "آمتیست", "آکوامارین")
        val idx = month - 1
        val animal = chinese[floorMod(PersianCalendar.toGregorian(birth).year - 2020, 12)]
        return FunProfile(
            monthTitle = monthNames[idx], traits = traits[idx], luckyNumber = ((birth.year + birth.month + birth.day) % 9 + 1).toString(),
            color = colors[idx], flower = flowers[idx], scent = listOf("مرکبات", "گل رز", "چوب تازه", "وانیل", "دارچین", "اسطوخودوس", "یاس", "چوب صندل", "نعناع", "قهوه", "باران", "دریا")[idx],
            flavor = listOf("تند", "شیرین", "ترش", "ملایم", "کاراملی", "خنک", "شیرین‌ملایم", "تلخ", "ترش‌وشیرین", "گرم", "خنک", "میوه‌ای")[idx],
            jewel = jewels[idx], favoriteAnimal = animal,
            tree = listOf("سرو", "زیتون", "افرا", "بید", "بلوط", "کاج", "نارون", "چنار", "گردو", "سدر", "سپیدار", "بید مجنون")[idx],
            plant = listOf("رزماری", "نعناع", "ریحان", "آلوئه‌ورا", "آفتابگردان", "اسطوخودوس", "شمعدانی", "کاکتوس", "بامبو", "پوتوس", "اکالیپتوس", "بنفشه")[idx],
            spice = listOf("فلفل", "هل", "زردچوبه", "وانیل", "دارچین", "زعفران", "گل‌محمدی", "میخک", "زنجبیل", "زیره", "رازیانه", "جوز هندی")[idx],
            metal = listOf("آهن", "مس", "برنج", "نقره", "طلا", "فولاد", "مس", "تیتانیوم", "قلع", "سرب", "آلومینیوم", "نقره")[idx],
            motto = listOf("شروعش کن", "آرام و پیوسته", "همیشه چیزی برای کشف هست", "خانه نقطه قوت من است", "با نور خودت بدرخش", "جزئیات مهم‌اند", "تعادل را حفظ کن", "عمیق برو", "آزاد فکر کن", "هدف را رها نکن", "متفاوت فکر کن", "با دل ببین")[idx],
            bestMatch = monthNames[(idx + 4) % 12], challengingMatch = monthNames[(idx + 6) % 12],
        )
    }

    fun milestones(birth: PersianDate): List<Milestone> = listOf(
        Milestone("پیش‌دبستانی یک", PersianCalendar.addYears(birth, 4), "رسیدن به ۴ سالگی"),
        Milestone("پیش‌دبستانی دو", PersianCalendar.addYears(birth, 5), "رسیدن به ۵ سالگی"),
        Milestone("کلاس اول", PersianCalendar.addYears(birth, 6), "رسیدن به ۶ سالگی؛ ضوابط ثبت‌نام ممکن است تغییر کند"),
        Milestone("سن ۱۸ سال", PersianCalendar.addYears(birth, 18), "تاریخ کامل شدن ۱۸ سال"),
        Milestone("سن گواهینامه", PersianCalendar.addYears(birth, 18), "نمایش زمانی؛ شرایط قانونی صدور گواهینامه را جداگانه بررسی کنید"),
    )

    private fun westernSign(month: Int, day: Int): String = when {
        (month == 3 && day >= 21) || (month == 4 && day <= 19) -> "حَمَل / Aries"
        (month == 4) || (month == 5 && day <= 20) -> "ثور / Taurus"
        (month == 5) || (month == 6 && day <= 20) -> "جوزا / Gemini"
        (month == 6) || (month == 7 && day <= 22) -> "سرطان / Cancer"
        (month == 7) || (month == 8 && day <= 22) -> "اسد / Leo"
        (month == 8) || (month == 9 && day <= 22) -> "سنبله / Virgo"
        (month == 9) || (month == 10 && day <= 22) -> "میزان / Libra"
        (month == 10) || (month == 11 && day <= 21) -> "عقرب / Scorpio"
        (month == 11) || (month == 12 && day <= 21) -> "قوس / Sagittarius"
        (month == 12) || (month == 1 && day <= 19) -> "جدی / Capricorn"
        (month == 1) || (month == 2 && day <= 18) -> "دلو / Aquarius"
        else -> "حوت / Pisces"
    }
}
