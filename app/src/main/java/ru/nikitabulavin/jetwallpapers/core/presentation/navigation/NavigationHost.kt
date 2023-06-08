package ru.nikitabulavin.jetwallpapers.core.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.nikitabulavin.jetwallpapers.feature_categories.presentation.CategoriesScreen

@Composable
fun NavigationHost(navController: NavHostController, innerPadding: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = Screen.Categories.route
    ) {
        composable(route = Screen.Categories.route) {
            CategoriesScreen()
        }

        composable(route = Screen.Photos.route) {

        }

        composable(route = Screen.Photo.route) {

        }

        composable(route = Screen.Favorites.route) {

        }

        composable(route = Screen.Downloads.route) {

        }

        composable(route = Screen.Settings.route) {

        }
    }
}