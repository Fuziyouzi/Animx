package com.example.animex.data.base

sealed class ErrorSource: Throwable() {

    object Network : ErrorSource()

    object NotFound : ErrorSource()

    object AccessDenied : ErrorSource()

    object ServiceUnavailable : ErrorSource()

    object Unknown : ErrorSource()

    object JsonException: ErrorSource()
}