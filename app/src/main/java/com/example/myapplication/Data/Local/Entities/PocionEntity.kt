package com.example.myapplication.Data.Local.Entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Pociones")
data class PocionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val nombre: String,
    val descripcion: String
) : Parcelable
