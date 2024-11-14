package org.iesch.a15_google_maps

import android.content.pm.PackageManager
import android.location.Location
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CustomCap
import com.google.android.gms.maps.model.Dash
import com.google.android.gms.maps.model.Dot
import com.google.android.gms.maps.model.Gap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.maps.model.RoundCap

class MainActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {


    private lateinit var map : GoogleMap


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

    private fun createFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    // 2

    private fun createPolylines() {
        val polylinesOptions = PolylineOptions()
            .add(LatLng(40.35326928818816,-1.10872386116381 ))
            .add(LatLng(40.341787196327715,-1.1153078441756463 ))
            .add(LatLng(40.3276087956057,-1.1069706639350727 ))
            .add(LatLng(40.32642885176733,-1.0915317577413646 ))
            .add(LatLng(40.34256434412808,-1.0966072458418807 ))
            .add(LatLng(40.35326928818816,-1.10872386116381 ))
            .width(30f)
            .color(ContextCompat.getColor(this, R.color.polilyne_color))

        val polyline = map.addPolyline(polylinesOptions)
        polyline.startCap = RoundCap()
        // polyline.endCap = CustomCap(BitmapDescriptorFactory.fromResource(R.drawable.indice))

        val pattern = listOf(
            Dot(), Gap(10F), Dash(50F), Gap(10F)
        )
        polyline.pattern = pattern

        polyline.isClickable = true
        map.setOnPolylineClickListener {
            cambiarColor(polyline)
        }
    }

    private fun cambiarColor(polyline: Polyline) {
        val color = (0..3).random()
        when(color){
            0-> polyline.color = ContextCompat.getColor(this, R.color.polilyne_color)
            1-> polyline.color = ContextCompat.getColor(this, R.color.polilyne_color_2)
            2-> polyline.color = ContextCompat.getColor(this, R.color.polilyne_color_3)
            3-> polyline.color = ContextCompat.getColor(this, R.color.polilyne_color_4)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        // 1
        createMarker()
        createPolylines()
        map.setOnMyLocationButtonClickListener(this)
        map.setOnMyLocationClickListener(this)
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


    private fun isLocationPermissionGranted() = ContextCompat
        .checkSelfPermission( this,
            android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED


    private fun enableLocation(){

        if (!::map.isInitialized) return
        if ( isLocationPermissionGranted()){

            map.isMyLocationEnabled = true
        } else {
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission() {

        if ( ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.ACCESS_FINE_LOCATION)){

            Toast.makeText(this, "Ve a ajustes y acepta los permisos de ubicación", Toast.LENGTH_SHORT).show()
        } else {

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

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this, "Botón Pulsado", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun onMyLocationClick(p0: Location) {
        Toast.makeText(this, "Estás en ${p0.latitude}, ${p0.longitude}", Toast.LENGTH_SHORT).show()
    }
}
















