package org.iesch.a02_registrodesuperheroes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.a02_registrodesuperheroes.databinding.ActivityRegisterBinding
import org.iesch.a02_registrodesuperheroes.model.Hero

class RegisterActivity : AppCompatActivity() {

    //13 (OPCIONAL) Podemos usar constantes para asignar las llaves y no equivocarnos
    companion object {
        const val HERO_NAME_KEY = "hero"
        const val ALTER_EGO_KEY = "alter_ego"
        const val BIO_KEY = "bio"
        const val POWER_KEY = "power"
        const val HERO_KEY = "hero"
    }


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
//        val superHeroName = bundle.getString(HERO_NAME_KEY) ?: "Sin Nombre"
//        val alterEgo = bundle.getString(ALTER_EGO_KEY) ?:  ""
//        val bio = bundle.getString(BIO_KEY) ?: ""
//        val power = bundle.getFloat(POWER_KEY) ?: 0.0
        val superHero = bundle.getParcelable<Hero>(HERO_KEY)!!

        // 12 - Los mostramos en pantalla
        binding.heroName.text = superHero.name
        binding.alterEgoText.text = superHero.alterEgo
        binding.bioText.text = superHero.bio
        binding.ratingBar.rating = superHero.power

    }
}


















