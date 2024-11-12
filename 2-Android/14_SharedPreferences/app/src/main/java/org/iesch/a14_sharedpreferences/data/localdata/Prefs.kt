package org.iesch.a14_sharedpreferences.data.localdata

import android.content.Context

// Nuestra clase Prefs guardará y recuperará información
// Necesitaremos el Contexto, y en principio aqui no lo tenemos
class Prefs( val context: Context) {

    val SHARED_BD = "MiBD"
    val SHARED_USER_NAME = "username"
    val SHARED_USER_EMAIL = "email"
    val SHARED_VIP = "vip"

    val storage = context.getSharedPreferences(SHARED_BD, 0)

    fun guardarNombre(nombre:String){
        // con la clave username, guárdame el valo que hay en el campo de Nombre
        storage.edit().putString(SHARED_USER_NAME, nombre).apply()
    }
    fun guardarEmail(email:String){
        storage.edit().putString(SHARED_USER_EMAIL, email).apply()
    }
    fun guardarVIP(vip:Boolean){
        storage.edit().putBoolean(SHARED_VIP, vip).apply()
    }
    fun obtenerNombre() : String{
        return storage.getString(SHARED_USER_NAME, "")!!
    }
    fun obtenerEmail() : String{
        return storage.getString(SHARED_USER_EMAIL, "")!!
    }
    fun getVip() : Boolean{
        return  storage.getBoolean(SHARED_VIP, false)
    }

    fun borrarAll() {
        storage.edit().clear().apply()
    }
}