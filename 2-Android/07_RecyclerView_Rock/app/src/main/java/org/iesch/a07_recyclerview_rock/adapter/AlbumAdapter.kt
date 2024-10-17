package org.iesch.a07_recyclerview_rock.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.iesch.a07_recyclerview_rock.R
import org.iesch.a07_recyclerview_rock.model.Album

// 3 - Extendemos de RecyclerView: codigo que ya existe para sobreescribir los metodos de ese codigo, de manera que haga lo que nosotros queramos
class AlbumAdapter(private val listaDeAlbums:List<Album>) : RecyclerView.Adapter<AlbumViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        // Aqui le vamos a pasar el Layout que vamos a modificar.
        val layoutInflater = LayoutInflater.from(parent.context)

        return  AlbumViewHolder(layoutInflater.inflate(R.layout.item_album, parent, false))
    }

    override fun getItemCount(): Int {
        // Este metodo me pide el numero de elementos que va a tener el Recycler
        return listaDeAlbums.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        // Este metodo pasará por cada uno de los items y llamara a la funcion render
        val item = listaDeAlbums[position]
        holder.render(item)
    }
}