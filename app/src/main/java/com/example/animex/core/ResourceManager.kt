package com.example.animex.core

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface ResourceManager {
    fun string(@StringRes id: Int): String
}

class BaseResourceManager @Inject constructor(@ApplicationContext
    private val context: Context
): ResourceManager{
    override fun string(id: Int): String  = context.getString(id)
}