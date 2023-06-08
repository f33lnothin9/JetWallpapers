package ru.nikitabulavin.jetwallpapers.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.nikitabulavin.jetwallpapers.core.presentation.ui.theme.JetWallpapersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetWallpapersTheme {

            }
        }
    }
}