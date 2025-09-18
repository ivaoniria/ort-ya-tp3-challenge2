package com.ort.challenge2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Componente reutilizable para mostrar un número dentro de un círculo
 */
@Composable
fun CircledNumber(
    number: Int,
    backgroundColor: Color = Color(0xFF8B4513),
    textColor: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(28.dp)
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number.toString(),
            color = textColor,
            fontSize = 14.sp
        )
    }
}

/**
 * Componente reutilizable para un elemento seleccionable con checkbox
 */
@Composable
fun CheckableItem(
    title: String,
    isSelected: Boolean,
    onSelectionChanged: (Boolean) -> Unit,
    leadingContent: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Contenido a la izquierda (por ejemplo, un número en círculo)
        Box(modifier = Modifier.padding(end = 16.dp)) {
            leadingContent()
        }

        // Título del producto
        Text(
            text = title,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )

        // Checkbox
        Checkbox(
            checked = isSelected,
            onCheckedChange = onSelectionChanged,
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF8B4513),
                uncheckedColor = Color.Gray
            )
        )
    }
}
