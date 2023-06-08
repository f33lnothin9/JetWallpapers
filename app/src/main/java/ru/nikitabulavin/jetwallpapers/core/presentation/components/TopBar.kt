package ru.nikitabulavin.jetwallpapers.core.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.nikitabulavin.jetwallpapers.core.presentation.navigation.NavBar

@ExperimentalMaterial3Api
@Composable
fun TopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    navController: NavController,
    navigateToSettings: () -> Unit
) {
    val screens = listOf(
        NavBar.Categories,
        NavBar.Favorites,
        NavBar.Downloads,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val topBarDestination = screens.any { it.route == currentDestination?.route }

    if (topBarDestination) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    "JetWallpapers",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            actions = {
                IconButton(onClick = { navigateToSettings() }) {
                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = "Account"
                    )
                }
            },
            scrollBehavior = scrollBehavior
        )
    }
}