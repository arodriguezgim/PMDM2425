package org.iesch.a07_recyclerview_rock.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.iesch.a07_recyclerview_rock.R
import org.iesch.a07_recyclerview_rock.databinding.ItemAlbumBinding
import org.iesch.a07_recyclerview_rock.model.Album


class AlbumViewHolder(val view: View) : RecyclerView.ViewHolder(view){

    val binding = ItemAlbumBinding.bind(view)

    fun render(albumModel: Album, onClickListener:(Album)->Unit){

        binding.tvTitulo.text = albumModel.titulo
        binding.tvAnio.text = albumModel.anio.toString()
        binding.tvAutor.text = albumModel.autor
        Glide.with(binding.imgAlbum.context)
            .load(albumModel.portada)
            .into(binding.imgAlbum)
        // Ahora cada vez que pulsemos en un item vamos a llamar a la funcion Lambda
        itemView.setOnClickListener { onClickListener(albumModel) }

        // 1 - Controlamos la foto de cada celda
//        binding.imgAlbum.setOnClickListener {
//            Toast.makeText(
//                binding.imgAlbum.context,
//                albumModel.autor,
//                Toast.LENGTH_SHORT)
//                .show()
//        }
        // 2 -Si queremos controlar TODA la celda (lo mas comun)
//        itemView.setOnClickListener {
//            Toast.makeText(
//                binding.imgAlbum.context,
//                albumModel.titulo,
//                Toast.LENGTH_SHORT)
//                .show()
//        }
      }
}


















