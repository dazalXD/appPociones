package com.example.myapplication.Data.Mappers

import com.example.myapplication.Data.Ingrediente
import com.example.myapplication.Data.Local.Entities.IngredienteEntity
import com.example.myapplication.Data.Local.Entities.ObtencionEntity
import com.example.myapplication.Data.Obtencion

fun Ingrediente.ToIngredienteEntity(): IngredienteEntity = IngredienteEntity(
    id = this.id,
    nombre = this.nombre,
    tipo = this.tipo,
    descripcion = this.descripcion,
    imagen = this.imagen
)

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