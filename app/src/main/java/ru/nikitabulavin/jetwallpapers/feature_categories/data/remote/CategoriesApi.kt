package ru.nikitabulavin.jetwallpapers.feature_categories.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import ru.nikitabulavin.jetwallpapers.feature_categories.data.model.Category

interface CategoriesApi {

    @Headers("Authorization: Client-ID bR2wTHaS-MTlEXIX60Q11Hsp77LnbdrpI6K7Jmk9vOE")
    @GET("/collections")
    suspend fun getCategories(): Response<Category>
}