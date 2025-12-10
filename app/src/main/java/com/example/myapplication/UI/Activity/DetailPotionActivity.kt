package com.example.myapplication.UI.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.IngredientesAdapter
import com.example.myapplication.Adapter.PocionesAdapter
import com.example.myapplication.Data.Pocion
import com.example.myapplication.R
import com.example.myapplication.UI.ViewModel.DatailPotionsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailPotionActivity : AppCompatActivity() {
    private val detailPotionViewModel: DatailPotionsViewModel by viewModels()
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: IngredientesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_potion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textTitle = findViewById<TextView>(R.id.text_title)
        val textDescription = findViewById<TextView>(R.id.text_description)
        val textPasos = findViewById<TextView>(R.id.text_pasos)

        recycler = findViewById(R.id.recyclerIngredientesPocion)
        recycler.layoutManager = LinearLayoutManager(this)

        val item = intent.getParcelableExtra<Pocion>("pocion") as Pocion
        if (item != null) {
            detailPotionViewModel.setPocion(item)
        }

        detailPotionViewModel.pocion.observe(this) { pocion ->
            textTitle.text = "${pocion.nombre}"
            textDescription.text = "${pocion.descripcion}"
            textPasos.text = pocion.pasos.joinToString("\n")
            lifecycleScope.launch {
                adapter.updateData(pocion.ingredientes)
            }
        }

        adapter = IngredientesAdapter(emptyList()) { item ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("ingrediente", item)
            startActivity(intent)
        }
        recycler.adapter = adapter

    }
}