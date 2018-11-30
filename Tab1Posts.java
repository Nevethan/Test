package com.example.bruger.test;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruger on 29-11-2018.
 * source : http://camposha.info/source/android-viewpager-sliding-tabs-listviews-source
 */

public class Tab1Posts extends Fragment {


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

    FirebaseManager firebaseManager = new FirebaseManager();
    List<Post> pList = firebaseManager.getAllPosts();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);

        ListView listView = (ListView) view.findViewById(R.id.listView);
        CustomList customList = new CustomList(this.getActivity(),programs,imageId);

        //Make a onclickitemtlistener. When users click on a post, the name of the establishment should appear as a Toast.

        listView.setAdapter(customList);

        //The message received from this code, will tell which category the user wants.
        Intent intent = getActivity().getIntent();
        String category = intent.getStringExtra("category");
        checkCategory(category);

        return view;
    }

    public void checkCategory(String category){
        switch (category){
            case "All":
                Toast.makeText(this.getActivity(), "all", Toast.LENGTH_LONG).show();
            case "Clubs, Bars & Pubs":
                Toast.makeText(this.getActivity(), "clubs", Toast.LENGTH_LONG).show();
            case "Restaurants and cafe":
                Toast.makeText(this.getActivity(), "cafe", Toast.LENGTH_LONG).show();
            case "Hotspots":
                Toast.makeText(this.getActivity(), "hotspots", Toast.LENGTH_LONG).show();
            default:
                Toast.makeText(this.getActivity(), "all", Toast.LENGTH_LONG).show();

        }
    }

}
