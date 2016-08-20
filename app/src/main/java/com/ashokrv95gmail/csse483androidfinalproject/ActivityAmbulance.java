package com.ashokrv95gmail.csse483androidfinalproject;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by ashokvardhanraja on 8/6/16.
 */
public class ActivityAmbulance extends FragmentActivity {

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    LocationManager locationManager;
    double mylat, mylng;
    int currentMarker = 0, enable = 0;
    Marker Mylocationmarker;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_maps);
       /* mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
       mapFragment.getMapAsync(this);*/

        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

       locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
       GettingMyLocationLatLong();
    }

    private void GettingMyLocationLatLong() {
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                makeUseOfNewLocation(location);

            }

            private void makeUseOfNewLocation(Location location) {
                mylat = location.getLatitude();
                mylng = location.getLongitude();


                if(currentMarker == 0){
                    Mylocationmarker = mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(mylat, mylng))
                            .title("MyLocation")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.maps_blue_dot)));

                    if(enable==0){
                        CameraPosition cameraPosition = new CameraPosition.Builder()
                                .target(new LatLng(mylat, mylng))
                                .zoom(15)
                                .bearing(0)
                                .build();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        enable=1;
                    }else{

                    }
                    currentMarker=1;
                }else{

                    Mylocationmarker.remove();
                    Mylocationmarker = mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(mylat, mylng))
                            .title("MyLocation")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.maps_blue_dot)));

                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };


        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }
    }

   /* @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }*/
}
