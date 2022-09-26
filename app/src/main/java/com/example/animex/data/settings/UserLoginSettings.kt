package com.example.animex.data.settings

interface UserLoginSettings {

    fun getUserId(): Long

    fun setUserId(id: Long)

    companion object{
        const val NO_ACCOUNT_ID = -1L
    }
}