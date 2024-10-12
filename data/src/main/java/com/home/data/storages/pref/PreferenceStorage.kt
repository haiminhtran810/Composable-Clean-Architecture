package com.home.data.storages.pref

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Build
import androidx.core.content.edit
import com.google.gson.Gson
import timber.log.Timber
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

const val PREFS_NAME = "NHOC_TAX"
const val PREFS_ACCESS_TOKEN = "PREFS_ACCESS_TOKEN"
const val PREFS_REFRESH_TOKEN = "PREFS_REFRESH_TOKEN"

interface PreferenceStorage {
    var accessToken: String?
    var refreshToken: String?
}

class SharePreferenceStorage constructor(context: Context, gson: Gson) : PreferenceStorage {
    private val pref: Lazy<SharedPreferences> = lazy {
        (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.createDeviceProtectedStorageContext()
        } else {
            context.applicationContext
        }).getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).apply {
            registerOnSharedPreferenceChangeListener(changeLister)
        }
    }

    private val changeLister = OnSharedPreferenceChangeListener { _, key ->
        Timber.d("SharePreferenceStorage - OnSharedPreferenceChangeListener: $key")
    }

    override var accessToken: String? by StringPreference(pref, PREFS_ACCESS_TOKEN, null)
    override var refreshToken: String? by StringPreference(pref, PREFS_REFRESH_TOKEN, null)

}

class StringPreference(
    private val preferences: Lazy<SharedPreferences>,
    private val name: String,
    private val defaultValue: String?
) : ReadWriteProperty<Any, String?> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String? {
        return preferences.value.getString(name, defaultValue)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String?) {
        preferences.value.edit {
            putString(name, value)
        }
    }
}