package com.example.myapplication.Services

import com.example.myapplication.Data.Ingrediente
import com.example.myapplication.Data.Pocion
import retrofit2.http.GET

interface ApiServices {

    @GET("potions/ingredients")
    suspend fun getIngredients(): List<Ingrediente>

    @GET("potions/negative")
    suspend fun getNegativePotions(): List<Pocion>

    @GET("potions/positive")
    suspend fun getPositivePotions(): List<Pocion>

}