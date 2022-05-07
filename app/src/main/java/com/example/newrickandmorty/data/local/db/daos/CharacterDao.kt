package com.example.newrickandmorty.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newrickandmorty.data.remote.models.CharacterModel

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg characters: CharacterModel)

    @Query("SELECT * FROM character")
    suspend fun getAll() : List<CharacterModel>
}