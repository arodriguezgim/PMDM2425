package org.iesch.a15_google_maps

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    // 1 - Nos creamos la variable que será nuestro mapa
    private lateinit var map : GoogleMap

    // Creo la  constante para el codigo
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.map)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        createFragment()
    }
    // 2 - createFragment creará el mapa
    private fun createFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    // 3 - Este metoso se llamará cuando el mapa haya sido creado
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
        enableLocation()
    }

    private fun createMarker() {
        val chascoords = LatLng(40.34012863607817, -1.1063987071381094)
        val marcador = MarkerOptions().position(chascoords).title("Mi peña favorita")

        map.addMarker(marcador)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(chascoords, 18f),
            4000,
            null
        )
    }

    // 4 - Funcion para saber si tenemos los permisos o no
    private fun isLocationPermissionGranted() = ContextCompat
        .checkSelfPermission( this,
            android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

    // 5 Creamos una funcion que compruebe esto
    private fun enableLocation(){
        // si todavia no se ha creado el mapa
        if (!::map.isInitialized) return
        if ( isLocationPermissionGranted()){
            // si que tiene permiso
            map.isMyLocationEnabled = true
        } else {
            requestLocationPermission()
        }
    }
    // Esta funcion es para pedir los permisos de Localizacion
    private fun requestLocationPermission() {
        // Lógica para que el usuario acepte el permiso
        if ( ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.ACCESS_FINE_LOCATION)){
            // si entro por aqui será porque ya le habíamos pedido los permisos y los rechazó
            // Mostramos una alerta para que acepte los permisos
            Toast.makeText(this, "Ve a ajustes y acepta los permisos de ubicación", Toast.LENGTH_SHORT).show()
        } else {
            //Pedimos el permiso
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED ){
                    map.isMyLocationEnabled = true
                } else {
                    Toast.makeText(this, "Ve a ajustes y acepta los permisos de ubicación", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
















