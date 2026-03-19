package com.prueba.tecnica.core.designsystem.components.text

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.prueba.tecnica.core.designsystem.theme.AppTypography
import com.prueba.tecnica.core.designsystem.theme.MyTheme

@Composable
fun TextHeadline1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Left,
    fontSize: TextUnit = 30.sp,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = AppTypography.h1,
        fontSize = fontSize
    )
}

@Composable
fun TextHeadline2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Left,
    fontSize: TextUnit = 24.sp,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = AppTypography.h2.copy(fontSize = fontSize)
    )
}

@Composable
fun TextHeadline3(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = AppTypography.h3
    )
}

@Composable
fun TextHeadline4(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = AppTypography.h4
    )
}

@Composable
fun TextHeadline5(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Center,
    fontSize: TextUnit = 14.sp,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = AppTypography.h5.copy(fontSize = fontSize)
    )
}

@Composable
fun TextHeadline6(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = AppTypography.h6
    )
}

@Composable
fun TextBody1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Center,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = AppTypography.body1.copy(fontWeight = fontWeight, fontSize = fontSize)
    )
}

@Composable
fun TextBody2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Center,
    fontWeight: FontWeight = FontWeight.Normal,
    textDecoration: TextDecoration = TextDecoration.None,
    boldHighlighting: Boolean = false,
    boldText: List<String> = emptyList(),
    fontSize: TextUnit = 14.sp
) {
    if (boldHighlighting) {
        Text(
            text = setSomeWordsToBold(text, boldText),
            modifier = modifier,
            color = color,
            textAlign = textAlign,
            textDecoration = textDecoration,
            style = AppTypography.body2.copy(fontWeight = fontWeight, fontSize = fontSize)
        )
    } else {
        Text(
            text = text,
            modifier = modifier,
            color = color,
            textAlign = textAlign,
            textDecoration = textDecoration,
            style = AppTypography.body2.copy(fontWeight = fontWeight, fontSize = fontSize)
        )
    }

}

@Composable
fun TextButton(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 24.sp,
    color: Color = Color.Unspecified,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = AppTypography.button.copy(fontWeight = fontWeight),
        fontSize = fontSize,
    )
}

@Composable
fun TextCaption1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Center,
    fontWeight: FontWeight = FontWeight.Normal,
    maxLines: Int = 1,
    boldHighlighting: Boolean = false,
    boldText: List<String> = emptyList(),
    fontSize: TextUnit = 16.sp,
) {
    if (boldHighlighting) {
        Text(
            text = setSomeWordsToBold(text, boldText),
            modifier = modifier,
            color = color,
            textAlign = textAlign,
            maxLines = maxLines,
            style = AppTypography.caption.copy(fontWeight = fontWeight, fontSize = fontSize)
        )
    } else {
        Text(
            text = text,
            modifier = modifier,
            color = color,
            textAlign = textAlign,
            maxLines = maxLines,
            style = AppTypography.caption.copy(fontWeight = fontWeight)
        )
    }
}

@Composable
fun TextCaption2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Center,
    fontWeight: FontWeight = FontWeight.Medium,
    maxLines: Int = 1,
    boldHighlighting: Boolean = false,
    boldText: List<String> = emptyList()
) {
    if (boldHighlighting) {
        Text(
            text = setSomeWordsToBold(text, boldText),
            modifier = modifier,
            color = color,
            textAlign = textAlign,
            maxLines = maxLines,
            style = AppTypography.caption.copy(fontWeight = fontWeight, fontSize = 12.sp)
        )
    } else {
        Text(
            text = text,
            modifier = modifier,
            color = color,
            textAlign = textAlign,
            maxLines = maxLines,
            style = AppTypography.caption.copy(fontWeight = fontWeight, fontSize = 12.sp)
        )
    }
}

@Composable
fun TextOverLine(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Center,
    fontWeight: FontWeight = FontWeight.Normal,
    maxLines: Int = 1,
    boldHighlighting: Boolean = false,
    boldText: List<String> = emptyList()
) {
    if (boldHighlighting) {
        Text(
            text = setSomeWordsToBold(text, boldText),
            modifier = modifier,
            color = color,
            textAlign = textAlign,
            maxLines = maxLines,
            style = AppTypography.body2.copy(fontSize = 10.sp, fontWeight = fontWeight)
        )
    } else {
        Text(
            text = text,
            modifier = modifier,
            color = color,
            textAlign = textAlign,
            maxLines = maxLines,
            style = AppTypography.body2.copy(fontSize = 10.sp, fontWeight = fontWeight)
        )
    }
}

@Composable
fun TextNunitoNormal(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration = TextDecoration.None,
    fontSize: TextUnit = 14.sp,
    lineHeight : TextUnit = 20.sp
) {
    Text(
        text = text,
        modifier = modifier,
        color = textColor,
        textAlign = textAlign,
        textDecoration = textDecoration,
        style = AppTypography.body1.copy(
            fontSize = fontSize,
            lineHeight = lineHeight
        )
    )
}

@Preview(showSystemUi = true, backgroundColor = 0x00FFFFFF, showBackground = true)
@Composable
fun TextHeadline1Preview() {
    MyTheme {
        Column {
            TextHeadline1(text = "Text Headline 1")
            TextHeadline2(text = "Text Headline 2")
            TextHeadline3(text = "Text Headline 3")
            TextHeadline4(text = "Text Headline 4")
            TextHeadline5(text = "Text Headline 5")
            TextHeadline6(text = "Text Headline 6")
            TextBody1(text = "Text Body 1")
            TextBody2(text = "Text Body 2")
            TextButton(text = "Text Button")
            TextCaption1(text = "Text Caption 1")
            TextCaption2(text = "Text Caption 2")
            TextOverLine(text = "Text OverLine")
        }
    }
}