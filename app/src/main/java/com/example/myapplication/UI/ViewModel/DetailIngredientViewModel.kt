package com.example.myapplication.UI.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Domain.Models.Ingrediente

class DetailIngredientViewModel : ViewModel() {
    private val _ingrediente = MutableLiveData<Ingrediente>()
    val ingrediente: LiveData<Ingrediente> get() = _ingrediente

    fun setIngrediente(item: Ingrediente) {
        _ingrediente.value = item
    }
}