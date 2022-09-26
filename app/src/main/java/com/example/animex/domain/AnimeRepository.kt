package com.example.animex.domain

import com.example.animex.domain.models.Anime

interface AnimeRepository {

    suspend fun getAnime(): Anime

//    suspend fun getListAnime(): List<Anime>

}