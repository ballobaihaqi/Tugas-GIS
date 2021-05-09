package com.example.f55118071_pelabuhan;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng pelabuhan = new LatLng(1.051258, 120.800029);
        LatLng pel_ferry = new LatLng(1.038333, 120.809351);
        LatLng my_loc = new LatLng(1.044327, 120.823722);

        //custom size marker
        int tinggi = 100;
        int lebar = 100;

        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_start);
//        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_des);
        Bitmap s = bitmapStart.getBitmap();
//        Bitmap d = bitmapDes.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
//        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        //add marker to map
        mMap.addMarker(new MarkerOptions().position(my_loc).title("Marker in Location User")
                .snippet("Ini merupakan lokasi user saat ini")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(pelabuhan).title("Marker in Pelabuhan Dede Kabupaten Tolitoli"));
        mMap.addMarker(new MarkerOptions().position(pel_ferry).title("Marker in Pelabuhan Ferry Tanjung Batu Kabupaten Tolitoli"));

        //add polyline
        mMap.addPolyline(new PolylineOptions().add(
        my_loc,
        new LatLng(1.044082, 120.823932),
                new LatLng(1.042278, 120.824531),
                new LatLng(1.041287, 120.821433),
                new LatLng(1.041158, 120.820851),
                new LatLng(1.038541, 120.812244),
                new LatLng(1.038333, 120.811345),
                new LatLng(1.038196, 120.810849),
                new LatLng(1.038195, 120.810628),
                new LatLng(1.038283, 120.809955),
                new LatLng(1.038348, 120.809906),
                new LatLng(1.038341, 120.809484),
                new LatLng(1.038367, 120.809356),
                pel_ferry
        ).width(10)
                .color(Color.BLUE)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pelabuhan, 14.5f));
    }
}