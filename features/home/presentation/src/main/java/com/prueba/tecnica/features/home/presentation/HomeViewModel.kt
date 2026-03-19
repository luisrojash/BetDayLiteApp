package com.prueba.tecnica.features.home.presentation

import android.util.Log
import com.prueba.tecnica.core.common.presentation.BaseViewModel
import com.prueba.tecnica.core.common.presentation.executeTask
import com.prueba.tecnica.core.domain.Failure
import com.prueba.tecnica.features.home.domain.entities.MatchesUi
import com.prueba.tecnica.features.home.domain.usecase.MatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.OffsetDateTime
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val matchesUseCase: MatchesUseCase,
) : BaseViewModel<HomeState, HomeIntent, HomeNavigate>() {

    override fun createInitialState() = HomeState()

    override suspend fun handleIntent(intent: HomeIntent) {}

    init {
        initService()
    }

    private fun initService() {
        // showLoadingButton()
        executeTask(
            onSuccess = ::onMatchesSuccess,
            onFailure = ::onMatchesError
        ) {
            matchesUseCase.invoke()
        }
    }


    fun onMatchesSuccess(matchUi: MatchesUi) {
        // hideLoadingButton()
        Log.i("HomeViewModel", "characterListUi : $matchUi")
        val orderedList = matchUi.listMatch.sortedByDescending {
            OffsetDateTime.parse(it.startTime)
        }
        setUiState {
            copy(
                listMatches = orderedList
            )
        }
    }

    private fun onMatchesError(failure: Failure) {
        //hideLoadingButton()
        Log.i("CharacterViewModel", "$failure")
    }

}