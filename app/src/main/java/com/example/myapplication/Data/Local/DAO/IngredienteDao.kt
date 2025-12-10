package com.example.myapplication.Data.Local.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.myapplication.Data.Local.Entities.IngredienteEntity
import com.example.myapplication.Data.Local.Relations.IngredienteConObtencion

@Dao
interface IngredienteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngrediente(ingrediente: IngredienteEntity): Long

    @Query("SELECT * FROM ingredientes")
    suspend fun getAllIngredientes(): List<IngredienteEntity>

    @Transaction
    @Query("SELECT * FROM ingredientes")
    suspend fun getIngredientesConObtencion(): List<IngredienteConObtencion>
}