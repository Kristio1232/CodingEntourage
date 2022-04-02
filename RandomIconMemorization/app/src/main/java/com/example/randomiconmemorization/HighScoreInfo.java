package com.example.randomiconmemorization;

public class HighScoreInfo {
    private static HighScore highScore;

    public static HighScore getHighScore() {
        return highScore;
    }

    public static void setHighScore(HighScore highScore) {
        HighScoreInfo.highScore = highScore;
    }
}
