package com.prueba.tecnica.core.common.presentation

import androidx.annotation.DrawableRes
import com.prueba.tecnica.core.domain.Failure


sealed class ErrorState {
    data object None : ErrorState()
    data class Dialog(
        val title: String,
        val description: String? = "",
        @DrawableRes val icon: Int = 0,
        val actionCode: String = "NONE",
        val doOnDismiss: () -> Unit = {},
        val doOnAction: () -> Unit = {}
    ) : ErrorState()

    data class DialogFailure(
        val failure: Failure,
        val actionCode: String = "NONE",
        val doOnDismiss: () -> Unit = {},
        val doOnAction: () -> Unit = {},
    ) : ErrorState()

    data class ShowToast(val text: String) : ErrorState()
}


