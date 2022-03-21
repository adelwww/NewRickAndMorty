package com.example.newrickandmorty.data.remote.apiservices

import com.example.newrickandmorty.data.models.CharacterModel
import com.example.newrickandmorty.data.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {

    @GET("api/character")
    suspend fun fetchCharacter(): RickAndMortyResponse<CharacterModel>

    @GET("api/character/{id}")
    suspend fun fetchIdCharacter(
        @Path("id") id : Int
    ) : CharacterModel

}