package com.example.myapplication.Data.Local.Entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ObtencionEntity(
    val id: Int,
    val ingredienteId: Int,
    val dimencion: String,
    val ubicacion: String,
    val Herramienta: String,
    val crafteo: String
) : Parcelable