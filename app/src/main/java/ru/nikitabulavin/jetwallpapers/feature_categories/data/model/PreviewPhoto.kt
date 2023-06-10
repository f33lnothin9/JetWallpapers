package ru.nikitabulavin.jetwallpapers.feature_categories.data.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class PreviewPhoto(
    val id: String,
    val slug: String,
    val urls: Urls
)