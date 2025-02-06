package com.urosmilosavljevic.foodapp.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme =
    darkColorScheme(
        primary = Orange,
        onPrimary = White,
        primaryContainer = OrangeLight,
        secondary = DarkBlue,
        onSecondary = White,
        background = DarkBlue,
        onBackground = Gray50,
        surface = White,
        onSurface = Gray300,
    )

private val LightColorScheme =
    lightColorScheme(
        primary = Orange,
        onPrimary = White,
        primaryContainer = OrangeLight,
        secondary = DarkBlue,
        onSecondary = White,
        background = Gray50,
        onBackground = DarkGrey,
        surface = White,
        onSurface = Gray300,
    )

@Composable
fun FoodAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
        shapes = Shapes,
    )
}
