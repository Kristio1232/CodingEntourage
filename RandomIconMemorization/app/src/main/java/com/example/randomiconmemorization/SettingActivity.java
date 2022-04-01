package com.example.randomiconmemorization;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class SettingActivity extends AppCompatActivity {

    private static String MY_PREFS = "switch_prefs";
    private static String THEME_TOGGLE = "theme_toggle";
    private static String SWITCH_STATUS = "switch_status";

    boolean switch_status;
    boolean theme_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        SwitchMaterial switchBtn = findViewById(R.id.switchBtn);

        SharedPreferences myPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor myEditor = getSharedPreferences(MY_PREFS,MODE_PRIVATE).edit();

        switch_status = myPreferences.getBoolean(SWITCH_STATUS, false);
        theme_status = myPreferences.getBoolean(THEME_TOGGLE, false);

        switchBtn.setChecked(switch_status);

        if (theme_status) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                    myEditor.putBoolean(SWITCH_STATUS, true);
                    myEditor.putBoolean(THEME_TOGGLE, true);
                    myEditor.apply();
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                    myEditor.putBoolean(SWITCH_STATUS, false);
                    myEditor.putBoolean(THEME_TOGGLE, false);
                    myEditor.apply();
                }
            }
        });
    }

    public void backButton(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}