package com.example.animex.data.base

interface ErrorHandler {

    fun getError(throwable: Throwable): ErrorSource
}