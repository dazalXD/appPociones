package com.example.myapplication.Data.Local.Entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(
    tableName = "Obtencion",
    foreignKeys = [
        ForeignKey(
            entity = IngredienteEntity::class,
            parentColumns = ["id"],
            childColumns = ["ingredienteId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ObtencionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val ingredienteId: Int,
    val dimencion: String,
    val ubicacion: String,
    val Herramienta: String,
    val crafteo: String
) : Parcelable