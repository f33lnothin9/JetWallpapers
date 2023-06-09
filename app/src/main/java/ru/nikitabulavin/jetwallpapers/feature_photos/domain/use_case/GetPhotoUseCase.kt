package ru.nikitabulavin.jetwallpapers.feature_photos.domain.use_case

import ru.nikitabulavin.jetwallpapers.feature_photos.data.repository.PhotosApiRepository
import javax.inject.Inject

class GetPhotoUseCase @Inject constructor(
    private val repository: PhotosApiRepository
) {

    suspend operator fun invoke(id: String) = repository.getPhoto(id)
}