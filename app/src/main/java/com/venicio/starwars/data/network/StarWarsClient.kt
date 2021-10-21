package com.venicio.starwars.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object StarWarsClient {

    private val moshiAdapter = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    fun getInstance() : StarWarsService {

        val retrofit = Retrofit.Builder()
            .baseUrl(StarWarsService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshiAdapter))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(OkHttpClient.Builder().build())
            .build()

        return retrofit.create(StarWarsService::class.java)
    }
}