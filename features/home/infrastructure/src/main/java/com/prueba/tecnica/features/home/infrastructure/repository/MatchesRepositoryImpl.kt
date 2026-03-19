package com.prueba.tecnica.features.home.infrastructure.repository

import com.prueba.tecnica.core.common.network.NetworkMonitor
import com.prueba.tecnica.core.domain.Result
import com.prueba.tecnica.features.home.domain.entities.MatchesUi
import com.prueba.tecnica.features.home.domain.repository.MatchesRepository
import com.prueba.tecnica.features.home.infrastructure.repository.remote.MatchesDataSource
import javax.inject.Inject

class MatchesRepositoryImpl @Inject constructor(
    private val dataSource: MatchesDataSource,
    // private val characterDao: CharacterDao,
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
                //characterDao.insertAll(result.data.characterList.map { it.toDomainDB() })
                Result.Success(result.data)
            }

            is Result.Error -> {
                getFromLocalOrError()
            }
        }
    }

    private suspend fun getFromLocalOrError(): Result<MatchesUi> {
       /* val localData = characterDao.getAll().map { it.toDomainUi() }
        return if (localData.isNotEmpty()) {
            Result.Success(CharacterListUi(localData))
        } else {
            Result.Error(error)
        }*/

        return Result.Success(MatchesUi(
            emptyList()
        ))

    }
    /*
        private suspend fun fetchFromRemoteOrLocal(): Result<CharacterListUi> {
            return when (val result = dataSource.getListCharacter()) {
                is Result.Success -> {
                    characterDao.insertAll(result.data.characterList.map { it.toDomainDB() })
                    Result.Success(result.data)
                }

                is Result.Error -> {
                    getFromLocalOrError(result.error)
                }
            }
        }*/

    private suspend fun getFromLocal(): Result<MatchesUi> {
        /*  val localData = characterDao.getAll().map { it.toDomainUi() }
          return Result.Success(CharacterListUi(localData))*/
        return Result.Success(MatchesUi(
            emptyList()
        ))
    }
}