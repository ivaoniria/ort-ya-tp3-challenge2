package com.ort.challenge2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.challenge2.R
import com.ort.challenge2.ui.components.BottomNavigationBar
import com.ort.challenge2.ui.components.ProfileInputField
import com.ort.challenge2.ui.theme.Challenge2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onMenuClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    onNavigateToMainLayout: () -> Unit = {},
    onNavigateToShop: () -> Unit = {},
    onNavigateToFavourites: () -> Unit = {},
    onShowChatPopup: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var emailValue by remember { mutableStateOf("") }
    var phoneValue by remember { mutableStateOf("") }
    var websiteValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.profile),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = stringResource(R.string.back))
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.trailing_icon),
                            contentDescription = stringResource(R.string.profile),
                            modifier = Modifier.size(23.dp)
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(selectedItem = 4, onItemSelected = { index ->
                when (index) {
                    0 -> onNavigateToMainLayout()
                    1 -> onNavigateToShop()
                    2 -> onShowChatPopup()
                    3 -> onNavigateToFavourites()
                    4 -> {}
                }
            })
        },
        modifier = modifier
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFFFF5F5))
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            // Profile Image Section
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                // Profile Image
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = stringResource(R.string.profile),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(Color.Gray.copy(alpha = 0.3f))
                )

                // Edit Button (lapiz)
                Image(
                    painter = painterResource(id = R.drawable.lapiz),
                    contentDescription = "Edit",
                    modifier = Modifier.size(36.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Name and Title
            Text(
                text = stringResource(R.string.martin),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = stringResource(R.string.ux_ui_design),
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Input Fields
            ProfileInputField(
                label = stringResource(R.string.email_address),
                value = emailValue,
                placeholder = stringResource(R.string.email_placeholder),
                onValueChange = { emailValue = it },
                iconResId = R.drawable.user, // Usando user icon para email
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ProfileInputField(
                label = stringResource(R.string.phone_number),
                value = phoneValue,
                placeholder = stringResource(R.string.phone_placeholder),
                onValueChange = { phoneValue = it },
                iconResId = R.drawable.home,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ProfileInputField(
                label = stringResource(R.string.web_site),
                value = websiteValue,
                placeholder = stringResource(R.string.website_placeholder),
                onValueChange = { websiteValue = it },
                iconResId = R.drawable.search,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ProfileInputField(
                label = stringResource(R.string.password),
                value = passwordValue,
                placeholder = stringResource(R.string.password_placeholder),
                onValueChange = { passwordValue = it },
                iconResId = R.drawable.bag,
                isPassword = true,
                modifier = Modifier.padding(bottom = 32.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    Challenge2Theme {
        ProfileScreen()
    }
}
