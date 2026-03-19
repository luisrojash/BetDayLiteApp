package com.prueba.tecnica.features.home.presentation.component.selector

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.prueba.tecnica.features.home.domain.entities.DayUi

@Composable
fun DaySelector() {

    var selectedIndex by remember { mutableStateOf(0) }

    val days = listOf(
        DayUi("TODAY", "12"),
        DayUi("TUE", "13"),
        DayUi("WED", "14"),
        DayUi("THU", "15"),
        DayUi("FRI", "16")
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(days) { index, day ->

            val isSelected = index == selectedIndex

            DayItem(
                day = day,
                isSelected = isSelected,
                onClick = { selectedIndex = index }
            )
        }
    }
}