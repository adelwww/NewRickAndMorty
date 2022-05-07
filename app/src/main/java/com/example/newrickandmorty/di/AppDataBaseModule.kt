package com.example.newrickandmorty.di

import android.content.Context
import com.example.newrickandmorty.data.local.db.AppDataBase
import com.example.newrickandmorty.data.local.db.RoomClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDataBaseModule {

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context) =
        RoomClient().provideCreateAppDataBase(context)

    @Singleton
    @Provides
    fun provideCharacterDao(appDataBase: AppDataBase) =
        RoomClient().provideCharacterDao(appDataBase)

    @Singleton
    @Provides
    fun provideEpisodeDao(appDataBase: AppDataBase) =
        RoomClient().provideEpisodeDao(appDataBase)

    @Singleton
    @Provides
    fun provideLocationDao(appDataBase: AppDataBase) =
        RoomClient().provideLocationDao(appDataBase)
}