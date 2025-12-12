package com.example.myapplication.Domain.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Obtencion(
    val id: Int,
    val ingredienteId: Int,
    val dimencion: String,
    val ubicacion: String,
    val Herramienta: String,
    val crafteo: String
) : Parcelable
