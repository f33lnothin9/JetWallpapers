package ru.nikitabulavin.jetwallpapers.feature_categories.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ru.nikitabulavin.jetwallpapers.feature_categories.data.remote.CategoriesApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CategoriesModule {

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, okHttpClient: OkHttpClient): Retrofit {

        val contentType = "application/json".toMediaType()
        val json = Json {
            ignoreUnknownKeys = true
        }

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideCategoriesApi(retrofit: Retrofit): CategoriesApi =
        retrofit.create(CategoriesApi::class.java)
}