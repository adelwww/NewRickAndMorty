package com.example.newrickandmorty.data.remote.apiservices

import com.example.newrickandmorty.data.models.LocationModel
import com.example.newrickandmorty.data.models.RickAndMortyResponse
import retrofit2.http.GET

interface LocationApi {

    @GET("api/location")
    suspend fun fetchLocation(): RickAndMortyResponse<LocationModel>
}