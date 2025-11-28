//package com.example.myapplication.Adapter
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ArrayAdapter
//import android.widget.TextView
//import com.example.myapplication.Data.Obtencion
//import com.example.myapplication.R
//
//class ObtencionListAdapter(
//    private val context: Context, private val dataList: List<Obtencion>
//) : ArrayAdapter<Obtencion>(context, 0, dataList) {
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//
//        val view = convertView ?: LayoutInflater.from(context).inflate(
//            R.layout.item_list, parent, false
//        )
//
//        val item = dataList[position]
//        val dimencionTextView = view.findViewById<TextView>(R.id.text_dimension)
//        val ubicacionTextView = view.findViewById<TextView>(R.id.text_ubicacion)
//        val herramientaTextView = view.findViewById<TextView>(R.id.text_herramienta)
//        val crafteoTextView = view.findViewById<TextView>(R.id.text_crafteo)
//
//        dimencionTextView.text = item.dimencion
//        ubicacionTextView.text = item.ubicacion
//        herramientaTextView.text = item.Herramienta
//        crafteoTextView.text = item.crafteo
//
//        return view
//    }
//}