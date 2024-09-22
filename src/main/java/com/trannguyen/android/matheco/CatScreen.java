package com.trannguyen.android.matheco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class CatScreen extends AppCompatActivity {
    Button easyaddbtn;
    Button easysubbtn;
    Button easymultibtn;
    Button easydivbtn;
    Button easyallinbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cat_screen);

        //Easy Add Button
        easyaddbtn = findViewById(R.id.easy_addbtn);
        easyaddbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easylevadd();
            }
        });
        //Easy Subtract Button
        easysubbtn = findViewById(R.id.easy_subbtn);
        easysubbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easylevsub();
            }
        });
        //Easy Multi Button
        easymultibtn = findViewById(R.id.easy_multibtn);
        easymultibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easylevmulti();
            }
        });
        //Easy Division Button
        easydivbtn = findViewById(R.id.easy_divbtn);
        easydivbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easylevdivi();
            }
        });
        //Easy All-In-One Button
        easyallinbtn = findViewById(R.id.easy_allinbtn);
        easyallinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easylevmix();
            }
        });
    }
    public void easylevadd() {
        Intent intent = new Intent(CatScreen.this, TestEasyActivity.class);
        intent.putExtra("actionTitle", "Addition");
        startActivity(intent);
    }
     public void easylevsub() {
        Intent intent = new Intent(CatScreen.this, TestEasyActivity.class);
         intent.putExtra("actionTitle", "Subtraction");
        startActivity(intent);
    }
    public void easylevmulti() {
        Intent intent = new Intent(CatScreen.this, TestEasyActivity.class);
        intent.putExtra("actionTitle", "Multiplication");
        startActivity(intent);
    }
    public void easylevdivi() {
        Intent intent = new Intent(CatScreen.this, TestEasyActivity.class);
        intent.putExtra("actionTitle", "Division");
        startActivity(intent);
    }
    public void easylevmix() {
        Intent intent = new Intent(CatScreen.this, TestEasyActivity.class);
        intent.putExtra("actionTitle", "All-in-one");
        startActivity(intent);
    }
}