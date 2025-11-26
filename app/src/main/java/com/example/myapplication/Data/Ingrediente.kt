package com.example.myapplication.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ingrediente(
    val id: Int,
    val nombre: String,
    val tipo: String,
    val descripcion: String,
    val imagen: String,
) : Parcelable
