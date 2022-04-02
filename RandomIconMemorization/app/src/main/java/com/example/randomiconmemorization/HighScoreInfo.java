package com.example.randomiconmemorization;

public class HighScoreInfo {
    private static HighScore highScore;

    public static HighScore getHighScore() {
        System.out.println("Return");
        System.out.println(highScore == null);
        if (highScore != null){
            System.out.println(highScore.getHighScores());
        }

        return highScore;
    }

    public static void setHighScore(HighScore highScore) {
        System.out.println(highScore.getHighScores());
        HighScoreInfo.highScore = highScore;
    }
}
