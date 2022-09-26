package com.example.animex.presenter.home

import com.example.animex.core.MutableLiveEvent
import com.example.animex.core.share
import com.example.animex.domain.models.Anime
import com.example.animex.domain.usecases.UseCaseGetAnime
import com.example.animex.presenter.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelHome @Inject constructor(
    private val getList: UseCaseGetAnime
): BaseViewModel() {

    private val _anime = MutableLiveEvent<List<Anime>>()
    val anime = _anime.share()






}