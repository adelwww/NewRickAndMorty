package com.example.newrickandmorty.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newrickandmorty.data.local.db.daos.CharacterDao
import com.example.newrickandmorty.data.local.db.daos.EpisodesDao
import com.example.newrickandmorty.data.local.db.daos.LocationDao
import com.example.newrickandmorty.data.remote.models.CharacterModel
import com.example.newrickandmorty.data.remote.models.EpisodesModel
import com.example.newrickandmorty.data.remote.models.LocationModel

@Database(entities = [CharacterModel::class, EpisodesModel::class, LocationModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    abstract fun episodeDao(): EpisodesDao

    abstract fun locationDao(): LocationDao
}