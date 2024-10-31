package org.iesch.a12_fragmentos_y_menu.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.iesch.a12_fragmentos_y_menu.R

const val NOMBRE_BUNDLE = "nombre"
const val DIRECCION_BUNDLE = "direccion"


class PrimerFragment : Fragment() {

    private var nombre: String? = null
    private var direccion: String? = null

    // Este método se llama cuando la vista se haya cargado
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Oye! hay argumentos? (Con educacion). Si hay alguno... me lo puedes dar?
        arguments?.let {
            nombre = it.getString(NOMBRE_BUNDLE)
            direccion = it.getString(DIRECCION_BUNDLE)

            Log.i("DAM2", nombre.orEmpty() )
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primer, container, false)
    }

    // Los fragmentos se suelen instanciar con un método llamado newInstance
    // Este método, lo único que hace, es devolver el Fragment
    // Desde donde quiera que llame a este Fragment, le voy a pasar los parámetros que sea
    companion object {
        @JvmStatic
        fun newInstance(nombre: String, direccion: String) =
            PrimerFragment().apply {
                // Le estoy diciendo que coja al atrbuto arguments y le voy a pasar un Bundle
                // Un Bundle es donde va a guardar toda la info que le vamos a pasar al Fragment
                arguments = Bundle().apply {
                    putString(NOMBRE_BUNDLE, nombre)
                    putString(DIRECCION_BUNDLE, direccion)
                }
            }
    }
}