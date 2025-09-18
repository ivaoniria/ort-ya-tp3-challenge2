package com.ort.challenge2.ui.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Estado que contiene y maneja la navegación para toda la aplicación
 */
class AppNavigationState(
    val navController: NavHostController,
    val drawerState: DrawerState,
    private val coroutineScope: CoroutineScope,
    private val startDestination: String
) {
    // Ruta actual
    var currentScreen: NavigationRoutes by mutableStateOf(NavigationRoutes.fromRoute(startDestination))
        private set

    // Actualizar la pantalla actual basado en la ruta
    fun updateCurrentScreen(route: String) {
        currentScreen = NavigationRoutes.fromRoute(route)
    }

    // Navegar a una pantalla
    fun navigateTo(screen: NavigationRoutes) {
        navController.navigate(screen.route) {
            popUpTo(startDestination) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
        updateCurrentScreen(screen.route)
        closeDrawer()
    }

    // Abrir drawer
    fun openDrawer() {
        coroutineScope.launch {
            drawerState.open()
        }
    }

    // Cerrar drawer
    fun closeDrawer() {
        coroutineScope.launch {
            drawerState.close()
        }
    }
}

@Composable
fun rememberAppNavigationState(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    startDestination: String = NavigationRoutes.ShopList.route
): AppNavigationState {

    val navigationState = remember(navController, drawerState, coroutineScope, startDestination) {
        AppNavigationState(
            navController = navController,
            drawerState = drawerState,
            coroutineScope = coroutineScope,
            startDestination = startDestination
        )
    }

    // Actualizar la pantalla actual cuando cambia la navegación
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (currentRoute != null && currentRoute != navigationState.currentScreen.route) {
        navigationState.updateCurrentScreen(currentRoute)
    }

    return navigationState
}
