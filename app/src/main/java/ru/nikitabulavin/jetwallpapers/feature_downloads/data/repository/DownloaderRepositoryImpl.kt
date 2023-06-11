package ru.nikitabulavin.jetwallpapers.feature_downloads.data.repository

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri
import ru.nikitabulavin.jetwallpapers.feature_downloads.domain.repository.DownloaderRepository

class DownloaderRepositoryImpl(
    private val context: Context
) : DownloaderRepository {

    private val downloadManager = context.getSystemService(DownloadManager::class.java)

    override fun downloadPhoto(url: String): Long {
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("wallpaper/jpeg")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle("wallpaper.jpg")
            .addRequestHeader("Authorization", "Client-ID bR2wTHaS-MTlEXIX60Q11Hsp77LnbdrpI6K7Jmk9vOE")
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, "wallpaper.jpg")
        return downloadManager.enqueue(request)
    }
}