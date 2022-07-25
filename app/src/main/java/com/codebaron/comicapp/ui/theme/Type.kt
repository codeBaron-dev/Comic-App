package com.codebaron.comicapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.codebaron.comicapp.R

// Set of Material typography styles to start with
val EduFoundationTypography = FontFamily(
    Font(R.font.edu_nswact_foundation_regular),
    Font(R.font.edu_nswact_foundation_bold, FontWeight.Bold),
    Font(R.font.edu_nswact_foundation_semi_bold, FontWeight.SemiBold),
    Font(R.font.edu_nswact_foundation_medium, FontWeight.Medium)
)
val Typography = Typography(
    displaySmall = TextStyle(
        fontFamily = EduFoundationTypography,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    displayLarge = TextStyle(
        fontFamily = EduFoundationTypography,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold
    ),
    titleLarge = TextStyle(
        fontFamily = EduFoundationTypography,
        fontSize = 50.sp,
        fontWeight = FontWeight.ExtraBold
    ),
    bodySmall = TextStyle(
        fontFamily = EduFoundationTypography,
        fontSize = 12.sp
    )

)