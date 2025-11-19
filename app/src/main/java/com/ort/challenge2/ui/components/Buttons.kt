package com.ort.challenge2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
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
            containerColor = Color(0xFF8B4513)
        ),
        shape = RoundedCornerShape(50),
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

                Spacer(modifier = Modifier.width(16.dp))
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
