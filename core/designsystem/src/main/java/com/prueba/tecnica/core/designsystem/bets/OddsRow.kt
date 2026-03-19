package com.prueba.tecnica.core.designsystem.bets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OddsRow(
    homeOdd: String,
    drawOdd: String,
    awayOdd: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        OddItem(
            modifier = Modifier.weight(1f),
            label = "1",
            value = homeOdd
        )

        OddItem(
            modifier = Modifier.weight(1f),
            label = "X",
            value = drawOdd
        )

        OddItem(
            modifier = Modifier.weight(1f),
            label = "2",
            value = awayOdd
        )
    }
}