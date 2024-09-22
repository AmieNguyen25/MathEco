package com.trannguyen.android.matheco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class CatScreenMedium extends AppCompatActivity {
    Button medaddbtn;
    Button medsubbtn;
    Button medmultibtn;
    Button meddivbtn;
    Button medallinbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cat_screen_medium);

        //Medium Add Button
        medaddbtn = findViewById(R.id.med_addbtn);
        medaddbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                medlevadd();
            }
        });
        //Medium Subtract Button
        medsubbtn = findViewById(R.id.med_subbtn);
        medsubbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medlevsub();
            }
        });
        //Medium Multi Button
        medmultibtn = findViewById(R.id.med_multibtn);
        medmultibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medlevmul();
            }
        });
        //Medium Divide Button
        meddivbtn = findViewById(R.id.med_divbtn);
        meddivbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medlevdiv();
            }
        });
        //Medium All-In-One Button
        medallinbtn = findViewById(R.id.med_allinbtn);
        medallinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medlevmix();
            }
        });
    }
    public void medlevadd(){
        Intent intent = new Intent(CatScreenMedium.this, TestMediumActivity.class);
        intent.putExtra("actionTitle", "Addition");
        startActivity(intent);
    }
    public void medlevsub() {
        Intent intent = new Intent(CatScreenMedium.this, TestMediumActivity.class);
        intent.putExtra("actionTitle", "Subtraction");
        startActivity(intent);
    }
    public void medlevmul() {
        Intent intent = new Intent(CatScreenMedium.this, TestMediumActivity.class);
        intent.putExtra("actionTitle", "Multiplication");
        startActivity(intent);
    }
    public void medlevdiv() {
        Intent intent = new Intent(CatScreenMedium.this, TestMediumActivity.class);
        intent.putExtra("actionTitle", "Division");
        startActivity(intent);
    }
    public void medlevmix() {
        Intent intent = new Intent(CatScreenMedium.this, TestMediumActivity.class);
        intent.putExtra("actionTitle", "All-in-one");
        startActivity(intent);
    }
}
