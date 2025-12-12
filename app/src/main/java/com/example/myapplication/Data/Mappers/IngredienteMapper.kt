package com.example.myapplication.Data.Mappers

import com.example.myapplication.Domain.Models.Ingrediente
import com.example.myapplication.Data.Local.Entities.IngredienteEntity
import com.example.myapplication.Data.Local.Entities.ObtencionEntity
import com.example.myapplication.Domain.Models.Obtencion

fun Ingrediente.ToIngredienteEntity(): IngredienteEntity = IngredienteEntity(
    id = this.id,
    nombre = this.nombre,
    tipo = this.tipo,
    descripcion = this.descripcion,
    imagen = this.imagen
)

suspend fun List<IngredienteEntity>.ToListIngrediente(): List<Ingrediente> = this.map {
    Ingrediente(
        id = it.id,
        nombre = it.nombre,
        tipo = it.tipo,
        descripcion = it.descripcion,
        imagen = it.imagen,
        obtencion = Obtencion(
            id = 0,
            ingredienteId = 0,
            dimencion = "",
            ubicacion = "",
            Herramienta = "",
            crafteo = ""
        )
    )
}

fun List<Ingrediente>.ToIngredienteEntity(): List<IngredienteEntity> =
    this.map { it.ToIngredienteEntity() }


fun Obtencion.ToObtencionEntity(toInt: Int): ObtencionEntity = ObtencionEntity(
    id = this.id,
    ingredienteId = toInt,
    dimencion = this.dimencion,
    ubicacion = this.ubicacion,
    Herramienta = this.Herramienta,
    crafteo = this.crafteo
)