package com.ort.challenge2.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val BrownPrimary = Color(0xFF7B3F00)
val BrownSecondary = Color(0xFFA0522D)
val White = Color(0xFFFFFFFF)
val Black: Color
    get() = Color(0xFF000000)

private val LightColors = lightColorScheme(
    primary = BrownPrimary,
    onPrimary = White,
    secondary = BrownSecondary,
    onSecondary = White,
    background = White,
    onBackground = Black,
    surface = White,
    onSurface = Black
)

private val DarkColors = darkColorScheme(
    primary = BrownSecondary,
    onPrimary = Black,
    secondary = BrownPrimary,
    onSecondary = White,
    background = Black,
    onBackground = White,
    surface = Black,
    onSurface = White
)


@Composable
fun ShopAppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}

@Composable
fun Challenge2Theme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(),
        content = content
    )
}

