package com.prueba.tecnica.features.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.prueba.tecnica.core.common.presentation.ErrorState
import com.prueba.tecnica.core.designsystem.BaseScreen
import com.prueba.tecnica.core.designsystem.headertoolbar.HeaderToolbar
import com.prueba.tecnica.core.designsystem.theme.Primary
import com.prueba.tecnica.features.home.presentation.component.LazyTimeline
import com.prueba.tecnica.features.home.presentation.component.selector.DaySelector


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val viewModel = hiltViewModel<HomeViewModel>()
    val state = viewModel.uiState.collectAsState().value
    val errorState by viewModel.errorState.collectAsState(initial = ErrorState.None)

    LaunchedEffect(viewModel.navigation) {
        viewModel.navigation.collect {
            when (it) {
                //Solo para ejecutar Acciones
                is HomeNavigate.OnBackPressed -> {}
            }
        }
    }

    BaseScreen(progress = state.showLoadingContent, errorState = errorState, onDismiss = {
        viewModel.hideDialog()
    }, onButtonClick = { _ ->
        viewModel.hideDialog()
    })
    HomeContentScreen(
        state = state,
        onIntent = {
            viewModel.setIntent(it)
        }
    )
}

@Composable
fun HomeContentScreen(
    state: HomeState,
    onIntent: (HomeIntent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
    ) {
        HeaderToolbar(
            contentDaySelector = {
                DaySelector()
            }
        )
        LazyTimeline(
            state = state,
            modifier = Modifier.weight(1f)
        )
    }
}