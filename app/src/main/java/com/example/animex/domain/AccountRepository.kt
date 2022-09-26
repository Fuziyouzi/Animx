package com.example.animex.domain

import android.graphics.Bitmap
import com.example.animex.domain.models.User
import com.example.animex.domain.models.UserSignUp
import kotlinx.coroutines.flow.Flow

interface AccountRepository {

    suspend fun login(email: String, password: String)

    suspend fun isSignedIn(): Boolean

    suspend fun signUp(signUpModel: UserSignUp)

    suspend fun logout()

    fun getUser(): Flow<User?>

    suspend fun updateUserNicknameInData(newNickname: String)

    suspend fun updateUserPassword(newPassword: String, repPass: String)

    suspend fun updateUserImage(newImage: Bitmap?)

    suspend fun updateUserEmail(newEmail: String, repeatEmail: String)

   fun userId(): Long

//   suspend fun addToFavoriteAnime(anime: String)
}