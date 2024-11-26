package com.alberto.practica17.view

import android.content.Context
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
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig


enum class  ProviderType {
    EMAIL_PASSWORD,
    GOOGLE
}

class HomeActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityHomeBinding
    
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
            .addOnCompleteListener {
                if (it.isSuccessful){
                    val mostrarboton = Firebase.remoteConfig["mostrar_boton"].asBoolean()
                }
            }

        setup(email ?: "", provider ?: "")
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
    }
}