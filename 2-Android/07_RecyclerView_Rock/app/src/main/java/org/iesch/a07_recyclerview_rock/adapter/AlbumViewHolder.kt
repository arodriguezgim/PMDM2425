package org.iesch.a07_recyclerview_rock.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.iesch.a07_recyclerview_rock.R
import org.iesch.a07_recyclerview_rock.databinding.ItemAlbumBinding
import org.iesch.a07_recyclerview_rock.model.Album


class AlbumViewHolder(val view: View) : RecyclerView.ViewHolder(view){

    val binding = ItemAlbumBinding.bind(view)

    fun render(albumModel: Album){

        binding.tvTitulo.text = albumModel.titulo
        binding.tvAnio.text = albumModel.anio.toString()
        binding.tvAutor.text = albumModel.autor
    // 2
        Glide.with(binding.imgAlbum.context)
            .load(albumModel.portada)
            .into(binding.imgAlbum)
    }
}