package org.iesch.a08_retrofit_dogs

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.iesch.a08_retrofit_dogs.api.APIService
import org.iesch.a08_retrofit_dogs.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // 3 Creamos la instancia de nuestro Objeto Retrofit
    // Esta llamada va a tardar, hemos de hacer ASÍNCRONA
    private fun getRetrofit(): Retrofit{
        return  Retrofit.Builder()
            // IMPORTANTE: Siempre ha de terminar con una BARRA
            .baseUrl("https://dog.ceo/api/breed/")
            //.addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    // 4 Creamos otro metodo usando Corrutinas
    private fun searchByName(raza: String){
        //Creamos la Corrutina
        CoroutineScope(Dispatchers.IO).launch {
            // Todas las cosas que hagamos aqui se ejecutarán en un hilo secundario
            val call = getRetrofit().create(APIService::class.java).getDogsByBreed("$raza/images")
            //call es un Response, no es el objeto que buscamos, por eso me creopuppies, que es el body de la respuesta
            val puppies = call.body()
            if (call.isSuccessful){

            } else {
                //mostramos un error
            }
        }
    }
}



















