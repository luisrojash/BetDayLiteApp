package com.prueba.tecnica.features.home.presentation.component.timeline

import androidx.compose.runtime.Composable
import com.prueba.tecnica.features.home.domain.entities.ItemMatch
import com.prueba.tecnica.features.home.domain.entities.MatchesStageStatus
import com.prueba.tecnica.features.home.presentation.R

@Composable
 fun GetIconTime(stage: ItemMatch): Int? {
    return if (stage.status == MatchesStageStatus.CURRENT) {
        R.drawable.ic_bubble_warning_16
    } else {
        null
    }
}