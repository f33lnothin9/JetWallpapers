package ru.nikitabulavin.jetwallpapers.feature_categories.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.nikitabulavin.jetwallpapers.core.presentation.components.CoilImage
import ru.nikitabulavin.jetwallpapers.core.presentation.ui.theme.Typography
import ru.nikitabulavin.jetwallpapers.feature_categories.data.model.Category

@ExperimentalMaterial3Api
@Composable
fun CategoryCard(
    category: Category,
    navigateToPhotos: () -> Unit
) {

    Card(
        onClick = navigateToPhotos
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            CoilImage(url = category.cover_photo.urls.regular)

            Text(
                text = category.title,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 4.dp),
                style = Typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "${category.total_photos} photos",
                modifier = Modifier.padding(start = 16.dp, bottom = 16.dp, end = 16.dp),
                style = Typography.bodyMedium
            )
        }
    }
}