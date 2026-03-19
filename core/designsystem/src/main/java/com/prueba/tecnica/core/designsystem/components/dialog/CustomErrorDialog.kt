package com.prueba.tecnica.core.designsystem.components.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.prueba.tecnica.core.designsystem.R
import com.prueba.tecnica.core.designsystem.components.button.ButtonPrimary
import com.prueba.tecnica.core.designsystem.theme.Accent
import com.prueba.tecnica.core.designsystem.theme.Background
import com.prueba.tecnica.core.designsystem.components.text.TextCaption1
import com.prueba.tecnica.core.designsystem.components.text.TextHeadline5


@Composable
fun CustomErrorDialog(
    icon: Int = R.drawable.ic_warning,
    titleError: String,
    messageError: String,
    actionText: String = "Aceptar",
    onButtonClick: () -> Unit,
    onDismiss: () -> Unit,
    showError: Boolean = true
) {

    val openBasicDialog = remember { mutableStateOf(showError) }

    if (openBasicDialog.value) {
        Dialog(
            onDismissRequest = {
                openBasicDialog.value = false
            },
            properties = DialogProperties(
                dismissOnBackPress = true, dismissOnClickOutside = true
            ),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .background(Background, RoundedCornerShape(10.dp))
            ) {

                Column(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .background(Color.White, RoundedCornerShape(10.dp))
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_warning),
                                contentDescription = null,
                                modifier = Modifier
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    if (titleError.isNotEmpty()) {
                        TextCaption1(
                            text = titleError,
                            textAlign = TextAlign.Center,
                            color = Accent,
                            fontSize = 14.sp
                        )
                    }


                    Spacer(modifier = Modifier.height(8.dp))


                    TextHeadline5(
                        fontSize = 12.sp,
                        text = messageError,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))


                    ButtonPrimary(text = actionText) {
                        onButtonClick()
                    }
                    Spacer(modifier = Modifier.height(26.dp))
                }

            }
        }
    }
}


@Preview
@Composable
fun CustomErrorDialogPreview() {
    CustomErrorDialog(
        titleError = "Mensaje de error controlado de backend",
        messageError = "Mensaje de error ",
        onButtonClick = {},
        onDismiss = {}
    )
}