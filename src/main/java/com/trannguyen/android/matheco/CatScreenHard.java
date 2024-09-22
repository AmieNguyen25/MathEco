package com.trannguyen.android.matheco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class CatScreenHard extends AppCompatActivity {
    Button hardaddbtn;
    Button hardsubbtn;
    Button hardmultibtn;
    Button harddivbtn;
    Button hardallinbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cat_screen_hard);

        //Hard Add Button
        hardaddbtn = findViewById(R.id.hard_addbtn);
        hardaddbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hardlevadd();
            }
        });
        //Hard Subtract Button
        hardsubbtn = findViewById(R.id.hard_subbtn);
        hardsubbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hardlevsub();
            }
        });
        //Hard Multi Button
        hardmultibtn = findViewById(R.id.hard_multibtn);
        hardmultibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hardlevmul();
            }
        });
        //Hard Divide Button
        harddivbtn = findViewById(R.id.hard_divbtn);
        harddivbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hardlevdiv();
            }
        });
        //Hard All-In-One Button
        hardallinbtn = findViewById(R.id.hard_allinbtn);
        hardallinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hardlevmix();
            }
        });
    }
    public void hardlevadd() {
        Intent intent = new Intent(CatScreenHard.this, TestHardActivity.class);
        intent.putExtra("actionTitle", "Addition");
        startActivity(intent);
    }
    public void hardlevsub() {
        Intent intent = new Intent(CatScreenHard.this, TestHardActivity.class);
        intent.putExtra("actionTitle", "Subtraction");
        startActivity(intent);
    }
    public void hardlevmul() {
        Intent intent = new Intent(CatScreenHard.this, TestHardActivity.class);
        intent.putExtra("actionTitle", "Multiplication");
        startActivity(intent);
    }
    public void hardlevdiv() {
        Intent intent = new Intent(CatScreenHard.this, TestHardActivity.class);
        intent.putExtra("actionTitle", "Division");
        startActivity(intent);
    }
    public void hardlevmix() {
        Intent intent = new Intent(CatScreenHard.this, TestHardActivity.class);
        intent.putExtra("actionTitle", "All-in-one");
        startActivity(intent);
    }
}