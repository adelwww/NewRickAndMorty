package com.example.newrickandmorty.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newrickandmorty.data.remote.models.EpisodesModel

@Dao
interface EpisodesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllEpisodes(vararg episodes: EpisodesModel)

    @Query("SELECT * FROM episode")
    suspend fun getAllEpisodes() : List<EpisodesModel>

}