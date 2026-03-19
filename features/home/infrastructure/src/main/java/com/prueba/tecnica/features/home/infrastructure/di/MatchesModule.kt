package com.prueba.tecnica.features.home.infrastructure.di

import com.prueba.tecnica.features.home.domain.repository.MatchesRepository
import com.prueba.tecnica.features.home.infrastructure.repository.MatchesRepositoryImpl
import com.prueba.tecnica.features.home.infrastructure.repository.MatchesService
import com.prueba.tecnica.features.home.infrastructure.repository.remote.MatchesDataSource
import com.prueba.tecnica.features.home.infrastructure.repository.remote.MatchesDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
class MatchesModule {
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): MatchesService =
        retrofit.create(MatchesService::class.java)
}
@Module
@InstallIn(SingletonComponent::class)
abstract class MatchesDataBinds {

    @Binds
    abstract fun bindMatchesDataSource(datasourceImpl: MatchesDataSourceImpl): MatchesDataSource

    @Binds
    abstract fun bindMatchesRepository(datasourceImpl: MatchesRepositoryImpl): MatchesRepository
}
