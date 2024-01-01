package com.husyairi.valuecomparison;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        startButton = findViewById(R.id.startButton);

        Intent intent = new Intent(getApplicationContext(), Calculate.class);
        startActivity(intent);
        finish();
    }
}