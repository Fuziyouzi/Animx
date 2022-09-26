package com.example.animex.domain.usecases

import com.example.animex.domain.AccountRepository
import com.example.animex.domain.models.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCaseProfile @Inject constructor(
    private val repository: AccountRepository
) {

    fun getUser(): Flow<User?> = repository.getUser()

}