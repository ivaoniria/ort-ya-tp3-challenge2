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
    var currentScreen: NavigationRoutes by mutableStateOf(NavigationRoutes.fromRoute(startDestination))
        private set

    fun updateCurrentScreen(route: String) {
        currentScreen = NavigationRoutes.fromRoute(route)
    }

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

    fun openDrawer() {
        coroutineScope.launch {
            drawerState.open()
        }
    }

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

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (currentRoute != null && currentRoute != navigationState.currentScreen.route) {
        navigationState.updateCurrentScreen(currentRoute)
    }

    return navigationState
}
