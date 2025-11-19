package com.ort.challenge2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.challenge2.R
import com.ort.challenge2.ui.components.BottomNavigationBar
import com.ort.challenge2.ui.components.BuyButton
import com.ort.challenge2.ui.components.OrderListDialog
import com.ort.challenge2.ui.components.ShopTopBar
import com.ort.challenge2.ui.manager.FavoritesManager
import com.ort.challenge2.ui.model.Product
import com.ort.challenge2.ui.theme.Challenge2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouritesScreen(
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit = {},
    onBuyClick: (Product) -> Unit = {},
    onNavigateToMainLayout: () -> Unit = {},
    onNavigateToShop: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {},
    onShowChatPopup: () -> Unit = {}
) {
    var showOrderDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            ShopTopBar(
                titleResId = R.string.favourites,
                onMenuClick = onMenuClick,
                onProfileClick = onNavigateToProfile
            )
        },
        bottomBar = {
            BottomNavigationBar(selectedItem = 3, onItemSelected = { index ->
                when (index) {
                    0 -> onNavigateToMainLayout()
                    1 -> onNavigateToShop()
                    2 -> onShowChatPopup()
                    3 -> {}
                    4 -> onNavigateToProfile()
                }
            })
        },
        modifier = modifier
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFFFF5F5))
        ) {
            if (FavoritesManager.favorites.isEmpty()) {
                Text(
                    text = stringResource(R.string.no_favorites),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
                ) {
                    items(FavoritesManager.favorites) { product ->
                        FavoriteItemCard(
                            product = product,
                            onBuyClick = { onBuyClick(product) },
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(80.dp))
                    }
                }

                if (FavoritesManager.favorites.isNotEmpty()) {
                    BuyButton(
                        text = stringResource(id = R.string.buy),
                        onClick = { showOrderDialog = true },
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(16.dp)
                            .width(100.dp),
                        showPlusIcon = true
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
        },
        onBackClick = { showOrderDialog = false }
    )
}

@Composable
fun FavoriteItemCard(
    product: Product,
    modifier: Modifier = Modifier,
    onBuyClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF8B4513))
                    .padding(8.dp)
            ) {
                Text(
                    text = product.id.toString(),
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

            // Información del producto
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = product.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            // Imagen del producto
            Image(
                painter = painterResource(id = product.imageResId),
                contentDescription = product.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavouritesScreenPreview() {
    val context = androidx.compose.ui.platform.LocalContext.current
    Challenge2Theme {
        for (product in FavoritesManager.getSampleProducts(context)) {
            FavoritesManager.addToFavorites(product)
        }
        FavouritesScreen()
    }
}
