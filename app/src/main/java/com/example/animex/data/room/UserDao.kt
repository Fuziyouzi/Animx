package com.example.animex.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT id, password FROM accounts WHERE email = :email")
    suspend fun findByEmail(email: String): UserLoginTuple?

    @Query("SELECT id FROM accounts WHERE email = :email")
    suspend fun findId(email: String): UserId?

    @Update(entity = UserEntity::class)
    suspend fun updateNickname(updateUserNickNameTuple: UpdateUserNickNameTuple)

    @Update(entity = UserEntity::class)
    suspend fun updateEmail(updateUserEmailTuple: UpdateUserEmailTuple)

    @Update(entity = UserEntity::class)
    suspend fun updateImage(updateImageUserTuple: UpdateImageUserTuple)

    @Update(entity = UserEntity::class)
    suspend fun updatePassword(updatePasswordUserTuple: UpdatePasswordUserTuple)

    @Insert
    suspend fun createAccount(userEntity: UserEntity)

    @Query("SELECT * FROM accounts WHERE id = :accountId")
    fun getById(accountId: Long): Flow<UserEntity?>

//    @Update(entity = UserEntity::class)
//    fun addAnimeToList(addFavoriteAnimeTuple: AddFavoriteAnimeTuple)
//
}