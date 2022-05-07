package com.example.newrickandmorty.data.local.db

import android.content.Context
import androidx.room.Room
import com.example.newrickandmorty.data.local.db.daos.CharacterDao
import com.example.newrickandmorty.data.local.db.daos.EpisodesDao
import com.example.newrickandmorty.data.local.db.daos.LocationDao

class RoomClient {

    fun provideCreateAppDataBase(context: Context) = Room.databaseBuilder(
        context, AppDataBase::class.java, "dababase-rickandmorty.com")
        .fallbackToDestructiveMigration()
        .build()

    fun provideCharacterDao(appDataBase: AppDataBase): CharacterDao = appDataBase.characterDao()

    fun provideEpisodeDao(appDataBase: AppDataBase): EpisodesDao = appDataBase.episodeDao()

    fun provideLocationDao(appDataBase: AppDataBase): LocationDao = appDataBase.locationDao()
}