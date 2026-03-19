package com.prueba.tecnica.features.home.presentation.component.timeline

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.prueba.tecnica.core.designsystem.theme.DEFAULT_COLOR_TIMELINE
import com.prueba.tecnica.core.designsystem.theme.Gray200
import com.prueba.tecnica.core.designsystem.theme.Green500
import com.prueba.tecnica.core.designsystem.theme.Orange500
import com.prueba.tecnica.core.designsystem.timeline.defaults.LineParametersDefaults
import com.prueba.tecnica.core.designsystem.timeline.models.LineParameters
import com.prueba.tecnica.core.designsystem.timeline.models.StrokeParameters
import com.prueba.tecnica.features.home.domain.entities.ItemMatch
import com.prueba.tecnica.features.home.domain.entities.MatchesStageStatus

@Composable
fun GetLineBrush(circleRadius: Dp, index: Int, items: List<ItemMatch>): LineParameters? {
    return if (index != items.lastIndex) {
        val currentStage: ItemMatch = items[index]
        val nextStage: ItemMatch = items[index + 1]
        val circleRadiusInPx = with(LocalDensity.current) { circleRadius.toPx() }
        LineParametersDefaults.linearGradient(
            strokeWidth = 3.dp,
            startColor = (getIconStrokeColor(currentStage)?.color ?: getIconColor(currentStage)),
            endColor = (getIconStrokeColor(nextStage)?.color ?: getIconColor(items[index + 1])),
            startY = circleRadiusInPx * 2
        )
    } else {
        null
    }
}

fun getIconColor(stage: ItemMatch): Color {
    return when (stage.status) {
        MatchesStageStatus.FINISHED -> Green500
        MatchesStageStatus.CURRENT -> Orange500
        MatchesStageStatus.UPCOMING -> Color.White
        else ->
            DEFAULT_COLOR_TIMELINE
    }
}

fun getIconStrokeColor(stage: ItemMatch): StrokeParameters? {
    return if (stage.status == MatchesStageStatus.UPCOMING) {
        StrokeParameters(color = Gray200, width = 2.dp)
    } else {
        null
    }
}

