package com.example.newrickandmorty.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.newrickandmorty.base.BaseRepository
import com.example.newrickandmorty.data.models.CharacterModel
import com.example.newrickandmorty.data.models.LocationModel
import com.example.newrickandmorty.data.remote.apiservices.LocationApiService
import com.example.newrickandmorty.data.remote.pagingsource.CharacterPagingSource
import com.example.newrickandmorty.data.remote.pagingsource.LocationPagingSource
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationApi: LocationApiService
) : BaseRepository() {

    fun fetchLocations(): LiveData<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                LocationPagingSource(locationApi)
            }
        ).liveData
    }
}