package com.example.animex.data.source

import com.example.animex.core.Dispatcher
import com.example.animex.data.base.ErrorHandler
import com.example.animex.domain.AnimeRepository
import com.example.animex.domain.models.Anime
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RetrofitAnimeRepository @Inject constructor(
    private val api: AnimeApi,
    private val handler: ErrorHandler,
    private val dispatcher: Dispatcher
) : AnimeRepository {


    override suspend fun getAnime(): Anime = withContext(dispatcher.io) {
        try {
            return@withContext api.getAnime().data.to()
        } catch (e: Throwable) {
            throw handler.getError(e)
        }
    }

    }