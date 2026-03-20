package com.prueba.tecnica.features.detailbets.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.tecnica.core.designsystem.theme.BorderColor
import com.prueba.tecnica.core.designsystem.theme.PrimaryText
import com.prueba.tecnica.core.designsystem.theme.SecondaryText
import com.prueba.tecnica.core.designsystem.theme.SoftBlue

@Composable
fun MatchResumeCard(
    leagueName:String,
    firstTeam:String,
    secondTeam:String,
    date:String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = SecondaryText),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = BorderStroke(1.dp, BorderColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "$leagueName\nLEAGUE",
                        color = Color.Black,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Fase de Grupos",
                        color = Color.Black,
                        fontSize = 13.sp
                    )
                }

                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Estadio Santiago\nBernabéu",
                        color = Color.Black,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = date,
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
               /* TeamScoreBlock(
                    teamName = firstTeam,
                    isLeft = true
                )*/

                TeamItem(
                    teamName = firstTeam,
                    boxColor = Color.White
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "2",
                            color = PrimaryText,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 28.sp
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "-",
                            color = Color.Black,
                            fontWeight = FontWeight.Medium,
                            fontSize = 26.sp
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "1",
                            color = PrimaryText,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 28.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFFEAF1FF))
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = "65' Min",
                            color = SoftBlue,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                TeamItem(
                    teamName = secondTeam,
                    boxColor = Color.Black
                )
            }
        }
    }
}