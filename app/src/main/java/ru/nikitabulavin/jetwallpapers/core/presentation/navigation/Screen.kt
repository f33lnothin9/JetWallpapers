package ru.nikitabulavin.jetwallpapers.core.presentation.navigation

sealed class Screen(val route: String) {
    object Categories: Screen(route = "categories_screen")
    object Photos: Screen(route = "photos_screen")
    object Photo: Screen(route = "photo_screen")
    object Favorites: Screen(route = "favorites_screen")
    object Settings: Screen(route = "settings_screen")
}