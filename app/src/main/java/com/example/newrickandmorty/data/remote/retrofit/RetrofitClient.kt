package com.example.newrickandmorty.data.remote.retrofit

import com.example.newrickandmorty.common.constants.Constants
import com.example.newrickandmorty.data.models.CharacterModel
import com.example.newrickandmorty.data.remote.apiservices.CharacterApi
import com.example.newrickandmorty.data.remote.apiservices.EpisodeApi
import com.example.newrickandmorty.data.remote.apiservices.LocationApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(provideLoginInterceptor())
        .build()

    private fun provideLoginInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val provideRetrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideCharacterApiService() : CharacterApi =
        provideRetrofit.create(CharacterApi::class.java)

    fun provideEpisodeApiService() : EpisodeApi =
        provideRetrofit.create(EpisodeApi::class.java)

    fun provideLocationApiService() : LocationApi =
        provideRetrofit.create(LocationApi::class.java)
}