package ru.nikitabulavin.jetwallpapers.feature_photos.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import ru.nikitabulavin.jetwallpapers.core.presentation.navigation.Screen
import ru.nikitabulavin.jetwallpapers.feature_photos.presentation.components.PhotoCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun PhotosScreen(
    id: String,
    navController: NavController,
    viewModel: PhotosViewModel = hiltViewModel()
) {

    viewModel.getPhotos(id)

    val photos by viewModel.photos.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Photos") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .statusBarsPadding()
                .padding(start = 16.dp, end = 16.dp, top = 64.dp),
            columns = StaggeredGridCells.Adaptive(140.dp),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(photos) {photo ->

                PhotoCard(
                    photo = photo,
                    navigateToPhoto = {
                        navController.navigate("${Screen.Photo.route}/${photo.id}")
                    }
                )
            }
        }
    }
}