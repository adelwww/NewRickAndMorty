package com.example.newrickandmorty.data.models

import com.example.newrickandmorty.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class LocationModel(

    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("url")
    private var url: String

) : IBaseDiffModel
