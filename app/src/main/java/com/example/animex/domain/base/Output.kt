package com.example.animex.domain.base

sealed class Output<out R, out E> {

    data class Success<out T>(val data: T ): Output<T, Nothing>()

    data class Error<out S>(val error: String): Output<Nothing, S>()

}