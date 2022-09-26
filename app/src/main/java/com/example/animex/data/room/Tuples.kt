package com.example.animex.data.room

import android.graphics.Bitmap

data class UserLoginTuple(
    val id: Long,
    val password: String
)
data class UserId(
    val id: Long
)
data class UpdateUserNickNameTuple(
    val id: Long,
    val nickname: String
)
data class UpdateUserEmailTuple(
    val id: Long,
    val email: String
)
data class UpdateImageUserTuple(
    val id: Long,
    val image: Bitmap?
)
data class UpdatePasswordUserTuple(
    val id: Long,
    val password: String
)
data class AddFavoriteAnimeTuple(
    val id: Long,
    val anime: ArrayList<String>
)