package com.example.newrickandmorty.data.remote.repository

import com.example.newrickandmorty.base.BaseRepository
import com.example.newrickandmorty.data.remote.apiservices.EpisodeApi
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val episodeApi: EpisodeApi
) : BaseRepository(){

    fun fetchEpisode() = doRequest {
        episodeApi.fetchEpisode()
    }

}