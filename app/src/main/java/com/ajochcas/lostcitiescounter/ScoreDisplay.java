/*
package com.ajochcas.lostcitiescounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScoreDisplay extends AppCompatActivity {

    private int thisScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_display);

        Intent intent = getIntent();
        String message = intent.getStringExtra(CardSelector.SCORE_OUTPUT);

        TextView textView = (TextView) findViewById(R.id.scoreView);
        assert textView != null;
        textView.setTextSize(40);
        textView.setText(message);

        Button homeButton = (Button) findViewById(R.id.homeButton);
        assert homeButton != null;
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScoreDisplay.this, Landing.class));
            }
        });

        //save to file under here

        thisScore = Integer.parseInt(message);

        Button save = (Button) findViewById(R.id.save);

        assert save != null;
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Scanner in = null;

                File file = new File("res/raw/score.txt");

                try {
                    in = new Scanner(file);
                } catch (FileNotFoundException ignored) {

                }

                int scores[] = new int[]{-401, -401, -401, -401, -401, -401, -401, -401, -401, -401};
                int index = 0;

                assert in != null;
                while (in.hasNext()) {
                    scores[index] = in.nextInt();
                    index++;
                }

                File overwrite = new File("res/raw/score.txt");

                try {
                    FileWriter write = new FileWriter(overwrite);
                    write.write("" + thisScore);

                    for (int i = 0; i < 9; i++) {
                        write.write(" " + scores[i]);
                    }

                } catch (IOException ignored) {

                }
            }
        });
    }
}

*/

package com.homework.lostcitiesscorer.lostcitiesscorer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Sai Chang on 4/21/2016.
 */
public class DisplayScore extends AppCompatActivity {

    private int scores[];
    int thisScore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        Intent i = getIntent();

        String message = "123";

        int number = Integer.parseInt(message);

        Scanner in = new Scanner(i.getStringExtra("score"));

        thisScore = in.nextInt();

        ((TextView) findViewById(R.id.score)).setText(i.getStringExtra("score"));


        Button save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Scanner in = new Scanner(getResources().openRawResource(R.raw.score));

                int scores[] = new int[]{-401, -401, -401, -401, -401, -401, -401, -401, -401, -401};
                int index = 0;

                while (in.hasNext()) {
                    scores[index] = in.nextInt();
                    index++;
                }

                try {
                    PrintWriter write = new PrintWriter("android.resource://com.cpt.sample/raw/score.txt");
                    write.print("" + thisScore);

                    for(int i = 0; i < 9; i++) {
                        write.write(" " + scores[i]);
                    }
                    write.close();
                } catch (FileNotFoundException e) {}
                /*
                try {
                    FileWriter write = new FileWriter(overwrite);
                    write.write("" + thisScore);

                    for(int i = 0; i < 9; i++) {
                        write.write(" " + scores[i]);
                    }
                } catch (IOException e) {}
                */
            }
        });
    }

}

