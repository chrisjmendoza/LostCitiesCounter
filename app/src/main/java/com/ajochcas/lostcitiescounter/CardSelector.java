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
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    MediaPlayer volcano;
    boolean allowMusic;
    boolean isPlaying = true;

    public final static String SCORE_OUTPUT = "com.ajochcas.lostcitiescounter.MESSAGE";

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
                Intent intent = new Intent(CardSelector.this, ScoreDisplay.class);
                String scoreOuput = Integer.toString(cardSet.calculateValue());
                intent.putExtra(SCORE_OUTPUT, scoreOuput);
                startActivity(intent);
            }

        });

        Button x1 = (Button) findViewById(R.id.x1);
        x1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardx1();
            }

        });

        Button x2 = (Button) findViewById(R.id.x2);
        x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardx2();
            }

        });

        Button x3 = (Button) findViewById(R.id.x3);
        x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardx3();
            }

        });

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardOne();
            }

        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardTwo();
            }

        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardThree();
            }

        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardFour();
            }

        });

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardFive();
            }

        });

        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardSix();
            }

        });

        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardSeven();
            }

        });

        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardEight();
            }

        });

        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardNine();
            }

        });

        Button button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardTen();
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

    public void cardx1() {
        if(!cardSet.cards[0]) {
            cardSet.cards[0] = true;
        } else {
            cardSet.cards[0] = false;
        }
    }

    public void cardx2() {
        if(!cardSet.cards[1]) {
            cardSet.cards[1] = true;
        } else {
            cardSet.cards[1] = false;
        }
    }

    public void cardx3() {
        if(!cardSet.cards[2]) {
            cardSet.cards[2] = true;
        } else {
            cardSet.cards[2] = false;
        }
    }

    public void cardOne() {
        if(!cardSet.cards[3]) {
            cardSet.cards[3] = true;
        } else {
            cardSet.cards[3] = false;
        }
    }

    public void cardTwo() {
        if(!cardSet.cards[4]) {
            cardSet.cards[4] = true;
        } else {
            cardSet.cards[4] = false;
        }
    }

    public void cardThree() {
        if(!cardSet.cards[5]) {
            cardSet.cards[5] = true;
        } else {
            cardSet.cards[5] = false;
        }
    }

    public void cardFour() {
        if(!cardSet.cards[6]) {
            cardSet.cards[6] = true;
        } else {
            cardSet.cards[6] = false;
        }
    }

    public void cardFive() {
        if(!cardSet.cards[7]) {
            cardSet.cards[7] = true;
        } else {
            cardSet.cards[7] = false;
        }
    }

    public void cardSix() {
        if(!cardSet.cards[8]) {
            cardSet.cards[8] = true;
        } else {
            cardSet.cards[8] = false;
        }
    }

    public void cardSeven() {
        if(!cardSet.cards[9]) {
            cardSet.cards[9] = true;
        } else {
            cardSet.cards[9] = false;
        }
    }

    public void cardEight() {
        if(!cardSet.cards[10]) {
            cardSet.cards[10] = true;
        } else {
            cardSet.cards[10] = false;
        }
    }

    public void cardNine() {
        if(!cardSet.cards[11]) {
            cardSet.cards[11] = true;
        } else {
            cardSet.cards[11] = false;
        }
    }

    public void cardTen() {
        if(!cardSet.cards[12]) {
            cardSet.cards[12] = true;
        } else {
            cardSet.cards[12] = false;
        }
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

    @Override
    public void onClick(View v) {
    }
}
