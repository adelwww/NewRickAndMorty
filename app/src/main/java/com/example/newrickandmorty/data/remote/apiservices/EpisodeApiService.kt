package com.example.newrickandmorty.data.remote.apiservices

import com.example.newrickandmorty.data.remote.models.EpisodesModel
import com.example.newrickandmorty.data.remote.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("api/episode")
    suspend fun fetchEpisode(
        @Query("page") page: Int
    ): RickAndMortyResponse<EpisodesModel>


}