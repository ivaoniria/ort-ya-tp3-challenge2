package com.ort.challenge2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ort.challenge2.ui.components.ChatWithManagerDialog
import com.ort.challenge2.ui.model.Product
import com.ort.challenge2.ui.screens.FavouritesScreen
import com.ort.challenge2.ui.screens.LeatherBootsScreen
import com.ort.challenge2.ui.screens.MainLayoutScreen
import com.ort.challenge2.ui.screens.ProfileScreen
import com.ort.challenge2.ui.screens.SettingsScreen
import com.ort.challenge2.ui.screens.ShopListScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit
) {
    var showChatDialog by remember { mutableStateOf(false) }

    if (showChatDialog) {
        ChatWithManagerDialog(
            showDialog = true,
            onDismiss = { showChatDialog = false }
        )
    }

    val showChat = {
        showChatDialog = true
    }

    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.MainLayout.route,
        modifier = modifier
    ) {
        composable(NavigationRoutes.MainLayout.route) {
            MainLayoutScreen(
                onMenuClick = onMenuClick,
                onNavigateToShop = {
                    navController.navigate(NavigationRoutes.ShopList.route)
                },
                onNavigateToProfile = {
                    navController.navigate(NavigationRoutes.Profile.route)
                },
                onNavigateToFavourites = {
                    navController.navigate(NavigationRoutes.Favourites.route)
                },
                onShowChatPopup = showChat
            )
        }

        // ShopListScreen
        composable(NavigationRoutes.ShopList.route) {
            ShopListScreen(
                onMenuClick = onMenuClick,
                onBuyClick = {
                    navController.navigate(NavigationRoutes.ProductDetail.route)
                },
                onNavigateToMainLayout = {
                    navController.navigate(NavigationRoutes.MainLayout.route)
                },
                onNavigateToProfile = {
                    navController.navigate(NavigationRoutes.Profile.route)
                },
                onNavigateToFavourites = {
                    navController.navigate(NavigationRoutes.Favourites.route)
                },
                onShowChatPopup = showChat
            )
        }

        // Favourites
        composable(NavigationRoutes.Favourites.route) {
            FavouritesScreen(
                onMenuClick = onMenuClick,
                onBuyClick = { product: Product ->
                    navController.navigate(NavigationRoutes.ProductDetail.route)
                },
                onNavigateToMainLayout = {
                    navController.navigate(NavigationRoutes.MainLayout.route)
                },
                onNavigateToShop = {
                    navController.navigate(NavigationRoutes.ShopList.route)
                },
                onNavigateToProfile = {
                    navController.navigate(NavigationRoutes.Profile.route)
                },
                onShowChatPopup = showChat
            )
        }

        // ProductDetail
        composable(NavigationRoutes.ProductDetail.route) {
            LeatherBootsScreen(
                onMenuClick = onMenuClick,
                onBackClick = {
                    navController.popBackStack()
                },
                onBuyClick = {
                    navController.popBackStack()
                }
            )
        }

        // Profile
        composable(NavigationRoutes.Profile.route) {
            ProfileScreen(
                onMenuClick = onMenuClick,
                onBackClick = {
                    navController.popBackStack()
                },
                onNavigateToMainLayout = {
                    navController.navigate(NavigationRoutes.MainLayout.route)
                },
                onNavigateToShop = {
                    navController.navigate(NavigationRoutes.ShopList.route)
                },
                onNavigateToFavourites = {
                    navController.navigate(NavigationRoutes.Favourites.route)
                },
                onShowChatPopup = showChat
            )
        }

        // Settings
        composable(NavigationRoutes.Settings.route) {
            SettingsScreen(
                onMenuClick = onMenuClick
            )
        }
    }
}
