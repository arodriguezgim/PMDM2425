package com.alberto.practica17.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alberto.practica17.R
import com.alberto.practica17.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.get
import com.google.firebase.remoteconfig.ktx.remoteConfig


enum class  ProviderType {
    EMAIL_PASSWORD,
    GOOGLE
}

class HomeActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityHomeBinding
    // 1 Instancia de nuestra Base de Datos
    private val db = FirebaseFirestore.getInstance()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Recuperarmos los datos del Bundle
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        // Guardado de datos
        val prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE)
        prefs.edit().putString("email", email).putString("provider", provider).apply()

        // Recupero la informacin de RemoteConfig
        binding.btnTodos.visibility = View.INVISIBLE
        Firebase.remoteConfig.fetchAndActivate()
            .addOnCompleteListener { respuesta ->
                if (respuesta.isSuccessful){
                    val mostrarboton = Firebase.remoteConfig["show_todo_button"].asBoolean()
                    val textoBoton = Firebase.remoteConfig["text_todo_button"].asString()
                    binding.btnTodos.visibility = if ( mostrarboton ) View.VISIBLE else View.GONE
                    binding.btnTodos.text = textoBoton
                }
            }

        setup(email ?: "", provider ?: "")
        // Firebase Firestore
        // 2 Tomamos el control de nuestro Botones
        binding.btnGuardar.setOnClickListener {
            // 2 Guardamos Datos
            db.collection("usuarios").document(email!!).set(
                hashMapOf(
                    "provider" to provider,
                    "direccion" to binding.addressTextView.text.toString(),
                    "telefono" to binding.phoneTextView.text.toString(),
                )
            )
        }
        binding.btnRecuperar.setOnClickListener {
            // Recuperamos la Info
            db.collection("usuarios").document( email!! ).get().addOnCompleteListener {
                // dibujamos los datos obtenidos
                binding.addressTextView.setText(it.result.getString("direccion"))
                binding.phoneTextView.setText(it.result.getString("telefono"))
            }
        }
        binding.btnBorrar.setOnClickListener {
            // Borrar los datos
            db.collection("usuarios").document( email!! ).delete()
        }
    }


    private fun setup(email: String, provider: String) {
        title = "Home"
        binding.emailTextView.text = email.toString()
        binding.providerTextView.text = provider.toString()

        // Boton Cerrar Sesion
        binding.btnLogout.setOnClickListener {
            // borrado de datos
            val prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE)
            prefs.edit().clear().apply()

            FirebaseAuth.getInstance().signOut()
            onBackPressed()
            finish()
        }

        // Boton Crash
        binding.btnCrash.setOnClickListener {

            // Podemos enviar log de contexto
            FirebaseCrashlytics.getInstance().log("Esta App pasa por aquí")
            // La app crasheará en Firebase
            throw RuntimeException("Error controlado para Firebase CrashLytics")
        }

        binding.btnTodos.setOnClickListener {
            val intent = Intent(this, ListaTareasActivity::class.java)
            startActivity(intent)
        }
    }
}