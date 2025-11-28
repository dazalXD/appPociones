package com.example.myapplication.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pocion(
    val nombre: String,
    val descripcion: String,
    val ingredientes: List<Ingrediente>,
    val pasos: List<String>
) : Parcelable
