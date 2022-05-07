package com.example.newrickandmorty.data.repository

import com.example.newrickandmorty.base.BaseRepository
import com.example.newrickandmorty.data.local.db.daos.CharacterDao
import com.example.newrickandmorty.data.remote.apiservices.CharacterApiService
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApi: CharacterApiService,
    private val characterDao: CharacterDao
) : BaseRepository() {

    fun fetchCharacters(page: Int) = doRequest(
        { characterApi.fetchCharacter(page) },
        { characters ->
            characterDao.insertAll(*characters.results.toTypedArray())
        }
    )

    fun getCharacters() = doRequest {
        characterDao.getAll()
    }

}