package com.ajochcas.lostcitiescounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Scanner;

public class Landing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }

    protected void onStart() {
        super.onStart();

        Scanner in;

        //in = new Scanner(this.getResources().openRawResource(R.raw.score));

        ArrayList<Integer> scores = new ArrayList<>();

        int index = 0;


        //TextView vw = (TextView) findViewById(R.id.score2);

        //vw.setText("Test2");
        /*while (in.hasNext()) {
            scores[index] = in.nextInt();
            index++;
        }*/

        TextView[] view = {
                (TextView) findViewById(R.id.scoretext1),
                (TextView) findViewById(R.id.scoretext2),
                (TextView) findViewById(R.id.scoretext3),
                (TextView) findViewById(R.id.scoretext4),
                (TextView) findViewById(R.id.scoretext5),
                (TextView) findViewById(R.id.scoretext6),
                (TextView) findViewById(R.id.scoretext7),
                (TextView) findViewById(R.id.scoretext8),
                (TextView) findViewById(R.id.scoretext9),
                (TextView) findViewById(R.id.scoretext10)
        };

        for(int i = 0; i < 10; i++) {
            String score = view[i].toString();
            scores.add(i, Integer.getInteger(score));
        }

        Button next = (Button) findViewById(R.id.nextFirst);
        assert next != null;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Landing.this, CardSelector.class));
            }
        });
    }
}