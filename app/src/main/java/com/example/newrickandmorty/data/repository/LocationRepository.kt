package com.example.newrickandmorty.data.repository

import com.example.newrickandmorty.base.BaseRepository
import com.example.newrickandmorty.data.local.db.daos.LocationDao
import com.example.newrickandmorty.data.remote.apiservices.LocationApiService
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationApi: LocationApiService,
    private val locationDao: LocationDao
) : BaseRepository() {

    fun fetchLocations(page: Int) = doRequest(
        { locationApi.fetchLocation(page) },
        { locations ->
            locationDao.insertAllLocations(*locations.results.toTypedArray())
        }
    )

    fun getLocations() = doRequest {
        locationDao.getAllLocations()
    }
}