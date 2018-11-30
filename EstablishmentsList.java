package com.example.bruger.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class EstablishmentsList extends AppCompatActivity {

    String[] programs = {
            "Program 1",
            "Program 2",
            "Program 3",
            "Program 4",
            "Program 5",
            "Program 6"
    };

    Integer[] imageId = {
            R.drawable.me,
            R.drawable.me,
            R.drawable.me,
            R.drawable.me,
            R.drawable.me,
            R.drawable.me
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishments_list);

        ListView listView = (ListView) findViewById(R.id.listViewEstablishments);
        CustomList customList = new CustomList(this,programs,imageId);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nameOfEstablishment = programs[position];
                directToEstablishmentInfo(nameOfEstablishment);
            }
        });

        listView.setAdapter(customList);
    }

    public void directToEstablishmentInfo(String msg){
        Intent intent = new Intent(this,EstablishmentInfo.class);
        intent.putExtra("Name of Establishment", msg);
        startActivity(intent);
    }



}
