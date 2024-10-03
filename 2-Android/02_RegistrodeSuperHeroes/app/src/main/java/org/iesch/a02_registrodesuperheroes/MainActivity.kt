package org.iesch.a02_registrodesuperheroes

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.a02_registrodesuperheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // 1 - Añadimos dataBinding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 2 - Le damos funcionalidad al boton
        binding.saveButton.setOnClickListener {
            // 6 - Nos creamos las variables necesarias para pasarlas al Intent
            val superHeroName = binding.etHeroname.text.toString()
            val alterEgo = binding.etAlterego.text.toString()
            val bio = binding.bioEdit.text.toString()
            val power = binding.powerBar.rating
            openDetailActivity(superHeroName, alterEgo, bio, power)
        }
    }
    //3 - Creamos la funcion que genera un Intent y nos lleva a detalle
    // 7
    private fun openDetailActivity(superheroName: String, alterEgo: String, bio: String, power: Float) {
        // 4 - Vamos a abrir DetailActivity. El Intent debe tener muy claro desde dónde se le llama y a dónde va
        val intent = Intent(this, RegisterActivity::class.java)

        // 8 Añado los valores al Intent con la funcion putExtra
        intent.putExtra(RegisterActivity.HERO_NAME_KEY, superheroName)
        intent.putExtra(RegisterActivity.ALTER_EGO_KEY, alterEgo)
        intent.putExtra(RegisterActivity.BIO_KEY, bio)
        intent.putExtra(RegisterActivity.POWER_KEY, power)
        // 5 Para utilizar el intent tenemos que llamar a startActivity
        startActivity(intent)
    }
}