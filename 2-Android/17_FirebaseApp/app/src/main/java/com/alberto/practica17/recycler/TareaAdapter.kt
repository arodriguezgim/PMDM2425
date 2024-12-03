package com.alberto.practica17.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alberto.practica17.model.Tarea

class TareaAdapter(
    private var tareas: List<Tarea>,
    private val eliminarTarea: (Tarea) -> Unit
) : RecyclerView.Adapter<TareaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate()
    }

    override fun onBindViewHolder(holder: TareaAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return tareas.size
    }
}