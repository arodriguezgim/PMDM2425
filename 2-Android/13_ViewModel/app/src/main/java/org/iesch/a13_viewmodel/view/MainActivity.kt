package org.iesch.a13_viewmodel.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import org.iesch.a13_viewmodel.R
import org.iesch.a13_viewmodel.databinding.ActivityMainBinding
import org.iesch.a13_viewmodel.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    // 3 Creamos la variable para conectar la activity con nuestro ViewModel.
    // Le especificamos eltipo y con el by nos hará toda la conexión de ciclo de vida, etc.
    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.viewContainer)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 4 A nuestro quoteViewModel le vamos a observar la variable quoteModel conla funcion Observer
        quoteViewModel.quoteModel.observe( this, Observer { cita->
            // To do lo que tenemos aquí dentro estará enganchado a nuestro LiveData
            // Cuando nuestro LiveData tenga un cambio, cambiará la cita
            binding.tvCita.text = cita.cita
            binding.tvAutor.text = cita.autor
        })
        // 5 Llamamos a la funcion de cambiar la Cita cuando toquemos la pantalla
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }

    }
}















