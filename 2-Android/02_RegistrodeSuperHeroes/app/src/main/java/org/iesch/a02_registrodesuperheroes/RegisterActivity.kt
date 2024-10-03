package org.iesch.a02_registrodesuperheroes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.a02_registrodesuperheroes.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // 9 - binding
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 10 - Nos creamos una variable bundle que recoge todos los valores traídos.
        val bundle:Bundle = intent.extras!!
        // 11 - Recoger cada uno de los valores del bundle
        // Estos valores pueden ser nulos. Lo solucionamos mediante el operador Elvis ?:
        val superHeroName = bundle.getString("heroName") ?: "Sin Nombre"
        val alterEgo = bundle.getString("alter_ego") ?:  ""
        val bio = bundle.getString("bio") ?: ""
        val power = bundle.getFloat("power") ?: 0.0

        // 12 - Los mostramos en pantalla
        binding.heroName.text = superHeroName.toString()
        binding.alterEgoText.text = alterEgo.toString()
        binding.bioText.text = bio.toString()
        binding.ratingBar.rating = power.toFloat()

    }
}


















