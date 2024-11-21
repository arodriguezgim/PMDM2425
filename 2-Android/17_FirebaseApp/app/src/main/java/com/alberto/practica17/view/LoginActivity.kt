package com.alberto.practica17.view

import android.content.Intent
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

        // Funcion setup para separar la lógica
        setup()
    }


    private fun setup() {
        // PULSAR EL BOTON IR A REGISTRO
        binding.btnRegister.setOnClickListener {
            irARegistro()
        }
        // PULSAR EN EL BOTON LOGUEAR
        binding.btnLogin.setOnClickListener {
            // Comprobar que se haya introducido usuario y contraseña
            if (binding.emailEditText.text.isNotEmpty() && binding.passEditText.text.isNotEmpty()) {

                // Loguear al usuario
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    binding.emailEditText.text.toString(), binding.passEditText.text.toString()
                ).addOnCompleteListener { respuesta ->
                        if (respuesta.isSuccessful) {
                            // Login Correcto
                            irAHomeActivity(binding.emailEditText.text.toString(), ProviderType.EMAIL_PASSWORD)
                        } else {
                            showError()
                        }
                    }


            }
        }
    }
    private fun irAHomeActivity(email:String, provider: ProviderType ) {
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }

    private fun irARegistro() {
        val registerIntent = Intent(this, RegisterActivity::class.java)
        startActivity(registerIntent)
    }

    private fun showError() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al loguear el usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}