package com.example.myapplication.Domain.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pocion(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val ingredientes: List<Ingrediente>,
    val pasos: List<String>
) : Parcelable
