package com.example.animex.presenter.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animex.core.share
import com.example.animex.domain.models.User
import com.example.animex.domain.usecases.UseCaseProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelProfile @Inject constructor(
    private val profile: UseCaseProfile
) : ViewModel() {

    private val _user = MutableLiveData<User?>()
    val user= _user.share()

    init {
        viewModelScope.launch{
            profile.getUser().collect() {
                _user.value = it
            }
        }
    }

}