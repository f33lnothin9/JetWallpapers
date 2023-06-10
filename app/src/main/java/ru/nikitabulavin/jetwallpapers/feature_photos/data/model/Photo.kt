package ru.nikitabulavin.jetwallpapers.feature_photos.data.model

import kotlinx.serialization.Serializable
import ru.nikitabulavin.jetwallpapers.feature_categories.data.model.Urls

@Serializable
data class Photo(
    val id: String? = null,
    val links: Links? = null,
    val urls: Urls? = null
)