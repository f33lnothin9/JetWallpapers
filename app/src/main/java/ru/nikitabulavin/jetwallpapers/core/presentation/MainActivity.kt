package ru.nikitabulavin.jetwallpapers.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.nikitabulavin.jetwallpapers.core.presentation.components.BottomBar
import ru.nikitabulavin.jetwallpapers.core.presentation.components.TopBar
import ru.nikitabulavin.jetwallpapers.core.presentation.navigation.NavigationHost
import ru.nikitabulavin.jetwallpapers.core.presentation.ui.theme.JetWallpapersTheme

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            JetWallpapersTheme {

                val navController = rememberNavController()
                val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

                Scaffold(
                    topBar = {
                        TopBar(
                            scrollBehavior = scrollBehavior,
                            navController = navController,
                            navigateToSettings = {

                            }
                        )
                    },
                    bottomBar = {
                        BottomBar(navController = navController)
                    }
                ) { innerPadding ->
                    NavigationHost(
                        navController = navController,
                        innerPadding = innerPadding
                    )
                }
            }
        }
    }
}