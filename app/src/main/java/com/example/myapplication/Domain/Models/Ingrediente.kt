package com.example.myapplication.Domain.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ingrediente(
    val id: Int,
    val nombre: String,
    val tipo: String,
    val descripcion: String,
    val imagen: String,
    val obtencion: Obtencion
) : Parcelable
