package com.hellking.higher.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Green200,
    primaryVariant = Green000,
    secondary = Blue100,
    background = Color.White
)

private val LightColorPalette = lightColors(
    primary = Green100,
    primaryVariant = Green300,
    secondary = Blue200,
    background = Color.White

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun HigherTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    if (darkTheme) {
        systemUiController.setSystemBarsColor(
            color = Green200
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = Green100
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}