package com.example.bruger.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EstablishmentInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishment_info);

        Intent intent = getIntent();

        String establishmentName = intent.getStringExtra("Name of Establishment");

        //Get the data from the string 'establishmentName'

    }
}
