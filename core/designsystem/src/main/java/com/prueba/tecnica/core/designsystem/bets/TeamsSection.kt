package com.prueba.tecnica.core.designsystem.bets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TeamsSection(
    homeTeam: String,
    awayTeam: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TeamItem(
            teamName = homeTeam,
            boxColor = Color.White
        )

        Text(
            text = "VS",
            color = Color(0xFF5F6470),
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold
        )

        TeamItem(
            teamName = awayTeam,
            boxColor = Color(0xFF005A73)
        )
    }
}

@Composable
fun TeamItem(
    teamName: String,
    boxColor: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(width = 46.dp, height = 54.dp)
                .clip(RoundedCornerShape(2.dp))
                .background(boxColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = teamName.take(1),
                color = if (boxColor == Color.White) Color.Black else Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = teamName,
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}