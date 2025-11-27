package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.IngredientesAdapter
import com.example.myapplication.UI.Activity.DetailActivity
import com.example.myapplication.UI.ViewModel.MainViewModel
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: IngredientesAdapter

    // Propiedades para el Navigation Drawer
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: MaterialToolbar
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // --- Configuración del Navigation Drawer ---
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)

        // --- Edge-to-Edge ---
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- RecyclerView y Adapter ---
        recycler = findViewById(R.id.recyclerIngredientes)
        recycler.layoutManager = LinearLayoutManager(this)

        // NOTA: Asumo que tu IngredientesAdapter tiene un método `updateData`.
        // Si esto da error, es posible que el constructor del adapter sea diferente.
        adapter = IngredientesAdapter(emptyList()) { item ->
            Log.d("Ingrediente", "${item.nombre}")
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("ingrediente", item)
            startActivity(intent)
        }
        recycler.adapter = adapter

        // --- ViewModel ---
        lifecycleScope.launch {
            viewModel.ingredients.collect { lista ->
                adapter.updateData(lista)
            }
        }
    }

    // Función para manejar los clicks en los items del menú
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show()
            R.id.nav_profile -> Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show()
            R.id.nav_settings -> Toast.makeText(this, "Ajustes", Toast.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawers()
        return true
    }

    // Permite que el toggle maneje el click en el ícono de hamburguesa
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    // Al presionar "atrás", si el menú está abierto, lo cierra.
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(navigationView)
        } else {
            super.onBackPressed()
        }
    }
}
