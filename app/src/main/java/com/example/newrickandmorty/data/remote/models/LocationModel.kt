package com.example.newrickandmorty.data.remote.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newrickandmorty.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

@Entity(tableName = "location")
data class LocationModel(

    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("url")
     var url: String

) : IBaseDiffModel
