package com.thepantoster.mikuquiz.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.thepantoster.mikuquiz.R

val titleFamily = FontFamily(
    Font(R.font.forte, FontWeight.Normal)
)

val startButtonFamily = FontFamily(
    Font(R.font.calibri, FontWeight.Normal)
)

val answersFamily = FontFamily(
    Font(R.font.bahnschrift, FontWeight.W600),
    Font(R.font.bahnschrift, FontWeight.W800)
)

val percentFamily = FontFamily(
    Font(R.font.terminus, FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)