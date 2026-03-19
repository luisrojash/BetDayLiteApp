package com.prueba.tecnica.features.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.prueba.tecnica.core.common.presentation.ErrorState
import com.prueba.tecnica.core.designsystem.BaseScreen
import com.prueba.tecnica.core.designsystem.theme.Primary
import com.prueba.tecnica.core.designsystem.theme.PrimaryGreen
import com.prueba.tecnica.features.presentation.component.BetCard
import com.prueba.tecnica.features.presentation.component.UserHeaderCard

@Composable
fun ProfileScreen() {

    val viewModel = hiltViewModel<ProfileViewModel>()
    val state = viewModel.uiState.collectAsState().value
    val errorState by viewModel.errorState.collectAsState(initial = ErrorState.None)

    LaunchedEffect(viewModel.navigation) {
        viewModel.navigation.collect {
            when (it) {
                //Solo para ejecutar Acciones
                is ProfileNavigate.OnBackPressed -> {

                }
            }
        }
    }

    BaseScreen(progress = state.showLoadingContent, errorState = errorState, onDismiss = {
        viewModel.hideDialog()
    }, onButtonClick = { _ ->
        viewModel.hideDialog()
    })
    ProfileContentScreen(
        state = state,
        onIntent = {
            viewModel.setIntent(it)
        }
    )
}


@Composable
fun ProfileContentScreen(
    state: ProfileState,
    onIntent: (ProfileIntent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Primary
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item { Spacer(modifier = Modifier.height(8.dp)) }

            item {
                UserHeaderCard(
                    name = "Luis Rojas",
                    userType = "Usuario Premium",
                    balance = "$ 1,240.50",
                    photoUrl = "https://i.pravatar.cc/150?img=12"
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Mis Apuestas",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    TextButton(onClick = {}) {
                        Text(
                            text = "Ver Historial",
                            color = PrimaryGreen,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            items(state.listBets) { bet ->
                BetCard(bet = bet)
            }

            item { Spacer(modifier = Modifier.height(12.dp)) }
        }
    }
}