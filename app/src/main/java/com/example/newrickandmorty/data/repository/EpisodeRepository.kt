package com.example.newrickandmorty.data.repository

import com.example.newrickandmorty.base.BaseRepository
import com.example.newrickandmorty.data.local.db.daos.EpisodesDao
import com.example.newrickandmorty.data.remote.apiservices.EpisodeApiService
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val episodeApi: EpisodeApiService,
    private val episodeDao: EpisodesDao
) : BaseRepository() {

    fun fetchEpisodes(page: Int) = doRequest(
        { episodeApi.fetchEpisode(page) },
        { episodes ->
            episodeDao.insertAllEpisodes(*episodes.results.toTypedArray())
        }
    )

    fun getEpisodes() = doRequest {
        episodeDao.getAllEpisodes()
    }
}