package com.example.newrickandmorty.data.remote.apiservices

import com.example.newrickandmorty.data.models.EpisodesModel
import com.example.newrickandmorty.data.models.RickAndMortyResponse
import retrofit2.http.GET

interface EpisodeApi {

    @GET("api/episode")
    suspend fun fetchEpisode(): RickAndMortyResponse<EpisodesModel>


}