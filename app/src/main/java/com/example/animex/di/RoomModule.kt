package com.example.animex.di

import android.content.Context
import androidx.room.Room
import com.example.animex.AppDatabase
import com.example.animex.core.Dispatcher
import com.example.animex.data.room.RoomUserRepositoryImpl
import com.example.animex.data.room.UserDao
import com.example.animex.domain.AccountRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext appContext: Context): AppDatabase{
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "RssBuilder"
        ).build()
    }

    @Provides
    @Singleton
    fun providesDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.getUserDao()
    }

    @Provides
    @Singleton
    fun providesUserRepository (roomUserRepositoryImpl: RoomUserRepositoryImpl): AccountRepository {
        return roomUserRepositoryImpl
    }
    @Provides
    fun prov(): Dispatcher {
        return Dispatcher()
    }
}