package org.iesch.a08_retrofit_dogs

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.iesch.a08_retrofit_dogs.adapter.DogAdapter
import org.iesch.a08_retrofit_dogs.api.APIService
import org.iesch.a08_retrofit_dogs.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// 1SV - Extiendo de OnQueryTextListener y me pedirá dos metodos
class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: DogAdapter
    private val dogImages = mutableListOf<String>()

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
        binding.svDogs.setOnQueryTextListener(this)
        initRecyclerView()
    }

    private fun initRecyclerView() {

            adapter = DogAdapter(dogImages)
            binding.rvDogs.layoutManager = LinearLayoutManager(this)
            //vamos a tener que pasarle un adapter
            binding.rvDogs.adapter = adapter
    }

    // 3 Creamos la instancia de nuestro Objeto Retrofit
    // Esta llamada va a tardar, hemos de hacer ASÍNCRONA
    private fun getRetrofit(): Retrofit{
        return  Retrofit.Builder()
            // IMPORTANTE: Siempre ha de terminar con una BARRA
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
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
            runOnUiThread {

                if (call.isSuccessful){
                    //Si es correcta la respuesta cogeremos las imágenes y se las añadiremos al listado de imágenes
                    val images = puppies?.imagesList ?: emptyList()
                    // borramos lo que tenemos anteriormente
                    dogImages.clear()
                    //añadimos lo que tenemos aqui
                    dogImages.addAll(images)
                    // avisamos al adapter que ha habido cambios en esta funcion
                    adapter.notifyDataSetChanged()
                } else {
                    //mostramos un error
                    showError()
                }
                hideKeyBoard()
            }
        }
    }

    private fun hideKeyBoard() {
        // Ocultaremos el teclado cada vez que demos a Buscar
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.main.windowToken, 0)
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un ERROR", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()){
            searchByName(query.lowercase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        //Este metodo nos va a avisar cada vez que haya cambios en cada letra
        //Como no nos interesa, devolvemos un true
        return true
    }
}



















