package com.ort.challenge2.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.ort.challenge2.R
import com.ort.challenge2.ui.components.BottomNavigationBar
import com.ort.challenge2.ui.components.ProductCard
import com.ort.challenge2.ui.components.ShopTopBar
import com.ort.challenge2.ui.manager.FavoritesManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopListScreen(
    onMenuClick: () -> Unit = {},
    onBuyClick: () -> Unit = {},
    onNavigateToMainLayout: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {},
    onNavigateToFavourites: () -> Unit = {},
    onShowChatPopup: () -> Unit = {}
) {
    val context = LocalContext.current
    val products = FavoritesManager.getSampleProducts(context)

    Scaffold(
        topBar = {
            ShopTopBar(
                titleResId = R.string.shop_list,
                onMenuClick = onMenuClick,
                onProfileClick = onNavigateToProfile
            )
        },
        bottomBar = {
            BottomNavigationBar(selectedItem = 1, onItemSelected = { index ->
                when (index) {
                    0 -> onNavigateToMainLayout()
                    1 -> {}
                    2 -> onShowChatPopup()
                    3 -> onNavigateToFavourites()
                    4 -> onNavigateToProfile()
                }
            })
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(products) { product ->
                ProductCard(
                    title = product.title,
                    price = product.price,
                    description = product.description,
                    imageResId = product.imageResId,
                    onFavouriteClick = {
                        FavoritesManager.addToFavorites(product)
                    },
                    onBuyClick = onBuyClick,
                    isFavorite = FavoritesManager.isInFavorites(product)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShopListScreenPreview() {
    ShopListScreen()
}
