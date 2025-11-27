package com.example.myapplication.UI.Activity

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import com.example.myapplication.Data.Ingrediente
import com.example.myapplication.R
import com.example.myapplication.UI.ViewModel.DetailViewModel
import com.google.android.material.appbar.MaterialToolbar

class DetailActivity : AppCompatActivity() {
    private val detailViewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            val controller = ViewCompat.getWindowInsetsController(v)
            controller?.isAppearanceLightStatusBars = true
            insets
        }

        val imageItem = findViewById<ImageView>(R.id.image_item)
        val textTitle = findViewById<TextView>(R.id.text_title)
        val textDescription = findViewById<TextView>(R.id.text_description)
        val textTipo = findViewById<TextView>(R.id.text_tipo)

        val item = intent.getParcelableExtra<Ingrediente>("ingrediente") as Ingrediente
        if (item != null) {
            detailViewModel.setIngrediente(item)
        }

        detailViewModel.ingrediente.observe(this) { ingrediente ->
            Log.d("Detalle de ingrediente", "$ingrediente")
            imageItem.load("${ingrediente.imagen}")
            textTitle.text = "${ingrediente.nombre}"
            textTipo.text = "${ingrediente.tipo}"
            textDescription.text = "${ingrediente.descripcion}"

        }

//        Log.d("Detalle de ingrediente", "$item¡")

    }
}