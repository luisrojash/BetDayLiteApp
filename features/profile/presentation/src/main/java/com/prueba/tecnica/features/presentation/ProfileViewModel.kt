package com.prueba.tecnica.features.presentation

import android.util.Log
import com.prueba.tecnica.core.common.presentation.BaseViewModel
import com.prueba.tecnica.core.common.presentation.executeTask
import com.prueba.tecnica.core.common.utils.Utils
import com.prueba.tecnica.core.domain.Failure
import com.prueba.tecnica.feature.domain.entities.BetListUi
import com.prueba.tecnica.feature.domain.usecase.BetUseCase
import com.prueba.tecnica.features.home.domain.entities.MatchesUi
import com.prueba.tecnica.features.home.domain.usecase.MatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val betUseCase: BetUseCase,
    private val matchesUseCase: MatchesUseCase,
) : BaseViewModel<ProfileState, ProfileIntent, ProfileNavigate>() {

    override fun createInitialState() = ProfileState()


    override suspend fun handleIntent(intent: ProfileIntent) {
        when (intent) {
            is ProfileIntent.OnClickedCardProfile -> {
                goNavigation(
                    ProfileNavigate.NavigateDetailsBets(
                        leagueName = intent.betUi.firstTeam,
                        date = Utils.formatDate("2026-02-12T19:25:00-05:00"),
                        firstTeam = intent.betUi.firstTeam,
                        secondTeam = intent.betUi.secondTeam,
                        share = intent.betUi.oddText,
                        speak = intent.betUi.amountValue
                    )
                )
            }
        }
    }

    init {
        initService()
    }

    private fun initService() {
        // showLoadingButton()
        executeTask(
            onSuccess = ::onBetSuccess,
            onFailure = ::onMatchesError
        ) {
            betUseCase.invoke()
        }
    }

    fun onBetSuccess(betList: BetListUi) {
        // hideLoadingButton()
        initServiceMatch(betList)
    }

    private fun initServiceMatch(betList: BetListUi) {
        // showLoadingButton()
        executeTask(
            onSuccess = { response ->
                onMatchesSuccess(
                    betList = betList,
                    matchUi = response
                )
            },
            onFailure = ::onMatchesError
        ) {
            matchesUseCase.invoke()
        }
    }

    fun onMatchesSuccess(
        matchUi: MatchesUi,
        betList: BetListUi
    ) {
        // hideLoadingButton()
        Log.i("HomeViewModel", "characterListUi : $matchUi")
        val matchMap = matchUi.listMatch.associateBy { it.id }

        val result = betList.bets.map { bet ->
            val match = matchMap[bet.matchId]
            bet.copy(
                firstTeam = match?.firstTeam?.name.orEmpty(),
                secondTeam = match?.secondTeam?.name.orEmpty(),
                sportLeague = match?.firstTeam?.name ?: "",
                match = match?.let { "${match.firstTeam.name} vs ${match.secondTeam.name}" } ?: ""
            )
        }

        setUiState {
            copy(
                listBets = result
            )
        }
    }

    private fun onMatchesError(failure: Failure) {
        //hideLoadingButton()
        Log.i("CharacterViewModel", "$failure")
    }


}