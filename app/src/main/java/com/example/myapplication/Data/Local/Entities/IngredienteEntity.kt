package com.example.myapplication.Data.Local.Entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Ingredientes")
data class IngredienteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val tipo: String,
    val descripcion: String,
    val imagen: String
) : Parcelable