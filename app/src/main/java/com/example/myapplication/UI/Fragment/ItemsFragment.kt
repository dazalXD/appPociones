package com.example.myapplication.UI.Fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.IngredientesAdapter
import com.example.myapplication.R
import com.example.myapplication.UI.Activity.DetailActivity
import com.example.myapplication.UI.ViewModel.HomeFragmentViewModel
import com.example.myapplication.UI.ViewModel.ItemsFragmentViewModel
import kotlinx.coroutines.launch
import kotlin.getValue

class ItemsFragment : Fragment() {
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: IngredientesAdapter
    private val viewModel: ItemsFragmentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.recyclerIngredientes)
        recycler.layoutManager = LinearLayoutManager(requireContext())

        adapter = IngredientesAdapter(emptyList()) { item ->
            Log.d("Ingrediente", "${item.nombre}")
            val intent = Intent(requireActivity(), DetailActivity::class.java).apply {
                putExtra("ingrediente", item)
            }
            startActivity(intent)
        }
        recycler.adapter = adapter

        lifecycleScope.launch {
            viewModel.ingredients.collect { lista ->
                adapter.updateData(lista)
            }
        }
    }
}