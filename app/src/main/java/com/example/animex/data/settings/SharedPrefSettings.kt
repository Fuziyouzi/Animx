package com.example.animex.data.settings

import android.content.Context
import com.example.animex.data.settings.UserLoginSettings.Companion.NO_ACCOUNT_ID

class SharedPrefSettings(
    context: Context
): UserLoginSettings{

    private val sharedPrefs = context.getSharedPreferences("setting", Context.MODE_PRIVATE)

    override fun getUserId(): Long = sharedPrefs.getLong(PREF_CURRENT_USER_ID, NO_ACCOUNT_ID)

    override fun setUserId(id: Long) {
        sharedPrefs.edit()
            .putLong(PREF_CURRENT_USER_ID, id)
            .apply()
    }

    companion object{
        private const val PREF_CURRENT_USER_ID = "currentUserId"
    }
}