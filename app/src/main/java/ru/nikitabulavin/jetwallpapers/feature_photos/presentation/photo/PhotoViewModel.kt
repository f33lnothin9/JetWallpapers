package ru.nikitabulavin.jetwallpapers.feature_photos.presentation.photo

import android.app.WallpaperManager
import android.content.Context
import android.graphics.BitmapFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.nikitabulavin.jetwallpapers.feature_photos.data.model.Photo
import ru.nikitabulavin.jetwallpapers.feature_photos.domain.use_case.GetPhotoUseCase
import java.net.URL
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val getPhotoUseCase: GetPhotoUseCase
) : ViewModel() {

    private val _photo = MutableStateFlow(Photo())
    private val _isLoading = MutableStateFlow(true)
    private val _isError = MutableStateFlow(false)

    val photo = _photo.asStateFlow()
    val isLoading = _isLoading.asStateFlow()
    val isError = _isError.asStateFlow()

    fun getPhoto(id: String) {
        viewModelScope.launch {
            getPhotoUseCase.invoke(id).let {
                if (it.isSuccessful) {
                    _photo.value = it.body()!!
                    _isLoading.value = false
                } else {
                    _isError.value = true
                }
            }
        }
    }

    suspend fun setWallpaper(context: Context, url: String) {
        val wallpaperManager = WallpaperManager.getInstance(context)

        try {
            coroutineScope {
                val task = async(Dispatchers.IO) {

                    BitmapFactory.decodeStream(
                        URL(url)
                            .openConnection()
                            .getInputStream()
                    )
                }

                val bitmap = task.await()

                wallpaperManager.setBitmap(bitmap)
            }
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
    }
}