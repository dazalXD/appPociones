package com.example.myapplication.UI.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Data.Ingrediente
import com.example.myapplication.Repository.PocionesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemsFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = PocionesRepository(application.applicationContext)
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