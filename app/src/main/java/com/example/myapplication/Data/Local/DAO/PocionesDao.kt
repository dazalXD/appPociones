package com.example.myapplication.Data.Local.DAO

import androidx.room.*
import com.example.myapplication.Data.Local.Entities.IngredienteEntity
import com.example.myapplication.Data.Local.Entities.PasoPocionEntity
import com.example.myapplication.Data.Local.Entities.PocionEntity
import com.example.myapplication.Data.Local.Entities.PocionIngredienteCrossRef
import com.example.myapplication.Data.Local.Relations.PocionConIngredientes
import kotlinx.coroutines.flow.Flow

@Dao
interface PocionesDao {

    // ---------- INSERTS ----------
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPocion(pocion: PocionEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngrediente(ingrediente: IngredienteEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPaso(paso: PasoPocionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrossRef(crossRef: PocionIngredienteCrossRef)


    // ---------- GET LISTAS SIMPLES ----------

    @Query("SELECT * FROM Ingredientes")
    fun getAllIngredientes(): Flow<List<IngredienteEntity>>

    @Query("SELECT * FROM Pociones")
    suspend fun getAllPociones(): List<PocionEntity>


    // ---------- GET RELACIONES COMPLETAS ----------

    // Obtener TODAS las pociones con ingredientes + pasos
    @Transaction
    @Query("SELECT * FROM Pociones")
    fun getPocionesConIngredientes(): Flow<List<PocionConIngredientes>>

    // Obtener una poción en específico con todo
    @Transaction
    @Query("SELECT * FROM Pociones WHERE id = :id")
    suspend fun getPocionCompleta(id: Int): PocionConIngredientes?


    // ---------- DELETE ----------

    @Query("DELETE FROM Pociones")
    suspend fun deleteAllPociones()

    @Query("DELETE FROM Ingredientes")
    suspend fun deleteAllIngredientes()

    @Query("DELETE FROM pasos_pocion")
    suspend fun deleteAllPasos()

    @Query("DELETE FROM pocion_ingrediente")
    suspend fun deleteAllCrossRef()
}
