package ru.nikitabulavin.jetwallpapers.feature_photos.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.nikitabulavin.jetwallpapers.feature_photos.data.remote.PhotosApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PhotosModule {

    @Provides
    @Singleton
    fun providePhotosApi(retrofit: Retrofit): PhotosApi =
        retrofit.create(PhotosApi::class.java)
}