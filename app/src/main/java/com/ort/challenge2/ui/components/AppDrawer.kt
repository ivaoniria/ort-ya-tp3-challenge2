package com.ort.challenge2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.challenge2.R
import com.ort.challenge2.ui.navigation.NavigationRoutes

/**
 * Ítem del drawer con información avanzada como contadores
 */
@Composable
fun DrawerItemWithBadge(
    title: String,
    iconResId: Int,
    badgeCount: Int? = null,
    selected: Boolean = false,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = title,
                tint = Color.Unspecified,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(title)
        }

        badgeCount?.let {
            Text(
                text = it.toString(),
                fontSize = 14.sp
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawer(
    currentScreen: NavigationRoutes,
    onScreenSelected: (NavigationRoutes) -> Unit,
    closeDrawer: () -> Unit,
    favouritesCount: Int = 3
) {
    ModalDrawerSheet(
        modifier = Modifier.width(270.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Título
        Text(
            text = stringResource(R.string.drawer_title),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(16.dp)
        )

        // Sección header
        Text(
            text = stringResource(R.string.drawer_section_header),
            color = Color.Gray,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        // Shop list - usando NavigationDrawerItem estándar
        NavigationDrawerItem(
            label = { Text(text = NavigationRoutes.ShopList.title) },
            selected = currentScreen == NavigationRoutes.ShopList,
            onClick = {
                onScreenSelected(NavigationRoutes.ShopList)
                closeDrawer()
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.circ),
                    contentDescription = NavigationRoutes.ShopList.title,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
            },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    if (currentScreen == NavigationRoutes.ShopList) Color(0xFFFFE2DB) else MaterialTheme.colorScheme.surface
                )
        )

        // Favourites - usando nuestro componente personalizado
        DrawerItemWithBadge(
            title = NavigationRoutes.Favourites.title,
            iconResId = R.drawable.cua,
            badgeCount = favouritesCount,
            selected = currentScreen == NavigationRoutes.Favourites,
            onClick = {
                onScreenSelected(NavigationRoutes.Favourites)
                closeDrawer()
            }
        )

        // Profile
        NavigationDrawerItem(
            label = { Text(text = NavigationRoutes.Profile.title) },
            selected = currentScreen == NavigationRoutes.Profile,
            onClick = {
                onScreenSelected(NavigationRoutes.Profile)
                closeDrawer()
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.pent),
                    contentDescription = NavigationRoutes.Profile.title,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
            },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp)
        )

        // Settings
        NavigationDrawerItem(
            label = { Text(text = NavigationRoutes.Settings.title) },
            selected = currentScreen == NavigationRoutes.Settings,
            onClick = {
                onScreenSelected(NavigationRoutes.Settings)
                closeDrawer()
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.tri),
                    contentDescription = NavigationRoutes.Settings.title,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
            },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp)
        )
    }
}
