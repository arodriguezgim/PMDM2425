package org.iesch.a07_recyclerview_rock

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.iesch.a07_recyclerview_rock.adapter.AlbumAdapter
import org.iesch.a07_recyclerview_rock.databinding.ActivityMainBinding
import org.iesch.a07_recyclerview_rock.model.Album
import org.iesch.a07_recyclerview_rock.provider.AlbumProvider

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        //val layout = GridLayoutManager(this, 2)
        val layout = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, layout.orientation )

        binding.recyclerAlbum.layoutManager = layout
        // Ahora el Activity me esta diciendo que necesita un parametro para el onClickListener (la funcion Lambda)
        binding.recyclerAlbum.adapter = AlbumAdapter(AlbumProvider.listaDeAlbums) { album ->
            onItemSelected(
                album
            )
        }
        // it es la parte más confusa, cuando llame a esa funcionle voy a pasar el it, que va a ser el contenido del album
        binding.recyclerAlbum.addItemDecoration(decoration)
    }
    // Esta funcion va a recibir un Album
    fun onItemSelected(album: Album){
        // Creamos un Toast para comprobar que funcion
        Toast.makeText(
            this,
            album.titulo,
            Toast.LENGTH_SHORT)
            .show()
    }
}