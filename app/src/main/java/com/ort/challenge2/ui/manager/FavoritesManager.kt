package com.ort.challenge2.ui.manager

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ort.challenge2.R
import com.ort.challenge2.ui.model.Product

/**
 * Administrador de estado para la lista de favoritos
 */
object FavoritesManager {
    // Lista mutable de productos favoritos
    private val _favorites = mutableStateListOf<Product>()

    // Lista expuesta como solo lectura para UI
    val favorites: SnapshotStateList<Product> = _favorites

    /**
     * Obtiene la lista de productos de ejemplo con strings resueltas desde contexto
     */
    fun getSampleProducts(context: Context): List<Product> {
        val title = context.getString(R.string.sample_product_title)
        val price = context.getString(R.string.sample_product_price)
        val description = context.getString(R.string.sample_product_description)

        return listOf(
            Product(
                id = 1,
                title = title,
                price = price,
                description = description,
                imageResId = R.drawable.product
            ),
            Product(
                id = 2,
                title = title,
                price = price,
                description = description,
                imageResId = R.drawable.product
            ),
            Product(
                id = 3,
                title = title,
                price = price,
                description = description,
                imageResId = R.drawable.product
            )
        )
    }

    fun addToFavorites(product: Product) {
        if (!_favorites.contains(product)) {
            _favorites.add(product)
        }
    }

    fun removeFromFavorites(product: Product) {
        _favorites.remove(product)
    }

    fun isInFavorites(product: Product): Boolean {
        return _favorites.contains(product)
    }
}
