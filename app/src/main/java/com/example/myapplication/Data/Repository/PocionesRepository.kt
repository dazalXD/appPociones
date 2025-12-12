package com.example.myapplication.Data.Repository

import android.util.Log
import com.example.myapplication.Data.Local.Sources.PocionesLocalDataSource
import com.example.myapplication.Domain.Models.Ingrediente
import com.example.myapplication.Domain.Models.Pocion
import com.example.myapplication.Domain.Repository.PocionesRepo
import com.example.myapplication.Services.ApiServices
import javax.inject.Inject

class PocionesRepository @Inject constructor(
    private val api: ApiServices,
    private val localDataSource: PocionesLocalDataSource
) : PocionesRepo {

    /**
     * obtiene la lista de ingredientes
     * Primero intenta desde la API. Si tiene éxito, gurda los datos en la base de datos
     * Si falla la llamada a la API, obtiene los datos dede la base de datos local.
     * */

    override suspend fun getIngredients(): List<Ingrediente> {
        try {
            val ingredientes = api.getIngredients()
            localDataSource.saveIngredientes(ingredientes)
            return ingredientes
        } catch (e: Exception) {
            Log.d("GetError", "${e.message}")
            val ingredientesLocal = localDataSource.getAllIngredientes()

            val ingredientesCargados: MutableList<String> = mutableListOf()
            ingredientesLocal.forEach { ingrediente ->
                ingredientesCargados.add(
                    "${ingrediente.id.toString()}" +
                            "${ingrediente.nombre}  ${ingrediente.descripcion}"
                )
            }
            Log.d(
                "base de datos: ",
                "datos obtenidos: $ingredientesCargados"
            )
            return ingredientesLocal
        }
    }

    override suspend fun getPociones(): List<Pocion> {
        try {
            val pociones = api.getNegativePotions() + api.getPositivePotions()
            return pociones
        } catch (e: Exception) {
            Log.d("GetError", "${e.message}")
            return emptyList()
        }
    }
}