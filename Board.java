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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        /*
        Use putExtra for sending message to another activity
        https://stackoverflow.com/questions/16014144/send-message-from-one-activity-to-another
         */
        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(this, "about", Toast.LENGTH_LONG).show();
                return true;
            case R.id.all:
                dataManager.getEstablishments();
                //Toast.makeText(this, "Item 2", Toast.LENGTH_LONG).show();
                return true;
            case R.id.clubs:
                dataManager.barsCategory();
                directToBoard();
                //categorizePosts("Clubs, Bars & Pubs");
                //Toast.makeText(this, "Item 3", Toast.LENGTH_LONG).show();
                return true;
            case R.id.restaurants:
                //categorizePosts("Restaurants & Café");
                return true;
            case R.id.hotspots:
                //categorizePosts("Hotspots");
                return true;
            case R.id.list_establishments:
                directToEstablishmentList();

        }
        return super.onOptionsItemSelected(item);
    }

    /*public void categorizePosts(String category){
        //See if you can direct to Board Activity - so that you dont have to be directed to tab1 every time.
        dataManager.checkCategory(category);
    }*/

    public void directToEstablishmentList(){
        Intent intent = new Intent(this, EstablishmentsList.class);
        startActivity(intent);
    }

    public void directToBoard(){
        Intent intent = new Intent(this, Board.class);
        startActivity(intent);
    }
}
