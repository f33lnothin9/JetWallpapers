package ru.nikitabulavin.jetwallpapers.feature_photos.presentation.components

import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import ru.nikitabulavin.jetwallpapers.core.presentation.components.CoilImage
import ru.nikitabulavin.jetwallpapers.feature_photos.data.model.Photo

@ExperimentalMaterial3Api
@Composable
fun PhotoCard(
    photo: Photo,
    navigateToPhoto: () -> Unit = {}
) {

    Card(
        onClick = navigateToPhoto
    ) {
        photo.urls?.let { CoilImage(url = it.regular) }
    }
}