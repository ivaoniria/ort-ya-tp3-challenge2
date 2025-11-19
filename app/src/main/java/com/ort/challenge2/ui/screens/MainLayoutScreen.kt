package com.ort.challenge2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ort.challenge2.R
import com.ort.challenge2.ui.components.BottomNavigationBar
import com.ort.challenge2.ui.components.ShopTopBar
import com.ort.challenge2.ui.theme.Challenge2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayoutScreen(
    onMenuClick: () -> Unit = {},
    onNavigateToShop: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {},
    onNavigateToFavourites: () -> Unit = {},
    onShowChatPopup: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ShopTopBar(
                titleResId = R.string.title,
                onMenuClick = onMenuClick,
                onProfileClick = onNavigateToProfile
            )
        },
        bottomBar = {
            BottomNavigationBar(
                selectedItem = 0,
                onItemSelected = { index ->
                    when (index) {
                        0 -> {}
                        1 -> onNavigateToShop()
                        2 -> onShowChatPopup()
                        3 -> onNavigateToFavourites()
                        4 -> onNavigateToProfile()
                    }
                }
            )
        },
        modifier = modifier
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFFFF5F5)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.layout_principal),
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainLayoutScreenPreview() {
    Challenge2Theme {
        MainLayoutScreen()
    }
}
