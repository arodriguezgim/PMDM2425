package com.alberto.practica17.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alberto.practica17.R
import com.alberto.practica17.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings

class LoginActivity : AppCompatActivity() {

    private val GOOGLE_SIGN_IN = 100

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
        // Iniciamos Remote Config
        val configSettings : FirebaseRemoteConfigSettings =  remoteConfigSettings {
            // cada cuantos segundos quiero que se actualicen estos valores
            minimumFetchIntervalInSeconds = 60
        }
        // Ya podemos acceder a remote Config
        val firebaseConfig : FirebaseRemoteConfig = Firebase.remoteConfig
        firebaseConfig.setConfigSettingsAsync(configSettings)
        // La aplicacion puede no tener acceso a internet en ese instante
        firebaseConfig.setDefaultsAsync(
            mapOf(
                "show_todo_button" to false,
                "text_todo_button" to "Un texto cualquiera"
            )
        )
        // Configuramos los mensajes Push
        notification()
        // Funcion setup para separar la lógica
        setup()
        // Comprobamos si hay una sesion
        session()
    }

    private fun notification() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            it.result?.let { token ->
                //Imprimimos el token
                println("Este es el token del dispositivo: $token")
            }
        }
        // Nos suscribimos a temas
        FirebaseMessaging.getInstance().subscribeToTopic("DAM")

        // Recuperamos unformacion de la notificacion
        val url = intent.getStringExtra("url")
        url?.let {
            println("Ha llegado información en un Push: $it")
        }
    }

    private fun session() {
        val prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE)
        val email = prefs.getString("email", null)
        val provider = prefs.getString("provider", null)
        if (email != null && provider != null ){
            binding.authLayout.visibility = View.INVISIBLE
            irAHomeActivity(email, ProviderType.valueOf(provider))
        }
    }

    override fun onStart() {
        super.onStart()
        binding.authLayout.visibility = View.VISIBLE
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
        // PULSAR EL BOTON LOGIN GOOGLE
        binding.btnGoogle.setOnClickListener {
            // Configuracion
            val googleConf =GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.google_id))
                .requestEmail()
                .build()
            // Iniciar la autentificacion
            val googleSignInClient = GoogleSignIn.getClient(this, googleConf)

            googleSignInClient.signOut()

            startActivityForResult(googleSignInClient.signInIntent, GOOGLE_SIGN_IN)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if ( requestCode == GOOGLE_SIGN_IN ){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            val account = task.getResult(ApiException::class.java)
            // Si to do ha ido bien tendremos la cuenta de google.
            //Ahora nos autenticamos en Google
            if ( account != null ){
                val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                FirebaseAuth.getInstance().signInWithCredential(credential)
                    .addOnCompleteListener {
                        registro ->
                        if (registro.isSuccessful) {
                            irAHomeActivity(account.email ?: "", ProviderType.GOOGLE)
                        } else {
                            showError()
                        }
                    }
            }
        }
    }
}