package app.compassites.com.healthosapp

import android.app.Activity
import android.content.Context

/**
 * Created by shruthi on 31/8/18.
 */
class DataManager(context: Context?) {

    init {
        sharedPrefsHelper = SharedPrefsHelpers(context!!.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE))
    }

    companion object {
        var dataMangager: DataManager? = null
        var sharedPrefsHelper: SharedPrefsHelpers? = null

        fun getDataManager(context: Context?): DataManager {
            if (dataMangager == null)
                dataMangager = DataManager(context)
            return dataMangager as DataManager
        }
    }

    fun putValue(key: String, value: Any) {
        if (value is String) {
            sharedPrefsHelper?.put(key, value)
        } else if (value is Boolean) {
            sharedPrefsHelper?.put(key, value)
        } else if (value is Int) {
            sharedPrefsHelper?.put(key, value)
        } else if (value is Long) {
            sharedPrefsHelper?.put(key, value)
        } else if (value is Float) {
            sharedPrefsHelper?.put(key, value)
        }
    }

    fun getString(key: String): String? {
        return sharedPrefsHelper?.get(key, "")
    }

    fun getFloat(key: String): Float? {
        return sharedPrefsHelper?.get(key, 0f)
    }

    fun getBoolean(key: String): Boolean? {
        return sharedPrefsHelper?.get(key, false)
    }

    fun getInt(key: String): Int? {
        return sharedPrefsHelper?.get(key, 0)
    }

    fun setString(key: String): String? {
        return sharedPrefsHelper?.get(key, "")
    }

    fun setFloat(key: String): Float? {
        return sharedPrefsHelper?.get(key, 0f)
    }

    fun setBoolean(key: String): Boolean? {
        return sharedPrefsHelper?.get(key, false)
    }

    fun setInt(key: String): Int? {
        return sharedPrefsHelper?.get(key, 0)
    }

    fun clear() {
        sharedPrefsHelper?.deleteAllSavedData()
    }

    fun deleteData(key: String) {
        sharedPrefsHelper?.deleteSavedData(key)
    }
}
