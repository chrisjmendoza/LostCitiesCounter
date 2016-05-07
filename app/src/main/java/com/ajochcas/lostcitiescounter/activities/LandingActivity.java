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

import java.util.Scanner;

public class LandingActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }

    protected void onStart() {
        super.onStart();

        sharedPreferences = getSharedPreferences("scores", Context.MODE_PRIVATE);

        if(!sharedPreferences.contains("scores")) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("scores", "");
            edit.apply();
        }

        Scanner in;

        in = new Scanner(sharedPreferences.getString("scores", null));
        //InputStream is = this.getResources().openRawResource(R.raw.scores);
        //in.useDelimiter(",");

        String scores[] = new String[10];

        for (int i = 0; i < 10; i++) {
            if(!in.hasNext()) {
                break;
            }
            scores[i] = in.next();
        }

        TextView[] view = {
                (TextView) findViewById(R.id.scoreText1),
                (TextView) findViewById(R.id.scoreText2),
                (TextView) findViewById(R.id.scoreText3),
                (TextView) findViewById(R.id.scoreText4),
                (TextView) findViewById(R.id.scoreText5),
                (TextView) findViewById(R.id.scoreText6),
                (TextView) findViewById(R.id.scoreText7),
                (TextView) findViewById(R.id.scoreText8),
                (TextView) findViewById(R.id.scoreText9),
                (TextView) findViewById(R.id.scoreText10)
        };

        for(int i = 0; i < 10; i++) {
            view[i].setText(scores[i]);
            //scores.add(i, Integer.getInteger(score));
        }

        Button next = (Button) findViewById(R.id.nextFirst);
        assert next != null;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, CardSelectorActivity.class));
            }
        });
    }
}
