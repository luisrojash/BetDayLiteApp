package com.prueba.tecnica.features.home.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.prueba.tecnica.core.common.utils.Utils
import com.prueba.tecnica.core.designsystem.bets.LeagueHeader
import com.prueba.tecnica.core.designsystem.bets.OddsRow
import com.prueba.tecnica.core.designsystem.bets.TeamsSection
import com.prueba.tecnica.core.designsystem.components.text.TextBody1
import com.prueba.tecnica.core.designsystem.theme.TextColorGray
import com.prueba.tecnica.features.home.domain.entities.ItemMatch


@Composable
fun MatchesCard(
    modifier: Modifier = Modifier,
    itemMatch: ItemMatch
) {

    Column {
        TextBody1(
            modifier = Modifier
                .padding(start = 32.dp),
            color = TextColorGray,
            text =  Utils.formatDate(itemMatch.startTime),
        )
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF111216)
            ),
            border = BorderStroke(
                width = 1.dp,
                color = Color(0xFF1F222A)
            )
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 18.dp)
            ) {
                LeagueHeader(leagueName = itemMatch.firstTeam.name)

                Spacer(modifier = Modifier.height(20.dp))

                TeamsSection(
                    homeTeam = itemMatch.firstTeam.name,
                    awayTeam = itemMatch.secondTeam.name
                )

                Spacer(modifier = Modifier.height(20.dp))

                OddsRow(
                    homeOdd = itemMatch.market.bets.firstBets.toString(),
                    drawOdd = itemMatch.market.bets.threeBets.toString(),
                    awayOdd = itemMatch.market.bets.secondBets.toString(),
                )
            }
        }
    }

}