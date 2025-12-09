package com.example.myapplication.Data.Local.Entities

import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    tableName = "pocion_ingrediente",
    primaryKeys = ["pocionId", "ingredienteId"],
    foreignKeys = [
        ForeignKey(
            entity = PocionEntity::class,
            parentColumns = ["id"],
            childColumns = ["pocionId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = IngredienteEntity::class,
            parentColumns = ["id"],
            childColumns = ["ingredienteId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PocionIngredienteCrossRef(
    val pocionId: Int,
    val ingredienteId: Int
)
