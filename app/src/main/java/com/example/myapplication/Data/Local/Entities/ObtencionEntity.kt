package com.example.myapplication.Data.Local.Entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Obtencion")
data class ObtencionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val dimencion: String,
    val ubicacion: String,
    val Herramienta: String,
    val crafteo: String
) : Parcelable
