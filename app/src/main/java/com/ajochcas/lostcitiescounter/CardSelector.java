package com.ajochcas.lostcitiescounter;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class CardSelector extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    MediaPlayer volcano;
    boolean allowMusic;
    boolean isPlaying = true;

    ExpeditionCardSet cardSet = new ExpeditionCardSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_selector);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CardSelector.this, ScoreDisplay.class));
            }

        });

        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CardSelector.this, Landing.class));
            }

        });

        // Set the volcano sound, this will have to be modified with other expedition sounds later
        volcano = MediaPlayer.create(CardSelector.this, R.raw.volcano);
        volcano.setLooping(true);
        volcano.start();
    }

    public void cardSelect(View view) {
        Button button = (Button) findViewById(view.getId());
    }


    /**
     * Pauses or resumes the music, or doesn't play at all if the preference is turned off
     */
    protected void musicPause() {
        if (allowMusic) {
            if (isPlaying) {
                volcano.pause();
                isPlaying = false;
            } else {
                volcano.start();
                isPlaying = true;
            }
        }
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
        getMenuInflater().inflate(R.menu.card_selector, menu);
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

        if (id == R.id.himalayas) {
            // Handle the camera action
        } else if (id == R.id.rain) {

        } else if (id == R.id.desert) {

        } else if (id == R.id.volcano) {

        } else if (id == R.id.neptune) {

        } else if (id == R.id.nav_share) {

//        } else if (id == R.id.scoreScreen) {
//
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Required for MediaPlayer Lifecycle, pause the music on app focus loss
     */
    @Override
    protected void onPause() {
        super.onPause();
        volcano.release();
        finish();
    }
}
