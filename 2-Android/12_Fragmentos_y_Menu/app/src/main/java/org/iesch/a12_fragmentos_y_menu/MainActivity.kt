package org.iesch.a12_fragmentos_y_menu

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.iesch.a12_fragmentos_y_menu.fragments.DIRECCION_BUNDLE
import org.iesch.a12_fragmentos_y_menu.fragments.NOMBRE_BUNDLE
import org.iesch.a12_fragmentos_y_menu.fragments.PrimerFragment
import org.iesch.a12_fragmentos_y_menu.fragments.SegundoFragment
import org.iesch.a12_fragmentos_y_menu.fragments.TercerFragment

class MainActivity : AppCompatActivity() {

    private lateinit var  navigation: BottomNavigationView
    private val mOnNavMenu = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when ( item.itemId ){
            R.id.itemPrimerFragment -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<PrimerFragment>(R.id.fragmentContainer )
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.itemSegundoFragment -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<SegundoFragment>(R.id.fragmentContainer )
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.itemTercerFragment -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<TercerFragment>(R.id.fragmentContainer )
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        navigation = findViewById(R.id.navMenu)
        navigation.setOnNavigationItemSelectedListener(mOnNavMenu)

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