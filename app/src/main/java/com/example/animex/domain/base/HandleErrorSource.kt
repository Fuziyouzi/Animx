package com.example.animex.domain.base

import com.example.animex.R
import com.example.animex.core.ResourceManager
import com.example.animex.data.base.ErrorSource
import javax.inject.Inject

interface HandleErrorSource {

    fun handle(errorSource: ErrorSource): Output.Error<String>
}

data class SourceError @Inject constructor(
    private val resourceManager: ResourceManager
): HandleErrorSource{
    override fun  handle(errorSource: ErrorSource): Output.Error<String> {
       return when(errorSource){
            is ErrorSource.Network -> Output.Error(resourceManager.string(R.string.network_error))
            is ErrorSource.NotFound -> Output.Error(resourceManager.string(R.string.http_not_fount))
            is ErrorSource.AccessDenied -> Output.Error(resourceManager.string(R.string.http_forbiden))
            is ErrorSource.ServiceUnavailable -> Output.Error(resourceManager.string(R.string.http_unvalibale))
            is ErrorSource.JsonException -> Output.Error(resourceManager.string(R.string.json_error))
            is ErrorSource.Unknown -> Output.Error(resourceManager.string(R.string.unknown_error))
        }
    }

}