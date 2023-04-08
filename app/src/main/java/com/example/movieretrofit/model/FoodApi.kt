package com.example.movieretrofit.model

import com.example.movieretrofit.data.AllFood
import com.example.movieretrofit.fragments.ui.API_KEY
import com.example.movieretrofit.fragments.ui.BASE_URI
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface FoodApiService {
    @GET("search")
    suspend fun getAllFood(
        @Query("query") query: String = "apple",
        @Query("apiKey") app_key: String = API_KEY
    ): Response<AllFood>
}

var okHttpClient: OkHttpClient = OkHttpClient.Builder().build()

var retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URI)
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

var restFoodApi: FoodApiService = retrofit.create(FoodApiService::class.java)
