package ru.nikitabulavin.jetwallpapers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.nikitabulavin.jetwallpapers.ui.theme.JetWallpapersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetWallpapersTheme {

            }
        }
    }
}