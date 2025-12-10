package com.example.myapplication.Data.Mappers

import com.example.myapplication.Data.Local.Entities.PocionEntity
import com.example.myapplication.Data.Pocion

fun Pocion.ToPocionEntity(): PocionEntity = PocionEntity(
    id = this.id,
    nombre = this.nombre,
    descripcion = this.descripcion
)
