package ir.tarikhyar.app.core.system

import android.content.Context
import ir.tarikhyar.app.BuildConfig
import ir.tarikhyar.app.core.data.LocalDataRepository
import org.json.JSONObject
import java.security.SecureRandom
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec

/** پشتیبان رمزگذاری‌شده برای انتقال امن داده‌های محلی بین دستگاه‌ها تولید می‌کند. */
object BackupManager {
    private const val PREFIX = "TYBK2"
    private const val ITERATIONS = 120_000

    fun exportEncrypted(context: Context, password: String): ByteArray {
        require(password.length >= 4) { "رمز پشتیبان باید حداقل ۴ کاراکتر باشد." }
        val payload = JSONObject().apply {
            put("format", 2)
            put("appVersion", BuildConfig.VERSION_NAME)
            put("data", LocalDataRepository.dataSnapshot(context))
            put("settings", settingsToJson(UserSettings.settingsSnapshot(context)))
        }.toString().toByteArray(Charsets.UTF_8)

        val salt = ByteArray(16).also { SecureRandom().nextBytes(it) }
        val iv = ByteArray(12).also { SecureRandom().nextBytes(it) }
        val key = deriveKey(password, salt)
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.ENCRYPT_MODE, key, GCMParameterSpec(128, iv))
        val encrypted = cipher.doFinal(payload)
        val encoder = Base64.getEncoder()
        return listOf(
            PREFIX,
            encoder.encodeToString(salt),
            encoder.encodeToString(iv),
            encoder.encodeToString(encrypted),
        ).joinToString("\n").toByteArray(Charsets.UTF_8)
    }

    fun restoreEncrypted(context: Context, bytes: ByteArray, password: String) {
        val parts = bytes.toString(Charsets.UTF_8).trim().split("\n")
        require(parts.size == 4 && parts[0] == PREFIX) { "فایل پشتیبان تاریخ‌یار معتبر نیست." }
        val decoder = Base64.getDecoder()
        val salt = decoder.decode(parts[1])
        val iv = decoder.decode(parts[2])
        val encrypted = decoder.decode(parts[3])
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.DECRYPT_MODE, deriveKey(password, salt), GCMParameterSpec(128, iv))
        val payload = JSONObject(cipher.doFinal(encrypted).toString(Charsets.UTF_8))
        LocalDataRepository.restoreSnapshot(context, payload.getJSONObject("data"))
        UserSettings.restoreSettings(context, jsonToSettings(payload.optJSONObject("settings") ?: JSONObject()))
        ReminderScheduler.scheduleAll(context)
    }

    private fun deriveKey(password: String, salt: ByteArray): SecretKeySpec {
        val spec = PBEKeySpec(password.toCharArray(), salt, ITERATIONS, 256)
        val encoded = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).encoded
        return SecretKeySpec(encoded, "AES")
    }

    private fun settingsToJson(values: Map<String, *>): JSONObject = JSONObject().apply {
        for ((key, value) in values) put(key, value)
    }

    private fun jsonToSettings(value: JSONObject): Map<String, Any?> = buildMap {
        val keys = value.keys()
        while (keys.hasNext()) {
            val key = keys.next()
            val item = value.get(key)
            put(key, when (item) {
                is Number -> {
                    val doubleValue = item.toDouble()
                    if (doubleValue % 1.0 == 0.0) item.toInt() else item.toFloat()
                }
                else -> item
            })
        }
    }
}
