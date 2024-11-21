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
import com.alberto.practica17.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setup()
    }

    private fun setup() {
        // PULSAR EN IR A LOGIN
        binding.btnIrALogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        // PULSAR EN EL BOTON REGISTRAR
        binding.btnCrearCuenta.setOnClickListener {
            // Comprobar que se haya introducido usuario y contraseña
            if ( binding.emailEditText.text.isNotEmpty() && binding.passEditText.text.isNotEmpty() ){

                // Comprobamos que la contraseña sea la misma
                if ( binding.passEditText.text.toString() == binding.passRepeatEditText.text.toString()){
                    // Registramos el usuario
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                        binding.emailEditText.text.toString(),
                        binding.passEditText.text.toString()
                    )
                        .addOnCompleteListener {
                                respuesta ->
                            if ( respuesta.isSuccessful ){
                                // Esto es porque se ha añadido el usuario a nuestro Firebase
                                Toast.makeText(this, "Usuario Registrado correctamente", Toast.LENGTH_SHORT).show()
                                irAHomeActivity(
                                    binding.nombreEditText.text.toString(),
                                    binding.emailEditText.text.toString(),
                                    ProviderType.EMAIL_PASSWORD
                                    )
                            } else {
                                showError()
                            }
                        }
                } else {
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }


            }
        }
    }

    private fun irAHomeActivity(nombre: String, email:String, provider: ProviderType ) {
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("nombre",nombre)
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }

    private fun showError() {
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle("Error al registrar")
        builder.setMessage("Se ha producido un error")
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}