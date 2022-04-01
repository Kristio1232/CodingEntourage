package com.example.randomiconmemorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    final Handler handler = new Handler();
    private Game game = new Game();
    private Button redButton;
    private Button blueButton;
    private Button greenButton;
    private Button orangeButton;
    private Button purpleButton;
    private Button brownButton;
    private TextView score;
    private TextView name;
    private boolean showPattern = false;
    String playerName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);
        redButton = findViewById(R.id.redButton);
        blueButton = findViewById(R.id.blueButton);
        greenButton = findViewById(R.id.greenButton);
        orangeButton = findViewById(R.id.orangeButton);
        purpleButton = findViewById(R.id.purpleButton);
        brownButton = findViewById(R.id.brownButton);
        score = findViewById(R.id.playerScore);
        name = findViewById(R.id.playerName);
        game.newGameRound();
        playerName = getIntent().getExtras().getString("playerName");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showPattern(game.getOrder());
            }
        }, 100);
    }


    public void resetColor() {

        redButton.setBackgroundColor(Color.parseColor("#FD0000"));
        blueButton.setBackgroundColor(Color.parseColor("#03A9F4"));
        greenButton.setBackgroundColor(Color.parseColor("#4CAF50"));
        orangeButton.setBackgroundColor(Color.parseColor("#FF5722"));
        purpleButton.setBackgroundColor(Color.parseColor("#673AB7"));
        brownButton.setBackgroundColor(Color.parseColor("#472F2F"));
    }

    /*
    Show the pattern
     */

    private void showPattern(ArrayList<Icon> order) {
        score.setText(game.getPoints());
        name.setText(playerName);
        showPattern = true;
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i;
            Icon icon;

            public void run() {
                for (i = 0; i < order.size(); i++) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // need to do tasks on the UI thread
                            icon = order.get(i);
                            if (icon.getName().equals("Red")) {
                                redButton.setBackgroundColor(0xffffffff);
                                redButton.invalidate();

                            } else if (icon.getName().equals("Blue")) {
                                blueButton.setBackgroundColor(0xffffffff);
                                blueButton.invalidate();
                            } else if (icon.getName().equals("Green")) {
                                greenButton.setBackgroundColor(0xffffffff);
                                greenButton.invalidate();
                            } else if (icon.getName().equals("Orange")) {
                                orangeButton.setBackgroundColor(0xffffffff);
                                orangeButton.invalidate();
                            } else if (icon.getName().equals("Purple")) {
                                purpleButton.setBackgroundColor(0xffffffff);
                                purpleButton.invalidate();
                            } else if (icon.getName().equals("Brown")) {
                                brownButton.setBackgroundColor(0xffffffff);
                                brownButton.invalidate();
                            }
                        }
                    }, 100);
                    //Add some downtime
                    SystemClock.sleep(1000);
                    resetColor();
                }
                showPattern = false;
            }
        };
        new Thread(runnable).start();

    }


    private void gameButton(String name) {


        this.game.buttonClicked(name);
        /*
        If game is not over
         */

        if (!game.isGameOver()) {
            if (game.isNextRound()) {

                showPattern(game.getOrder());

                game.setNextRound(false);
            }
        } else {
            /*
            What Happens when the game is over
             */
            Intent intent = new Intent(this, GameOverActivity.class);
            startActivity(intent);
        }
    }


    public void redButtonPressed(View view) {
        if (!showPattern){gameButton("Red"); }
    }


    public void blueButtonPressed(View view) {
        if (!showPattern){gameButton("Blue");};
    }

    public void greenButtonPressed(View view) {
        if (!showPattern){gameButton("Green");};
    }

    public void orangeButtonPressed(View view) {
        if (!showPattern){gameButton("Orange");};
    }

    public void purpleButtonPressed(View view) {
        if (!showPattern){gameButton("Purple");};
    }

    public void brownButtonPressed(View view) {
        if (!showPattern){gameButton("Brown");};
    }
}