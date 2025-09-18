package com.ort.challenge2.ui.navigation

sealed class NavigationRoutes(val route: String, val title: String) {
    object MainLayout : NavigationRoutes("mainLayout", "Layout Principal")
    object ShopList : NavigationRoutes("shopList", "Shop list")
    object Favourites : NavigationRoutes("favourites", "Favourites")
    object Profile : NavigationRoutes("profile", "Profile")
    object Settings : NavigationRoutes("settings", "Settings")
    object ProductDetail : NavigationRoutes("productDetail", "Leather boots")

    companion object {
        fun fromRoute(route: String?): NavigationRoutes {
            return when (route) {
                MainLayout.route -> MainLayout
                ShopList.route -> ShopList
                Favourites.route -> Favourites
                Profile.route -> Profile
                Settings.route -> Settings
                ProductDetail.route -> ProductDetail
                else -> MainLayout // Cambio el default a MainLayout
            }
        }

        val allScreens = listOf(MainLayout, ShopList, Favourites, Profile, Settings, ProductDetail)
    }
}
