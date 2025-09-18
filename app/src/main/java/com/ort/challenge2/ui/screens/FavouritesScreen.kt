package com.ort.challenge2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
    // Estado para controlar la visibilidad del diálogo
    var showOrderDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            ShopTopBar(
                titleResId = R.string.favourites,
                onMenuClick = onMenuClick,
                onProfileClick = onNavigateToProfile // Redirige a ProfileScreen
            )
        },
        bottomBar = {
            BottomNavigationBar(selectedItem = 3, onItemSelected = { index ->
                when (index) {
                    0 -> onNavigateToMainLayout() // Botón 1: MainLayoutScreen
                    1 -> onNavigateToShop() // Botón 2: ShopListScreen
                    2 -> onShowChatPopup() // Botón 3: Muestra el popup de Chat
                    3 -> {} // Ya estamos en FavouritesScreen
                    4 -> onNavigateToProfile() // Botón 5: ProfileScreen
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
                // Mostrar mensaje si no hay favoritos
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
                // Mostrar la lista de favoritos
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

                    // Espacio extra al final para que el botón flotante no tape ningún elemento
                    item {
                        Spacer(modifier = Modifier.height(80.dp))
                    }
                }

                // Si hay favoritos, mostrar el botón de comprar con el signo +
                if (FavoritesManager.favorites.isNotEmpty()) {
                    BuyButton(
                        text = stringResource(id = R.string.buy),
                        onClick = { showOrderDialog = true },
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(16.dp)
                            .width(100.dp),
                        showPlusIcon = true // Mostrar el signo +
                    )
                }
            }
        }
    }

    // Mostrar el diálogo de Order List cuando se hace clic en Buy
    OrderListDialog(
        showDialog = showOrderDialog,
        onDismiss = { showOrderDialog = false },
        onBuyClick = {
            // Procesar la compra y cerrar el diálogo
            showOrderDialog = false
            // Aquí podrías implementar la lógica adicional de compra
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
            // Número de orden en un círculo
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
    Challenge2Theme {
        // Añadir productos de ejemplo para la previsualización
        for (product in FavoritesManager.sampleProducts) {
            FavoritesManager.addToFavorites(product)
        }
        FavouritesScreen()
    }
}
