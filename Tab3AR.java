package com.example.bruger.test;


import android.content.Context;
import android.hardware.SensorEventListener;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;

import android.location.LocationManager;


import com.wikitude.architect.ArchitectStartupConfiguration;
import com.wikitude.architect.ArchitectView;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by Bruger on 29-11-2018.
 */

/*
The implementation of this fragment is bollowed code from https://github.com/Luckyrana001/Argumented-Reality/tree/master/app/src/main/java/com/androidluckyguys.
 */

public class Tab3AR extends Fragment{

    Context mContext;
    private ArchitectView architectView;

    private LocationManager lm;
    LocationProvider locationProvider;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_fragment,container,false);

        this.architectView = (ArchitectView) view.findViewById(R.id.architectView);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initAR(){
        final ArchitectStartupConfiguration config = new ArchitectStartupConfiguration();
        config.setFeatures(ArchitectStartupConfiguration.Features.Geo);
        config.setLicenseKey("pQFRv7deSVB2Fe30MPw+WSnQru9EIfqbq6N22+3/1woT8maJzhTujuJEIoPKhxODU3jD9J9JGMqsQpGopVQ5s/R" +
                "1GgGDIe/m9F3zSQwjzWEfm/jT37M0X+CjtNx5MjUsiYY8/wNOLooHv72wt8gAjaDW4CMHDtRNhOUaiIGIRGNTYWx0ZWRfX5srMFOX" +
                "ik7lNB78u95iQTgKbVsjN2YxxWhW641p3F8PCDSLozQoo3Q9tW470R4VHLe/wvC/lgj6iKN8CoskJ/S4YsKXKqxU2l8n3BD72Tav30/R" +
                "rI2THaWcmNtsS1C1b+uwPW2N9DbGDz0uSgVI47cPgvWJfqV/PA9xq7LeFf0QAfVspKxzKwegJ13U+geXK/DTsVYTFR4Y7q2sU1HceqYyf" +
                "imtddEOfLF04eLtHYxGxd9k68TAL8hvVXO6RcPKQ7enDAuUfPLEGfE/7CblpL0EaQgs7RAGeW4MiyRaGm2ZLJ4mTFblbho17JkB5PgdZCkRn" +
                "baXbM6ePVNbTePCsRivFimkxz5Jl7IGFHHJ4909D65tu8OQ/bkHSifBd7JhoDBm2XBW8HJuOw08YNIcfTI730lzwawCJ1Udz+rV01FFZrBV+YLl" +
                "zKieQqXXnIQZbci5TzoL5syeNzO3eC+5wDhHYVdl3aZlUYskFsVjcbr5VgNEBJwg4fABhNXRkbKQXES7wr/zzKUqqyFdIo8aSPSFvOzFAS8Syw==");

        try {


            this.architectView.onCreate(config);

            locationProvider = new LocationProvider(this.getActivity(), new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    if (location != null && Tab3AR.this.architectView != null) {
                        // check if location has altitude at certain accuracy level & call right architect method (the one with altitude information)
                        if (location.hasAltitude() && location.hasAccuracy() && location.getAccuracy() < 7) {
                            Tab3AR.this.architectView.setLocation(location.getLatitude(), location.getLongitude(), location.getAltitude(), location.getAccuracy());
                        } else {
                            Tab3AR.this.architectView.setLocation(location.getLatitude(), location.getLongitude(), location.hasAccuracy() ? location.getAccuracy() : 1000);
                        }
                    }
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


            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initAR();

        if(this.architectView != null){
            this.architectView.onPostCreate();
        }

        try{
            this.architectView.load("08_PointOfInterest_3_MultiplePois/index.html");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onPause() {
        super.onPause();

        try{
            this.architectView.onPause();
            locationProvider.onPause();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onResume() {
        super.onResume();

        try{
            this.architectView.onResume();
            locationProvider.onResume();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        try{
            this.architectView.onDestroy();
            //locationProvider = null;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        if ( this.architectView != null ) {
            this.architectView.onLowMemory();
        }
    }

}
