package com.ort.challenge2.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ort.challenge2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopTopBar(
    titleResId: Int,
    onMenuClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    TopAppBar(
        title = { Text(stringResource(id = titleResId)) },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(Icons.Default.Menu, contentDescription = stringResource(R.string.menu))
            }
        },
        actions = {
            IconButton(onClick = onProfileClick) {
                Icon(
                    painter = painterResource(id = R.drawable.trailing_icon),
                    contentDescription = stringResource(R.string.profile),
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    )
}
