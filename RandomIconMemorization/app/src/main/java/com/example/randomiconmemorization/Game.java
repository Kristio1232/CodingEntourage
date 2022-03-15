package com.example.randomiconmemorization;
/*
Stores high score
Starts gameRound
Has Game Over when gameRound ends
 */
public class Game {
    private GameRound gameRound;
    private int orderNumber;
    private int points;
    private boolean gameOver;
    public Game(){
        gameRound = new GameRound();
        orderNumber = 0;
        gameOver = false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public GameRound getGameRound() {
        return gameRound;
    }

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
                orderNumber =0;
            }else{
                orderNumber++;
            }
        }else{
            gameOver = true;
        }

    }


}
