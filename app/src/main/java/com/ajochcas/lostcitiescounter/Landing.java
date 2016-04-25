package com.ajochcas.lostcitiescounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        int scores[] = new int[]{-300, -301, -301, -301, -301, -301, -301, -301, -301, -301};
        int index = 0;


        //TextView vw = (TextView) findViewById(R.id.score2);

        //vw.setText("Test2");
        /*while (in.hasNext()) {
            scores[index] = in.nextInt();
            index++;
        }*/

        TextView[] view = {(TextView) findViewById(R.id.score1),
                (TextView) findViewById(R.id.score2),
                (TextView) findViewById(R.id.score3),
                (TextView) findViewById(R.id.score4),
                (TextView) findViewById(R.id.score5),
                (TextView) findViewById(R.id.score6),
                (TextView) findViewById(R.id.score7),
                (TextView) findViewById(R.id.score8),
                (TextView) findViewById(R.id.score9),
                (TextView) findViewById(R.id.score10)};

        for (int i = 0; i < 10; i++) {
            //if (scores[i] > -301) {
                view[i].setText("" + (scores[i]));
            //}
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