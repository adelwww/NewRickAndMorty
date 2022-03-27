package com.example.newrickandmorty.di

import com.example.newrickandmorty.data.remote.apiservices.CharacterApiService
import com.example.newrickandmorty.data.remote.apiservices.EpisodeApiService
import com.example.newrickandmorty.data.remote.apiservices.LocationApiService
import com.example.newrickandmorty.data.remote.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    private val retrofit = RetrofitClient()

    @Provides
    @Singleton
    fun providesCharacterApi(): CharacterApiService =
        retrofit.provideCharacterApiService()

    @Provides
    @Singleton
    fun providesEpisodeApi(): EpisodeApiService =
        retrofit.provideEpisodeApiService()

    @Provides
    @Singleton
    fun providesLocationApi(): LocationApiService =
        retrofit.provideLocationApiService()


}