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
