package com.alberto.practica17.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.alberto.practica17.R
import com.alberto.practica17.databinding.ActivityListaTareasBinding
import com.alberto.practica17.model.Tarea
import com.alberto.practica17.recycler.TareaAdapter
import com.google.firebase.firestore.FirebaseFirestore

class ListaTareasActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListaTareasBinding
    private lateinit var adapter : TareaAdapter
    private val db = FirebaseFirestore.getInstance()
    private val tareasCollection = db.collection("tareas")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListaTareasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerView
        adapter = TareaAdapter( emptyList() ) { tarea -> eliminarTarea(tarea) }
        binding.tasksRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.tasksRecyclerView.adapter = adapter

        // Traemos la lista de tareas
        fetchTareas()

        // Añadir tarea al Recycler
        binding.addTaskButton.setOnClickListener {
            val nombreTarea = binding.taskInput.text.toString()
            if ( nombreTarea.isNotEmpty() ){
                addTarea(nombreTarea)
                fetchTareas()
            } else {
                Toast.makeText(this, "La tarea no puede estar vacia", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun fetchTareas() {
        tareasCollection.get()
            .addOnSuccessListener { snapshot ->
                val tareas = snapshot.documents.map {
                    doc ->
                    Tarea( id = doc.id, name = doc.getString("name") ?: "")
                }
                adapter.actualizarTareas(tareas)
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al Actualizar tareas", Toast.LENGTH_SHORT).show()
            }
    }

    private fun addTarea(nombreTarea: String) {
            val tarea = hashMapOf("name" to nombreTarea )
        tareasCollection.add( tarea )
            .addOnSuccessListener {
                binding.taskInput.text.clear()
                Toast.makeText(this, "Tarea Añadida", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al añadir tarea", Toast.LENGTH_SHORT).show()
            }
    }

    private fun eliminarTarea(tarea: Tarea) {
        tareasCollection.document(tarea.id).delete()
            .addOnSuccessListener {
                fetchTareas()
                Toast.makeText(this, "Tarea ELIMINADA", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "No se ha podido eliminar la tarea", Toast.LENGTH_SHORT).show()
            }
    }
}