package com.example.animex.presenter.profile.editprofile.email

import androidx.lifecycle.viewModelScope
import com.example.animex.presenter.base.BaseViewModel
import com.example.animex.base.DispatchersI
import com.example.animex.domain.usecases.UseCaseEditProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ViewModelEmail @Inject constructor(
    private val editProfile: UseCaseEditProfile,
    private val dispatcher: DispatchersI
) : BaseViewModel() {

    fun changeEmail(emailT: String, repeatEmail: String) {
        dispatcher.launchUi(viewModelScope) {
            handle(editProfile.updateUserEmail(emailT, repeatEmail))
        }
    }
}