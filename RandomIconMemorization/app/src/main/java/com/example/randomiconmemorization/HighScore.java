package com.example.randomiconmemorization;



import android.os.Build;

import java.util.*;

public class HighScore{
    private ArrayList<Score> highScores ;
    private int count;
    private int index;

    public HighScore() {
        this.highScores = new ArrayList<>();
        this.count = 0;
        this.index = 0;
    }
    public HighScore(HighScore highScore) {
        this.highScores = highScore.getHighScores();
        this.count = 0;
        this.index = 0;
    }



    public int nameExists(Score score) {

        for (int j = 0; j < this.highScores.size(); j++) {

            String[] score2 = this.highScores.get(j).getScores();
            String[] score1 = score.getScores();
            String str_score2 = score2[0];
            String str_score1 = score1[0];
            int int_score2 = Integer.parseInt(score2[1]);
            int int_score1 = Integer.parseInt(score1[1]);
            if ((str_score2.equals(str_score1) && (int_score2 <= int_score1)))
            {
                return j;
            }
            else if ((str_score2.equals(str_score1) && (int_score2 > int_score1))) {

                return -2;
            }

        }
        return -1;
    }


    public void addScores(Score score)
    {
        int nameExists = nameExists(score);
        if (nameExists != -1 && nameExists != -2) {
            this.highScores.remove(nameExists);
            this.highScores.add(score);
        }else if (nameExists != -2 ){
            highScores.add(score);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            highScores.sort(Collections.reverseOrder((Score a, Score b)-> a.compareTo(b)));

        }

    }

    public ArrayList<Score> getHighScores() {
        return highScores;
    }




}
