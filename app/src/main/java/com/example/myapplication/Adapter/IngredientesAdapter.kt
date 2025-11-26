package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.Data.Ingrediente
import com.example.myapplication.R

class IngredientesAdapter(
    private val ingredientes: List<Ingrediente>, private val onItemClick: (Ingrediente) -> Unit
) : RecyclerView.Adapter<IngredientesAdapter.IngredienteViewHolder>() {
    class IngredienteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.title_ingrediente)
        val descripcion: TextView = itemView.findViewById(R.id.description_ingrediente)
        val imagen: ImageView = itemView.findViewById(R.id.image_ingrediente)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredienteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_ingrediente, parent, false)
        return IngredienteViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredienteViewHolder, position: Int) {
        val ingrediente = ingredientes[position]
        holder.titulo.text = ingrediente.nombre
        holder.descripcion.text = ingrediente.descripcion
        holder.imagen.load(ingrediente.imagen)
        holder.itemView.setOnClickListener {
            onItemClick(ingrediente)
        }
    }

    override fun getItemCount(): Int {
        return ingredientes.size
    }
}