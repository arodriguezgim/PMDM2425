package org.iesch.edadcanina

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.edadcanina.databinding.ActivityMainBinding

// 3 - Añadimos Data Binding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 1 - Tomamos el control sobre las Vistas que vamos a necesitar en la Activity
//        val resultText = findViewById<TextView>(R.id.tvRespuesta)
//        val calculateButton = findViewById<Button>(R.id.btnCalcular)
//        val ageEdit = findViewById<EditText>(R.id.etEdad)

        // LOGS EN ANDROID
//        Log.i("DAM2","Esto es un Los de tipo INFO")
//        Log.v("DAM2","Esto es un Los de tipo VERBOSE")
//        Log.d("DAM2","Esto es un Los de tipo DEBUG")
//        Log.w("DAM2","Esto es un Los de tipo WARNING")
//        Log.e("DAM2","Esto es un Los de tipo ERROR")




        // 2 - Los botones tienen la propiedad onClickListener al pulsarlos
        binding.btnCalcular.setOnClickListener {

            val ageString = binding.etEdad.text.toString()

            if (ageString.isEmpty()){
                // No hacemos nada
                //Log.i("EdadCanina", "No has introducido ningun numero")
                // makeText no necesita llamar a getString (lo hace automaticamente)
                Toast.makeText(this, getString(R.string.debes_numero), Toast.LENGTH_LONG).show()
            } else {
                val ageInt = ageString.toInt()
                val dogAge = ageInt * 7
                //resultText.text = "Si fueras perro, tu edad sería de $dogAge años."
                binding.tvRespuesta.text = getString(R.string.resultado, dogAge)
            }






        }

        
    }
}