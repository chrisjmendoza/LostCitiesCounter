package com.ajochcas.lostcitiescounter.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ajochcas.lostcitiescounter.R;
import com.ajochcas.lostcitiescounter.helpers.ExpeditionCardSet;

public class CardSelectorActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    public final static String SCORE_OUTPUT = "com.ajochcas.lostcitiescounter.MESSAGE";

    private static final String DEBUG_TAG = "Gestures";
    private final Button[] buttonArray = new Button[12];
    // This boolean determines which expedition is the "Active" expedition. Only one of these
    // should be true at any given time after initialization.
    private final boolean[] activeExpedition = new boolean[5];
    private Activity activity;
    private GestureDetectorCompat mDetector;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_selector);
        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this, this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);

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
        ActiveExpedition(activeExpedition);

        buttonArray[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change this card's boolean value
                cardSet.cards[0] = !cardSet.cards[0];
                // Update the score for the current set
                currentScore = cardSet.calculateValue();
                // Update the total score
                totalScore();
                // Update the integer value of the boolean set
                currentInt = cardSet.castToInt();
                // Change the button color
                buttonClicks();
            }
        });

        buttonArray[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardSet.cards[1] = !cardSet.cards[1];
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
                cardSet.cards[2] = !cardSet.cards[2];
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
                cardSet.cards[3] = !cardSet.cards[3];
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
                cardSet.cards[4] = !cardSet.cards[4];
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
                cardSet.cards[5] = !cardSet.cards[5];
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
                cardSet.cards[6] = !cardSet.cards[6];
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
                cardSet.cards[7] = !cardSet.cards[7];
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
                cardSet.cards[8] = !cardSet.cards[8];
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
                cardSet.cards[9] = !cardSet.cards[9];
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
                cardSet.cards[10] = !cardSet.cards[10];
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
                cardSet.cards[11] = !cardSet.cards[11];
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
                startActivity(new Intent(CardSelectorActivity.this, LandingActivity.class));
            }
        });

        Button calculateScoreButton = (Button) findViewById(R.id.calculateScore);
        assert calculateScoreButton != null;
        calculateScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeExpedition();
                Intent intent = new Intent(CardSelectorActivity.this, ScoreDisplayActivity.class);
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

    }

    /**
     * Calculates the total score
     */
    private void totalScore() {
        totalScore = desertScore + waterScore + snowScore + forestScore + volcanoScore;
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
     * The default changeExpedition method will change the Expeditions in order: Desert to Water,
     * Water to Snow, Snow to Forest, Forest to Volcano, and Volcano to Desert.
     */
    private void changeExpedition() {

        // Desert to Water
        if (activeExpedition[0]) {
            changeExpedition(1);

            // Water to Snow
        } else if (activeExpedition[1]) {
            changeExpedition(2);

            // Snow to Forest
        } else if (activeExpedition[2]) {
            changeExpedition(3);

            // Forest to Volcano
        } else if (activeExpedition[3]) {
            changeExpedition(4);

            // Volcano to Desert
        } else if (activeExpedition[4]) {
            changeExpedition(0);
        }
    }

    /**
     * Changes the expedition based on the user's selection. Can be set up to be the only method
     *
     * @param selected The selected expedition 0 - Desert, 1 - Water, 2 - Himalayans, 3 - Rainforest,
     *                 4 - Volcano
     */
    private void changeExpedition(int selected) {

        TextView text = (TextView) findViewById(R.id.expeditionTitle);

        int expedition = 0;

        if (selected == 0) {
            expedition = desertInt;
        } else if (selected == 1) {
            expedition = waterInt;
            assert text != null;
        } else if (selected == 2) {
            expedition = snowInt;
        } else if (selected == 3) {
            expedition = forestInt;
        } else if (selected == 4) {
            expedition = volcanoInt;
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
            // Change the name of the Expedition on Screen
            assert text != null;
            text.setText(R.string.neptune);

        } else if (activeExpedition[1]) {
            waterInt = currentInt;
            waterScore = currentScore;
            activeExpedition[1] = false;
            cardSet = new ExpeditionCardSet(expedition);
            currentScore = cardSet.calculateValue();
            currentInt = cardSet.castToInt();
            activeExpedition[selected] = true;
            assert text != null;
            text.setText(R.string.himalayas);

        } else if (activeExpedition[2]) {
            snowInt = currentInt;
            snowScore = currentScore;
            activeExpedition[2] = false;
            cardSet = new ExpeditionCardSet(expedition);
            currentScore = cardSet.calculateValue();
            currentInt = cardSet.castToInt();
            activeExpedition[selected] = true;
            assert text != null;
            text.setText(R.string.rainforest);

        } else if (activeExpedition[3]) {
            forestInt = currentInt;
            forestScore = currentScore;
            activeExpedition[3] = false;
            cardSet = new ExpeditionCardSet(expedition);
            currentScore = cardSet.calculateValue();
            currentInt = cardSet.castToInt();
            activeExpedition[selected] = true;
            assert text != null;
            text.setText(R.string.volcano);

        } else if (activeExpedition[4]) {
            volcanoInt = currentInt;
            volcanoScore = currentScore;
            activeExpedition[4] = false;
            cardSet = new ExpeditionCardSet(expedition);
            currentScore = cardSet.calculateValue();
            currentInt = cardSet.castToInt();
            activeExpedition[selected] = true;
            assert text != null;
            text.setText(R.string.desert);
        }
        ActiveExpedition(activeExpedition);
    }

    /**
     * Changes the background of the app depending on what Expedition the player is calculating
     *
     * @param activeExpedition determines what expedition the player is on based on the passed array
     */
    private void ActiveExpedition(boolean[] activeExpedition) {

        // If the game was just started,
        if (!activeExpedition[0] && !activeExpedition[1] && !activeExpedition[2] && !activeExpedition[3] && !activeExpedition[4]) {
            activeExpedition[0] = true;
        }
        if (activeExpedition[0]) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                activity.findViewById(android.R.id.content).setBackground(getResources().getDrawable(R.drawable.bg_desert));
            } else {
                activity.findViewById(android.R.id.content).setBackgroundColor(getResources().getColor(R.color.desert));
            }
        } else if (activeExpedition[1]) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                activity.findViewById(android.R.id.content).setBackground(getResources().getDrawable(R.drawable.bg_water));
            } else {
                activity.findViewById(android.R.id.content).setBackgroundColor(getResources().getColor(R.color.desert));
            }
        } else if (activeExpedition[2]) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                activity.findViewById(android.R.id.content).setBackground(getResources().getDrawable(R.drawable.bg_snow));
            } else {
                activity.findViewById(android.R.id.content).setBackgroundColor(getResources().getColor(R.color.desert));
            }
        } else if (activeExpedition[3]) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                activity.findViewById(android.R.id.content).setBackground(getResources().getDrawable(R.drawable.bg_forest));
            } else {
                activity.findViewById(android.R.id.content).setBackgroundColor(getResources().getColor(R.color.desert));
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                activity.findViewById(android.R.id.content).setBackground(getResources().getDrawable(R.drawable.bg_volcano));
            } else {
                activity.findViewById(android.R.id.content).setBackgroundColor(getResources().getColor(R.color.desert));
            }
        }

        buttonClicks();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        changeExpedition();
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.d(DEBUG_TAG, "onDown: " + e.toString());
        changeExpedition();
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.d(DEBUG_TAG, "onLongPress: " + e.toString());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}