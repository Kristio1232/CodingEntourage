package com.example.randomiconmemorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        game.newGameRound();
    }

    private Game game = new Game();
    /*
    Show the pattern
     */

    private void showPattern(ArrayList<Icon> order){

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
        gameButton("red");

    }


    public void blueButtonPressed(View view) {
        gameButton("blue");
    }

    public void greenButtonPressed(View view) {
        gameButton("green");
    }

    public void orangeButtonPressed(View view) {
        gameButton("orange");
    }

    public void purpleButtonPressed(View view) {
        gameButton("purple");
    }

    public void brownButtonPressed(View view) {
        gameButton("brown");
    }
}