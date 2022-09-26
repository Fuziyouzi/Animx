package com.example.animex.data.source

import com.example.animex.data.source.models.AnimeSourceModel
import retrofit2.http.GET
import retrofit2.http.Headers

interface AnimeApi {


    @Headers("Accept: application/vnd.api+json", "Content-Type: application/vnd.api+json")
    @GET("/api/edge/anime/1")
    suspend fun getAnime(): AnimeSourceModel



}

