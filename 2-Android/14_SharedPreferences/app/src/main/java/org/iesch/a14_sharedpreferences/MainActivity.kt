package org.iesch.a14_sharedpreferences

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.a14_sharedpreferences.UserVipApplication.Companion.prefs
import org.iesch.a14_sharedpreferences.databinding.ActivityMainBinding

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

        initUI()
        comprobar()
    }

    private fun comprobar() {
        if ( prefs.obtenerNombre().isNotEmpty() ){
            irADetalle()
        }
    }


    private fun initUI() {
        // Capturar el listener del boton
        binding.btnGuardar.setOnClickListener {
            comprobarValores()
        }
    }

    private fun comprobarValores() {
        //Comprobaremos si tenemos email y nombre
        if (binding.etEmail.text.toString().isNotEmpty() && binding.etNombre.text.toString().isNotEmpty() ){
            // Guardaremos la información del usuario
            prefs.guardarNombre(binding.etNombre.text.toString())
            prefs.guardarEmail(binding.etEmail.text.toString())
            prefs.guardarVIP(binding.cbVip.isChecked)
            // Vamos a la otra pantalla
            irADetalle()
        } else {
            // Haremos otra cosa
            Toast.makeText(this, "Debes rellenar los 2 campos editables", Toast.LENGTH_SHORT).show()
        }
    }

    private fun irADetalle() {
        startActivity(Intent(this, ResultActivity::class.java))
    }
}