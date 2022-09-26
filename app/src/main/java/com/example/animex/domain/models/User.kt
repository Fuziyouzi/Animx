package com.example.animex.domain.models

import android.graphics.Bitmap

data class User(
    val id: Long,
    val nickname: String,
    val email: String,
    val image: Bitmap?
)