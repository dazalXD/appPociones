package com.example.myapplication.Data.Local.Entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IngredienteEntity(
    val id: Int,
    val nombre: String,
    val tipo: String,
    val descripcion: String,
    val imagen: String
) : Parcelable