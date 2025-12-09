package com.example.myapplication.Data.Local.Relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.myapplication.Data.Local.Entities.IngredienteEntity
import com.example.myapplication.Data.Local.Entities.PasoPocionEntity
import com.example.myapplication.Data.Local.Entities.PocionEntity
import com.example.myapplication.Data.Local.Entities.PocionIngredienteCrossRef

data class PocionConIngredientes(
    @Embedded val pocion: PocionEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            PocionIngredienteCrossRef::class,
            parentColumn = "pocionId",
            entityColumn = "ingredienteId"
        )
    )
    val ingredientes: List<IngredienteEntity>,

    @Relation(
        parentColumn = "id",
        entityColumn = "pocionId"
    )
    val pasos: List<PasoPocionEntity>
)
