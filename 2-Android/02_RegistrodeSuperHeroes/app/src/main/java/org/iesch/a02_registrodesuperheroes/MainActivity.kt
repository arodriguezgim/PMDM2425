package org.iesch.a02_registrodesuperheroes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.a02_registrodesuperheroes.databinding.ActivityMainBinding
import org.iesch.a02_registrodesuperheroes.model.Hero
import java.io.File

class MainActivity : AppCompatActivity() {
    private val CAMERA_KEY = 1000

    private lateinit var heroImage: ImageView

    private var heroBitmap: Bitmap? = null
    // 1 - Si queremos guardar la imagen en memoria o que se vea mejor:
    private var pictureFullPath = ""

    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicture()){

        // Ahora nos devuelve un booleano. Si la toma de foto fue exitosa devolveremos un success
        success ->
        if (success && pictureFullPath.isNotEmpty()){
            heroBitmap = BitmapFactory.decodeFile(pictureFullPath)
            //dibujamos la imagen en miniatura
            heroImage.setImageBitmap(heroBitmap!!)
        }
    }



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

       // 3 - Creamos un File y de ese file recuperamos el uri. Creamos la funcion.
        val imageFile = createImageFile()// 5 - Dependiendo de la version que tengamos de Android se obtiene el Uri de una manera o de otra
        val uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            //En las nuevas versiones...
            FileProvider.getUriForFile(
                this,
                "$packageName.provider",
                imageFile
            )

        } else {
            Uri.fromFile(imageFile)
        }

        getContent.launch(uri)
    }

    //4
    private fun createImageFile(): File {
        val fileName = "superhero_image"
        //Directorio donde vamos a guardar la imagen. Directory Pictures se utiliza por defecto
        val fileDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        //Creamos nuestro file, nos pide el nombre, el formato y el directorio
        val file = File.createTempFile(fileName,".jpg", fileDirectory)
        //El path absoluto se va a guardar en filepath
        pictureFullPath = file.absolutePath
        return file
    }

    private fun openDetailActivity(heroe:Hero) {

        val intent = Intent(this, RegisterActivity::class.java)

        intent.putExtra(RegisterActivity.HERO_KEY, heroe)
        intent.putExtra(RegisterActivity.FOTO_KEY, pictureFullPath)

        startActivity(intent)
    }



}







