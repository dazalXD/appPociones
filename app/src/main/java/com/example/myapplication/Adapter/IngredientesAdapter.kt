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
    private var ingredientes: List<Ingrediente>,
    private val onItemClick: (Ingrediente) -> Unit
) : RecyclerView.Adapter<IngredientesAdapter.IngredienteViewHolder>() {
    class IngredienteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.title_ingrediente)
        val tipo: TextView = itemView.findViewById(R.id.tipo_ingrediente)
        val imagen: ImageView = itemView.findViewById(R.id.image_ingrediente)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredienteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return IngredienteViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredienteViewHolder, position: Int) {
        val ingrediente = ingredientes[position]
        holder.titulo.text = ingrediente.nombre
        holder.tipo.text = ingrediente.tipo
        holder.imagen.load(ingrediente.imagen)
        holder.itemView.setOnClickListener {
            onItemClick(ingrediente)
        }
    }

    fun updateData(newList: List<Ingrediente>) {
        ingredientes = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return ingredientes.size
    }
}