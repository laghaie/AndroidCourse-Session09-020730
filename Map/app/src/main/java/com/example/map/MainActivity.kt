package com.example.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.myMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val sematecLatLng = LatLng(35.739161007573394, 51.44333458182703)
        //googleMap.moveCamera(CameraUpdateFactory.newLatLng(sematecLatLng))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sematecLatLng, 16f))
        googleMap.addMarker(MarkerOptions().position(sematecLatLng).title("Sematec"))
    }
}