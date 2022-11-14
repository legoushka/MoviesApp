package com.example.moviesapp.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorPalette = darkColors(
    primary = LightGreen200,
    primaryVariant = LightGreen700,
    secondary = DeepOrange300,

    background = Color.DarkGray,
    surface = Color.DarkGray,

    onBackground = Color.White,
    onSurface = Color.White,

)

private val LightColorPalette = lightColors(
    primary = LightGreen200,
    primaryVariant = LightGreen700,
    secondary = DeepOrange300

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
fun MoviesAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val view = LocalView.current
    SideEffect {

        val window = (view.context as Activity).window
        //WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = colors.surface.toArgb()
        window.navigationBarColor = colors.surface.toArgb()

        WindowCompat.getInsetsController(window, view)
            .isAppearanceLightStatusBars = !darkTheme
        WindowCompat.getInsetsController(window, view)
            .isAppearanceLightNavigationBars = !darkTheme
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}