package org.iesch.a12_fragmentos_y_menu

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import org.iesch.a12_fragmentos_y_menu.fragments.DIRECCION_BUNDLE
import org.iesch.a12_fragmentos_y_menu.fragments.NOMBRE_BUNDLE
import org.iesch.a12_fragmentos_y_menu.fragments.PrimerFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if ( savedInstanceState == null){
            // 1 Creamos el Fragment desde aqui
            val bundle = bundleOf(
                NOMBRE_BUNDLE to "Alberto",
                DIRECCION_BUNDLE to "TERUEL"
            )

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<PrimerFragment>(R.id.fragmentContainer, args = bundle)
            }
        }



    }
}