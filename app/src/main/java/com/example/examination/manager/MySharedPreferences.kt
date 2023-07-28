package com.example.examination.manager

import android.content.Context
import android.content.SharedPreferences
import com.example.examination.util.Constants.EMAIL
import com.example.examination.util.Constants.PASS
import com.example.examination.util.Constants.PREFS_NAME

class MySharedPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveData(email: String, pass: String) {
        val edit = sharedPreferences.edit()
        edit.putString(EMAIL, email)
        edit.putString(PASS, pass)
        edit.apply()
    }

    fun getData(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun clear() {
        val edit = sharedPreferences.edit()
        edit.clear()
        edit.apply()
    }
}