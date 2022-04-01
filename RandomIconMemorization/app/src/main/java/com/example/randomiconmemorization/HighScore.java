package com.example.randomiconmemorization;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.*;

public class HighScore implements Parcelable {
    private ArrayList<Score> HighScores ;
    private int count;
    private int index;

    public HighScore() {
        this.HighScores = new ArrayList<>();
        this.count = 0;
        this.index = 0;
    }
    public HighScore(HighScore highScore) {
        this.HighScores = highScore.getHighScores();
        this.count = 0;
        this.index = 0;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    protected HighScore(Parcel in) {
        count = in.readInt();
        index = in.readInt();
    }

    public static final Creator<HighScore> CREATOR = new Creator<HighScore>() {
        @Override
        public HighScore createFromParcel(Parcel in) {
            return new HighScore(in);
        }

        @Override
        public HighScore[] newArray(int size) {
            return new HighScore[size];
        }
    };
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int nameExists(Score score) {

        for (int j = 0; j < this.HighScores.size(); j++) {

            String[] score2 = this.HighScores.get(j).getScores();
            String[] score1 = score.getScores();
            String str_score2 = score2[0];
            String str_score1 = score1[0];
            int int_score2 = Integer.parseInt(score2[1]);
            int int_score1 = Integer.parseInt(score1[1]);
            if ((str_score2.equals(str_score1) && (int_score2 <= int_score1))) {
                return j;
            } else if ((str_score2.equals(str_score1) && (int_score2 > int_score1))) {

                return -2;
            }

        }
        return -1;
    }


    public void addScores(Score score) {
        int counter_1 = nameExists(score);
        if (counter_1 != -1 && counter_1 != -2) {
            this.HighScores.remove(counter_1);
            this.count = this.count - 1;

        }
        if (this.count == 0) {
            this.HighScores.add(score);

        } else {
            for (int i = 0; i < count; i++) {
                String[] score2 = this.HighScores.get(i).getScores();
                String[] score1 = score.getScores();
                int int_score2 = Integer.parseInt(score2[1]);
                int int_score1 = Integer.parseInt(score1[1]);
                this.index = 0;
                if (int_score2 <= int_score1) {
                    this.HighScores.add(i, score);
                    this.index = i;
                    break;
                }

                if (i == count - 1 && (int_score2 > int_score1)) {
                    this.HighScores.add(i, score);
                }
            }
        }
        this.count = this.count + 1;
        if (counter_1 == -2) {
            this.HighScores.remove(this.index);
            this.index = 0;
        }

    }

    public ArrayList<Score> getHighScores() {
        return HighScores;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(count);
        parcel.writeInt(index);
    }
}
