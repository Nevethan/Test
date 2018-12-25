package com.example.bruger.test;

;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

/**
 * Created by Bruger on 29-11-2018.
 */

public class Tab2Map extends Fragment {

    private static final int LOCATION_REQUEST_CODE = 0;
    MapView mMapView;
    private GoogleMap googleMap;

    DataManager dataManager = DataManager.getInstance();

    List<Establishment> establishments = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);

        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        establishments = dataManager.returnEstablishmentList();

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;


                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED) {

                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_REQUEST_CODE);

                    return;
                }
                googleMap.setMyLocationEnabled(true);
                createMarkers(googleMap);

            }
        });

        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case LOCATION_REQUEST_CODE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this.getActivity(), "Permission Granted!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this.getActivity(), "Permission Denied!", Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void createMarkers(GoogleMap map){
        for(Establishment e : establishments){
            double lat = e.getLat();
            double lng = e.getLng();

            LatLng marker = new LatLng(lat,lng);
            map.addMarker(new MarkerOptions().position(marker).title(e.getName()).icon(BitmapDescriptorFactory.
                    defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            /*if(e.getType().equals("Clubs, Bars & Pubs")){
                map.addMarker(new MarkerOptions().position(marker).title(e.getName()).icon(BitmapDescriptorFactory.
                        defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            }else if(e.getType().equals("Hotspots")){
                map.addMarker(new MarkerOptions().position(marker).title(e.getName()).icon(BitmapDescriptorFactory.
                        defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            }else if(e.getType().equals("Restaurants & Café")){
                map.addMarker(new MarkerOptions().position(marker).title(e.getName()).icon(BitmapDescriptorFactory.
                        defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            }*/
        }
        LatLng zoomIn = new LatLng(establishments.get(0).getLat(), establishments.get(0).getLng());
        moveToFirstEstablishment(zoomIn);

    }

    private void moveToFirstEstablishment(LatLng currentLocation)
    {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,15));
        // Zoom in, animating the camera.
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));


    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
