package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.IngredientesAdapter
import com.example.myapplication.Repository.PocionesRepository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recycler = findViewById(R.id.recyclerIngredientes)
        recycler.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val pocionesRepo = PocionesRepository()
            val listaIngredientes = pocionesRepo.getIngredients()

            recycler.adapter = IngredientesAdapter(listaIngredientes) { item ->
                Log.d("Ingrediente", "${item.nombre}")
            }
            Log.d("Ingredientes", "$listaIngredientes")
        }
    }
}
