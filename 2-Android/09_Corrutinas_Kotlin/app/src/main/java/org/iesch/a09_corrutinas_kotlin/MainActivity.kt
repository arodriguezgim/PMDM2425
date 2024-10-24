package org.iesch.a09_corrutinas_kotlin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.iesch.a09_corrutinas_kotlin.retrofit.RetrofitHelper

class MainActivity : AppCompatActivity() {

    val retrofit = RetrofitHelper.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Main -> Hilo principal. Es el quepinta la UI. No usar nunca si no es para algo de la UI
        // IO -> Peticiones no muy pesadas, pero que pueden tardar.
        // Default -> Operaciones muy pesadas que requieran mucha CPU
        lifecycleScope.launch(Dispatchers.IO) {
            // Lo que mande aqui me lo ejecuta en una corrutina aparte
            // Llamo a Retrofit
            val response = retrofit.getSuperHeroes("a")
            withContext(Dispatchers.Main){
                // vuelvo al hilo principal
                if ( response.isSuccessful ) {
                    Toast.makeText(this@MainActivity, "FUNCIONA", Toast.LENGTH_SHORT).show()
                }
            }
            // Esto es una alternativa
            //runOnUiThread { Toast.makeText(this@MainActivity, "FUNCIONA", Toast.LENGTH_SHORT).show() }

        }


    }
    // Las funciones suspendidas solo pueden ser llamadas desde una corrutina
    suspend fun hacerAlgo() {
    }

    fun waitForCoroutines(){
        lifecycleScope.launch(Dispatchers.IO) {
            //Necesito esperar a que todas estas llamadas se hagan para poder continuar
            // Para esto tenemos los deferred
//            val deferred1 = async { retrofit.getSuperHeroes("a") }
//            val deferred2 = async { retrofit.getSuperHeroes("b") }
//            val deferred3 = async { retrofit.getSuperHeroes("c") }
//            val deferred4 = async { retrofit.getSuperHeroes("d") }
//            // Como tengo Deferred
//            val response = deferred1.await()
//            val response2 = deferred2.await()
//            val response3 = deferred3.await()
//            val response4 = deferred4.await()
            // Hay una solucion mas top
            val deferreds = listOf(
                async { retrofit.getSuperHeroes("a")},
                async { retrofit.getSuperHeroes("b")},
                async { retrofit.getSuperHeroes("c")},
                async { retrofit.getSuperHeroes("d")},
            )
            val response = deferreds.awaitAll()
        }
    }
}