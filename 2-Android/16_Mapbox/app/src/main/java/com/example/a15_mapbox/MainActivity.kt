package com.example.a15_mapbox

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager

class MainActivity : AppCompatActivity() {

    private lateinit var mapView: MapView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mapView = MapView(this)
        setContentView(mapView)
        mapView.mapboxMap
            .apply {
                setCamera(
                    CameraOptions.Builder()
                        .center(Point.fromLngLat(LONGITUDE, LATITUDE))
                        .zoom(16.0)
                        .build()
                )
            }

        mostrarMarkers()
    }

    private fun mostrarMarkers() {

// Create an instance of the Annotation API and get the PointAnnotationManager.
        val annotationApi = mapView?.annotations
        val pointAnnotationManager = annotationApi?.createPointAnnotationManager(mapView)
// Set options for the resulting symbol layer.
        val pointAnnotationOptions: PointAnnotationOptions = PointAnnotationOptions()
            // Define a geographic coordinate.
            .withPoint(Point.fromLngLat(LATITUDE, LONGITUDE))
            .withIconColor(ContextCompat.getColor(this, R.color.black))
            // Specify the bitmap you assigned to the point annotation
            // The bitmap will be added to map style automatically.
            //.withIconImage(ContextCompat.getDrawable(this, R.drawable.red_marker))
// Add the resulting pointAnnotation to the map.
        pointAnnotationManager?.create(pointAnnotationOptions)
    }

    companion object {
        private const val LATITUDE = 40.351700611071
        private const val LONGITUDE = -1.1084665382996315
    }
}