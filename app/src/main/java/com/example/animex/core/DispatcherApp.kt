package com.example.animex.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

interface DispatchersI {
    fun launchUi(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit): Job
    fun launchBackground(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit): Job
}


class DispatcherApp @Inject constructor() : DispatchersI {
    override fun launchUi(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit): Job =
        scope.launch(Dispatchers.Main, block = block)

    override fun launchBackground(
        scope: CoroutineScope,
        block: suspend CoroutineScope.() -> Unit
    ): Job = scope.launch(Dispatchers.IO, block = block)
}