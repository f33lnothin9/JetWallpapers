package ru.nikitabulavin.jetwallpapers.feature_photos.presentation.photo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import ru.nikitabulavin.jetwallpapers.feature_downloads.data.repository.DownloaderRepositoryImpl
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
                IconButton(
                    onClick = {
                        photo.links?.let { viewModel.downloadPhoto(context, it.download) }
                    }
                ) {
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

            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = 16.dp, end = 16.dp, bottom = 60.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            photo.urls?.let { viewModel.setWallpaper(context, it.full, 1) }
                        }
                    }
                ) {
                    Text(text = "Home & Lock")
                }

                Button(
                    onClick = {
                        coroutineScope.launch {
                            photo.urls?.let { viewModel.setWallpaper(context, it.full, 2) }
                        }
                    }
                ) {
                    Text(text = "Home")
                }

                Button(
                    onClick = {
                        coroutineScope.launch {
                            photo.urls?.let { viewModel.setWallpaper(context, it.full, 3) }
                        }
                    }
                ) {
                    Text(text = "Lock")
                }
            }
        }
    }
}