package android.dev_company.data.local

import android.content.Context
import android.content.SharedPreferences
import com.securepreferences.SecurePreferences

/**
 * Creator: Ibrohim Ergashaliyev. Date: 9/20/2020. Time: 10:02
 */

class SharedPreference private constructor(context: Context) {

    companion object {

        lateinit var instance: SharedPreference
            private set

        fun init(context: Context) {
            instance = SharedPreference(context)
        }
    }

    private val pref = SecurePreferences(context, "password", "app_name")

    var isOpenedBefore: Boolean
        set(value) = pref.edit().putBoolean("OPENED_BEFORE", value).apply()
        get() = pref.getBoolean("OPENED_BEFORE", false)

    var isOpenedIntoBefore: Boolean
        set(value) = pref.edit().putBoolean("OPENED_INTO_BEFORE", value).apply()
        get() = pref.getBoolean("OPENED_INTO_BEFORE", false)
}