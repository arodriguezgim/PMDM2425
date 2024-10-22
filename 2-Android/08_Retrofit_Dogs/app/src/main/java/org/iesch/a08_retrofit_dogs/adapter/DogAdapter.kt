package org.iesch.a08_retrofit_dogs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.iesch.a08_retrofit_dogs.R

class DogAdapter(val images:List<String>) : RecyclerView.Adapter<DogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        //No tenemos ellayout que tenemos que inflar!!!!!!
        return DogViewHolder(layoutInflater.inflate(R.layout.dog_item, parent, false))
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val item = images[position]
        holder.render(item)
    }
}