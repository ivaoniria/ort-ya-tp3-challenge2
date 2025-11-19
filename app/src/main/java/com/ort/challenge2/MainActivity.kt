package com.ort.challenge2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ort.challenge2.ui.components.AppDrawer
import com.ort.challenge2.ui.navigation.AppNavGraph
import com.ort.challenge2.ui.navigation.rememberAppNavigationState
import com.ort.challenge2.ui.theme.Challenge2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Challenge2Theme {
                AppContent()
            }
        }
    }
}

@Composable
fun AppContent() {
    val navigationState = rememberAppNavigationState()

    ModalNavigationDrawer(
        drawerState = navigationState.drawerState,
        drawerContent = {
            AppDrawer(
                currentScreen = navigationState.currentScreen,
                onScreenSelected = { screen ->
                    navigationState.navigateTo(screen)
                },
                closeDrawer = {
                    navigationState.closeDrawer()
                }
            )
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            AppNavGraph(
                navController = navigationState.navController,
                modifier = Modifier.padding(innerPadding),
                onMenuClick = {
                    navigationState.openDrawer()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppContentPreview() {
    Challenge2Theme {
        AppContent()
    }
}
