package com.ort.challenge2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.challenge2.R
import com.ort.challenge2.ui.components.BottomNavigationBar
import com.ort.challenge2.ui.components.BuyButton
import com.ort.challenge2.ui.components.OrderListDialog
import com.ort.challenge2.ui.components.OutlinedActionButton
import com.ort.challenge2.ui.components.ProductCountInput
import com.ort.challenge2.ui.components.ShopTopBar
import com.ort.challenge2.ui.components.SizeSelector
import com.ort.challenge2.ui.theme.Challenge2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeatherBootsScreen(
    onMenuClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    onBuyClick: () -> Unit = {}
) {
    val inputText = stringResource(R.string.input)
    var selectedSize by remember { mutableStateOf(inputText) }
    var productCount by remember { mutableStateOf(inputText) }
    var showOrderDialog by remember { mutableStateOf(false) }

    val size38 = stringResource(R.string.size_38)
    val size39 = stringResource(R.string.size_39)
    val size40 = stringResource(R.string.size_40)
    val size41 = stringResource(R.string.size_41)
    val size42 = stringResource(R.string.size_42)
    val size43 = stringResource(R.string.size_43)
    val size44 = stringResource(R.string.size_44)

    val availableSizes = listOf(size38, size39, size40, size41, size42, size43, size44)

    Scaffold(
        topBar = {
            ShopTopBar(
                titleResId = R.string.leather_boots,
                onMenuClick = onMenuClick,
                onProfileClick = {}
            )
        },
        bottomBar = {
            BottomNavigationBar(selectedItem = 0, onItemSelected = {})
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFF5F5))
                    .padding(16.dp)
            ) {
                Text(text = stringResource(R.string.select_size))

                Spacer(modifier = Modifier.height(8.dp))

                SizeSelector(
                    label = stringResource(R.string.label),
                    options = availableSizes,
                    selectedOption = selectedSize,
                    onOptionSelected = { selectedSize = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = stringResource(R.string.count_of_product))

                Spacer(modifier = Modifier.height(8.dp))

                ProductCountInput(
                    label = stringResource(R.string.label),
                    count = productCount,
                    onCountChange = { productCount = it }
                )

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    OutlinedActionButton(
                        text = stringResource(R.string.back),
                        onClick = onBackClick,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(end = 8.dp)
                    )

                    BuyButton(
                        text = stringResource(R.string.buy),
                        onClick = { showOrderDialog = true },
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(start = 8.dp)
                            .fillMaxWidth(0.4f)
                    )
                }
            }
        }
    }

    OrderListDialog(
        showDialog = showOrderDialog,
        onDismiss = { showOrderDialog = false },
        onBuyClick = {
            showOrderDialog = false
            onBuyClick()
        },
        onBackClick = { showOrderDialog = false }
    )
}

@Preview(showBackground = true)
@Composable
fun LeatherBootsScreenPreview() {
    Challenge2Theme {
        LeatherBootsScreen()
    }
}
