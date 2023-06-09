package ru.nikitabulavin.jetwallpapers.feature_categories.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import ru.nikitabulavin.jetwallpapers.core.presentation.navigation.Screen
import ru.nikitabulavin.jetwallpapers.feature_categories.presentation.components.CategoryCard

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
fun CategoriesScreen(
    viewModel: CategoriesViewModel = hiltViewModel(),
    innerPadding: PaddingValues,
    navController: NavController
) {

    val categories by viewModel.categories.collectAsStateWithLifecycle()

    LazyVerticalStaggeredGrid(
        modifier = Modifier
            .systemBarsPadding()
            .statusBarsPadding()
            .padding(start = 16.dp, end = 16.dp, top = 64.dp, bottom = 80.dp),
        columns = StaggeredGridCells.Adaptive(150.dp),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) {category ->
            CategoryCard(
                category = category,
                navigateToPhotos = {
                    navController.navigate("${Screen.Photos.route}/${category.id}")
                }
            )
        }
    }
}