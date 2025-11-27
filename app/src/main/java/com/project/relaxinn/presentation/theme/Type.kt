package com.project.relaxinn.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.project.relaxinn.R

private val UnboundedFontFamily = FontFamily(
    Font(R.font.extrabold, FontWeight.ExtraBold, FontStyle.Normal),
    Font(R.font.bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.semibold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.light, FontWeight.Light, FontStyle.Normal),
)

@Immutable
data class AppTypography(
    val extraHeadLine: TextStyle,
    val mediumHeadLine: TextStyle,
    val headline: TextStyle,
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val body: TextStyle,
    val bodySmall: TextStyle,
    val label: TextStyle
)

val LocalAppTypography = staticCompositionLocalOf {
    AppTypography(
        extraHeadLine = TextStyle.Default,
        mediumHeadLine = TextStyle.Default,
        headline = TextStyle.Default,
        titleLarge = TextStyle.Default,
        titleMedium = TextStyle.Default,
        titleSmall = TextStyle.Default,
        body = TextStyle.Default,
        bodySmall = TextStyle.Default,
        label = TextStyle.Default,
    )
}

val extendedTypography = AppTypography(
    extraHeadLine = TextStyle(
        fontFamily = UnboundedFontFamily, fontSize = 70.sp, fontWeight = FontWeight.ExtraBold
    ), mediumHeadLine = TextStyle(
        fontFamily = UnboundedFontFamily, fontSize = 60.sp, fontWeight = FontWeight.ExtraBold
    ), headline = TextStyle(
        fontFamily = UnboundedFontFamily, fontSize = 32.sp, fontWeight = FontWeight.Normal
    ), titleLarge = TextStyle(
        fontFamily = UnboundedFontFamily, fontSize = 24.sp, fontWeight = FontWeight.Normal
    ), titleMedium = TextStyle(
        fontFamily = UnboundedFontFamily, fontSize = 20.sp, fontWeight = FontWeight.Normal
    ), titleSmall = TextStyle(
        fontFamily = UnboundedFontFamily, fontSize = 16.sp, fontWeight = FontWeight.Normal
    ), body = TextStyle(
        fontFamily = UnboundedFontFamily, fontSize = 14.sp, fontWeight = FontWeight.Normal
    ), bodySmall = TextStyle(
        fontFamily = UnboundedFontFamily, fontSize = 12.sp, fontWeight = FontWeight.Normal
    ), label = TextStyle(
        fontFamily = UnboundedFontFamily, fontSize = 11.sp, fontWeight = FontWeight.Light
    )
)