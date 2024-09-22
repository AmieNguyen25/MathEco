package com.trannguyen.android.matheco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class Levelscreen extends AppCompatActivity {
    Button buttoneasy;
    Button buttonmed;
    Button buttonhard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_levelscreen);

        SwitchMaterial switchBtn = findViewById(R.id.switchBtn);
        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean nightMode) {
                if (nightMode) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    compoundButton.setText("Night Mode");
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    compoundButton.setText("Light Mode");
                }
            }
        });

        //Easy Button
        buttoneasy = findViewById(R.id.easy);
        buttoneasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easy();
            }
        });

        //Medium Button
        buttonmed = findViewById(R.id.med);
        buttonmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medium();
            }
        });

        //Hard Button
        buttonhard = findViewById(R.id.hard);
        buttonhard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hard();
            }
        });
    }

    public void easy() {
        Intent intent = new Intent(Levelscreen.this, CatScreen.class);
        startActivity(intent);
    }

    public void medium() {
        Intent intent = new Intent(Levelscreen.this, CatScreenMedium.class);
        startActivity(intent);
    }
    public void hard() {
        Intent intent = new Intent(Levelscreen.this, CatScreenHard.class);
        startActivity(intent);
    }
}

