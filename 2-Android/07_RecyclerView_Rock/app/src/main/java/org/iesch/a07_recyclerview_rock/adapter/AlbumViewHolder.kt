package org.iesch.a07_recyclerview_rock.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.iesch.a07_recyclerview_rock.R
import org.iesch.a07_recyclerview_rock.model.Album

// 4 Modificamos el ViewHolder
class AlbumViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    // 6 Accedo a las vistas del item Album
    // (forma basica)
    val titulo = view.findViewById<TextView>(R.id.tvTitulo)
    val anio = view.findViewById<TextView>(R.id.tvAnio)
    val autor = view.findViewById<TextView>(R.id.tvAutor)
    val imgAlbum = view.findViewById<ImageView>(R.id.imgAlbum)

    // 5 Creamos una funcion que se va a llamar por cada album que tenga que dibujar
    fun render(albumModel: Album){
        // 7 Asignamos el valor del album
        titulo.text = albumModel.titulo
        anio.text = albumModel.anio.toString()
        autor.text = albumModel.autor
        // no tocamos nadamas hasta que funcione to do
    }
}