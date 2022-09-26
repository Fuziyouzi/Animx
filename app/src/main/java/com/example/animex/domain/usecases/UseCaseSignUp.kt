package com.example.animex.domain.usecases

import com.example.animex.R
import com.example.animex.domain.base.Output
import com.example.animex.core.ResourceManager
import com.example.animex.domain.AccountRepository
import com.example.animex.domain.base.HandleErrorData
import com.example.animex.domain.models.UserSignUp
import javax.inject.Inject


class UseCaseSignUp @Inject constructor(
    private val repository: AccountRepository,
    private val handler: HandleErrorData,
    private val resManager: ResourceManager
) {

    suspend fun createUser(userSignUp: UserSignUp): Output<String, String> {
        return try {
            repository.signUp(userSignUp)
            Output.Success(resManager.string(R.string.account_created))
        } catch (e: Exception) {
            handler.handle(e)
        }

    }


}