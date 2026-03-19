package com.prueba.tecnica.core.designsystem.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prueba.tecnica.core.designsystem.theme.AppTypography
import com.prueba.tecnica.core.designsystem.theme.ButtonDisable
import com.prueba.tecnica.core.designsystem.theme.MyTheme
import com.prueba.tecnica.core.designsystem.theme.TextColorGray
import com.prueba.tecnica.core.designsystem.R


@Composable
fun ButtonPrimary(
    text: String,
    fontWeight: FontWeight = FontWeight.Bold,
    @DrawableRes iconRight: Int = 0,
    @DrawableRes iconLeft: Int = 0,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {

    val myButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Red,
        contentColor = Color.White,
        disabledContainerColor = ButtonDisable,
        disabledContentColor = TextColorGray
    )

    Button(
        onClick = onClick, enabled = enabled, shape = RoundedCornerShape(27.dp),
        colors = myButtonColors, modifier = modifier
    ) {
        Row(verticalAlignment = CenterVertically) {
            if (iconLeft != 0) {
                Icon(
                    ImageVector.vectorResource(id = iconLeft),
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    contentDescription = ""
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            }

            Text(
                text = text,
                style = AppTypography.button.copy(fontWeight = fontWeight)
            )

            if (iconRight != 0) {
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Icon(
                    ImageVector.vectorResource(id = iconRight),
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    contentDescription = ""
                )
            }
        }
    }
}

@Preview
@Composable
fun ButtonPrimaryPreview() {
    MyTheme {
        ButtonPrimary("Button Text") {}
    }
}

@Preview
@Composable
fun ButtonPrimaryPreviewIconRight() {
    MyTheme {
        ButtonPrimary("Button Text", iconRight = R.drawable.ic_warning) {}
    }
}

@Preview
@Composable
fun ButtonPrimaryPreviewIconLeft() {
    MyTheme {
        ButtonPrimary("Button Text", iconLeft = R.drawable.ic_warning) {}
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ButtonPrimaryPreviewDisable() {
    MyTheme {
        ButtonPrimary("Button Text", enabled = false) {}
    }
}