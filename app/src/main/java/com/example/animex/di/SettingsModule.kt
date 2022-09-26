package com.example.animex.di

import android.content.Context
import com.example.animex.data.settings.SharedPrefSettings
import com.example.animex.data.settings.ThemeSettings
import com.example.animex.data.settings.ThemeSettingsImpl
import com.example.animex.data.settings.UserLoginSettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class SettingsModule {

    @Provides
    @Singleton
    fun provideAppSettings(@ApplicationContext context: Context): UserLoginSettings {
        return SharedPrefSettings(context = context)
    }

    @Provides
    @Singleton
    fun provideThemeSettings(@ApplicationContext context: Context): ThemeSettings {
        return ThemeSettingsImpl(context = context)
    }
}