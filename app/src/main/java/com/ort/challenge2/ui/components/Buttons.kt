package com.ort.challenge2.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BuyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    showPlusIcon: Boolean = false
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF8B4513) // Color marrón
        ),
        shape = RoundedCornerShape(50), // Bordes completamente redondeados
        modifier = modifier
    ) {
        if (showPlusIcon) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "+",
                    color = Color.White
                )
                // Aumentamos el espacio entre "+" y "Buy"
                Spacer(modifier = Modifier.width(16.dp)) // Aumentado de 8.dp a 16.dp
                Text(
                    text = text,
                    color = Color.White
                )
            }
        } else {
            Text(
                text = text,
                color = Color.White
            )
        }
    }
}

@Composable
fun OutlinedActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = text)
    }
}
