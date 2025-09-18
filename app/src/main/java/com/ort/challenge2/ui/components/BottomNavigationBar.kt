package com.ort.challenge2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.challenge2.R
import com.ort.challenge2.ui.theme.ShopAppTheme
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavigationBar(selectedItem: Int, onItemSelected: (Int) -> Unit) {
    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Gray,
    ) {
        val items = listOf(
            Pair(R.drawable.home, stringResource(R.string.nav_product)), // Ir a MainLayoutScreen
            Pair(R.drawable.search, stringResource(R.string.nav_search)), // Ir a ShopListScreen
            Pair(R.drawable.shop, stringResource(R.string.nav_shop)),     // Mostrar ChatManagerDialog
            Pair(R.drawable.bag, stringResource(R.string.nav_cart)),      // Ir a FavouritesScreen
            Pair(R.drawable.user, stringResource(R.string.nav_profile))   // Ir a ProfileScreen
        )

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = { onItemSelected(index) },
                icon = {
                    Image(
                        painter = painterResource(item.first),
                        contentDescription = item.second,
                        modifier = if (item.first == R.drawable.shop) {
                            Modifier.size(55.dp) // Tamaño especial solo para Shop
                        } else {
                            Modifier.size(23.dp) // Tamaño para todos los demás
                        }
                    )
                },
                label = if (item.first == R.drawable.shop) {
                    { }
                } else {
                    { Text(item.second) }
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewBottomNavigationBar() {
    ShopAppTheme {
        BottomNavigationBar(selectedItem = 0, onItemSelected = {})
    }
}
