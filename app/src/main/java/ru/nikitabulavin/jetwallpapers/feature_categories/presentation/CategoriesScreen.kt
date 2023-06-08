package ru.nikitabulavin.jetwallpapers.feature_categories.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CategoriesScreen(viewModel: CategoriesViewModel = hiltViewModel()) {

    val categories by viewModel.categories.collectAsStateWithLifecycle()

    LazyColumn() {
        items(categories) {category ->
            Text(text = category.title)
        }
    }
}