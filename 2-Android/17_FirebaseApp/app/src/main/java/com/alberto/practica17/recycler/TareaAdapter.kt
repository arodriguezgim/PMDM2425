package com.alberto.practica17.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alberto.practica17.R
import com.alberto.practica17.model.Tarea

class TareaAdapter(
    private var tareas: List<Tarea>,
    private val eliminarTarea: (Tarea) -> Unit
) : RecyclerView.Adapter<TareaAdapter.TaskViewHolder>() {

    class TaskViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val nombre: TextView = view.findViewById(R.id.taskName)
        val borrarBtn: Button = view.findViewById(R.id.deleteButton)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaAdapter.TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TareaAdapter.TaskViewHolder, position: Int) {
        val tarea = tareas[position]
        holder.nombre.text = tarea.name
        holder.borrarBtn.setOnClickListener { eliminarTarea(tarea) }
    }

    override fun getItemCount(): Int {
        return tareas.size
    }

    fun actualizarTareas( nuevasTareas: List<Tarea> ){
        tareas = nuevasTareas
        notifyDataSetChanged()
    }
}