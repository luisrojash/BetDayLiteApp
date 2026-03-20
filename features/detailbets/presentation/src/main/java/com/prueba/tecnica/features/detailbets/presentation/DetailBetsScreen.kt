package com.prueba.tecnica.features.detailbets.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prueba.tecnica.core.designsystem.theme.MyTheme
import com.prueba.tecnica.core.designsystem.theme.ScreenBg
import com.prueba.tecnica.features.detailbets.presentation.component.BetDetailTopBar
import com.prueba.tecnica.features.detailbets.presentation.component.BetInformationCard
import com.prueba.tecnica.features.detailbets.presentation.component.MatchResumeCard

@Composable
fun BetDetailScreen(
    onClickedBackPressed: () -> Unit,
    leagueName: String = "",
    date: String= "",
    firstTeam: String= "",
    secondTeam: String= "",
    share: String= "",
    speak: String= "",
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxSize()
        ) {
            BetDetailTopBar(
                onClickedBackPressed = onClickedBackPressed
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                MatchResumeCard(
                    leagueName =leagueName,
                    firstTeam = firstTeam,
                    secondTeam = secondTeam,
                    date = date
                )
                BetInformationCard(
                    share =share,
                    speak = speak
                )
            }
        }
    }
}

@Preview
@Composable
fun BetDetailScreenPreview() {
    MyTheme {
        BetDetailScreen(
            onClickedBackPressed = {}
        )
    }
}