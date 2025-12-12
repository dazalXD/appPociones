package com.example.myapplication.Domain.Repository

import com.example.myapplication.Domain.Models.Ingrediente
import com.example.myapplication.Domain.Models.Pocion

interface PocionesRepo {
    suspend fun getIngredients(): List<Ingrediente>
    suspend fun getPociones(): List<Pocion>
}