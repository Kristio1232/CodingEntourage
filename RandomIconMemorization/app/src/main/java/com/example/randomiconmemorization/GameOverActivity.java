package com.example.randomiconmemorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class GameOverActivity extends AppCompatActivity {
    private String currentPlayerName;
    private final HighScore highScore = new HighScore();
    private TextView HighScoreName1;
    private TextView HighScoreName2;
    private TextView HighScoreName3;
    private TextView HighScoreName4;
    private TextView HighScoreName5;
    private TextView ScoreName1;
    private TextView ScoreName2;
    private TextView ScoreName3;
    private TextView ScoreName4;
    private TextView ScoreName5;
    private final TextView[] names = new TextView[] { HighScoreName1, HighScoreName2, HighScoreName3, HighScoreName4, HighScoreName5};
    private final TextView[] Scores = new TextView[] { ScoreName1, ScoreName2, ScoreName3, ScoreName4, ScoreName5};
    private int index = 0;
    private int counter = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        currentPlayerName = getIntent().getExtras().getString("playerName");
        int currentPlayerPoints = getIntent().getExtras().getInt("playerScore");


        Score newPlayer = new Score();
        newPlayer.add(currentPlayerName, currentPlayerPoints);
        highScore.addScores(newPlayer);
        names[0] = findViewById(R.id.HighScoreName1);
        names[1] = findViewById(R.id.HighScoreName2);
        names[2] = findViewById(R.id.HighScoreName3);
        names[3] = findViewById(R.id.HighScoreName4);
        names[4] = findViewById(R.id.HighScoreName5);
        Scores[0] = findViewById(R.id.ScoreName1);
        Scores[1] = findViewById(R.id.ScoreName2);
        Scores[2] = findViewById(R.id.ScoreName3);
        Scores[3] = findViewById(R.id.ScoreName4);
        Scores[4] = findViewById(R.id.ScoreName5);

        if(index < 5)
            index ++;
        for(int i = 0; i < index; i++)
        {
            names[i].setText((counter)+")  " + highScore.getHighScores().get(i).getScores()[0]);
            counter++;
        }
        for(int j = 0; j < index; j++)
        {
            Scores[j].setText( highScore.getHighScores().get(j).getScores()[1]);
        }

    }

    public void HomeButton(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void PlayAgainButton(View v) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("playerName", currentPlayerName);
        startActivity(intent);
    }

}