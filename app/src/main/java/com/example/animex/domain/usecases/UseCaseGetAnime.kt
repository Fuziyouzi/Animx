package com.example.animex.domain.usecases

import com.example.animex.data.base.ErrorSource
import com.example.animex.domain.AnimeRepository
import com.example.animex.domain.base.HandleErrorSource
import com.example.animex.domain.base.Output
import com.example.animex.domain.models.Anime
import javax.inject.Inject

class UseCaseGetAnime @Inject constructor(
    private val anime: AnimeRepository,
    private val handleError: HandleErrorSource
) {

    suspend fun getAnime(): Output<Anime, String> {
        return try {
            Output.Success(anime.getAnime())
        }catch (e: ErrorSource){
            handleError.handle(e)
        }
    }



}