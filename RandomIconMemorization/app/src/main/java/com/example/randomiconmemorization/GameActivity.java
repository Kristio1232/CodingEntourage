package com.example.randomiconmemorization;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private Game game = new Game();
    final Handler handler = new Handler();
    private Button redButton;
    private Button blueButton;
    private Button greenButton;
    private Button orangeButton;
    private Button purpleButton;
    private Button brownButton;


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
        game.newGameRound();

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
        for (Icon icon : order) {


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

            try {
                Thread.sleep(600);

                resetColor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
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
        gameButton("Red");
    }


    public void blueButtonPressed(View view) {
        gameButton("Blue");
    }

    public void greenButtonPressed(View view) {
        gameButton("Green");
    }

    public void orangeButtonPressed(View view) {
        gameButton("Orange");
    }

    public void purpleButtonPressed(View view) {
        gameButton("Purple");
    }

    public void brownButtonPressed(View view) {
        gameButton("Brown");
    }
}