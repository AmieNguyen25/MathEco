package com.trannguyen.android.matheco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView txtResultScore;
    TextView txtLevelResult;
    TextView txtModeResult;
    Button btnPlayAgain;
    Intent intent;
    int score = 0;
    String userlevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResultScore = findViewById(R.id.txtScoreResult);
        txtLevelResult = findViewById(R.id.txtLevelResult);
        txtModeResult = findViewById(R.id.txtModeResult);
        btnPlayAgain = findViewById(R.id.playagainbutton);

        //accessing value that we sent from Game Activity
        intent = getIntent();
        txtModeResult.setText(intent.getStringExtra("Mode"));
        txtLevelResult.setText(intent.getStringExtra("Level"));
        score = intent.getIntExtra("Score",0);

        //set text with score
        //convert int to string first
        String strScore= String.valueOf(score);
        txtResultScore.setText(strScore);

        //Play Again Button
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               playagain();
            }
        });
    }
    public void playagain() {
        Intent intent = new Intent(Result.this, Levelscreen.class);
        startActivity(intent);
    }
}