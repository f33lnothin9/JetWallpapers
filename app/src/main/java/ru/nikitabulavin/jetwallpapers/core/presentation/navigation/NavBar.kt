package ru.nikitabulavin.jetwallpapers.core.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavBar(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val iconActive: ImageVector
) {
    object Categories : NavBar(
        route = Screen.Categories.route,
        title = "Categories",
        icon = Icons.Outlined.Category,
        iconActive = Icons.Filled.Category
    )

    object Favorites : NavBar(
        route = Screen.Favorites.route,
        title = "Favorites",
        icon = Icons.Outlined.FavoriteBorder,
        iconActive = Icons.Filled.Favorite
    )

    object Downloads : NavBar(
        route = Screen.Downloads.route,
        title = "Downloads",
        icon = Icons.Outlined.Download,
        iconActive = Icons.Filled.Download
    )
}