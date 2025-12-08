package com.example.myapplication.UI.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Data.Ingrediente
import com.example.myapplication.Repository.PocionesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemsFragmentViewModel : ViewModel() {
    private val repo = PocionesRepository()
    private val _ingredients = MutableStateFlow<List<Ingrediente>>(emptyList())
    val ingredients: StateFlow<List<Ingrediente>> = _ingredients

    init {
        getIngredients()
    }

    fun getIngredients() {
        viewModelScope.launch {
            val data = repo.getIngredients()
            _ingredients.value = data
        }
    }
}