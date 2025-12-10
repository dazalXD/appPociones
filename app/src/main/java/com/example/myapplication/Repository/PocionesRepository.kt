package com.example.myapplication.Repository

import android.util.Log
import com.example.myapplication.Data.Ingrediente
import com.example.myapplication.Data.Local.DAO.IngredienteDao
import com.example.myapplication.Data.Local.DAO.ObtencionDao
import com.example.myapplication.Data.Local.DAO.PocionesDao
import com.example.myapplication.Data.Mappers.ToObtencionEntity
import com.example.myapplication.Data.Mappers.ToIngredienteEntity
import com.example.myapplication.Data.Mappers.ToPocionEntity
import com.example.myapplication.Data.Pocion
import com.example.myapplication.Services.ApiServices
import javax.inject.Inject

class PocionesRepository @Inject constructor(
    private val api: ApiServices,
    private val ingredienteDao: IngredienteDao,
    private val pocionDao: PocionesDao,
    private val obtencionDao: ObtencionDao
) {

    /**
     * obtiene la lista de ingredientes
     * Primero intenta desde la API. Si tiene éxito, gurda los datos en la base de datos
     * Si falla la llamada a la API, obtiene los datos dede la base de datos local.
     * */

    suspend fun getIngredients(): List<Ingrediente> {
        try {
            val ingredientes = api.getIngredients()
            val ingredientesLocal = ingredienteDao.getAllIngredientes().size
            if (ingredientesLocal == ingredientes.size) {
                Log.d("PocionesRepository", "No hay nada que almacenar")
            } else {
                ingredientes.forEach { ingrediente ->
                    val ingredienteId =
                        ingredienteDao.insertIngrediente(ingrediente.ToIngredienteEntity())
                    obtencionDao.insertObtencion(
                        ingrediente.obtencion.ToObtencionEntity(
                            ingredienteId.toInt()
                        )
                    )
                }
                Log.d("PocionesRepository", "Ingredientes guardados en la base de datos local")
            }
            return ingredientes
        } catch (e: Exception) {
            Log.d("GetError", "${e.message}")
            return emptyList()
        }
    }

    suspend fun getPociones(): List<Pocion> {
        try {
            val pociones = api.getNegativePotions() + api.getPositivePotions()

            Log.d("PocionesRepository", "pociones obtenidas del backend: " + pociones)
            val pocionesLocal = pocionDao.getAllPociones().size

            if (pocionesLocal == pociones.size) {
                Log.d("PocionesRepository", "No hay nada que almacenar")
            } else {
                pociones.forEach { pocion ->
                    pocionDao.insertPocion(pocion.ToPocionEntity())
                }
            }
            return pociones
        } catch (e: Exception) {
            Log.d("GetError", "${e.message}")
            return emptyList()
        }
    }
}