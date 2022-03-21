package com.example.newrickandmorty.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class EpisodesModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("episodes")
    val episodes: String,

    @SerializedName("url")
    private var url: String

)
