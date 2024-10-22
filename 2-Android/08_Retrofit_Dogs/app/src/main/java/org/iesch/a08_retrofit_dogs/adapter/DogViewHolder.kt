package org.iesch.a08_retrofit_dogs.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.iesch.a08_retrofit_dogs.databinding.DogItemBinding

class DogViewHolder(view:View) : RecyclerView.ViewHolder(view) {
    private val binding = DogItemBinding.bind(view)
    fun render(image: String){
        // Vamos a usar la libreria de Picasso para pintar cada celda
        Picasso.get()
            .load(image)
            .into(binding.ivDog)
    }
}