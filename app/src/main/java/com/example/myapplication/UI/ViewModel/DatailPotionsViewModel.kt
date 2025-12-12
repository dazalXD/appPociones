package com.example.myapplication.UI.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Domain.Models.Pocion

class DatailPotionsViewModel : ViewModel() {
    private val _pocion = MutableLiveData<Pocion>()
    val pocion: LiveData<Pocion> get() = _pocion

    fun setPocion(item: Pocion) {
        _pocion.value = item
    }
}
