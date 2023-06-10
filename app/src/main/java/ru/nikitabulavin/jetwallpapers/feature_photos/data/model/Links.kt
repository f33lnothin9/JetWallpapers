package ru.nikitabulavin.jetwallpapers.feature_photos.data.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Links(
    val download: String,
    val download_location: String,
    val html: String,
    val self: String
)