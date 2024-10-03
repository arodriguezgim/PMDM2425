package org.iesch.a02_registrodesuperheroes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.a02_registrodesuperheroes.databinding.ActivityMainBinding
import org.iesch.a02_registrodesuperheroes.model.Hero

class MainActivity : AppCompatActivity() {
    private val CAMERA_KEY = 1000
    // lateinit es para prometerle a kotlin que cuando esa variable sea utilizada ya va a estar inicializada
    private lateinit var heroImage: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1 - Añadimos la funcionalidad de hacer click
        heroImage = binding.superheroImage
        heroImage.setOnClickListener {
            openCamera()
        }


        binding.saveButton.setOnClickListener {

            val superHeroName = binding.etHeroname.text.toString()
            val alterEgo = binding.etAlterego.text.toString()
            val bio = binding.bioEdit.text.toString()
            val power = binding.powerBar.rating

            val heroe = Hero(superHeroName, alterEgo, bio, power)
            openDetailActivity(heroe)
        }
    }

    private fun openCamera() {
        // 2 - ImplicitIntent: Android decide qué aplicaciones abre ese Intent
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, CAMERA_KEY)
    }

    private fun openDetailActivity(heroe:Hero) {

        val intent = Intent(this, RegisterActivity::class.java)

        intent.putExtra(RegisterActivity.HERO_KEY, heroe)
        intent.putExtra(RegisterActivity.FOTO_KEY, heroImage.drawable.toBitmap())

        startActivity(intent)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if ( resultCode == Activity.RESULT_OK && requestCode == CAMERA_KEY){
            val extras = data?.extras
            val heroBitmap = extras?.getParcelable<Bitmap>("data")
            heroImage.setImageBitmap(heroBitmap)
        }
    }
}







