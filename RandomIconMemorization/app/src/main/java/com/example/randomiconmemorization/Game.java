package com.example.randomiconmemorization;

import java.util.ArrayList;

/*
Stores high score
Starts gameRound
Has Game Over when gameRound ends
 */
public class Game {
    private GameRound gameRound;
    private int orderNumber;
    private int points;
    private boolean nextRound;
    private boolean gameOver;
    public Game(){
        gameRound = new GameRound();
        orderNumber = 0;
        gameOver = false;
    }

    public boolean isNextRound() {
        return nextRound;
    }

    public void setNextRound(boolean nextRound) {
        this.nextRound = nextRound;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public GameRound getGameRound() {
        return gameRound;
    }

    public ArrayList<Icon> getOrder(){return gameRound.getOrder();}

    public void newGameRound(){
        gameRound = new GameRound();
        orderNumber = 0;
        gameOver = false;

    }
    /*
    WHen button clicked checks if it is correct
    Checks if the game
     */
    public void buttonClicked(String name){
        boolean correctButton = gameRound.checkCorrect(name, orderNumber);
        if (correctButton){

            if (orderNumber == gameRound.getOrderLength()){
                gameRound.nextLevel();
                nextRound = true;
                orderNumber =0;
            }else{
                orderNumber++;
            }
        }else{
            gameOver = true;
        }

    }


}
