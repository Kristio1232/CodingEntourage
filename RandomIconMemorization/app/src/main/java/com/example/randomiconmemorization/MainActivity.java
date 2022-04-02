package com.example.randomiconmemorization;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = findViewById(R.id.Name);
        setContentView(R.layout.activity_main);
        SharedPreferences appSettingPrefs = getSharedPreferences("AppSettingPrefs", 0);
        SharedPreferences.Editor sharedPrefsEdit = appSettingPrefs.edit();
        Boolean isNightModeOn = appSettingPrefs.getBoolean("NightMode", false);
        Button switchButton = findViewById(R.id.switchButton);
        if (!AppInfo.musicStarted()) {
            PlayBackgroundSound();
            AppInfo.setMusicStarted(true);
        }

        if (isNightModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    public void PlayBackgroundSound() {
        Intent intent = new Intent(MainActivity.this, BackgroundSoundService.class);
        startService(intent);
    }

    private String getScreenContent(int id) {
        View contentView = findViewById(id);
        EditText contentText = (EditText) contentView;
        String content = contentText.getText().toString();
        return content;
    }

    public void toOptions(View v) {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }

    public void startGame(View v) {
        String content = getScreenContent(R.id.Name);
        String playerName = "";
        if (content.length() < 3) {
            Random random = new Random();
            char randomizedCharacter;
            for (int i = 0; i < 3; i++) {
                randomizedCharacter = (char) (random.nextInt(26) + 'a');
                playerName += randomizedCharacter;
            }

        } else {
            playerName = content;
        }
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("playerName", playerName);
        startActivity(intent);
    }

}