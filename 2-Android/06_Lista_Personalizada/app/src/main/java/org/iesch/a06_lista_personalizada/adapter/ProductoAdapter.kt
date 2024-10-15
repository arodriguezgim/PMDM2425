package org.iesch.a06_lista_personalizada.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import org.iesch.a06_lista_personalizada.R
import org.iesch.a06_lista_personalizada.model.Producto

class ProductoAdapter(private val mContext: Context, private val listaProductos:List<Producto>) : ArrayAdapter<Producto> (mContext,0, listaProductos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_producto, parent, false)

        val producto = listaProductos[position]
        layout.findViewById<TextView>(R.id.tvTitulo).text = producto.nombre
        layout.findViewById<TextView>(R.id.tvprecio).text = "${producto.precio}€"
        layout.findViewById<ImageView>(R.id.imgproducto).setImageResource(producto.imagen)

        return layout
    }
}