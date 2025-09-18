package com.ort.challenge2.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ort.challenge2.R

@Composable
fun OrderListDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onBuyClick: () -> Unit,
    onBackClick: () -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Título
                    Text(
                        text = stringResource(R.string.order_list),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    // Descripción
                    Text(
                        text = stringResource(R.string.order_description),
                        fontSize = 14.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Lista de productos
                    var leatherBootsSelected by remember { mutableStateOf(true) }
                    var sneakersSelected by remember { mutableStateOf(true) }
                    var yellowSlippersSelected by remember { mutableStateOf(false) }

                    // Producto 1 - Leather boots
                    CheckableItem(
                        title = stringResource(R.string.leather_boots),
                        isSelected = leatherBootsSelected,
                        onSelectionChanged = { leatherBootsSelected = it },
                        leadingContent = { CircledNumber(number = 1) }
                    )

                    // Producto 2 - Sneakers
                    CheckableItem(
                        title = stringResource(R.string.sneakers),
                        isSelected = sneakersSelected,
                        onSelectionChanged = { sneakersSelected = it },
                        leadingContent = { CircledNumber(number = 2) }
                    )

                    // Producto 3 - Yellow Slippers
                    CheckableItem(
                        title = stringResource(R.string.yellow_slippers),
                        isSelected = yellowSlippersSelected,
                        onSelectionChanged = { yellowSlippersSelected = it },
                        leadingContent = { CircledNumber(number = 3) }
                    )

                    // Botones
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TextButton(onClick = onBackClick) {
                            Text(
                                text = stringResource(R.string.back),
                                color = Color(0xFF8B4513)
                            )
                        }

                        TextButton(onClick = onBuyClick) {
                            Text(
                                text = stringResource(R.string.buy),
                                color = Color(0xFF8B4513)
                            )
                        }
                    }
                }
            }
        }
    }
}
