package com.example.randomiconmemorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void lightModeToggle(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void darkModeToggle(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void backButton(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}