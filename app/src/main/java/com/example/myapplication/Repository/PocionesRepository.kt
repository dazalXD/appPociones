package com.example.myapplication.Repository

import android.util.Log
import com.example.myapplication.Data.Ingrediente
import com.example.myapplication.Data.Pocion
import com.example.myapplication.Services.ApiServices
import com.example.myapplication.Services.RetrofitClient

class PocionesRepository {
    private val api = RetrofitClient.apiService

    suspend fun getIngredients(): List<Ingrediente> {
        try {
            return api.getIngredients()
        } catch (e: Exception) {
            Log.d("GetError", "${e.message}")
            return emptyList()
        }
    }

    suspend fun getPociones(): List<Pocion> {
        try {
            return api.getNegativePotions()
        } catch (e: Exception) {
            Log.d("GetError", "${e.message}")
            return emptyList()
        }
    }
}