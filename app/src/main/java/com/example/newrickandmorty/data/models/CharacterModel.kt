package com.example.newrickandmorty.data.models

import com.example.newrickandmorty.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class CharacterModel(

    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("species")
    val species: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("image")
    val image: String
) : IBaseDiffModel