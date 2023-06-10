package ru.nikitabulavin.jetwallpapers.feature_photos.presentation.photo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import ru.nikitabulavin.jetwallpapers.feature_photos.presentation.components.PhotoCard

@ExperimentalMaterial3Api
@Composable
fun PhotoScreen(id: String, viewModel: PhotoViewModel = hiltViewModel(), navController: NavController) {

    viewModel.getPhoto(id)

    val photo by viewModel.photo.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Preview") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            actions = {
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Outlined.Download,
                        contentDescription = "Download"
                    )
                }
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorite"
                    )
                }
            }
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            PhotoCard(photo = photo)

            Button(
                onClick = {
                    coroutineScope.launch {
                        photo.urls?.let { viewModel.setWallpaper(context, it.full) }
                    }
                },
                modifier = Modifier
                    .padding(bottom = 60.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Text(text = "Set Wallpaper")
            }
        }
    }
}