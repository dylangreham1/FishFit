package com.example.fishfit;

import android.content.Intent;
import android.graphics.Bitmap;
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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Intent intent;
    private WebView stream;
    private Button start_stream;
    private Button stop_stream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        StartStream(stream);

        FloatingActionButton fabOn = (FloatingActionButton) findViewById(R.id.fabOn);
        fabOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Snackbar.make(view1, "Notifications off", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                view1.setVisibility(View.VISIBLE);
            }
        });

        FloatingActionButton fabOff = (FloatingActionButton) findViewById(R.id.fabOff);
        fabOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Snackbar.make(view2, "Notifications on", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                view2.setVisibility(View.VISIBLE);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void StartStream(View view){
        String ipAddress = "http://192.168.43.28:8080/";
        stream = (WebView) findViewById(R.id.stream);
        stream.setWebViewClient(new WebViewClient());
        stream.getSettings().setJavaScriptEnabled(true);
        stream.loadUrl(ipAddress);

        stream.setWebViewClient(new WebViewClient()
        {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
            {
                stream.loadUrl("file:///assets/off.html");
            }
        });
    }

    public void StopStream(View view) {
        stream.loadUrl("file:///assets/off.html");
        stream.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                stream.loadUrl("file:///assets/off.html");
            }
        });
    }

    //public void Screenshot(){
    //}

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
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new SettingsFragment()).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {                             //FrameLayout in activity_home
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
        else if (id == R.id.nav_quality){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new QualityFragment()).commit();

        } else if (id == R.id.nav_feeding) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FeedingFragment()).commit();

        } else if (id == R.id.nav_stocking) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new StockingFragment()).commit();

        } else if (id == R.id.nav_calendar) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new CalendarFragment()).commit();

        } else if (id == R.id.nav_share) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ShareFragment()).commit();

        } else if (id == R.id.nav_settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new SettingsFragment()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
