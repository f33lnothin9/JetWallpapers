package ru.nikitabulavin.jetwallpapers.feature_categories.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.nikitabulavin.jetwallpapers.feature_categories.data.model.Category
import ru.nikitabulavin.jetwallpapers.feature_categories.domain.use_case.GetCategoriesUseCase
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _categories = MutableStateFlow(emptyList<Category>())
    private val _isLoading = MutableStateFlow(true)
    private val _isError = MutableStateFlow(false)

    val categories = _categories.asStateFlow()
    val isLoading = _isLoading.asStateFlow()
    val isError = _isError.asStateFlow()

    init {
        viewModelScope.launch {
            getCategoriesUseCase.invoke().let {
                if (it.isSuccessful) {
                    _categories.value = it.body()!!
                    _isLoading.value = false
                } else {
                    _isError.value = true
                }
            }
        }
    }
}