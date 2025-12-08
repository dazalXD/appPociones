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
import com.example.myapplication.Adapter.PocionesAdapter
import com.example.myapplication.R
import com.example.myapplication.UI.Activity.DetailActivity
import com.example.myapplication.UI.Activity.DetailPotionActivity
import com.example.myapplication.UI.ViewModel.HomeFragmentViewModel
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: PocionesAdapter

    private val viewModel: HomeFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.recyclerIngredientes)
        recycler.layoutManager = LinearLayoutManager(requireContext())

        adapter = PocionesAdapter(emptyList()) { item ->
            val Intent = Intent(requireActivity(), DetailPotionActivity::class.java)
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