package com.example.hp.whereltc;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ServiceActivity extends FragmentActivity implements OnMapReadyCallback {

    //Explicit
    private GoogleMap mMap;


    private LocationManager locationManager;
    private Criteria criteria;
    private double latADouble, lngADouble;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);



        //Setup locationManager = getSystemServer(LOCATION_SERVICE) cast to (Alt+Enter)
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);










        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }// Main Method

    // Override Method for Resume Service (Alt+Insert > Override Method > select onResume():void )
    @Override
    protected void onResume() {
        super.onResume();
        latADouble = 17.96914017;
        lngADouble = 102.61349559;

        Location networkLocation = myFindLocation(LocationManager.NETWORK_PROVIDER);
        if (networkLocation != null) {
            latADouble = networkLocation.getLatitude();
            lngADouble = networkLocation.getLatitude();
        }

        Location gpsLocation = myFindLocation(LocationManager.GPS_PROVIDER);
        if (gpsLocation != null) {
            latADouble = networkLocation.getLatitude();
            lngADouble = networkLocation.getLatitude();
        }

        Log.d("15DecV1","lng > " + latADouble );
        Log.d("15DecV1", " lng > " + lngADouble);

    }



    // Override Method for StopService (Alt+Insert > Override Method > select onStop():void )
    @Override
    protected void onStop() {
        super.onStop();
        //Method t yark hai stop
        locationManager.removeUpdates(locationListener);
    }





    public Location myFindLocation(String strProvider) {
        Location location = null;
        if (locationManager.isProviderEnabled(strProvider)) {
            locationManager.requestLocationUpdates(strProvider, 1000, 10, locationListener);
            location = locationManager.getLastKnownLocation(strProvider);
        }
        return location;
    }









    public LocationListener  locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

            latADouble = location.getLatitude();
            lngADouble = location.getLongitude();


        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };







    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng latLng = new LatLng(latADouble, lngADouble);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,19));
        myAddMarker(latADouble, lngADouble);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMap.clear();
                myAddMarker(latLng.latitude,latLng.longitude);
            }
        });


    }

    private void myAddMarker(double latADouble, double lngADouble) {
        LatLng latLng = new LatLng(latADouble, lngADouble);
        mMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.build1)));


    }
}
