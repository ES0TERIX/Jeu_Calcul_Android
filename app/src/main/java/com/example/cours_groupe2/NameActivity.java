package com.example.cours_groupe2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.cours_groupe2.DAO.ScoreBaseHelper;
import com.example.cours_groupe2.DAO.ScoreDao;
import com.example.cours_groupe2.model.entities.Score;

public class NameActivity extends AppCompatActivity {
    TextView textDernierScore;
    private ScoreDao scoreDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        scoreDao = new ScoreDao(new ScoreBaseHelper(this, "BDD", 1));
        Score monScore = scoreDao.lastOrNull();
        textDernierScore = findViewById(R.id.textViewDernierScore);
        textDernierScore.setText(monScore.getScore());
    }
}