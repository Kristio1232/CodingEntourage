package com.example.randomiconmemorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {
    private String currentPlayerName;
    private int currentPlayerPoints;
    private HighScore highScore = new HighScore();
    private TextView HighScoreName1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        currentPlayerName = getIntent().getExtras().getString("playerName");
        currentPlayerPoints = getIntent().getExtras().getInt("playerScore");
        HighScoreName1 = findViewById(R.id.HighScoreName1);
        HighScoreName1.setText(currentPlayerName);
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