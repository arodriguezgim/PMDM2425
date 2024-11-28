package com.alberto.practica17.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alberto.practica17.R
import com.alberto.practica17.model.Tarea

class TareaAdapter(
    private var tasks: List<Tarea>,
    private val onDelete: (Tarea) -> Unit
) : RecyclerView.Adapter<TareaAdapter.TaskViewHolder>() {
    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val taskName: TextView = view.findViewById(R.id.taskName)
        val deleteButton: Button = view.findViewById(R.id.deleteButton)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.taskName.text = task.name
        holder.deleteButton.setOnClickListener { onDelete(task) }
    }
    override fun getItemCount(): Int = tasks.size
    fun updateTasks(newTasks: List<Tarea>) {
        tasks = newTasks
        notifyDataSetChanged()
    }
}