package com.appzlogic.fatchusers.util

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder

object ModelPreferencesManager {

    lateinit var preferences: SharedPreferences
    private const val PREFERENCES_FILE_NAME = "com.appzlogic.fatchusers"

    fun with(application: Application) {
        preferences = application.getSharedPreferences(
            PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    }
    fun <T> put(`object`: T, key: String) {
        //Convert object to JSON String.
        val jsonString = GsonBuilder().create().toJson(`object`)
        //Save that String in SharedPreferences
        preferences.edit().putString(key, jsonString).apply()
    }

    inline fun <reified T> get(key: String): T? {
        //We read JSON String which was saved.
        val value = preferences.getString(key, null)
        //JSON String was found which means object can be read.
        //We convert this JSON String to model object. Parameter "c" (of
        //type Class < T >" is used to cast.
        return GsonBuilder().create().fromJson(value, T::class.java)
    }

}