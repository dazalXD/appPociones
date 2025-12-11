package com.example.myapplication.Services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    //    private val URL_BASE = "http://192.168.1.105:3000/api/v1/"
    private val URL_BASE = "http://10.55.37.2:3000/api/v1/"
    val apiService: ApiServices by lazy {
        Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServices::class.java)
    }
}