package app.compassites.com.healthosapp

import android.content.SharedPreferences


/**
 * Created by shruthi on 31/8/18.
 */
class SharedPrefsHelpers constructor(private val sharedPreferences: SharedPreferences) {

    fun put(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun put(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    fun put(key: String, value: Float) {
        sharedPreferences.edit().putFloat(key, value).apply()
    }

    fun put(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }


    fun put(key: String, value: Long) {
        sharedPreferences.edit().putLong(key, value).apply()
    }

    operator fun get(key: String, defaultValue: String): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    operator fun get(key: String, defaultValue: Int): Int? {
        return sharedPreferences.getInt(key, defaultValue)
    }

    operator fun get(key: String, defaultValue: Float): Float? {
        return sharedPreferences.getFloat(key, defaultValue)
    }

    operator fun get(key: String, defaultValue: Boolean): Boolean? {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun deleteSavedData(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    fun deleteAllSavedData() {
        sharedPreferences.edit().clear().apply()
    }

}
