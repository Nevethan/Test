package com.example.bruger.test;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Board extends AppCompatActivity {
    /*
        Source https://www.youtube.com/watch?v=bNpWGI_hGGg
    */

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    private DataManager dataManager = DataManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        sectionsPageAdapter.addFragment(new Tab1Posts(), "Posts");
        sectionsPageAdapter.addFragment(new Tab2Map(), "Map");
        sectionsPageAdapter.addFragment(new Tab3AR(), "AR");

        viewPager.setAdapter(sectionsPageAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    /*
            The switch statement has a case for each menu item and its implementation.
            Each of the categories call a method from DataManager to update the list showed in the listview.
            Then the entire board.class will be refreshed.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(this, "about", Toast.LENGTH_LONG).show();
                return true;
            case R.id.all:
                dataManager.allCategory();
                directToBoard();
                return true;
            case R.id.clubs:
                dataManager.barsCategory();
                directToBoard();
                return true;
            case R.id.restaurants:
                dataManager.cafeCategory();
                directToBoard();
                return true;
            case R.id.hotspots:
                dataManager.hotCategory();
                directToBoard();
                return true;
            case R.id.list_establishments:
                directToEstablishmentList();

        }
        return super.onOptionsItemSelected(item);
    }

    public void directToEstablishmentList(){
        Intent intent = new Intent(this, EstablishmentsList.class);
        startActivity(intent);
    }

    public void directToBoard(){
        Intent intent = new Intent(this, Board.class);
        startActivity(intent);
    }
}
