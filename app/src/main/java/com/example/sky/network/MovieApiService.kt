package com.example.sky.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


val BASE_URL = "https://howtodoandroid.com/apis/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MovieApiService {
    @GET("movielist.json")
    suspend fun getMovie() : List<Movie>
}

object MovieAPI {
    val retrofitService: MovieApiService by lazy {
      retrofit.create(MovieApiService::class.java)
    }
}