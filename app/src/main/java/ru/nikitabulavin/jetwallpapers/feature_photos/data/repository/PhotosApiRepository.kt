package ru.nikitabulavin.jetwallpapers.feature_photos.data.repository

import ru.nikitabulavin.jetwallpapers.feature_photos.data.remote.PhotosApi
import javax.inject.Inject

class PhotosApiRepository @Inject constructor(
    private val apiRepository: PhotosApi
) {

    suspend fun getPhotos(id: String) = apiRepository.getPhotos(id)

    suspend fun getPhoto(id: String) = apiRepository.getPhoto(id)
}