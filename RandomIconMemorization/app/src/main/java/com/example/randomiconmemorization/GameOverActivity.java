package com.example.randomiconmemorization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {
    private String currentPlayerName;
    private int currentPlayerPoints;
    private HighScore highScore = new HighScore();
    private TextView view23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        currentPlayerName = getIntent().getExtras().getString("playerName");
        currentPlayerPoints = getIntent().getExtras().getInt("playerScore");
        view23 = findViewById(R.id.textView23);
        view23.setText(currentPlayerName);
    }
}