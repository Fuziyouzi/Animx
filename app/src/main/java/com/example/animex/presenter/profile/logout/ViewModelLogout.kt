package com.example.animex.presenter.profile.logout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animex.domain.AccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelLogout @Inject constructor(
    private val repository: AccountRepository
) : ViewModel() {

    fun logout(){
        viewModelScope.launch {
            repository.logout()
        }
    }

}