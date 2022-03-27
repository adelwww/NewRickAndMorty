package com.example.newrickandmorty.data.remote.apiservices

import com.example.newrickandmorty.data.models.LocationModel
import com.example.newrickandmorty.data.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApiService {

    @GET("api/location")
    suspend fun fetchLocation(
        @Query("page") page: Int
    ): RickAndMortyResponse<LocationModel>
}