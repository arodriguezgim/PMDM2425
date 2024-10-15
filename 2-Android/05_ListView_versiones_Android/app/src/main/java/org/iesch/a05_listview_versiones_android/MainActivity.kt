package org.iesch.a05_listview_versiones_android

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.a05_listview_versiones_android.databinding.ActivityMainBinding

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

        // 1 - Creamos un ArrayAdapter para trabajar con los elementos de nuestro ListView
        val arrayAdapter: ArrayAdapter<*>
        // 2 - Voy a usar unalista mutable, y coloco los elementos
        val versiones = mutableListOf("Pie", "Oreo", "Nougat", "Marshmallow", "Lollipop", "Kitkat", "JellyBean", "Ice Cream", "Tiramisu", "...")
        // 3 Declaro la variable que va a llamar de formagráfica a mi ListView
        val lvDatos:ListView = binding.listaversiones
        // 4  - Para llenar de datos la lista creamos un arrayAdapter, que es un objeto de tipo ArrayAdapter
        // Me pide: el contexto, cómo quiero mostrar mis datos por pantalla (ahora uso una genérica de Android), y los datos que quiero mostrar
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, versiones)
        // 5 - Llamo al lvdatos de Datos y lo adapto, el adaptador traerá toda la indformación del arrayList, y lo adaptará a nuestra lista
        lvDatos.adapter = arrayAdapter
        // 6 - Quiero hacer que muestre un mensaje Toast con el nombre del elemento que pulso
        lvDatos.setOnItemClickListener {
                                       // Los 4 parametro de la funcion lambda:
                                       adapterView, view, position, id ->
            //adapterView es el elemento visual donde estan los datos
            //view es la vista
            //position es la posicion de cada elemento
            // id es el index de cada elemento
            Toast.makeText(this, adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show()
        }
    }
}
















