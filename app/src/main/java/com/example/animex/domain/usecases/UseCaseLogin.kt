package com.example.animex.domain.usecases

import com.example.animex.R
import com.example.animex.domain.base.Output
import com.example.animex.core.ResourceManager
import com.example.animex.domain.AccountRepository
import com.example.animex.domain.base.HandleErrorData
import javax.inject.Inject

class UseCaseLogin @Inject constructor(
    private val repository: AccountRepository,
    private val resManager: ResourceManager,
    private val handle: HandleErrorData
) {

    suspend fun login(email: String, pass: String): Output<String, String> {
        return try {
            repository.login(email, pass)
            Output.Success(resManager.string(R.string.done))
        } catch (e: Exception) {
            handle.handle(e)
        }

    }


}