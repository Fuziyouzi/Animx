package com.example.animex.data.room

import android.graphics.Bitmap
import com.example.animex.core.*
import com.example.animex.data.settings.UserLoginSettings
import com.example.animex.domain.AccountRepository
import com.example.animex.domain.models.User
import com.example.animex.domain.models.UserSignUp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RoomUserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val settings: UserLoginSettings,
    private val dispatcher: Dispatcher
) : AccountRepository {

    override suspend fun login(email: String, password: String) = withContext(dispatcher.io) {
        email.checkEmail()
        password.empty()
        delay(2000)
        val id = findUserIdByEmailAndPassword(email, password)
        settings.setUserId(id)

    }

    override suspend fun isSignedIn(): Boolean = withContext(dispatcher.io){
        delay(1000)
        return@withContext settings.getUserId() != UserLoginSettings.NO_ACCOUNT_ID
    }

    override suspend fun signUp(signUpModel: UserSignUp) = withContext(dispatcher.io) {
        signUpModel.validate()
        delay(1000)
        createAccount(signUpModel)
    }

    private suspend fun createAccount(signUpModel: UserSignUp) {
        val entity = UserEntity.fromLoginData(signUpModel)
        userDao.createAccount(entity)
        val userId = userDao.findId(signUpModel.email) ?: throw AccountAlreadyExistsException()
        settings.setUserId(userId.id)
    }

    private suspend fun findUserIdByEmailAndPassword(email: String, password: String): Long {
        val tuple = userDao.findByEmail(email) ?: throw AccountNotExistException()
        if (tuple.password != password) throw AuthException()
        return tuple.id
    }

    private fun getAccountById(accountId: Long): Flow<User?> {
        return userDao.getById(accountId).map { it?.toAccount() }
    }

    override suspend fun logout() = withContext(dispatcher.io) {
        settings.setUserId(UserLoginSettings.NO_ACCOUNT_ID)
    }

    override fun getUser(): Flow<User?> {
        return getAccountById(userId())
    }


    override suspend fun updateUserNicknameInData(newNickname: String) =
        withContext(dispatcher.io) {
            newNickname.empty()
            userDao.updateNickname(
                UpdateUserNickNameTuple(userId(), newNickname)
            )
        }

    override suspend fun updateUserPassword(newPassword: String, repPass: String) =
        withContext(dispatcher.io) {
            newPassword.checkPass(repPass)
            userDao.updatePassword(
                UpdatePasswordUserTuple(userId(), newPassword)
            )
        }

    override suspend fun updateUserImage( newImage: Bitmap?) {
        userDao.updateImage(
            UpdateImageUserTuple(userId(), newImage)
        )
    }

    override suspend fun updateUserEmail(newEmail: String, repeatEmail: String) =
        withContext(dispatcher.io) {
            newEmail.checkEmails(repeatEmail)
            userDao.updateEmail(
                UpdateUserEmailTuple(userId(), newEmail)
            )
        }

    override fun userId(): Long {
        if (settings.getUserId() == UserLoginSettings.NO_ACCOUNT_ID) throw StorageException()
        return settings.getUserId()
    }

//    override suspend fun addToFavoriteAnime(anime: String) = withContext(dispatcher.io) {
//        userDao.addAnimeToList(
//            AddFavoriteAnimeTuple(userId(),)
//        )
//    }


}