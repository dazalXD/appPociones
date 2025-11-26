package com.example.myapplication.Services

import com.example.myapplication.Data.Ingrediente
import retrofit2.http.GET

interface ApiServices {

    @GET("potions/ingredients")
    suspend fun getIngredients(): List<Ingrediente>
}