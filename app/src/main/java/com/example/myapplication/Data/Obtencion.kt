package com.example.myapplication.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Obtencion(
    val dimencion: String,
    val ubicacion: String,
    val Herramienta: String,
    val crafteo: String
) : Parcelable
