package com.example.myapplication.Repository

import android.util.Log
import com.example.myapplication.Data.Ingrediente
import com.example.myapplication.Data.Local.DAO.IngredienteDao
import com.example.myapplication.Data.Local.DAO.ObtencionDao
import com.example.myapplication.Data.Local.DAO.PocionesDao
import com.example.myapplication.Data.Mappers.ToObtencionEntity
import com.example.myapplication.Data.Mappers.ToIngredienteEntity
import com.example.myapplication.Data.Mappers.ToListIngrediente
import com.example.myapplication.Data.Mappers.ToListPocion
import com.example.myapplication.Data.Mappers.ToPocionEntity
import com.example.myapplication.Data.Pocion
import com.example.myapplication.Services.ApiServices
import retrofit2.Call
import retrofit2.Callback
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
            val ingredientesLocal = ingredienteDao.getAllIngredientes()

//            ingredientes.enqueue(object : Callback<List<Ingrediente>> {})
//            if (ingredientesLocal.size == ingredientes.size) {
//                Log.d("PocionesRepository", "No hay nada que almacenar")
//            return ingredientesLocal.ToListIngrediente()
            return ingredientes
//            } else {
//                Log.d("api","pasa a la api a carga la info desde ahi.")
//                ingredientes.forEach { ingrediente ->
//                    val ingredienteId =
//                        ingredienteDao.insertIngrediente(ingrediente.ToIngredienteEntity())
//                    obtencionDao.insertObtencion(
//                        ingrediente.obtencion.ToObtencionEntity(
//                            ingredienteId.toInt()
//                        )
//                    )
//                }
//                Log.d("PocionesRepository", "Ingredientes guardados en la base de datos local")
//                return ingredientes
//            }
        } catch (e: Exception) {
            Log.d("GetError", "${e.message}")
            return emptyList()
        }
    }

    suspend fun getPociones(): List<Pocion> {
        try {
            val pociones = api.getNegativePotions() + api.getPositivePotions()

//            Log.d("PocionesRepository", "pociones obtenidas del backend: " + pociones)
//            val pocionesLocal = pocionDao.getAllPociones()

//            if (pocionesLocal.size == pociones.size) {
//                Log.d("PocionesRepository", "No hay nada que almacenar")
//            } else {
//                pociones.forEach { pocion ->
//                    pocionDao.insertPocion(pocion.ToPocionEntity())
//                }
//            }
            return pociones
        } catch (e: Exception) {
            Log.d("GetError", "${e.message}")
            return emptyList()
        }
    }
}