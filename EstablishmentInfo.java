package com.example.bruger.test;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class EstablishmentInfo extends AppCompatActivity {

    DataManager dataManager = DataManager.getInstance();
    String establishmentName = "";

    List<Establishment> establishmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishment_info);

        TextView name = (TextView) findViewById(R.id.estblishmentName);
        TextView address = (TextView) findViewById(R.id.establishmentAddress);
        TextView rating = (TextView) findViewById(R.id.establishmentRating);
        TextView type = (TextView) findViewById(R.id.establishmentType);
        TextView description = (TextView) findViewById(R.id.establishmentDescription);

        ImageView imgView = (ImageView) findViewById(R.id.imageView2);

        Intent intent = getIntent();
        establishmentName= intent.getStringExtra("Name of Establishment");
        establishmentList = dataManager.getAllEstablishments();

        for(Establishment e : establishmentList){
            if(e.getName().equals(establishmentName)){
                name.setText(e.getName());
                address.setText(e.getAddress());
                rating.setText("Ratings: " + String.valueOf(e.getRating()));
                type.setText(e.getType());
                description.setText(e.getDescription());

                Drawable icon = getResources().getDrawable(e.getImg());
                imgView.setImageDrawable(icon);
            }
        }
    }
}
