package com.prueba.tecnica.features.infrastructure.repository

import com.prueba.tecnica.core.common.network.NetworkMonitor
import com.prueba.tecnica.core.database.dao.BetItemDao
import com.prueba.tecnica.core.domain.Failure
import com.prueba.tecnica.core.domain.Result
import com.prueba.tecnica.feature.domain.entities.BetListUi
import com.prueba.tecnica.feature.domain.repository.BetRepository
import com.prueba.tecnica.features.infrastructure.repository.mapper.toDomainDB
import com.prueba.tecnica.features.infrastructure.repository.mapper.toUi
import com.prueba.tecnica.features.infrastructure.repository.remote.BetDataSource
import javax.inject.Inject


class BetRepositoryImpl @Inject constructor(
    private val dataSource: BetDataSource,
    private val betItemDao: BetItemDao,
    private val networkMonitor: NetworkMonitor
) : BetRepository {


    override suspend fun getListBets(): Result<BetListUi> {
        return if (networkMonitor.isConnected()) {
            fetchFromRemoteOrLocal()
        } else {
            getFromLocal()
        }
    }

    private suspend fun fetchFromRemoteOrLocal(): Result<BetListUi> {
        return when (val result = dataSource.getListBet()) {
            is Result.Success -> {
                betItemDao.insertAll(result.data.bets.map { it.toDomainDB() })
                Result.Success(result.data)
            }

            is Result.Error -> {
                getFromLocalOrError()
            }
        }
    }
  //  fun List<BetWithMatchDB>.toUi() = map { it.toUi() }
    private suspend fun getFromLocalOrError(): Result<BetListUi> {
     //   val localData = betItemDao.getAll().map { it.toDomainUi(it) }
        val localData =  betItemDao.getAll().map { it.toUi() }
        return if (localData.isNotEmpty()) {
            Result.Success(data = BetListUi(bets = localData))
        } else {
            Result.Error(Failure.Others)
        }
    }

    private suspend fun getFromLocal(): Result<BetListUi> {
        //val localData = betItemDao.getAll().map { it.toDomainUi(it) }
        val localData =  betItemDao.getAll().map { it.toUi() }
        return Result.Success(data = BetListUi(bets = localData))
    }
}