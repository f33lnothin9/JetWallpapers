package ru.nikitabulavin.jetwallpapers.feature_categories.data.repository

import ru.nikitabulavin.jetwallpapers.feature_categories.data.remote.CategoriesApi
import javax.inject.Inject

class CategoriesApiRepository @Inject constructor(
    private val apiRepository: CategoriesApi
) {

    suspend fun getCategories() = apiRepository.getCategories()
}