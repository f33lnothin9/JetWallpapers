package ru.nikitabulavin.jetwallpapers.feature_categories.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PreviewPhoto(
    val id: String,
    val slug: String,
    val urls: Urls
)