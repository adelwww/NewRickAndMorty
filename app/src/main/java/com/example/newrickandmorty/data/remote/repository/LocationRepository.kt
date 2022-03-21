package com.example.newrickandmorty.data.remote.repository

import com.example.newrickandmorty.base.BaseRepository
import com.example.newrickandmorty.data.remote.apiservices.LocationApi
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationApi: LocationApi
) : BaseRepository() {

    fun fetchLocation() = doRequest {
        locationApi.fetchLocation()
    }
}