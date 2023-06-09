package ru.nikitabulavin.jetwallpapers.feature_photos.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.nikitabulavin.jetwallpapers.feature_photos.data.model.Photo
import ru.nikitabulavin.jetwallpapers.feature_photos.domain.use_case.GetPhotosUseCase
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {

    private val _photos = MutableStateFlow(emptyList<Photo>())
    private val _isLoading = MutableStateFlow(true)
    private val _isError = MutableStateFlow(false)

    val photos = _photos.asStateFlow()
    val isLoading = _isLoading.asStateFlow()
    val isError = _isError.asStateFlow()

    fun getPhotos(id: String) {
        viewModelScope.launch {
            getPhotosUseCase.invoke(id).let {
                if (it.isSuccessful) {
                    _photos.value = it.body()!!
                    _isLoading.value = false
                } else {
                    _isError.value = true
                }
            }
        }
    }
}