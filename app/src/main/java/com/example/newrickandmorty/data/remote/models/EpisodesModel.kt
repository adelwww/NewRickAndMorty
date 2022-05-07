package com.example.newrickandmorty.data.remote.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newrickandmorty.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

@Entity(tableName = "episode")
data class EpisodesModel(

    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("episodes")
    val episodes: String,

    @SerializedName("url")
    var url: String

) : IBaseDiffModel
