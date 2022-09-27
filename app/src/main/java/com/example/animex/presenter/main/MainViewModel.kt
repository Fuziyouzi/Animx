package com.example.animex.presenter.main

import androidx.lifecycle.viewModelScope
import com.example.animex.domain.AccountRepository
import com.example.animex.presenter.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AccountRepository,
): BaseViewModel() {

    init {
        viewModelScope.launch {
            state(repository.isSignedIn())
        }
    }

}