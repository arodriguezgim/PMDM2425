package org.iesch.a11_splash_cine_halloween

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.iesch.a11_splash_cine_halloween.retrofit.MovieAPI
import org.iesch.a11_splash_cine_halloween.retrofit.MovieAdapter

private val apiKey = "61a4a7c148f9712b9b9044196bd0376d"

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerHalloween)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Usamos Corrutinas para mostrar la API
        CoroutineScope(Dispatchers.IO).launch {
            val movieApi = MovieAPI.create()
            val response = movieApi.getPopularMovies(apiKey)
            withContext(Dispatchers.Main){
                recyclerView.adapter = MovieAdapter(response.results)
            }
        }
    }
}