package org.iesch.a07_recyclerview_rock.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.iesch.a07_recyclerview_rock.R
import org.iesch.a07_recyclerview_rock.model.Album

// 1 - Le vamos a pasar una funcion lambda
class AlbumAdapter(private val listaDeAlbums:List<Album>, private val onClickListener:(Album) -> Unit) : RecyclerView.Adapter<AlbumViewHolder>() {
    // Pero claro, este listener esta en al Adapter y se lo tenemos que pasar al ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return  AlbumViewHolder(layoutInflater.inflate(R.layout.item_album, parent, false))
    }

    override fun getItemCount(): Int {
        return listaDeAlbums.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val item = listaDeAlbums[position]
        // 2
        holder.render(item, onClickListener)
    }
}