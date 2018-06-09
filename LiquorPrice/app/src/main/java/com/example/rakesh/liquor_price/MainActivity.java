package com.example.rakesh.liquor_price;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        private String test_ad_id="ca-app-pub-3940256099942544~3347511713";
        private AdView madView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MobileAds.initialize(this,test_ad_id);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Spinner liqType= findViewById(R.id.spinner);
        Spinner Vol= findViewById(R.id.spinner2);
        Button search= findViewById(R.id.button);

        madView=findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        madView.loadAd(adRequest);



        //liq type spinner
        final List<String> liqTypeList = new ArrayList<String>();
        liqTypeList.add("Liquor Type");
        liqTypeList.add("BEER");
        liqTypeList.add("Whisky");
        liqTypeList.add("Rum");
        liqTypeList.add("Vodka");
        liqTypeList.add("Gin");
        final ArrayAdapter<String> liqTypList;
        liqTypList = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, liqTypeList);
        liqTypList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liqType.setAdapter(liqTypList);
        liqType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(getApplicationContext(),liqTypeList.get(position),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //volume spiner
        final List<String> liqVolList=new ArrayList<String>();
        liqVolList.add("select volume");
        liqVolList.add("180ml");
        liqVolList.add("375ml");
        liqVolList.add("750ml");
        liqVolList.add("other");
        final ArrayAdapter<String> liqVolListt;
        liqVolListt=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,liqVolList);
        liqVolListt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Vol.setAdapter(liqVolListt);
        Vol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(getApplicationContext(),liqVolList.get(position),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //search button




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        }  else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
