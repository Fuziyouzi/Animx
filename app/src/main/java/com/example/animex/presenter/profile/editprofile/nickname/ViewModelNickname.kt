package com.example.animex.presenter.profile.editprofile.nickname

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.animex.presenter.base.BaseViewModel
import com.example.animex.base.DispatchersI
import com.example.animex.core.share
import com.example.animex.domain.usecases.UseCaseEditProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelNickname @Inject constructor(
    private val editProfile: UseCaseEditProfile,
    private val dispatchers: DispatchersI
) : BaseViewModel() {

    private val _nick = MutableLiveData<String>()
    val nick = _nick.share()

    fun updateNickname(nickname: String) {
        dispatchers.launchUi(viewModelScope) {
            handle(editProfile.updateNickname(nickname))
        }
    }

    init {
        viewModelScope.launch {
            editProfile.getUser().collect() {
                _nick.value = it?.nickname
            }
        }
    }


}