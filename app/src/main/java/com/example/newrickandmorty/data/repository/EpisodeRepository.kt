package com.example.newrickandmorty.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.newrickandmorty.base.BaseRepository
import com.example.newrickandmorty.data.models.EpisodesModel
import com.example.newrickandmorty.data.remote.apiservices.EpisodeApiService
import com.example.newrickandmorty.data.remote.pagingsource.EpisodePagingSource
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val episodeApi: EpisodeApiService
) : BaseRepository(){

    fun fetchEpisodes(): LiveData<PagingData<EpisodesModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                EpisodePagingSource(episodeApi)
            }
        ).liveData
    }

}