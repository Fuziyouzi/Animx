package com.example.animex.di

import com.example.animex.core.Dispatcher

import com.example.animex.core.ResourceManager
import com.example.animex.domain.AccountRepository
import com.example.animex.domain.base.HandleErrorData
import com.example.animex.domain.base.HandleSuccess
import com.example.animex.domain.usecases.UseCaseEditProfile
import com.example.animex.domain.usecases.UseCaseLogin
import com.example.animex.domain.usecases.UseCaseSignUp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideUserCaseEdit(
        repository: AccountRepository,
        handle: HandleErrorData,
        handleSuccess: HandleSuccess,
        resourceManager: ResourceManager
    ): UseCaseEditProfile {
        return UseCaseEditProfile(repository, handle,handleSuccess, resourceManager )
    }

    @Provides
    fun providesUseCaseSignUp(
        repository: AccountRepository,
        handle: HandleErrorData,
        resourceManager: ResourceManager
    ): UseCaseSignUp {
        return UseCaseSignUp(repository, handle, resourceManager)
    }

    @Provides
    fun providesUseCaseLogin(
        repository: AccountRepository,
        handle: HandleErrorData,
        resourceManager: ResourceManager
    ): UseCaseLogin {
        return UseCaseLogin(repository, resourceManager, handle)
    }

    @Provides
    fun prov(): Dispatcher {
        return Dispatcher()
    }


}
