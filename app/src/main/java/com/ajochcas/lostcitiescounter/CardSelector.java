package com.ajochcas.lostcitiescounter;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CardSelector extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    public final static String SCORE_OUTPUT = "com.ajochcas.lostcitiescounter.MESSAGE";

    Activity activity;

    Button[] buttonArray = new Button[12];

    private MediaPlayer volcano;
    private boolean allowMusic;
    private boolean isPlaying = true;

    // Define the 5 card sets
    private ExpeditionCardSet cardSet = new ExpeditionCardSet();

    // Integer value of the selected Expedition Cards
    private int volcanoInt = 0;
    private int forestInt = 0;
    private int snowInt = 0;
    private int waterInt = 0;
    private int desertInt = 0;
    private int currentInt = 0;

    // Integer values of the current scores
    private int desertScore = 0;
    private int waterScore = 0;
    private int snowScore = 0;
    private int forestScore = 0;
    private int volcanoScore = 0;
    private int currentScore = 0;
    private int totalScore = 0;

    // This boolean determines which expedition is the "Active" expedition. Only one of these
    // should be true at any given time after initialization.
    private boolean[] activeExpedition = new boolean[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_selector);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        assert drawer != null;
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        activity = this;

        // Initialize the Button Array
        buttonArray[0] = (Button) findViewById(R.id.x1);
        buttonArray[1] = (Button) findViewById(R.id.x2);
        buttonArray[2] = (Button) findViewById(R.id.x3);
        buttonArray[3] = (Button) findViewById(R.id.button2);
        buttonArray[4] = (Button) findViewById(R.id.button3);
        buttonArray[5] = (Button) findViewById(R.id.button4);
        buttonArray[6] = (Button) findViewById(R.id.button5);
        buttonArray[7] = (Button) findViewById(R.id.button6);
        buttonArray[8] = (Button) findViewById(R.id.button7);
        buttonArray[9] = (Button) findViewById(R.id.button8);
        buttonArray[10] = (Button) findViewById(R.id.button9);
        buttonArray[11] = (Button) findViewById(R.id.button10);

        // Change the background based on which expedition is active
        checkActiveExpedition(activeExpedition);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);

        buttonArray[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change this card's boolean value
                cardx1();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                buttonClicks();
            }
        });

        buttonArray[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardx2();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                buttonClicks();
            }
        });

        buttonArray[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardx3();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                buttonClicks();
            }
        });

        buttonArray[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardTwo();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                buttonClicks();
            }
        });

        buttonArray[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardThree();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                buttonClicks();
            }
        });

        buttonArray[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardFour();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                buttonClicks();
            }
        });

        buttonArray[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardFive();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                buttonClicks();
            }
        });

        buttonArray[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardSix();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                buttonClicks();
            }
        });

        buttonArray[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardSeven();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                buttonClicks();
            }
        });

        buttonArray[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardEight();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                buttonClicks();
            }
        });

        buttonArray[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardNine();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                buttonClicks();
            }
        });

        buttonArray[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardTen();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                buttonClicks();
            }
        });

        Button homeButton = (Button) findViewById(R.id.homeButton);
        assert homeButton != null;
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CardSelector.this, Landing.class));
            }
        });

        Button calculateScoreButton = (Button) findViewById(R.id.calculateScore);
        assert calculateScoreButton != null;
        calculateScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeExpedition();
                Intent intent = new Intent(CardSelector.this, ScoreDisplay.class);
                totalScore();
                String scoreOutput = Integer.toString(totalScore);
                intent.putExtra(SCORE_OUTPUT, scoreOutput);
                startActivity(intent);
            }
        });

        Button nextButton = (Button) findViewById(R.id.nextButton);
        assert nextButton != null;
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeExpedition();
            }
        });

        // Set the volcano sound, this will have to be modified with other expedition sounds later
        volcano = MediaPlayer.create(CardSelector.this, R.raw.volcano);
        volcano.setLooping(true);
        volcano.start();
    }

    /**
     * Calculates the total score
     */
    private void totalScore() {
        totalScore = desertScore + waterScore + snowScore + forestScore + volcanoScore;
    }

    /**
     * The default changeExpedition method will change the Expeditions in order: Desert to Water,
     * Water to Snow, Snow to Forest, Forest to Volcano, and Volcano to Desert. REWRITE THIS
     * IMPLEMENTATION TO REMOVE THE PARAMETER-LESS VERSION AND JUST KEEP IT DOWN TO ONE METHOD
     */
    private void changeExpedition() {

        TextView text = (TextView) findViewById(R.id.selectcardtext);

        // Desert to Water
        if (activeExpedition[0]) {
            // Save the current boolean array values in an int
            desertInt = currentInt;
            // Save the current score of the Expedition
            desertScore = currentScore;
            // Make the next expedition card set, based on the bitwise integer
            cardSet = new ExpeditionCardSet(waterInt);
            // Update the currentInt value with a bitwise integer (returning to a land)
            currentInt = cardSet.castToInt();
            // Update the "Current" score with the value of the next cardset
            currentScore = cardSet.calculateValue();
            // Set the Desert Expedition off
            activeExpedition[0] = false;
            // Make the Water Expedition Active
            activeExpedition[1] = true;
            assert text != null;
            // Change the name of the Expedition on Screen
            text.setText(R.string.neptune);

            // Water to Snow
        } else if (activeExpedition[1]) {
            waterInt = currentInt;
            waterScore = currentScore;
            cardSet = new ExpeditionCardSet(snowInt);
            currentInt = cardSet.castToInt();
            currentScore = cardSet.calculateValue();
            activeExpedition[1] = false;
            activeExpedition[2] = true;
            assert text != null;
            text.setText(R.string.himalayas);

            // Snow to Forest
        } else if (activeExpedition[2]) {
            snowInt = currentInt;
            snowScore = currentScore;
            cardSet = new ExpeditionCardSet(forestInt);
            currentInt = cardSet.castToInt();
            currentScore = cardSet.calculateValue();
            activeExpedition[2] = false;
            activeExpedition[3] = true;
            assert text != null;
            text.setText(R.string.rainforest);

            // Forest to Volcano
        } else if (activeExpedition[3]) {
            forestInt = currentInt;
            forestScore = currentScore;
            cardSet = new ExpeditionCardSet(volcanoInt);
            currentInt = cardSet.castToInt();
            currentScore = cardSet.calculateValue();
            activeExpedition[3] = false;
            activeExpedition[4] = true;
            assert text != null;
            text.setText(R.string.volcano);

            // Volcano to Desert
        } else if (activeExpedition[4]) {
            volcanoInt = currentInt;
            volcanoScore = currentScore;
            cardSet = new ExpeditionCardSet(desertInt);
            currentInt = cardSet.castToInt();
            currentScore = cardSet.calculateValue();
            activeExpedition[4] = false;
            activeExpedition[0] = true;
            assert text != null;
            text.setText(R.string.desert);
        }
        checkActiveExpedition(activeExpedition);
    }

    /**
     * Goes through the button array and highlights any value that has been pressed, or turns it
     * off if pressed again
     */
    private void buttonClicks() {
        for (int i = 0; i < buttonArray.length; i++) {
            if (cardSet.cards[i]) {
                buttonArray[i].setBackgroundResource(R.drawable.bg_button_pressed);
            } else {
                buttonArray[i].setBackgroundResource(R.drawable.bg_button);
            }
        }
    }

    /**
     * Changes the expedition based on the user's selection. Can be set up to be the only method
     *
     * @param selected The selected expedition 0 - Desert, 1 - Water, 2 - Himalayans, 3 - Rainforest,
     *                 4 - Volcano
     */
    private void changeExpedition(int selected) {

        TextView text = (TextView) findViewById(R.id.selectcardtext);

        int expedition = 0;
        String expeditionTitle = "";

        if (selected == 0) {
            expedition = desertInt;
            expeditionTitle = "Saharan Desert";
        } else if (selected == 1) {
            expedition = waterInt;
            expeditionTitle = "Neptune's Realm";
        } else if (selected == 2) {
            expedition = snowInt;
            expeditionTitle = "Himalayan Mountains";
        } else if (selected == 3) {
            expedition = forestInt;
            expeditionTitle = "Hidden Rain forest";
        } else if (selected == 4) {
            expedition = volcanoInt;
            expeditionTitle = "Ancient Volcanoes";
        }

        // If the current Expedition is the desert, save values and switch to selected land
        if (activeExpedition[0]) {
            // Save the current bitmask integer value
            desertInt = currentInt;
            // Save the current score of the expedition
            desertScore = currentScore;
            // Make this expedition not active
            activeExpedition[0] = false;
            // Change the cardSet to reflect the chosen Expedition
            cardSet = new ExpeditionCardSet(expedition);
            // Update the current score to the value of the selected expedition
            currentScore = cardSet.calculateValue();
            // Update the bitmask value to the selected land
            currentInt = cardSet.castToInt();
            // Make the selected expedition active
            activeExpedition[selected] = true;
            assert text != null;
            // Change the Expedition Land title
            text.setText(expeditionTitle);

        } else if (activeExpedition[1]) {
            waterInt = currentInt;
            waterScore = currentScore;
            activeExpedition[1] = false;
            cardSet = new ExpeditionCardSet(expedition);
            currentScore = cardSet.calculateValue();
            currentInt = cardSet.castToInt();
            activeExpedition[selected] = true;
            assert text != null;
            text.setText(expeditionTitle);

        } else if (activeExpedition[2]) {
            snowInt = currentInt;
            snowScore = currentScore;
            activeExpedition[2] = false;
            cardSet = new ExpeditionCardSet(expedition);
            currentScore = cardSet.calculateValue();
            currentInt = cardSet.castToInt();
            activeExpedition[selected] = true;
            assert text != null;
            text.setText(expeditionTitle);

        } else if (activeExpedition[3]) {
            forestInt = currentInt;
            forestScore = currentScore;
            activeExpedition[3] = false;
            cardSet = new ExpeditionCardSet(expedition);
            currentScore = cardSet.calculateValue();
            currentInt = cardSet.castToInt();
            activeExpedition[selected] = true;
            assert text != null;
            text.setText(expeditionTitle);

        } else if (activeExpedition[4]) {
            volcanoInt = currentInt;
            volcanoScore = currentScore;
            activeExpedition[4] = false;
            cardSet = new ExpeditionCardSet(expedition);
            currentScore = cardSet.calculateValue();
            currentInt = cardSet.castToInt();
            activeExpedition[selected] = true;
            assert text != null;
            text.setText(expeditionTitle);

        }

        checkActiveExpedition(activeExpedition);
    }

    /**
     * Changes the background of the app depending on what Expedition the player is calculating
     *
     * @param activeExpedition determines what expedition the player is on based on the passed array
     */
    private void checkActiveExpedition(boolean[] activeExpedition) {
        // If the game was just started,
        if (!activeExpedition[0] && !activeExpedition[1] && !activeExpedition[2] && !activeExpedition[3] && !activeExpedition[4]) {
            activeExpedition[0] = true;
        }
        if (activeExpedition[0]) {
            activity.findViewById(android.R.id.content).setBackgroundColor(0x12345);
        } else if (activeExpedition[1]) {
            activity.findViewById(android.R.id.content).setBackgroundColor(0xFF2345);
        } else if (activeExpedition[2]) {
            activity.findViewById(android.R.id.content).setBackgroundColor(0xFF3456);
        } else if (activeExpedition[3]) {
            activity.findViewById(android.R.id.content).setBackgroundColor(0xFF4561);
        } else {
            activity.findViewById(android.R.id.content).setBackgroundColor(0xFF5612);
        }

        buttonClicks();
    }

    private void cardx1() {
        cardSet.cards[0] = !cardSet.cards[0];
    }

    private void cardx2() {
        cardSet.cards[1] = !cardSet.cards[1];
    }

    private void cardx3() {
        cardSet.cards[2] = !cardSet.cards[2];
    }

    private void cardTwo() {
        cardSet.cards[3] = !cardSet.cards[3];
    }

    private void cardThree() {
        cardSet.cards[4] = !cardSet.cards[4];
    }

    private void cardFour() {
        cardSet.cards[5] = !cardSet.cards[5];
    }

    private void cardFive() {
        cardSet.cards[6] = !cardSet.cards[6];
    }

    private void cardSix() {
        cardSet.cards[7] = !cardSet.cards[7];
    }

    private void cardSeven() {
        cardSet.cards[8] = !cardSet.cards[8];
    }

    private void cardEight() {
        cardSet.cards[9] = !cardSet.cards[9];
    }

    private void cardNine() {
        cardSet.cards[10] = !cardSet.cards[10];
    }

    private void cardTen() {
        cardSet.cards[11] = !cardSet.cards[11];
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
        assert drawer != null;
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

        if (id == R.id.desert) {
            changeExpedition(0);

        } else if (id == R.id.neptune) {
            changeExpedition(1);

        } else if (id == R.id.himalayas) {
            changeExpedition(2);

        } else if (id == R.id.rainforest) {
            changeExpedition(3);

        } else if (id == R.id.volcano) {
            changeExpedition(4);

        } else if (id == R.id.nav_share) {

//        } else if (id == R.id.scoreScreen) {
//
//        }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        assert drawer != null;
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
