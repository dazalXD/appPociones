package com.example.myapplication.Services

import com.example.myapplication.Domain.Models.Ingrediente
import com.example.myapplication.Domain.Models.Pocion
import retrofit2.http.GET

interface ApiServices {

    @GET("potions/ingredients")
    suspend fun getIngredients(): List<Ingrediente>

    @GET("potions/negative")
    suspend fun getNegativePotions(): List<Pocion>

    @GET("potions/positive")
    suspend fun getPositivePotions(): List<Pocion>

}