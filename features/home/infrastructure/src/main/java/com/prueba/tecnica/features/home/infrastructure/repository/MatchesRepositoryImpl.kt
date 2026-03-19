package com.prueba.tecnica.features.home.infrastructure.repository

import com.prueba.tecnica.core.common.network.NetworkMonitor
import com.prueba.tecnica.core.database.dao.MatchItemDao
import com.prueba.tecnica.core.domain.Failure
import com.prueba.tecnica.core.domain.Result
import com.prueba.tecnica.features.home.domain.entities.MatchesUi
import com.prueba.tecnica.features.home.domain.repository.MatchesRepository
import com.prueba.tecnica.features.home.infrastructure.repository.mapper.toDomainDB
import com.prueba.tecnica.features.home.infrastructure.repository.mapper.toDomainUi
import com.prueba.tecnica.features.home.infrastructure.repository.remote.MatchesDataSource
import javax.inject.Inject

class MatchesRepositoryImpl @Inject constructor(
    private val dataSource: MatchesDataSource,
    private val matchItemDao: MatchItemDao,
    private val networkMonitor: NetworkMonitor
) : MatchesRepository {


    override suspend fun getListMatches(): Result<MatchesUi> {
        return if (networkMonitor.isConnected()) {
            fetchFromRemoteOrLocal()
        } else {
            getFromLocal()
        }
    }

    private suspend fun fetchFromRemoteOrLocal(): Result<MatchesUi> {
        return when (val result = dataSource.getListMatches()) {
            is Result.Success -> {
                matchItemDao.insertAll(result.data.listMatch.map { it.toDomainDB(it) })
                Result.Success(result.data)
            }

            is Result.Error -> {
                getFromLocalOrError()
            }
        }
    }

    private suspend fun getFromLocalOrError(): Result<MatchesUi> {
        val localData = matchItemDao.getAll().map { it.toDomainUi(it) }
        return if (localData.isNotEmpty()) {
            Result.Success(data = MatchesUi(listMatch = localData))
        } else {
            Result.Error(Failure.Others)
        }
    }

    private suspend fun getFromLocal(): Result<MatchesUi> {
        val localData = matchItemDao.getAll().map { it.toDomainUi(it) }
        return Result.Success(data = MatchesUi(listMatch = localData))
    }
}