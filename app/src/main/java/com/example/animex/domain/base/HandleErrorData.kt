package com.example.animex.domain.base

import com.example.animex.R
import com.example.animex.core.*
import javax.inject.Inject

interface HandleErrorData {

    fun  handle(exception: Exception): Output.Error<String>

}

data class DataError @Inject constructor(
    private val resource: ResourceManager
) : HandleErrorData {
    override fun  handle(exception: Exception): Output.Error<String> {
        return when (exception) {
            is AuthException -> Output.Error(resource.string(R.string.email_or_password_not_correct))
            is StorageException -> Output.Error(resource.string(R.string.storage_error))
            is AccountAlreadyExistsException -> Output.Error(resource.string(R.string.account_exist))
            is MinimumSizeOfPassword -> Output.Error(resource.string(R.string.size_of_password))
            is EmptyFieldException -> Output.Error(resource.string(R.string.empty_field))
            is PasswordMismatchException -> Output.Error(resource.string(R.string.mismatch_password))
            is EmailNotMatchException -> Output.Error(resource.string(R.string.Writepleseemail))
            is AccountNotExistException -> Output.Error(resource.string(R.string.account_not))

            else -> Output.Error(resource.string(R.string.unknown_exeption))
        }

    }
}