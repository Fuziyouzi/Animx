package com.example.animex.presenter.profile.editprofile

import android.graphics.Bitmap
import androidx.lifecycle.viewModelScope
import com.example.animex.base.DispatchersI
import com.example.animex.core.MutableLiveEvent
import com.example.animex.core.publishEvent
import com.example.animex.core.share
import com.example.animex.domain.base.Output
import com.example.animex.domain.usecases.UseCaseEditProfile
import com.example.animex.presenter.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelEditProfile @Inject constructor(
   private val editProfile: UseCaseEditProfile,
   private val dispatcher: DispatchersI
): BaseViewModel() {


    private val imageEvent = MutableLiveEvent<Bitmap?>()
    val imageEv = imageEvent.share()

    fun changeImage(image: Bitmap?){
        dispatcher.launchUi(viewModelScope) {
            when (val res = editProfile.changeImage(image)){
                is Output.Success -> imageEvent.publishEvent(res.data)
                is Output.Error -> event(res.error)
            }

        }
    }
    init {
        viewModelScope.launch {
            editProfile.getUser().collect(){
                imageEvent.publishEvent(it?.image)
            }
        }
    }
    fun get(){

    }

}