package com.example.myapplication.UI.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.UI.Activity.PotionsActivity
import com.example.myapplication.UI.ViewModel.FirtsViewModel

class NavigationBottomFragment : Fragment() {

    companion object {
        fun newInstance() = NavigationBottomFragment()
    }

    private val viewModel: FirtsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_bottom_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pocion = view.findViewById<ImageView>(R.id.pociones)
        val alquimia = view.findViewById<ImageView>(R.id.alquimia)
        val items = view.findViewById<ImageView>(R.id.items)

        pocion.setOnClickListener {
//            findNavController().navigate(R.id.)
            val intent = Intent(context, PotionsActivity::class.java)
            startActivity(intent)
        }

        alquimia.setOnClickListener {
//            findNavController().navigate(R.id.)
            Toast.makeText(context, "Alquimia", Toast.LENGTH_SHORT).show()
        }

        items.setOnClickListener {
//            findNavController().navigate(R.id.)
            Toast.makeText(context, "Items", Toast.LENGTH_SHORT).show()
        }


    }
}