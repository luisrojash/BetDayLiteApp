package com.prueba.tecnica.features.home.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.prueba.tecnica.core.designsystem.theme.BLACK_100
import com.prueba.tecnica.core.designsystem.theme.Primary
import com.prueba.tecnica.core.designsystem.timeline.TimelineNode
import com.prueba.tecnica.core.designsystem.timeline.defaults.CircleParametersDefaults
import com.prueba.tecnica.core.designsystem.timeline.models.TimelineNodePosition
import com.prueba.tecnica.features.home.presentation.HomeState
import com.prueba.tecnica.features.home.presentation.component.timeline.GetIconTime
import com.prueba.tecnica.features.home.presentation.component.timeline.GetLineBrush
import com.prueba.tecnica.features.home.presentation.component.timeline.getIconColor
import com.prueba.tecnica.features.home.presentation.component.timeline.getIconStrokeColor


@Composable
fun LazyTimeline(
    state: HomeState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .background(Primary),
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(state.listMatches) { index, matchesStage ->
            TimelineNode(
                position = mapToTimelineNodePosition(index, state.listMatches.size),
                circleParameters = CircleParametersDefaults.circleParameters(
                    backgroundColor = getIconColor(matchesStage),
                    stroke = getIconStrokeColor(matchesStage),
                    icon = GetIconTime(matchesStage)
                ),
                lineParameters = GetLineBrush(
                    circleRadius = 12.dp,
                    index = index,
                    items = state.listMatches
                ),
                contentStartOffset = 16.dp,
                spacer = 24.dp
            ) { itemModifier ->
                MatchesCard(
                    modifier = itemModifier,
                    itemMatch = matchesStage
                )
            }
        }
    }
}

private fun mapToTimelineNodePosition(index: Int, collectionSize: Int) = when (index) {
    0 -> TimelineNodePosition.FIRST
    collectionSize - 1 -> TimelineNodePosition.LAST
    else -> TimelineNodePosition.MIDDLE
}
