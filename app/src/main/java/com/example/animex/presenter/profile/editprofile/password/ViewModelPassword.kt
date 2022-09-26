package com.example.animex.presenter.profile.editprofile.password

import androidx.lifecycle.viewModelScope
import com.example.animex.presenter.base.BaseViewModel
import com.example.animex.base.DispatchersI
import com.example.animex.domain.usecases.UseCaseEditProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelPassword @Inject constructor(
    private val editProfile: UseCaseEditProfile,
    private val dispatchersInt: DispatchersI
) : BaseViewModel() {


    fun password(newPass: String, repeatPass: String) {
        dispatchersInt.launchUi(viewModelScope) {
            handle(editProfile.changePassword(newPass, repeatPass))
        }
    }
}