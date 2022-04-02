package com.example.randomiconmemorization;

public class AppInfo {
    private static HighScore highScore;
    private static boolean musicStarted = false;

    public static boolean musicStarted() {
        return musicStarted;
    }

    public static void setMusicStarted(boolean musicStarted) {
        AppInfo.musicStarted = musicStarted;
    }

    public static HighScore getHighScore() {
        return highScore;
    }

    public static void setHighScore(HighScore highScore) {
        AppInfo.highScore = highScore;
    }
}
