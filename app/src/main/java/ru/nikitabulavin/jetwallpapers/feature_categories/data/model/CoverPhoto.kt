package ru.nikitabulavin.jetwallpapers.feature_categories.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CoverPhoto(
    val id: String,
    val urls: Urls,
)