package com.example.animex.data.base

import okio.IOException
import org.json.JSONException
import retrofit2.HttpException
import java.net.HttpURLConnection

class ErrorHandlerImpl: ErrorHandler {

    override fun getError(throwable: Throwable): ErrorSource {
        when (throwable) {
            is IOException -> throw ErrorSource.Network
            is JSONException -> throw ErrorSource.JsonException
            is HttpException -> {
                when (throwable.code()) {

                    HttpURLConnection.HTTP_NOT_FOUND -> throw ErrorSource.NotFound

                    HttpURLConnection.HTTP_FORBIDDEN -> throw ErrorSource.AccessDenied

                    HttpURLConnection.HTTP_UNAVAILABLE -> throw ErrorSource.ServiceUnavailable

                    else -> throw ErrorSource.Unknown
                }
            }
            else -> throw ErrorSource.Unknown
        }
    }
}
