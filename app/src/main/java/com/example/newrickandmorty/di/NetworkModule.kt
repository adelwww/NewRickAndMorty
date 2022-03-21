package com.example.newrickandmorty.di

import com.example.newrickandmorty.data.remote.apiservices.CharacterApi
import com.example.newrickandmorty.data.remote.apiservices.EpisodeApi
import com.example.newrickandmorty.data.remote.apiservices.LocationApi
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
    fun providesCharacterApi(): CharacterApi =
        retrofit.provideCharacterApiService()

    @Provides
    @Singleton
    fun providesEpisodeApi(): EpisodeApi =
        retrofit.provideEpisodeApiService()

    @Provides
    @Singleton
    fun providesLocationApi(): LocationApi =
        retrofit.provideLocationApiService()

}