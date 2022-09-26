package com.example.animex.data.settings

interface ThemeSettings {

    fun isNightMode(): Boolean

    fun toggleNighMode(): Boolean

    fun toggleWhiteMode(): Boolean
}