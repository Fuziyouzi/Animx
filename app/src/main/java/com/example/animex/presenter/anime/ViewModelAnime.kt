package com.example.animex.presenter.anime

import androidx.lifecycle.viewModelScope
import com.example.animex.core.MutableLiveEvent
import com.example.animex.core.publishEvent
import com.example.animex.core.share
import com.example.animex.domain.base.Output
import com.example.animex.domain.models.Anime
import com.example.animex.domain.usecases.UseCaseGetAnime
import com.example.animex.presenter.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModelAnime @Inject constructor(
    private val useCase: UseCaseGetAnime
) : BaseViewModel() {

    private val _anime = MutableLiveEvent<Anime>()
    val anime = _anime.share()


    init {
        viewModelScope.launch {
            when (val res = useCase.getAnime()) {
                is Output.Success -> _anime.publishEvent(res.data)
                is Output.Error -> event(res.error)
            }
        }

    }
}