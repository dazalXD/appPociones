package com.example.myapplication.Data.Local.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.Data.Local.Entities.ObtencionEntity

@Dao
interface ObtencionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertObtencion(obtencion: ObtencionEntity)

    @Query("SELECT * FROM Obtencion")
    suspend fun getAllObtenciones(): List<ObtencionEntity>
}