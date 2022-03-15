package com.example.randomiconmemorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toOptions(View v){
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
    public void startGame(View v){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}