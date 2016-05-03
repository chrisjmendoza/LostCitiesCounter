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

    Button[] buttonArray = new Button[13];

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
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        activity = this;

        // Initialize the Button Array
        buttonArray[0] = (Button) findViewById(R.id.x1);
        buttonArray[1] = (Button) findViewById(R.id.x2);
        buttonArray[2] = (Button) findViewById(R.id.x3);
        buttonArray[3] = (Button) findViewById(R.id.button1);
        buttonArray[4] = (Button) findViewById(R.id.button2);
        buttonArray[5] = (Button) findViewById(R.id.button3);
        buttonArray[6] = (Button) findViewById(R.id.button4);
        buttonArray[7] = (Button) findViewById(R.id.button5);
        buttonArray[8] = (Button) findViewById(R.id.button6);
        buttonArray[9] = (Button) findViewById(R.id.button7);
        buttonArray[10] = (Button) findViewById(R.id.button8);
        buttonArray[11] = (Button) findViewById(R.id.button9);
        buttonArray[12] = (Button) findViewById(R.id.button10);

        // Change the background based on which expedition is active
        checkActiveExpedition(activeExpedition);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activeExpedition[4]) {
                    changeExpedition();
                    Intent intent = new Intent(CardSelector.this, ScoreDisplay.class);
                    totalScore();
                    String scoreOutput = Integer.toString(totalScore);
                    intent.putExtra(SCORE_OUTPUT, scoreOutput);
                    startActivity(intent);
                } else {
                    changeExpedition();
                }
            }
        });

        // THIS BUTTON CRASHES. IT'S TIED TO THE DRAWER CALCULATE BUTTON SELECTION
//        // The Calculate Total Button in the drawer menu
//        Button calculateTotal = (Button) findViewById(R.id.scoreScreen);
//        calculateTotal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                changeExpedition();
//                Intent intent = new Intent(CardSelector.this, ScoreDisplay.class);
//                totalScore();
//                String scoreOutput = Integer.toString(totalScore);
//                intent.putExtra(SCORE_OUTPUT, scoreOutput);
//                startActivity(intent);
//            }
//        });

        buttonArray[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean clicked = cardx1();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                if (!clicked) {
                    buttonArray[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button_pressed));
                } else {
                    buttonArray[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button));
                }
            }
        });

        buttonArray[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean clicked = cardx2();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                if (!clicked) {
                    buttonArray[1].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button_pressed));
                } else {
                    buttonArray[1].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button));
                }
            }
        });

        buttonArray[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean clicked = cardx3();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                if (!clicked) {
                    buttonArray[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button_pressed));
                } else {
                    buttonArray[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button));
                }
            }
        });

        buttonArray[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean clicked = cardOne();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                if (!clicked) {
                    buttonArray[3].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button_pressed));
                } else {
                    buttonArray[3].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button));
                }
            }
        });

        buttonArray[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean clicked = cardTwo();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                if (!clicked) {
                    buttonArray[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button_pressed));
                } else {
                    buttonArray[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button));
                }
            }
        });

        buttonArray[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean clicked = cardThree();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                if (!clicked) {
                    buttonArray[5].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button_pressed));
                } else {
                    buttonArray[5].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button));
                }
            }
        });

        buttonArray[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean clicked = cardFour();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                if (!clicked) {
                    buttonArray[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button_pressed));
                } else {
                    buttonArray[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button));
                }
            }
        });

        buttonArray[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean clicked = cardFive();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                if (!clicked) {
                    buttonArray[7].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button_pressed));
                } else {
                    buttonArray[7].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button));
                }
            }
        });

        buttonArray[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean clicked = cardSix();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                if (!clicked) {
                    buttonArray[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button_pressed));
                } else {
                    buttonArray[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button));
                }
            }
        });

        buttonArray[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean clicked = cardSeven();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                if (!clicked) {
                    buttonArray[9].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button_pressed));
                } else {
                    buttonArray[9].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button));
                }
            }
        });

        buttonArray[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean clicked = cardEight();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                if (!clicked) {
                    buttonArray[10].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button_pressed));
                } else {
                    buttonArray[10].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button));
                }
            }
        });

        buttonArray[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean clicked = cardNine();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                if (!clicked) {
                    buttonArray[11].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button_pressed));
                } else {
                    buttonArray[11].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button));
                }
            }
        });

        buttonArray[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean clicked = cardTen();
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                if (!clicked) {
                    buttonArray[12].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button_pressed));
                } else {
                    buttonArray[12].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button));
                }
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
            text.setText(R.string.desert);
        }
        checkActiveExpedition(activeExpedition);
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
            expeditionTitle = "Desert";
        } else if (selected == 1) {
            expedition = waterInt;
            expeditionTitle = "Neptune's Realm";
        } else if (selected == 2) {
            expedition = snowInt;
            expeditionTitle = "Himalayan Mountains";
        } else if (selected == 3) {
            expedition = forestInt;
            expeditionTitle = "Rainforest";
        } else if (selected == 4) {
            expedition = volcanoInt;
            expeditionTitle = "Volcano";
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
            text.setText(expeditionTitle);

        } else if (activeExpedition[2]) {
            snowInt = currentInt;
            snowScore = currentScore;
            activeExpedition[2] = false;
            cardSet = new ExpeditionCardSet(expedition);
            currentScore = cardSet.calculateValue();
            currentInt = cardSet.castToInt();
            activeExpedition[selected] = true;
            text.setText(expeditionTitle);

        } else if (activeExpedition[3]) {
            forestInt = currentInt;
            forestScore = currentScore;
            activeExpedition[3] = false;
            cardSet = new ExpeditionCardSet(expedition);
            currentScore = cardSet.calculateValue();
            currentInt = cardSet.castToInt();
            activeExpedition[selected] = true;
            text.setText(expeditionTitle);

        } else if (activeExpedition[4]) {
            volcanoInt = currentInt;
            volcanoScore = currentScore;
            activeExpedition[4] = false;
            cardSet = new ExpeditionCardSet(expedition);
            currentScore = cardSet.calculateValue();
            currentInt = cardSet.castToInt();
            activeExpedition[selected] = true;
            text.setText(expeditionTitle);

        }

        checkActiveExpedition(activeExpedition);
    }

    /**
     * Changes the background of the app depending on what Expedition the player is calculating
     * @param activeExpedition determines what expedition the player is on based on the passed array
     */
    private void checkActiveExpedition(boolean[] activeExpedition) {
        // If the game was just started,
        if (activeExpedition[0] == false && activeExpedition[1] == false && activeExpedition[2] == false && activeExpedition[3] == false && activeExpedition[4] == false) {
            activeExpedition[0] = true;
        }
        if (activeExpedition[0]) {
            activity.findViewById(android.R.id.content).setBackgroundColor(0xFF1234);
        } else if (activeExpedition[1]) {
            activity.findViewById(android.R.id.content).setBackgroundColor(0xFF2345);
        } else if (activeExpedition[2]) {
            activity.findViewById(android.R.id.content).setBackgroundColor(0xFF3456);
        } else if (activeExpedition[3]) {
            activity.findViewById(android.R.id.content).setBackgroundColor(0xFF4561);
        } else if (activeExpedition[4]) {
            activity.findViewById(android.R.id.content).setBackgroundColor(0xFF5612);
        }

        for (int i = 0; i < buttonArray.length; i++) {
            if (cardSet.cards[i]) {
                buttonArray[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button_pressed));
            } else {
                buttonArray[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_button));
            }
        }
    }

    private boolean cardx1() {
        boolean clicked = cardSet.cards[0];
        cardSet.cards[0] = !clicked;
        return clicked;
    }

    private boolean cardx2() {
        boolean clicked = cardSet.cards[1];
        cardSet.cards[1] = !clicked;
        return clicked;
    }

    private boolean cardx3() {
        boolean clicked = cardSet.cards[2];
        cardSet.cards[2] = !clicked;
        return clicked;
    }

    private boolean cardOne() {
        boolean clicked = cardSet.cards[3];
        cardSet.cards[3] = !clicked;
        return clicked;
    }

    private boolean cardTwo() {
        boolean clicked = cardSet.cards[4];
        cardSet.cards[4] = !clicked;
        return clicked;
    }

    private boolean cardThree() {
        boolean clicked = cardSet.cards[5];
        cardSet.cards[5] = !clicked;
        return clicked;
    }

    private boolean cardFour() {
        boolean clicked = cardSet.cards[6];
        cardSet.cards[6] = !clicked;
        return clicked;
    }

    private boolean cardFive() {
        boolean clicked = cardSet.cards[7];
        cardSet.cards[7] = !clicked;
        return clicked;
    }

    private boolean cardSix() {
        boolean clicked = cardSet.cards[8];
        cardSet.cards[8] = !clicked;
        return clicked;
    }

    private boolean cardSeven() {
        boolean clicked = cardSet.cards[9];
        cardSet.cards[9] = !clicked;
        return clicked;
    }

    private boolean cardEight() {
        boolean clicked = cardSet.cards[10];
        cardSet.cards[10] = !clicked;
        return clicked;
    }

    private boolean cardNine() {
        boolean clicked = cardSet.cards[11];
        cardSet.cards[11] = !clicked;
        return clicked;
    }

    private boolean cardTen() {
        boolean clicked = cardSet.cards[12];
        cardSet.cards[12] = !clicked;
        return clicked;
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

        } else if (id == R.id.scoreScreen) {

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
