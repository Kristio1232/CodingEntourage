package com.example.randomiconmemorization;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatDelegate;


public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        SharedPreferences appSettingPrefs = getSharedPreferences("AppSettingPrefs", 0);
        SharedPreferences.Editor sharedPrefsEdit = appSettingPrefs.edit();
        Boolean isNightModeOn = appSettingPrefs.getBoolean("NightMode", false);
        Button switchButton = findViewById(R.id.switchButton);
        if(isNightModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            switchButton.setText("Disable Dark Mode");
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            switchButton.setText("Enable Dark Mode");
        }
        switchButton.setOnClickListener(view -> {
            if (isNightModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                sharedPrefsEdit.putBoolean("NightMode", false);
                sharedPrefsEdit.apply();

                switchButton.setText("Enable Dark Mode");
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                sharedPrefsEdit.putBoolean("NightMode", true);
                sharedPrefsEdit.apply();

                switchButton.setText("Disable Dark Mode");
            }
        });
    }


    public void backButton(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
