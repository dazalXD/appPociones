package com.example.myapplication.UI.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.PocionesAdapter
import com.example.myapplication.R
import com.example.myapplication.UI.ViewModel.PotionsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PotionsActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: PocionesAdapter
    private val viewModel: PotionsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_potions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recycler = findViewById(R.id.recyclerPociones)
        recycler.layoutManager = LinearLayoutManager(this)

        adapter = PocionesAdapter(emptyList()) { item ->
            val Intent = Intent(this@PotionsActivity, DetailPotionActivity::class.java)
            Intent.putExtra("pocion", item)
            startActivity(Intent)
        }
        recycler.adapter = adapter

        lifecycleScope.launch {
            viewModel.potions.collect { lista ->
                adapter.updateData(lista)
            }
        }
    }
}