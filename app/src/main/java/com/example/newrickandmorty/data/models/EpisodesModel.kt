package com.example.newrickandmorty.data.models

import com.example.newrickandmorty.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class EpisodesModel(

    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("episodes")
    val episodes: String,

    @SerializedName("url")
    private var url: String

) : IBaseDiffModel
