package com.example.newrickandmorty.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.newrickandmorty.base.BaseRepository
import com.example.newrickandmorty.data.models.CharacterModel
import com.example.newrickandmorty.data.remote.apiservices.CharacterApiService
import com.example.newrickandmorty.data.remote.pagingsource.CharacterPagingSource
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApi: CharacterApiService
) : BaseRepository(){

    fun fetchCharacters(): LiveData<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                CharacterPagingSource(characterApi)
            }
        ).liveData
    }

}