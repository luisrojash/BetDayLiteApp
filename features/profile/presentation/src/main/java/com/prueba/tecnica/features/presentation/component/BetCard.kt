package com.prueba.tecnica.features.presentation.component

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.tecnica.core.designsystem.theme.CardBg2
import com.prueba.tecnica.core.designsystem.theme.CyanAccent
import com.prueba.tecnica.core.designsystem.theme.DividerColor
import com.prueba.tecnica.core.designsystem.theme.PrimaryGreen
import com.prueba.tecnica.core.designsystem.theme.RedAccent
import com.prueba.tecnica.core.designsystem.theme.SoftText
import com.prueba.tecnica.core.designsystem.theme.YellowAccent
import com.prueba.tecnica.feature.domain.entities.BetStatus
import com.prueba.tecnica.feature.domain.entities.BetUi

@Composable
fun BetCard(
    bet: BetUi,
    onClickedBetCard: (BetUi) -> Unit
) {
    val accentColor = when (bet.status) {
        BetStatus.PENDING -> YellowAccent
        BetStatus.WON -> CyanAccent
        BetStatus.LOST -> RedAccent
    }

    val badgeBg = when (bet.status) {
        BetStatus.PENDING -> Color(0xFF4D3C10)
        BetStatus.WON -> Color(0xFF0E4A45)
        BetStatus.LOST -> Color(0xFF4A1D25)
    }

    val badgeText = when (bet.status) {
        BetStatus.PENDING -> "PENDIENTE"
        BetStatus.WON -> "GANADA"
        BetStatus.LOST -> "PERDIDA"
    }

    Card(
        onClick = { onClickedBetCard(bet) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = CardBg2),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(138.dp)
                    .background(accentColor)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = bet.sportLeague,
                        color = SoftText,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 1.sp
                    )

                    StatusBadge(
                        text = badgeText,
                        background = badgeBg,
                        textColor = accentColor
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = bet.match,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(14.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(DividerColor)
                )

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = bet.playedText,
                            color = SoftText,
                            fontSize = 13.sp
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Row {
                            Text(
                                text = "Cuota: ",
                                color = SoftText,
                                fontSize = 13.sp
                            )
                            Text(
                                text = bet.oddText.removePrefix("Cuota: "),
                                color = PrimaryGreen,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = bet.amountLabel,
                            color = SoftText,
                            fontSize = 12.sp
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = bet.amountValue,
                            color = if (bet.status == BetStatus.LOST) SoftText else PrimaryGreen,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }
        }
    }
}
