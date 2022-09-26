package com.example.animex.di

import com.example.animex.base.DispatcherApp
import com.example.animex.base.DispatchersI
import com.example.animex.core.BaseResourceManager
import com.example.animex.core.ResourceManager
import com.example.animex.domain.base.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainSupportModule {


    @Binds
    fun providesResourceManager(baseResourceManager: BaseResourceManager): ResourceManager

    @Binds
    fun providesHandleErrorData(dataError: DataError): HandleErrorData

    @Binds
    fun providesErrorHandlerSource(sourceError: SourceError): HandleErrorSource

    @Binds
    fun providesHandleSuccessData(success: Success): HandleSuccess

    @Binds
    fun providesDispatchers(dispatcherApp: DispatcherApp): DispatchersI


}