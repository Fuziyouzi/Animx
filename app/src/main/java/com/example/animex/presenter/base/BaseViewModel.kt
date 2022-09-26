package com.example.animex.presenter.base

import androidx.lifecycle.ViewModel
import com.example.animex.core.MutableLiveEvent
import com.example.animex.core.publishEvent
import com.example.animex.core.share
import com.example.animex.domain.base.Output

abstract class BaseViewModel : ViewModel() {

    private val liveEventError = MutableLiveEvent<String>()

    protected fun event(result: String) = liveEventError.publishEvent(result)

    fun observe() = liveEventError.share()

    protected fun handle(result: Output<String, String>) {
        when (result) {
            is Output.Success -> event(result.data)
            is Output.Error -> event(result.error)
        }
    }

}