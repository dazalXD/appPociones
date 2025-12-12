package com.example.myapplication.Data.Local.Sources

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.myapplication.DB.DatabaseHelper
import com.example.myapplication.Domain.Models.Ingrediente
import com.example.myapplication.Domain.Models.Obtencion
import javax.inject.Inject

class PocionesLocalDataSource @Inject constructor(
    private val dbHelper: DatabaseHelper
) {
    fun getAllIngredientes(): List<Ingrediente> {
        val db = dbHelper.readableDatabase
        val ingredientesList = mutableListOf<Ingrediente>()

        val cursor = db.rawQuery("Select * from ingredientes", null)

        cursor.use { // use para que se cierre el cursor
            if (it.moveToFirst()) {
                val idIndex = it.getColumnIndex("id")
                val nombreIndex = it.getColumnIndex("nombre")
                val tipoIndex = it.getColumnIndex("tipo")
                val descripcionIndex = it.getColumnIndex("descripcion")
                val imagenIndex = it.getColumnIndex("imagen")


                if (idIndex == -1 || nombreIndex == -1) return emptyList()

                do {
                    val id = it.getInt(idIndex)
                    val nombre = it.getString(nombreIndex)
                    val tipo = it.getString(tipoIndex)
                    val descripcion = it.getString(descripcionIndex)
                    val imagen = it.getString(imagenIndex)

                    ingredientesList.add(
                        Ingrediente(
                            id = id, nombre, tipo, descripcion, descripcion, Obtencion(
                                0, 0, "", "", "", ""
                            )
                        )
                    )
                } while (it.moveToNext())
            }
        }
        Log.d("base de datos: ", "datos obtenidos")
        return ingredientesList
    }

    fun saveIngredientes(ingredientes: List<Ingrediente>) {
        val db = dbHelper.writableDatabase
        db.beginTransaction() // mejora el rendimiento para multiples inseciones

        try {
            db.delete("ingredientes", null, null)

            for (ingrediente in ingredientes) {
                val values = ContentValues().apply {
                    put("id", ingrediente.id)
                    put("nombre", ingrediente.nombre)
                    put("tipo", ingrediente.tipo)
                    put("descripcion", ingrediente.descripcion)
                    put("imagen", ingrediente.imagen)
                }
                db.insertWithOnConflict(
                    "ingredientes", null, values, SQLiteDatabase.CONFLICT_REPLACE
                )
            }
            Log.d("base de datos: ", "datos guardados")
            db.setTransactionSuccessful() // confirma la transaccion
        } finally {
            db.endTransaction() // Finaliza la transacción (commit o rollback)
        }
    }
}
