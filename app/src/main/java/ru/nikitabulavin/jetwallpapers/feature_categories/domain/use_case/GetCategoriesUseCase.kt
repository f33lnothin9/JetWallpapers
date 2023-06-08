package ru.nikitabulavin.jetwallpapers.feature_categories.domain.use_case

import ru.nikitabulavin.jetwallpapers.feature_categories.data.repository.CategoriesApiRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoriesApiRepository
) {

    suspend operator fun invoke() = repository.getCategories()
}