package com.example.myapplication.Data.Local.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.myapplication.Data.Local.Entities.IngredienteEntity
import com.example.myapplication.Data.Local.Entities.ObtencionEntity

data class IngredienteConObtencion(
    @Embedded val ingrediente: IngredienteEntity,
    @Relation(
        parentColumn = "obtencionId",
        entityColumn = "id"
    )
    val obtencion: ObtencionEntity
)
