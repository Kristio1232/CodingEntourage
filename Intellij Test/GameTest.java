package com.example.myapplication;
import java.util.*;
import java.util.ArrayList;


public class GameTest {
    private static Game game = new Game();
    public static void main(String[] args) {
        GameRound gameRound;
        ArrayList<Icon> gameRoundArray;
        String userAnswer = "True";
        Scanner sc= new Scanner(System.in);
        while (!userAnswer.equals("False")){
            gameRound = game.getGameRound();
            gameRoundArray = gameRound.getOrder();
            for (int i = 0;i < gameRoundArray.size();i++){
                System.out.print(gameRoundArray.get(i).getName() + " - ");
            }
            System.out.println("");
            System.out.println("Which button do u click:");
            userAnswer = sc.nextLine();
            game.buttonClicked(userAnswer);
        }
    }
}
