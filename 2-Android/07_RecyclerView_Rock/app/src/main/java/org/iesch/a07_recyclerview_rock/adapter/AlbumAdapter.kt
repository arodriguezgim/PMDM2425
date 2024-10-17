package org.iesch.a07_recyclerview_rock.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.iesch.a07_recyclerview_rock.R
import org.iesch.a07_recyclerview_rock.model.Album

class AlbumAdapter(private val listaDeAlbums:List<Album>) : RecyclerView.Adapter<AlbumViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return  AlbumViewHolder(layoutInflater.inflate(R.layout.item_album, parent, false))
    }

    override fun getItemCount(): Int {
        return listaDeAlbums.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val item = listaDeAlbums[position]
        holder.render(item)
    }
}