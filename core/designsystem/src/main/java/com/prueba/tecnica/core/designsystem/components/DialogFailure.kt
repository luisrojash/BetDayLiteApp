package com.prueba.tecnica.core.designsystem.components

import androidx.compose.runtime.Composable
import com.prueba.tecnica.core.common.presentation.ErrorState
import com.prueba.tecnica.core.designsystem.components.dialog.CustomErrorDialog
import com.prueba.tecnica.core.domain.Failure

@Composable
fun DialogFailure(errorState: ErrorState.DialogFailure, onDismiss: () -> Unit, onButtonClick: (actionText: String) -> Unit) {
    when (val failure = errorState.failure) {
        is Failure.BadRequest -> {
            CustomErrorDialog(
                titleError = failure.message,
                messageError = failure.any.toString(),
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }

        is Failure.AuthorizationRequired -> {
            CustomErrorDialog(
                titleError = failure.message,
                messageError = failure.any.toString(),
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }

        is Failure.AccessDeniedOrForbidden -> {
            CustomErrorDialog(
                titleError = failure.message,
                messageError = failure.any.toString(),
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }

        is Failure.NotFound -> {
            CustomErrorDialog(
                titleError = failure.message,
                messageError = failure.any.toString(),
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }

        is Failure.Conflict -> {
            CustomErrorDialog(
                titleError = failure.message,
                messageError = failure.any.toString(),
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }

        is Failure.Limits -> {
            CustomErrorDialog(
                titleError = failure.message,
                messageError = failure.any.toString(),
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }

        is Failure.DestinationLocked -> {
            CustomErrorDialog(
                titleError = failure.message,
                messageError = failure.any.toString(),
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }
        is Failure.Unprocessable -> {
            CustomErrorDialog(
                titleError = failure.message,
                messageError = failure.any.toString(),
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }
        is Failure.Locked -> {
            CustomErrorDialog(
                titleError = failure.message,
                messageError = failure.any.toString(),
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }
        is Failure.TooManyRequest -> {
            CustomErrorDialog(
                titleError = failure.message,
                messageError = failure.any.toString(),
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }
        is Failure.Internal -> {
            CustomErrorDialog(
                titleError = failure.message,
                messageError = failure.any.toString(),
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }
        is Failure.ServiceUnavailable -> {
            CustomErrorDialog(
                titleError = failure.message,
                messageError = failure.any.toString(),
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }
        is Failure.PreconditionFailed -> {
            CustomErrorDialog(
                titleError = failure.message,
                messageError = failure.any.toString(),
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }
        is Failure.OtpRequired -> {
            CustomErrorDialog(
                titleError = failure.message,
                messageError = failure.any.toString(),
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }
        is Failure.NetworkLost -> {
            CustomErrorDialog(
                titleError = "Network Lost",
                messageError = "Please check your internet connection",
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }
        is Failure.Others -> {
            CustomErrorDialog(
                titleError = "Error",
                messageError = "An error occurred",
                onButtonClick = {
                    onButtonClick(errorState.actionCode)
                },
                onDismiss = {onDismiss()},
            )
        }
        else -> {}
    }
}