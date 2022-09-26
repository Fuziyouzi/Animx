package com.example.animex.presenter.signup

import androidx.lifecycle.viewModelScope
import com.example.animex.presenter.base.BaseViewModel
import com.example.animex.base.DispatchersI
import com.example.animex.domain.base.Output
import com.example.animex.core.MutableLiveEvent
import com.example.animex.core.publishEvent
import com.example.animex.core.share
import com.example.animex.domain.models.UserSignUp
import com.example.animex.domain.usecases.UseCaseSignUp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelSignUp @Inject constructor(
    private val create: UseCaseSignUp,
    private val dispatchersInt: DispatchersI
): BaseViewModel() {


    private val _event = MutableLiveEvent<String>()
    val event = _event.share()


    fun signUp(signUpModel: UserSignUp) {
        dispatchersInt.launchUi(viewModelScope) {
            when (val res = create.createUser(signUpModel)) {
                is Output.Success -> _event.publishEvent(res.data)
                is Output.Error -> event(res.error)
            }
        }
    }
}

