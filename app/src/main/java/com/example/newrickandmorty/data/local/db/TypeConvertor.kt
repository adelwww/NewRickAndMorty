package com.example.newrickandmorty.data.local.db

import androidx.room.TypeConverter
import com.example.newrickandmorty.data.remote.models.CharacterModel
import com.example.newrickandmorty.data.remote.models.EpisodesModel
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class TypeConvertor {

    @TypeConverter
    fun fromString(value: String?): List<CharacterModel?>? {
        val listType: Type = object : TypeToken<List<CharacterModel?>?>() {}.type
        return Gson().fromJson<List<CharacterModel?>>(value, listType)
    }

    @TypeConverter
    fun stringToEpisode(value: String?): List<EpisodesModel?>? {
        val listType: Type = object : TypeToken<List<EpisodesModel?>?>() {}.type
        return Gson().fromJson<List<EpisodesModel?>>(value, listType)
    }

}