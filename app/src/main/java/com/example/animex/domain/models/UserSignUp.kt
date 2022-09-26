package com.example.animex.domain.models

import com.example.animex.base.checkEmail
import com.example.animex.base.checkPass
import com.example.animex.base.empty

data class UserSignUp(
    val nickname: String,
    val email: String,
    val password: String,
    val repeatPassword: String
) {
    fun validate(): Boolean{
        nickname.empty()
        email.checkEmail()
        password.checkPass(repeatPassword)
        return true
    }
}