package com.ajochcas.lostcitiescounter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreDisplay extends AppCompatActivity {
    
    int thisScore;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_display);

        Intent intent = getIntent();
        String message = intent.getStringExtra(CardSelector.SCORE_OUTPUT);
        TextView textView = (TextView) findViewById(R.id.scoreView);
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

        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                save.setClickable(false);

                SharedPreferences sharedPreferences;

                sharedPreferences = getSharedPreferences("scores", Context.MODE_PRIVATE);

                String temp = sharedPreferences.getString("scores", null);

                SharedPreferences.Editor edit = sharedPreferences.edit();

                edit.clear();

                edit.putString("scores", "" + thisScore + temp);

                edit.commit();


                /*
                try {
                    FileOutputStream out = openFileOutput("res/raw/scores.txt", MODE_WORLD_READABLE);
                    out.write(("" + thisScore).getBytes());

                    for(int i = 0; i < 9; i++) {
                        out.write((" " + scores[i]).getBytes());
                    }
                    out.close();
                    Toast.makeText(getBaseContext(), "file saved", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {}
                */

                /*
                file.delete();

                File overwrite = new File("res/raw/scores.txt");

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
