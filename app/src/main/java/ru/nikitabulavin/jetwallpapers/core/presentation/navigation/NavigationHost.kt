package ru.nikitabulavin.jetwallpapers.core.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.nikitabulavin.jetwallpapers.feature_categories.presentation.CategoriesScreen
import ru.nikitabulavin.jetwallpapers.feature_photos.presentation.PhotosScreen
import ru.nikitabulavin.jetwallpapers.feature_photos.presentation.photo.PhotoScreen

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

        composable(
            route = Screen.Photos.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )
        ) {
            val id = remember {
                it.arguments?.getString("id")
            }

            id?.let { PhotosScreen(id = it, navController = navController) }
        }

        composable(
            route = Screen.Photo.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )
        ) {
            val id = remember {
                it.arguments?.getString("id")
            }

            id?.let { PhotoScreen(id = it, navController = navController) }
        }

        composable(route = Screen.Settings.route) {

        }
    }
}