package com.ajochcas.lostcitiescounter.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ajochcas.lostcitiescounter.R;

public class ScoreDisplayActivity extends AppCompatActivity {

    private int thisScore;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_display);

        //Add activity intent and grab output
        String message = getIntent().getStringExtra(CardSelectorActivity.SCORE_OUTPUT);A
        TextView textView = (TextView) findViewById(R.id.scoreView);
        assert textView != null;
        textView.setText(message);

        //Add Listenr to home button to take the user home.
        Button homeButton = (Button) findViewById(R.id.homeButton);
        assert homeButton != null;
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScoreDisplayActivity.this, LandingActivity.class));
            }
        });
        
        //Save Score to history
        SharedPreferences sharedPreferences = getSharedPreferences("scores", Context.MODE_PRIVATE);
        String oldScores = sharedPreferences.getString("scores", null);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.putString("scores", "" + Integer.parseInt(message) + " " + oldScores);
        edit.apply();
    }
}
