package com.example.bruger.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EstablishmentsList extends AppCompatActivity {


    List<Establishment> establishments = new ArrayList<>();

    DataManager dataManager = DataManager.getInstance();

    private ListView listView;
    private EstablishmentCustomList mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishments_list);

        listView = (ListView) findViewById(R.id.listViewEstablishments);

        establishments = dataManager.getAllEstablishments();

        mAdapter = new EstablishmentCustomList(this,establishments);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nameOfEstablishment = establishments.get(position).getName();
                directToEstablishmentInfo(nameOfEstablishment);
            }
        });

        listView.setAdapter(mAdapter);
    }

    public void directToEstablishmentInfo(String msg){
        Intent intent = new Intent(this,EstablishmentInfo.class);
        intent.putExtra("Name of Establishment", msg);
        startActivity(intent);
    }

}
