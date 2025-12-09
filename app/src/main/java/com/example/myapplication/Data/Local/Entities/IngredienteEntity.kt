package com.example.myapplication.Data.Local.Entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Ingredientes",
    foreignKeys = [
        ForeignKey(
            entity = ObtencionEntity::class,
            parentColumns = ["id"],
            childColumns = ["obtencionId"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class IngredienteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val nombre: String,
    val tipo: String,
    val descripcion: String,
    val imagen: String,
    val obtencionId: Int
) : Parcelable
