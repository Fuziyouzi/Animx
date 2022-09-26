package com.example.animex.domain.base

import com.example.animex.domain.base.Output
import javax.inject.Inject

interface HandleSuccess {

    fun <T> handle(res: T): Output.Success<T>
}

class Success @Inject constructor(): HandleSuccess{
    override fun <T> handle(res: T): Output.Success<T> {
        return Output.Success(res)
    }

}