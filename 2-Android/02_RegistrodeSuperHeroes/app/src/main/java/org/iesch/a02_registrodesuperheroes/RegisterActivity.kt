package org.iesch.a02_registrodesuperheroes

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.a02_registrodesuperheroes.databinding.ActivityRegisterBinding
import org.iesch.a02_registrodesuperheroes.model.Hero

class RegisterActivity : AppCompatActivity() {


    companion object {
        const val HERO_NAME_KEY = "hero"
        const val ALTER_EGO_KEY = "alter_ego"
        const val BIO_KEY = "bio"
        const val POWER_KEY = "power"
        const val HERO_KEY = "hero"
        const val FOTO_KEY = "foto"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val extras:Bundle = intent.extras!!

        val superHero = extras.getParcelable<Hero>(HERO_KEY)!!
        //val bitmap = bundle.getParcelable<Bitmap>(FOTO_KEY)!!
        val imagePath = extras.getString(FOTO_KEY)
        val bitmap = BitmapFactory.decodeFile(imagePath)

        binding.heroName.text = superHero.name
        binding.alterEgoText.text = superHero.alterEgo
        binding.bioText.text = superHero.bio
        binding.ratingBar.rating = superHero.power
        if (bitmap != null ){
            binding.imageView.setImageBitmap(bitmap)
        }


    }
}


















