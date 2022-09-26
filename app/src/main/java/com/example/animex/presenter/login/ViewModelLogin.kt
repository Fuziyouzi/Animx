package com.example.animex.presenter.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animex.domain.base.Output
import com.example.animex.core.MutableLiveEvent
import com.example.animex.core.publishEvent
import com.example.animex.core.share
import com.example.animex.domain.usecases.UseCaseLogin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelLogin @Inject constructor(
    private val useCaseLogin: UseCaseLogin
) : ViewModel() {

    private val _toast = MutableLiveEvent<String>()
    val toast = _toast.share()

    private val _event = MutableLiveEvent<String>()
    val event = _event.share()

    fun login(email: String, password: String) = viewModelScope.launch {
       when(val res = useCaseLogin.login(email,password)){
           is Output.Success -> _event.publishEvent(res.data)
           is Output.Error ->  _toast.publishEvent(res.error)
       }
    }


}
