package com.ort.challenge2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.challenge2.R
import com.ort.challenge2.ui.theme.ShopAppTheme

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    title: String,
    price: String,
    description: String,
    imageResId: Int,
    onFavouriteClick: () -> Unit,
    onBuyClick: () -> Unit,
    isFavorite: Boolean = false
) {
    var showAddToFavouritesDialog by remember { mutableStateOf(false) }

    if (showAddToFavouritesDialog) {
        AddedToFavouritesDialog(
            showDialog = true,
            onDismiss = {
                showAddToFavouritesDialog = false
            },
            onConfirm = {
                onFavouriteClick()
                showAddToFavouritesDialog = false
            }
        )
    }

    Card(
        modifier = modifier
            .padding(12.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Column(modifier = Modifier.padding(12.dp)) {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                Text(text = price, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = description, style = MaterialTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedActionButton(
                        text = if (isFavorite) stringResource(R.string.added_to_favorites) else stringResource(id = R.string.add_to_favourite),
                        onClick = {
                            if (!isFavorite) {
                                showAddToFavouritesDialog = true
                            }
                        },
                        modifier = Modifier.weight(1f)
                    )

                    BuyButton(
                        text = stringResource(id = R.string.buy),
                        onClick = onBuyClick,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductCard() {
    ShopAppTheme {
        ProductCard(
            title = stringResource(id = R.string.product_title),
            price = stringResource(id = R.string.product_price),
            description = stringResource(id = R.string.product_description),
            imageResId = R.drawable.product,
            onFavouriteClick = {},
            onBuyClick = {}
        )
    }
}
