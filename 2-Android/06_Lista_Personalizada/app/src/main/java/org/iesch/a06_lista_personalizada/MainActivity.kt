package org.iesch.a06_lista_personalizada

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.a06_lista_personalizada.adapter.ProductoAdapter
import org.iesch.a06_lista_personalizada.databinding.ActivityMainBinding
import org.iesch.a06_lista_personalizada.model.Producto

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
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

        // 1
        val producto1 = Producto("Cámara de fotos", 100.0, "Camara epson de mpx de última generación",R.drawable.camara)
        val producto2 = Producto("Iphone 16", 980.0, "Móvil de Apple 5G",R.drawable.telefono)

        val listaProductos = listOf<Producto>(producto1,producto2)

        val customAdapter = ProductoAdapter(this, listaProductos)

        binding.listaproductos.adapter = customAdapter

        // Tarea a Domicilio
        binding.listaproductos.setOnItemClickListener { adapterView, view, position, id ->

            // Crear el Intent, pasarle mediante putExtra el Producto, y startActivity...
        }
    }
}
















