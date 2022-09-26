package com.example.animex.di

import com.example.animex.data.base.ErrorHandler
import com.example.animex.data.base.ErrorHandlerImpl
import com.example.animex.data.source.AnimeApi
import com.example.animex.data.source.RetrofitAnimeRepository
import com.example.animex.domain.AnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val URL = "https://kitsu.io"

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun providesInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun providesHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun providesAnimeApi(retrofit: Retrofit): AnimeApi = retrofit.create(AnimeApi::class.java)

    @Provides
    @Singleton
    fun providesAnimeUseCase(retrofitAnimeRepository: RetrofitAnimeRepository): AnimeRepository {
        return retrofitAnimeRepository
    }

    @Provides
    fun providesErrorHandler(): ErrorHandler = ErrorHandlerImpl()

}