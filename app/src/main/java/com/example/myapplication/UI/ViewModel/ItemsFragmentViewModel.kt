package com.example.myapplication.UI.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Domain.Models.Ingrediente
import com.example.myapplication.Data.Repository.PocionesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsFragmentViewModel @Inject constructor(
    private val repo: PocionesRepository
) : ViewModel() {
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