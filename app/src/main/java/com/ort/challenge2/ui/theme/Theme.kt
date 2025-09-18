package com.ort.challenge2.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val BrownPrimary = Color(0xFF7B3F00)   // Marrón principal (Buy button)
val BrownSecondary = Color(0xFFA0522D) // Marrón secundario más suave
val White = Color(0xFFFFFFFF)
val Black: Color
    get() = Color(0xFF000000)

private val LightColors = lightColorScheme(
    primary = BrownPrimary,      // Botones principales
    onPrimary = White,           // Texto sobre marrón
    secondary = BrownSecondary,  // Acentos
    onSecondary = White,         // Texto sobre secondary
    background = White,          // Fondo general
    onBackground = Black,        // Texto sobre fondo
    surface = White,             // Cards y superficies
    onSurface = Black            // Texto sobre surface
)

private val DarkColors = darkColorScheme(
    primary = BrownSecondary,    // Marrón más claro en dark mode
    onPrimary = Black,           // Texto sobre marrón claro
    secondary = BrownPrimary,    // Acento marrón más fuerte
    onSecondary = White,         // Texto sobre secondary
    background = Black,          // Fondo oscuro
    onBackground = White,        // Texto sobre fondo oscuro
    surface = Black,             // Superficies en dark
    onSurface = White            // Texto sobre surface
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

