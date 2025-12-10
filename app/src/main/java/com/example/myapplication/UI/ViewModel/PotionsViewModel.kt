package com.example.myapplication.UI.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Data.Pocion
import com.example.myapplication.Repository.PocionesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PotionsViewModel @Inject constructor(
    private val repo: PocionesRepository
) : ViewModel() {
    private val _potions = MutableStateFlow<List<Pocion>>(emptyList())
    val potions: StateFlow<List<Pocion>> = _potions

    init {
        getPociones()
    }

    fun getPociones() {
        viewModelScope.launch {
            val data = repo.getPociones()
            _potions.value = data
        }
    }
}