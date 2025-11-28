package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Data.Pocion
import com.example.myapplication.R

class PocionesAdapter(
    private var pociones: List<Pocion>, private val onItemClick: (Pocion) -> Unit
) : RecyclerView.Adapter<PocionesAdapter.PocionesViewHolder>() {

    class PocionesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.title_ingrediente)
        val tipo: TextView = itemView.findViewById(R.id.tipo_ingrediente)
        val imagen: ImageView = itemView.findViewById(R.id.image_ingrediente)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PocionesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return PocionesViewHolder(view)
    }

    override fun onBindViewHolder(holder: PocionesViewHolder, position: Int) {
        val pocion = pociones[position]
        holder.titulo.text = pocion.nombre
        holder.tipo.text = pocion.descripcion
        holder.itemView.setOnClickListener {
            onItemClick(pocion)
        }
    }

    fun updateData(newList: List<Pocion>) {
        pociones = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return pociones.size
    }
}