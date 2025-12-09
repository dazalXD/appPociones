package com.example.myapplication.Repository

import android.content.Context
import android.util.Log
import com.example.myapplication.DB.AppDataBase
import com.example.myapplication.Data.Ingrediente
import com.example.myapplication.Data.Mappers.ToIngredienteEntity
import com.example.myapplication.Data.Mappers.ToObtencionEntity
import com.example.myapplication.Data.Pocion
import com.example.myapplication.Services.ApiServices
import com.example.myapplication.Services.RetrofitClient
import okhttp3.internal.wait

class PocionesRepository(context: Context) {
    private val api = RetrofitClient.apiService
    private val ingredienteDao = AppDataBase.getInstance(context).ingredienteDao()
    private val pocionDao = AppDataBase.getInstance(context).pocionesDao()
    private val obtencionDao = AppDataBase.getInstance(context).obtencionDao()


    /**
     * obtiene la lista de ingredientes
     * Primero intenta desde la API. Si tiene éxito, gurda los datos en la base de datos
     * Si falla la llamada a la API, obtiene los datos dede la base de datos local.
     * */

    suspend fun getIngredients(): List<Ingrediente> {
        try {
            val ingredientes = api.getIngredients()

            obtencionDao.insertObtenciones(ingredientes.map { it.obtencion.ToObtencionEntity() })
//            ingredienteDao.insertIngredientes(ingredientes.map { it.ToIngredienteEntity() })
            Log.d("PocionesRepository", "Ingredientes guardados en la base de datos local")
            return ingredientes
        } catch (e: Exception) {
            Log.d("GetError", "${e.message}")
            return emptyList()
        }
    }

    suspend fun getPociones(): List<Pocion> {
        try {
            return api.getNegativePotions() + api.getPositivePotions()
        } catch (e: Exception) {
            Log.d("GetError", "${e.message}")
            return emptyList()
        }
    }
}