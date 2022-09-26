package com.example.animex.data.settings

import android.content.Context
import javax.inject.Inject

private const val STORE_NAME = "theme_data_store"

class ThemeSettingsImpl @Inject constructor(
    context: Context
): ThemeSettings {

    private val sharedPrefTheme = context.getSharedPreferences(STORE_NAME, Context.MODE_PRIVATE)

    override fun isNightMode(): Boolean = sharedPrefTheme.getBoolean("theme", false)

    override fun toggleNighMode(): Boolean {
      sharedPrefTheme.edit()
          .putBoolean("theme", true)
          .apply()
        return true
    }

    override fun toggleWhiteMode(): Boolean {
        sharedPrefTheme.edit()
            .putBoolean("theme", false)
            .apply()
        return false
    }


}