package com.example.animex.domain.usecases

import android.graphics.Bitmap
import com.example.animex.R
import com.example.animex.core.ResourceManager
import com.example.animex.domain.AccountRepository
import com.example.animex.domain.base.HandleErrorData
import com.example.animex.domain.base.HandleSuccess
import com.example.animex.domain.base.Output
import com.example.animex.domain.models.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class UseCaseEditProfile @Inject constructor(
    private val repository: AccountRepository,
    private val error: HandleErrorData,
    private val success: HandleSuccess,
    private val resManager: ResourceManager
) {

    suspend fun updateUserEmail(newEmail: String, repEmail: String): Output<String, String> {
        return try {
            repository.updateUserEmail(newEmail, repEmail)
            success.handle(resManager.string(R.string.emailUpd))
        } catch (e: Exception) {
            error.handle(e)
        }
    }

    suspend fun updateNickname(newNickname: String): Output<String, String> {
        return try {
            repository.updateUserNicknameInData(newNickname)
            success.handle(resManager.string(R.string.done))
        } catch (e: Exception) {
            error.handle(e)
        }

    }

    suspend fun changePassword(
        newPassword: String,
        repeatPassword: String
    ): Output<String, String> {
        return try {
            repository.updateUserPassword(newPassword, repeatPassword)
            success.handle(resManager.string(R.string.updatepass))
        } catch (e: Exception) {
            error.handle(e)
        }
    }
    suspend fun changeImage(image:Bitmap?): Output<Bitmap?, String>{
        return try {
            repository.updateUserImage(image)
            success.handle(image)
        }catch (e: Exception){
            error.handle(e)
        }
    }

    fun getUser(): Flow<User?> = repository.getUser()


}