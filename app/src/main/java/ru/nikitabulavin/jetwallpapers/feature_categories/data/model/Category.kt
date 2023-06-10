package ru.nikitabulavin.jetwallpapers.feature_categories.data.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Category(
    val cover_photo: CoverPhoto,
    val id: String,
    val preview_photos: List<PreviewPhoto>,
    val title: String,
    val total_photos: Int,
)