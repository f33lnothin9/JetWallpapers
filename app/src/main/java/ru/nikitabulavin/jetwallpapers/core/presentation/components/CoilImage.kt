package ru.nikitabulavin.jetwallpapers.core.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size

@Composable
fun CoilImage(url: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(400)
            .size(Size.ORIGINAL)
            .transformations()
            .build(),
        contentDescription = "Image",
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
    )
}