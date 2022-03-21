package com.example.newrickandmorty.data.models

import android.icu.text.IDNA
import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse<T>(

    @SerializedName("info")
    val info: InfoModel,

    @SerializedName("results")
    val results: ArrayList<T>
)