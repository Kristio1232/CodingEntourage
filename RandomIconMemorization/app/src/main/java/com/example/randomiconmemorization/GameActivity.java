package com.example.randomiconmemorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity {

    private Game game = new Game();

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

        showPattern(game.getOrder());
    }


    /*
    Show the pattern
     */

    private void showPattern(ArrayList<Icon> order){
        for (Icon icon: order){

            if (icon.getName().equals("Red")){
                redButton.setBackgroundColor(0xffffffff);
                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                redButton.setBackgroundColor(0xFD0000);
            }else if (icon.getName().equals("Blue")){
                blueButton.setBackgroundColor(0xffffffff);
                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                blueButton.setBackgroundColor(0x03A9F4);
            }else if (icon.getName().equals("Green")){
                greenButton.setBackgroundColor(0xffffffff);
                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                greenButton.setBackgroundColor(0x03A9F4);
            }else if (icon.getName().equals("Orange")){
                orangeButton.setBackgroundColor(0x4CAF50);
                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                orangeButton.setBackgroundColor(0xFF5722);
            }else if (icon.getName().equals("Purple")){
                purpleButton.setBackgroundColor(0xffffffff);
                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                purpleButton.setBackgroundColor(0x673AB7);
            }else if (icon.getName().equals("Brown")){
                brownButton.setBackgroundColor(0xffffffff);
                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                brownButton.setBackgroundColor(0x472F2F);
            }
        }
    }


    private void gameButton(String name){
        this.game.buttonClicked(name);
        /*
        If game is not over
         */

        if (!game.isGameOver()){
            if (game.isNextRound()){
                showPattern(game.getOrder());
                game.setNextRound(false);
            }
        }else{
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