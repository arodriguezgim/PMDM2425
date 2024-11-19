package com.alberto.practica17.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alberto.practica17.R
import com.alberto.practica17.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    // 1
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Funcion setupp para separar la lógica
        setup()
    }

    private fun setup() {
        // PULSAR EN EL BOTON REGISTRAR
        binding.btnRegister.setOnClickListener {
            // Comprobar que se haya introducido usuario y contraseña
            if ( binding.emailEditText.text.isNotEmpty() && binding.passEditText.text.isNotEmpty() ){
                // Registramos el usuario
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.emailEditText.text.toString(),
                    binding.passEditText.text.toString()
                )
                    // Le añadimos un listener para comprobar si se ha registrado correctamente o no
                    .addOnCompleteListener {
                        respuesta ->
                        if ( respuesta.isSuccessful ){
                            // Esto es porque se ha añadido el usuario a nuestro Firebase
                            Toast.makeText(this, "Usuario Registrado correctamente", Toast.LENGTH_SHORT).show()
                        } else {
                            showError()
                        }
                    }
            }
        }
    }

    private fun showError() {
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle("Error al registrar")
        builder.setMessage("Se ha prroducido un error")
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}