package ru.nikitabulavin.jetwallpapers.core.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.nikitabulavin.jetwallpapers.feature_categories.presentation.CategoriesScreen

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
fun NavigationHost(navController: NavHostController, innerPadding: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = Screen.Categories.route
    ) {
        composable(route = Screen.Categories.route) {
            CategoriesScreen(
                innerPadding = innerPadding,
                navController = navController
            )
        }

        composable(route = Screen.Favorites.route) {

        }

        composable(route = Screen.Downloads.route) {

        }

        composable(route = Screen.Photos.route) {

        }

        composable(route = Screen.Photo.route) {

        }

        composable(route = Screen.Settings.route) {

        }
    }
}