package com.ort.challenge2.ui.manager

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

    // Lista de productos de ejemplo
    val sampleProducts = listOf(
        Product(
            id = 1,
            title = "Leather boots", // Se mantiene aquí porque es data de ejemplo
            price = "27,5 $",        // Se mantiene aquí porque es data de ejemplo
            description = "Great warm shoes from the artificial leather. You can buy this model only in our shop", // Se mantiene aquí porque es data de ejemplo
            imageResId = R.drawable.product
        ),
        Product(
            id = 2,
            title = "Leather boots", // Se mantiene aquí porque es data de ejemplo
            price = "27,5 $",        // Se mantiene aquí porque es data de ejemplo
            description = "Great warm shoes from the artificial leather. You can buy this model only in our shop", // Se mantiene aquí porque es data de ejemplo
            imageResId = R.drawable.product
        ),
        Product(
            id = 3,
            title = "Leather boots", // Se mantiene aquí porque es data de ejemplo
            price = "27,5 $",        // Se mantiene aquí porque es data de ejemplo
            description = "Great warm shoes from the artificial leather. You can buy this model only in our shop", // Se mantiene aquí porque es data de ejemplo
            imageResId = R.drawable.product
        )
    )

    // Añadir un producto a favoritos
    fun addToFavorites(product: Product) {
        if (!_favorites.contains(product)) {
            _favorites.add(product)
        }
    }

    // Eliminar un producto de favoritos
    fun removeFromFavorites(product: Product) {
        _favorites.remove(product)
    }

    // Comprobar si un producto está en favoritos
    fun isInFavorites(product: Product): Boolean {
        return _favorites.contains(product)
    }
}
