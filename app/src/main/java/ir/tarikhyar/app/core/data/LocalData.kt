package ir.tarikhyar.app.core.data

import android.content.Context
import ir.tarikhyar.app.core.date.PersianCalendar
import ir.tarikhyar.app.core.date.PersianDate
import org.json.JSONArray
import org.json.JSONObject
import java.util.UUID

/** مدل یک پروفایل محلی برای خود کاربر، اعضای خانواده یا دوستان است. */
data class PersonProfile(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val relation: String = "",
    val birthDate: PersianDate,
    val favorite: Boolean = false,
    val reminderEnabled: Boolean = true,
)

/** مدل مناسبت شخصی مانند سالگرد، عقد، شروع کار یا هر تاریخ دلخواه است. */
data class PersonalEvent(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val date: PersianDate,
    val category: String = "شخصی",
    val note: String = "",
    val reminderEnabled: Boolean = true,
)

/** مناسبت‌های خورشیدی ثابت که در تقویم ماهانه نمایش داده می‌شوند. */
data class OfficialEvent(
    val month: Int,
    val day: Int,
    val title: String,
    val holiday: Boolean,
)

/** فهرست مناسبت‌های ثابت خورشیدی؛ مناسبت‌های قمری متغیر عمداً در این فهرست ثابت قرار ندارند. */
object OfficialEvents {
    val items = listOf(
        OfficialEvent(1, 1, "آغاز نوروز", true),
        OfficialEvent(1, 2, "تعطیلات نوروز", true),
        OfficialEvent(1, 3, "تعطیلات نوروز", true),
        OfficialEvent(1, 4, "تعطیلات نوروز", true),
        OfficialEvent(1, 12, "روز جمهوری اسلامی", true),
        OfficialEvent(1, 13, "روز طبیعت", true),
        OfficialEvent(2, 12, "روز معلم", false),
        OfficialEvent(3, 14, "رحلت امام خمینی", true),
        OfficialEvent(3, 15, "قیام پانزده خرداد", true),
        OfficialEvent(4, 7, "روز قوه قضائیه", false),
        OfficialEvent(6, 31, "آغاز هفته دفاع مقدس", false),
        OfficialEvent(7, 13, "روز نیروی انتظامی", false),
        OfficialEvent(8, 13, "روز دانش‌آموز", false),
        OfficialEvent(9, 16, "روز دانشجو", false),
        OfficialEvent(10, 9, "روز بصیرت", false),
        OfficialEvent(11, 22, "پیروزی انقلاب اسلامی", true),
        OfficialEvent(12, 29, "روز ملی شدن صنعت نفت", true),
    )

    fun forDate(date: PersianDate): List<OfficialEvent> =
        items.filter { it.month == date.month && it.day == date.day }

    fun isHoliday(date: PersianDate): Boolean =
        forDate(date).any { it.holiday }
}

/** مخزن داده آفلاین برنامه؛ داده‌ها را با JSON در SharedPreferences نگهداری می‌کند. */
object LocalDataRepository {
    private const val PREFS = "tarikhyar_data"
    private const val KEY_PROFILES = "profiles_json"
    private const val KEY_EVENTS = "events_json"
    private const val KEY_FAVORITE_TOOLS = "favorite_tools"

    fun profiles(context: Context): List<PersonProfile> {
        val raw = prefs(context).getString(KEY_PROFILES, "[]") ?: "[]"
        return runCatching {
            val array = JSONArray(raw)
            buildList {
                for (index in 0 until array.length()) {
                    val item = array.getJSONObject(index)
                    val date = PersianDate(
                        item.optInt("year"),
                        item.optInt("month"),
                        item.optInt("day"),
                    )
                    if (PersianCalendar.isValid(date)) {
                        add(
                            PersonProfile(
                                id = item.optString("id", UUID.randomUUID().toString()),
                                name = item.optString("name", "بدون نام"),
                                relation = item.optString("relation", ""),
                                birthDate = date,
                                favorite = item.optBoolean("favorite", false),
                                reminderEnabled = item.optBoolean("reminder", true),
                            )
                        )
                    }
                }
            }
        }.getOrDefault(emptyList())
    }

    fun saveProfile(context: Context, profile: PersonProfile) {
        val updated = profiles(context).toMutableList()
        val index = updated.indexOfFirst { it.id == profile.id }
        if (index >= 0) updated[index] = profile else updated += profile
        writeProfiles(context, updated)
    }

    fun deleteProfile(context: Context, id: String) {
        writeProfiles(context, profiles(context).filterNot { it.id == id })
    }

    fun events(context: Context): List<PersonalEvent> {
        val raw = prefs(context).getString(KEY_EVENTS, "[]") ?: "[]"
        return runCatching {
            val array = JSONArray(raw)
            buildList {
                for (index in 0 until array.length()) {
                    val item = array.getJSONObject(index)
                    val date = PersianDate(item.optInt("year"), item.optInt("month"), item.optInt("day"))
                    if (PersianCalendar.isValid(date)) {
                        add(
                            PersonalEvent(
                                id = item.optString("id", UUID.randomUUID().toString()),
                                title = item.optString("title", "مناسبت"),
                                date = date,
                                category = item.optString("category", "شخصی"),
                                note = item.optString("note", ""),
                                reminderEnabled = item.optBoolean("reminder", true),
                            )
                        )
                    }
                }
            }
        }.getOrDefault(emptyList())
    }

    fun saveEvent(context: Context, event: PersonalEvent) {
        val updated = events(context).toMutableList()
        val index = updated.indexOfFirst { it.id == event.id }
        if (index >= 0) updated[index] = event else updated += event
        writeEvents(context, updated)
    }

    fun deleteEvent(context: Context, id: String) {
        writeEvents(context, events(context).filterNot { it.id == id })
    }

    fun favoriteTools(context: Context): Set<String> =
        prefs(context).getStringSet(KEY_FAVORITE_TOOLS, emptySet())?.toSet() ?: emptySet()

    fun toggleFavoriteTool(context: Context, id: String) {
        val current = favoriteTools(context).toMutableSet()
        if (!current.add(id)) current.remove(id)
        prefs(context).edit().putStringSet(KEY_FAVORITE_TOOLS, current).apply()
    }

    fun dataSnapshot(context: Context): JSONObject {
        val objectValue = JSONObject()
        objectValue.put("profiles", JSONArray(profiles(context).map(::profileToJson)))
        objectValue.put("events", JSONArray(events(context).map(::eventToJson)))
        objectValue.put("favoriteTools", JSONArray(favoriteTools(context).toList()))
        return objectValue
    }

    fun restoreSnapshot(context: Context, value: JSONObject) {
        val profilesArray = value.optJSONArray("profiles") ?: JSONArray()
        val eventsArray = value.optJSONArray("events") ?: JSONArray()
        val favoriteArray = value.optJSONArray("favoriteTools") ?: JSONArray()
        prefs(context).edit()
            .putString(KEY_PROFILES, profilesArray.toString())
            .putString(KEY_EVENTS, eventsArray.toString())
            .putStringSet(KEY_FAVORITE_TOOLS, buildSet {
                for (index in 0 until favoriteArray.length()) add(favoriteArray.optString(index))
            })
            .apply()
    }

    fun nextBirthday(context: Context, today: PersianDate): Pair<PersonProfile, Int>? {
        return profiles(context).mapNotNull { profile ->
            val month = profile.birthDate.month
            val maxDayThisYear = PersianCalendar.monthLength(today.year, month)
            val day = profile.birthDate.day.coerceAtMost(maxDayThisYear)
            var next = PersianDate(today.year, month, day)
            if (PersianCalendar.compare(next, today) < 0) {
                val nextYear = today.year + 1
                next = PersianDate(nextYear, month, profile.birthDate.day.coerceAtMost(PersianCalendar.monthLength(nextYear, month)))
            }
            val days = PersianCalendar.daysBetween(today, next).toInt()
            profile to days
        }.minByOrNull { it.second }
    }

    private fun writeProfiles(context: Context, values: List<PersonProfile>) {
        prefs(context).edit().putString(KEY_PROFILES, JSONArray(values.map(::profileToJson)).toString()).apply()
    }

    private fun writeEvents(context: Context, values: List<PersonalEvent>) {
        prefs(context).edit().putString(KEY_EVENTS, JSONArray(values.map(::eventToJson)).toString()).apply()
    }

    private fun profileToJson(profile: PersonProfile) = JSONObject().apply {
        put("id", profile.id)
        put("name", profile.name)
        put("relation", profile.relation)
        put("year", profile.birthDate.year)
        put("month", profile.birthDate.month)
        put("day", profile.birthDate.day)
        put("favorite", profile.favorite)
        put("reminder", profile.reminderEnabled)
    }

    private fun eventToJson(event: PersonalEvent) = JSONObject().apply {
        put("id", event.id)
        put("title", event.title)
        put("category", event.category)
        put("note", event.note)
        put("year", event.date.year)
        put("month", event.date.month)
        put("day", event.date.day)
        put("reminder", event.reminderEnabled)
    }

    private fun prefs(context: Context) = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
}
