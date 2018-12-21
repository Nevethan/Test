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

    List<Post> posts = new ArrayList<>();

    DataManager dataManager = new DataManager();
    PostCustomList postCustomList;

    Bundle extras = new Bundle();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);

        ListView listView = (ListView) view.findViewById(R.id.listView);

        getData();

        postCustomList = new PostCustomList(this.getActivity(),posts);

        //Make a onclickitemtlistener. When users click on a post, the name of the establishment should appear as a Toast.

        listView.setAdapter(postCustomList);
        //The message received from this code, will tell which category the user wants.

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        String category = extras.getString("category");
        dataManager.checkCategory(category);
        //posts = dataManager.returnPosts();
        postCustomList.notifyDataSetChanged();
    }

    private void getData(){
        posts.clear();
        posts = dataManager.getPosts();
    }
}
