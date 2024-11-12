package org.iesch.a14_sharedpreferences

import android.app.Application
import org.iesch.a14_sharedpreferences.data.localdata.Prefs

// Esta clase quiero que se ejecute antes de arrancar la Aplicacion
// Podemos meter logica aqui que queramos usar en toda la aplicación
class UserVipApplication : Application() {
    companion object {
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        // cuando arranque la App haz lo que te diga aqui
        prefs = Prefs(applicationContext)
    }
}