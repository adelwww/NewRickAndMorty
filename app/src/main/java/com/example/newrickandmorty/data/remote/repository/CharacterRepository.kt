package com.example.newrickandmorty.data.remote.repository

import com.example.newrickandmorty.base.BaseRepository
import com.example.newrickandmorty.data.remote.apiservices.CharacterApi
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApi: CharacterApi
) : BaseRepository(){

    fun fetchCharacter() = doRequest {
        characterApi.fetchCharacter()
    }

}