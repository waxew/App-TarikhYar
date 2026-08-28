// [AS-TEAM-COMMENTED-V1] توضیحات خودکار آموزشی این فایل فعال شده است.
// راهنما: این خط پکیج فایل را مشخص می‌کند تا کلاس‌ها در مسیر درست پروژه قرار بگیرند.
package ir.tarikhyar.app.core.system

// راهنما: این import وابستگی «android.content.Context» را برای استفاده در این فایل وارد می‌کند.
import android.content.Context
// راهنما: این import وابستگی «ir.tarikhyar.app.BuildConfig» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.BuildConfig
// راهنما: این import وابستگی «ir.tarikhyar.app.core.data.LocalDataRepository» را برای استفاده در این فایل وارد می‌کند.
import ir.tarikhyar.app.core.data.LocalDataRepository
// راهنما: این import وابستگی «org.json.JSONObject» را برای استفاده در این فایل وارد می‌کند.
import org.json.JSONObject
// راهنما: این import وابستگی «java.security.SecureRandom» را برای استفاده در این فایل وارد می‌کند.
import java.security.SecureRandom
// راهنما: این import وابستگی «java.util.Base64» را برای استفاده در این فایل وارد می‌کند.
import java.util.Base64
// راهنما: این import وابستگی «javax.crypto.Cipher» را برای استفاده در این فایل وارد می‌کند.
import javax.crypto.Cipher
// راهنما: این import وابستگی «javax.crypto.SecretKeyFactory» را برای استفاده در این فایل وارد می‌کند.
import javax.crypto.SecretKeyFactory
// راهنما: این import وابستگی «javax.crypto.spec.GCMParameterSpec» را برای استفاده در این فایل وارد می‌کند.
import javax.crypto.spec.GCMParameterSpec
// راهنما: این import وابستگی «javax.crypto.spec.PBEKeySpec» را برای استفاده در این فایل وارد می‌کند.
import javax.crypto.spec.PBEKeySpec
// راهنما: این import وابستگی «javax.crypto.spec.SecretKeySpec» را برای استفاده در این فایل وارد می‌کند.
import javax.crypto.spec.SecretKeySpec

/** پشتیبان رمزگذاری‌شده برای انتقال امن داده‌های محلی بین دستگاه‌ها تولید می‌کند. */
// راهنما: این object یک نمونه Singleton برای سرویس یا داده مشترک برنامه ایجاد می‌کند.
object BackupManager {
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    private const val PREFIX = "TYBK2"
    // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
    private const val ITERATIONS = 120_000

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun exportEncrypted(context: Context, password: String): ByteArray {
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        require(password.length >= 4) { "رمز پشتیبان باید حداقل ۴ کاراکتر باشد." }
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val payload = JSONObject().apply {
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            put("format", 2)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            put("appVersion", BuildConfig.VERSION_NAME)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            put("data", LocalDataRepository.dataSnapshot(context))
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            put("settings", settingsToJson(UserSettings.settingsSnapshot(context)))
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        }.toString().toByteArray(Charsets.UTF_8)

        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val salt = ByteArray(16).also { SecureRandom().nextBytes(it) }
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val iv = ByteArray(12).also { SecureRandom().nextBytes(it) }
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val key = deriveKey(password, salt)
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        cipher.init(Cipher.ENCRYPT_MODE, key, GCMParameterSpec(128, iv))
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val encrypted = cipher.doFinal(payload)
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val encoder = Base64.getEncoder()
        // راهنما: این return نتیجه تابع را برمی‌گرداند و اجرای همان تابع را پایان می‌دهد.
        return listOf(
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            PREFIX,
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            encoder.encodeToString(salt),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            encoder.encodeToString(iv),
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            encoder.encodeToString(encrypted),
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ).joinToString("\n").toByteArray(Charsets.UTF_8)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    fun restoreEncrypted(context: Context, bytes: ByteArray, password: String) {
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val parts = bytes.toString(Charsets.UTF_8).trim().split("\n")
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        require(parts.size == 4 && parts[0] == PREFIX) { "فایل پشتیبان تاریخ‌یار معتبر نیست." }
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val decoder = Base64.getDecoder()
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val salt = decoder.decode(parts[1])
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val iv = decoder.decode(parts[2])
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val encrypted = decoder.decode(parts[3])
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        cipher.init(Cipher.DECRYPT_MODE, deriveKey(password, salt), GCMParameterSpec(128, iv))
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val payload = JSONObject(cipher.doFinal(encrypted).toString(Charsets.UTF_8))
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        LocalDataRepository.restoreSnapshot(context, payload.getJSONObject("data"))
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        UserSettings.restoreSettings(context, jsonToSettings(payload.optJSONObject("settings") ?: JSONObject()))
        // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
        ReminderScheduler.scheduleAll(context)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    private fun deriveKey(password: String, salt: ByteArray): SecretKeySpec {
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val spec = PBEKeySpec(password.toCharArray(), salt, ITERATIONS, 256)
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val encoded = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).encoded
        // راهنما: این return نتیجه تابع را برمی‌گرداند و اجرای همان تابع را پایان می‌دهد.
        return SecretKeySpec(encoded, "AES")
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    private fun settingsToJson(values: Map<String, *>): JSONObject = JSONObject().apply {
        // راهنما: این حلقه مجموعه‌ای از مقادیر را پیمایش و دستورهای داخل خود را تکرار می‌کند.
        for ((key, value) in values) put(key, value)
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }

    // راهنما: این خط یک تابع را تعریف می‌کند؛ دستورات داخل بلوک وظیفه همان تابع را اجرا می‌کنند.
    private fun jsonToSettings(value: JSONObject): Map<String, Any?> = buildMap {
        // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
        val keys = value.keys()
        // راهنما: این حلقه تا زمانی که شرط برقرار باشد اجرای دستورات داخل خود را تکرار می‌کند.
        while (keys.hasNext()) {
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val key = keys.next()
            // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
            val item = value.get(key)
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            put(key, when (item) {
                // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
                is Number -> {
                    // راهنما: این val یک مقدار فقط‌خواندنی را برای استفاده در منطق جاری نگهداری می‌کند.
                    val doubleValue = item.toDouble()
                    // راهنما: این شرط بررسی می‌کند کدام مسیر منطقی باید اجرا شود.
                    if (doubleValue % 1.0 == 0.0) item.toInt() else item.toFloat()
                // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
                }
                // راهنما: این شاخه زمانی اجرا می‌شود که شرط‌های قبلی برقرار نباشند.
                else -> item
            // راهنما: این دستور بخشی از منطق، داده یا چیدمان همین بخش را پیاده‌سازی می‌کند.
            })
        // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
        }
    // راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
    }
// راهنما: این خط محدوده بلوک یا فراخوانی فعلی را باز یا بسته می‌کند.
}
