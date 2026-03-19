package com.prueba.tecnica.core.designsystem.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Typography
import com.prueba.tecnica.core.designsystem.R


val baloo2SemiBold = FontFamily(Font(R.font.baloo2_semibold))
val baloo2Bold = FontFamily(Font(R.font.baloo2_bold))
val nunitoNormal = FontFamily(Font(R.font.nunito_regular))
val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
val nunitoBold = FontFamily(Font(R.font.nunito_bold))

class MyTypography(
    val defaultFontFamily: FontFamily,
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val h5: TextStyle,
    val h6: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val button: TextStyle,
    val caption: TextStyle
)

fun MyTypography.toMaterial3Typography(): Typography {
    return Typography(
        displayLarge = this.h1,
        displayMedium = this.h2,
        displaySmall = this.h3,
        headlineLarge = this.h4,
        headlineMedium = this.h5,
        headlineSmall = this.h6,
        bodyLarge = this.body1,
        bodyMedium = this.body2,
        labelMedium = this.button,
        labelSmall = this.caption
    )
}

    val AppTypography = MyTypography(
        defaultFontFamily = FontFamily(Font(R.font.nunito_regular)),
        h1 = TextStyle(
            fontFamily = baloo2Bold,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        ),
        h2 = TextStyle(
            fontFamily = baloo2Bold,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        h3 = TextStyle(
            fontFamily = baloo2SemiBold,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp
        ),
        h4 = TextStyle(
            fontFamily = baloo2SemiBold,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        ),
        h5 = TextStyle(
            fontFamily = nunitoMedium,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        ),
        h6 = TextStyle(
            fontFamily = nunitoNormal,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        body1 = TextStyle(
            fontFamily = nunitoNormal,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        body2 = TextStyle(
            fontFamily = nunitoNormal,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        button = TextStyle(
            fontFamily = baloo2Bold,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        ),
        caption = TextStyle(
            fontFamily = nunitoBold,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp
        )
    )