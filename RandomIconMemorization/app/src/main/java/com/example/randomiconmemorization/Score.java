package com.example.randomiconmemorization;

import java.util.*;

public class Score implements Comparable<Score> {
    private final String[] scores;

    public Score() {
        this.scores = new String[2];
    }

    public void add(String name, Integer score) {
        String myScore = score.toString();
        this.scores[0] = name;
        this.scores[1] = myScore;
    }

    public String[] getScores() {
        return scores;
    }

    public String toString() {
        return Arrays.toString(scores);
    }

    @Override
    public int compareTo(Score other) {

        return Integer.compare(Integer.parseInt(this.scores[1]), Integer.parseInt(other.scores[1]));
    }
}
