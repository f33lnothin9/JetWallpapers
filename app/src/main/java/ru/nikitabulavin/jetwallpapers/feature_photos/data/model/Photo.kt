package ru.nikitabulavin.jetwallpapers.feature_photos.data.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable
import ru.nikitabulavin.jetwallpapers.feature_categories.data.model.Urls

@Keep
@Serializable
data class Photo(
    val id: String? = null,
    val links: Links? = null,
    val urls: Urls? = null
)