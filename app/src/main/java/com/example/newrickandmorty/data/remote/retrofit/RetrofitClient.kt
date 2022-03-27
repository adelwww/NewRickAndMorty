package com.example.newrickandmorty.data.remote.retrofit

import com.example.newrickandmorty.common.constants.Constants
import com.example.newrickandmorty.data.remote.apiservices.CharacterApiService
import com.example.newrickandmorty.data.remote.apiservices.EpisodeApiService
import com.example.newrickandmorty.data.remote.apiservices.LocationApiService
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

    fun provideCharacterApiService() : CharacterApiService =
        provideRetrofit.create(CharacterApiService::class.java)

    fun provideEpisodeApiService() : EpisodeApiService =
        provideRetrofit.create(EpisodeApiService::class.java)

    fun provideLocationApiService() : LocationApiService =
        provideRetrofit.create(LocationApiService::class.java)
}