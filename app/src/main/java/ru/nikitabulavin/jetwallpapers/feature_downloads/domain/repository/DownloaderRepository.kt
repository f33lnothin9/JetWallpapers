package ru.nikitabulavin.jetwallpapers.feature_downloads.domain.repository

interface DownloaderRepository {

    fun downloadPhoto(url: String): Long
}