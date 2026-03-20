package com.prueba.tecnica.core.designsystem.bets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OddsRow(
    homeOdd: String,
    drawOdd: String,
    awayOdd: String
) {
    var selected by rememberSaveable { mutableStateOf<String?>(null) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        OddItem(
            modifier = Modifier.weight(1f),
            label = "1",
            value = homeOdd,
            isSelected = selected == "1",
            onClick = { selected = "1" }
        )

        OddItem(
            modifier = Modifier.weight(1f),
            label = "X",
            value = drawOdd,
            isSelected = selected == "X",
            onClick = { selected = "X" }
        )

        OddItem(
            modifier = Modifier.weight(1f),
            label = "2",
            value = awayOdd,
            isSelected = selected == "2",
            onClick = { selected = "2" }
        )
    }
}