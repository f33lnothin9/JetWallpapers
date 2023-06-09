package ru.nikitabulavin.jetwallpapers.feature_photos.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import ru.nikitabulavin.jetwallpapers.feature_photos.data.model.Photo

interface PhotosApi {

    @Headers("Authorization: Client-ID bR2wTHaS-MTlEXIX60Q11Hsp77LnbdrpI6K7Jmk9vOE")
    @GET("/collections/{id}/photos?page=1&per_page=25")
    suspend fun getPhotos(
        @Path("id") id: String
    ): Response<List<Photo>>

    @Headers("Authorization: Client-ID bR2wTHaS-MTlEXIX60Q11Hsp77LnbdrpI6K7Jmk9vOE")
    @GET("/photos/{id}")
    suspend fun getPhoto(
        @Path("id") id: String
    ): Response<Photo>
}