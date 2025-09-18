package com.ort.challenge2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ort.challenge2.R
import com.ort.challenge2.ui.components.BottomNavigationBar
import com.ort.challenge2.ui.components.SettingsArrowItem
import com.ort.challenge2.ui.components.SettingsSectionTitle
import com.ort.challenge2.ui.components.SettingsSwitchItem
import com.ort.challenge2.ui.components.ShopTopBar
import com.ort.challenge2.ui.theme.Challenge2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onMenuClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var pushNotificationsEnabled by remember { mutableStateOf(true) }
    var darkModeEnabled by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            ShopTopBar(
                titleResId = R.string.settings,
                onMenuClick = onMenuClick,
                onProfileClick = {}
            )
        },
        bottomBar = {
            BottomNavigationBar(selectedItem = 0, onItemSelected = {})
        },
        modifier = modifier
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFFFF5F5))
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Account Settings Section
            SettingsSectionTitle(title = stringResource(R.string.account_settings))

            SettingsArrowItem(
                title = stringResource(R.string.edit_profile),
                onClick = { /* Navegar a editar perfil */ }
            )

            SettingsArrowItem(
                title = stringResource(R.string.change_password),
                onClick = { /* Navegar a cambiar contraseña */ }
            )

            // Settings con switches
            SettingsSwitchItem(
                title = stringResource(R.string.push_notifications),
                isChecked = pushNotificationsEnabled,
                onCheckedChange = { pushNotificationsEnabled = it }
            )

            SettingsSwitchItem(
                title = stringResource(R.string.dark_mode),
                isChecked = darkModeEnabled,
                onCheckedChange = { darkModeEnabled = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // More Section
            SettingsSectionTitle(title = stringResource(R.string.more))

            SettingsArrowItem(
                title = stringResource(R.string.about_us),
                onClick = { /* Navegar a About us */ }
            )

            SettingsArrowItem(
                title = stringResource(R.string.privacy_policy),
                onClick = { /* Navegar a Privacy policy */ }
            )

            SettingsArrowItem(
                title = stringResource(R.string.terms_and_conditions),
                onClick = { /* Navegar a Terms and conditions */ }
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    Challenge2Theme {
        SettingsScreen()
    }
}
