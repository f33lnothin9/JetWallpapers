package ru.nikitabulavin.jetwallpapers.feature_categories.data.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class CoverPhoto(
    val id: String,
    val urls: Urls,
)