package com.example.newrickandmorty.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newrickandmorty.data.remote.models.LocationModel

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLocations(vararg locations: LocationModel)

    @Query("SELECT * FROM location")
    suspend fun getAllLocations() : List<LocationModel>

}