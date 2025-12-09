package com.example.myapplication.Data.Local.Entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "pasos_pocion",
    foreignKeys = [
        ForeignKey(
            entity = PocionEntity::class,
            parentColumns = ["id"],
            childColumns = ["pocionId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PasoPocionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val pocionId: Int,
    val descripcion: String,
)
