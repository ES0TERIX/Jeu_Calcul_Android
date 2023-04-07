package com.example.cours_groupe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HighScoreActivity extends AppCompatActivity {

    private TextView textViewHighScore;
    private TextView textViewNom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        textViewHighScore = findViewById(R.id.textView_HighScore);
        textViewNom = findViewById(R.id.textView_Nom);
        //Intent intent = getIntent();
        //Integer Score = intent.getIntExtra("SCORE",0);
        //String Nom = intent.getStringExtra("NOM");

        //textViewHighScore.setText(Score);
        //textViewNom.setText(Nom);
    }
}