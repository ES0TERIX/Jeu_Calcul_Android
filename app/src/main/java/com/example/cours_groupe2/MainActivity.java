package com.example.cours_groupe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button boutonCalcul;

    private Button boutonHighscore;

    private Button boutonApropos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boutonCalcul = findViewById(R.id.boutonCalcul);
        boutonCalcul.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,CalculActivity.class);
            startActivity(intent);
        });

        boutonHighscore = findViewById(R.id.boutonHighScore);
        boutonHighscore.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, HighScoreActivity.class);
            startActivity(intent);
        });

        boutonApropos = findViewById(R.id.butonApropos);
        boutonApropos.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,aPropos.class);
            startActivity(intent);
        });

    }
}