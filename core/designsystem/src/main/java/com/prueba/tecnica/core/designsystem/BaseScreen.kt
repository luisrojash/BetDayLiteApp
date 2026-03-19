package com.prueba.tecnica.core.designsystem

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.prueba.tecnica.core.common.presentation.ErrorState
import com.prueba.tecnica.core.designsystem.components.DialogFailure
import com.prueba.tecnica.core.designsystem.components.dialog.CustomErrorDialog
import com.prueba.tecnica.core.designsystem.components.loading.MyLoading

@Composable
fun BaseScreen(
    progress: Boolean = false,
    errorState: ErrorState = ErrorState.None,
    onDismiss: () -> Unit = {},
    onButtonClick: (actionText: String) -> Unit = {}
) {

    val context = LocalContext.current

    if (progress) {
        MyLoading {}
    }

    when (errorState) {
        is ErrorState.None -> {}
        is ErrorState.Dialog -> {
            CustomErrorDialog(
                icon = errorState.icon,
                titleError = errorState.title,
                messageError = errorState.description ?: "",
                onDismiss = onDismiss,
                onButtonClick = { onButtonClick(errorState.actionCode) },
                actionText = errorState.actionCode
            )
        }

        is ErrorState.DialogFailure -> {
            DialogFailure(errorState, onDismiss, onButtonClick)
        }

        is ErrorState.ShowToast -> {
            Toast.makeText(
                context,
                errorState.text,
                Toast.LENGTH_SHORT
            ).show()
        }

        else -> {}
    }
}
