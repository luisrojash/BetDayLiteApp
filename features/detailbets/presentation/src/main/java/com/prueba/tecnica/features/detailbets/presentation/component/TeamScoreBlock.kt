package com.prueba.tecnica.features.detailbets.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import com.prueba.tecnica.core.designsystem.theme.BorderColor
import com.prueba.tecnica.core.designsystem.theme.PrimaryText

@Composable
fun TeamScoreBlock(
    teamName: String,
    isLeft: Boolean
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /* Box(
             modifier = Modifier
                 .size(48.dp)
                 .clip(RoundedCornerShape(12.dp))
                 .background(Color(0xFFF2F4F7))
                 .border(1.dp, BorderColor, RoundedCornerShape(12.dp)),
             contentAlignment = Alignment.Center
         ) {
             Box(
                 modifier = Modifier
                     .size(34.dp)
                     .clip(RoundedCornerShape(8.dp))
                     .background(Color(0xFF184E49))
             )
         }*/


        TeamItem(
            teamName = teamName,
            boxColor = Color.White
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = teamName,
            color = PrimaryText,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
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