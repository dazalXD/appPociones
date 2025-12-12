package com.example.myapplication.Data.Mappers

import com.example.myapplication.Data.Local.Entities.PocionEntity
import com.example.myapplication.Domain.Models.Pocion

fun Pocion.ToPocionEntity(): PocionEntity = PocionEntity(
    id = this.id,
    nombre = this.nombre,
    descripcion = this.descripcion
)

fun List<PocionEntity>.ToListPocion(): List<Pocion> = this.map {
    Pocion(
        id = it.id,
        nombre = it.nombre,
        descripcion = it.descripcion,
        pasos = emptyList(),
        ingredientes = emptyList()
    )
}
