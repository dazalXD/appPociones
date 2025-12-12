package com.example.myapplication.Data.Local.Entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PocionEntity(
    val id: Int,
    val nombre: String,
    val descripcion: String
) : Parcelable
