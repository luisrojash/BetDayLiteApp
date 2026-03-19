package com.prueba.tecnica.features.infrastructure.di

import com.prueba.tecnica.feature.domain.repository.BetRepository
import com.prueba.tecnica.features.infrastructure.repository.BetRepositoryImpl
import com.prueba.tecnica.features.infrastructure.repository.BetService
import com.prueba.tecnica.features.infrastructure.repository.remote.BetDataSource
import com.prueba.tecnica.features.infrastructure.repository.remote.BetDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton




@Module
@InstallIn(SingletonComponent::class)
class BetModule {
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): BetService =
        retrofit.create(BetService::class.java)
}
@Module
@InstallIn(SingletonComponent::class)
abstract class BetDataBinds {

    @Binds
    abstract fun bindBetDataSource(datasourceImpl: BetDataSourceImpl): BetDataSource

    @Binds
    abstract fun bindBetRepository(datasourceImpl: BetRepositoryImpl): BetRepository
}