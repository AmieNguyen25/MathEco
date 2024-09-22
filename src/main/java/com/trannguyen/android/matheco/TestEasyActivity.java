package com.trannguyen.android.matheco;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class TestEasyActivity extends AppCompatActivity {
    TextView textScore;
    TextView TextTime;
    TextView textHeart;
    TextView textQuestion;
    EditText answer;
    Button ok;
    Button next;

    //generate random numbers
    Random rd = new Random();
    int num1;
    int num2;

    //user ans and correct ans
    int userAnswer;
    int realAnswer;

    //User data
    int userScore = 0;
    int userHeart = 3;
    String userMode;
    String userLevel = "Easy";

    //timer
    CountDownTimer timer;

    //private static variables are often used for constants, in this case, our minute long timer
    private static final long START_TIMER_IN_MS = 60000;

    //determines if timer is running or not
    Boolean timer_running;
    long time_left_in_ms = START_TIMER_IN_MS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_easy);

        textScore = findViewById(R.id.textViewscore);
        textHeart = findViewById(R.id.textViewheart);
        TextTime = findViewById(R.id.textViewtime);
        textQuestion = findViewById(R.id.question);
        answer = findViewById(R.id.editAnswer);
        ok = findViewById(R.id.btn1);
        next = findViewById(R.id.btn2);
        gameContinue();
        //button click listeners
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //pauses timer when user answers
                pauseTimer();

                //checking if user input is empty
                if (!answer.getText().toString().equals("")) {
                    //button can only click once time
                    ok.setClickable(false);
                    //get user answer as string converted to integer
                    userAnswer = Integer.parseInt(answer.getText().toString());
                }
                //check user answer to correct answer
                if (userAnswer == realAnswer) {
                    //count user score and show it was correct notification
                    if(userMode == "All-in-one"){
                        userScore = userScore + 15;
                    }
                    else {
                        userScore = userScore + 10;
                    }

                    //convert the score to an integer value and show it was correct notification
                    textQuestion.setText(R.string.correct);
                    textScore.setText(String.valueOf(userScore));
                } else {
                    //decrease user heart and show it was wrong notification
                    userHeart = userHeart - 1;
                    textQuestion.setText(R.string.incorrect);
                    textHeart.setText(String.valueOf(userHeart));
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clear answer and generate a new question
                answer.setText("");
                ok.setClickable(true);
                //checking if user input is empty
                if (!answer.getText().toString().equals("")) {
                    //button can only click once time
                    ok.setClickable(false);
                    //get user answer as string converted to integer
                    userAnswer = Integer.parseInt(answer.getText().toString());
                }
                //check user answer to correct answer
                if (userAnswer == realAnswer) {
                    //count user score and show it was correct notification
                    if(userMode == "All-in-one"){
                        userScore = userScore + 0;
                    }
                    else {
                        userScore = userScore + 0;
                    }
                    //convert the score to an integer value
                    textScore.setText(String.valueOf(userScore));
                } else {
                    //decrease user heart and show it was wrong notification
                    userHeart = userHeart - 1;
                    textQuestion.setText(R.string.incorrect);
                    textHeart.setText(String.valueOf(userHeart));
                }
                //if user run out of lives, open up the result and display user results
                if (userHeart <= 0)
                {
                    Toast.makeText(getApplicationContext(),R.string.game_over, Toast.LENGTH_LONG).show();
                    ok.setEnabled(false);
                    next.setEnabled(false);
                    Intent intent = new Intent(TestEasyActivity.this, Result.class);
                    intent.putExtra("Score", userScore);
                    intent.putExtra("Mode", userMode);
                    intent.putExtra("Level", userLevel);
                    startActivity(intent);
                    finish();
                }
                //if still have lives, game continues
                else
                {
                    gameContinue();
                }
            }
        });
    }

    public void gameContinue() {
        Intent intent;
        intent = getIntent();
        getSupportActionBar().setTitle(userLevel + " " + intent.getStringExtra("actionTitle"));

        String actionTitle = intent.getStringExtra("actionTitle");

        //generate random numbers between 0 and 10
        num1 = rd.nextInt(10);
        num2 = rd.nextInt(10);

        if (actionTitle.equals("Addition")) {
            //generate answer for question
            realAnswer = num1 + num2;

            //sets the text for the question in textview
            textQuestion.setText(num1 + " + " + num2);

            //User Mode
            userMode = "Addition";

            //starts timer
            startTimer();

        } else if (actionTitle.equals("Subtraction")) {
            //generate answer for question and sets the text for the question in textview
            if (num1 >= num2) {
                textQuestion.setText(num1 + " - " + num2);
                realAnswer = num1 - num2;
            } else {
                textQuestion.setText(num2 + " - " + num1);
                realAnswer = num2 - num1;
            }

            //User Mode
            userMode = "Subtraction";

            //starts timer
            startTimer();

        } else if (actionTitle.equals("Multiplication")) {
            //generate answer for question
            realAnswer = num1 * num2;

            //sets the text for the question in textview
            textQuestion.setText(num1 + " * " + num2);

            //User Mode
            userMode = "Multiplication";

            //starts timer
            startTimer();

        }else if (actionTitle.equals("Division")) {
            boolean reroll = true;
            while (reroll) {
                int num3 = rd.nextInt(10 - 1) + 1;
                int num4 = rd.nextInt(10 - 1) + 1;
                //generate answer for question and sets the text for the question in textview
                if (num3- num4 != 0 && num3 % num4 == 0) {
                    // If it's divisible, print the result and break the loop
                    textQuestion.setText(num3 + " / " + num4);
                    realAnswer = num3 / num4;
                    reroll = false;
                }
                else {
                    reroll = true;
                }
            }
            //User Mode
            userMode = "Division";

            //starts timer
            startTimer();

        } else {
            int operation = 0;

            operation = rd.nextInt(4);

            switch (operation) {
                case 0:
                    realAnswer = num1 + num2;
                    textQuestion.setText(num1 + " + " + num2);
                    break;
                case 1:
                    if (num1 >= num2) {
                        textQuestion.setText(num1 + " - " + num2);
                        realAnswer = num1 - num2;
                    } else {
                        textQuestion.setText(num2 + " - " + num1);
                        realAnswer = num2 - num1;
                    }
                    break;
                case 2:
                    realAnswer = num1 * num2;
                    textQuestion.setText(num1 + " * " + num2);
                    break;
                case 3:
                    boolean reroll = true;
                    while (reroll) {
                        int num3 = rd.nextInt(10 - 1) + 1;
                        int num4 = rd.nextInt(10 - 1) + 1;
                        //generate answer for question and sets the text for the question in textview
                        if (num3!=num4 && num3 % num4 == 0) {
                            // If it's divisible, print the result and break the loop
                            textQuestion.setText(num3 + " / " + num4);
                            realAnswer = num3 / num4;
                            reroll = false;
                        }
                        else {
                            reroll = true;
                        }
                    }
                    break;
            }
            //User Mode
            userMode = "All-in-one";

            //starts timer
            startTimer();
        }
    }

    private void startTimer() {
        //countdown in seconds for our 60 seconds
        timer = new CountDownTimer(time_left_in_ms, 1000) {
            @Override
            public void onTick(long l) {
                time_left_in_ms = l;
                updateText();
            }

            //if time runs out, stop the timer
            @Override
            public void onFinish() {
                timer_running = false;
                updateText();
                ok.setEnabled(false);
                next.setEnabled(false);
                textQuestion.setText(R.string.time_up);
                Intent intent = new Intent(TestEasyActivity.this, Result.class);
                startActivity(intent);
            }
        }.start();
        timer_running = true;

    }


    private void pauseTimer() {
        //cancel timer
        timer.cancel();
        timer_running = false;
    }

    private void updateText() {
        //convert the seconds into integers left
        int second = (int)(time_left_in_ms / 1000) % 60;

        //convert this value to string as two digits and show it in TextView
        String time_left = String.format(Locale.getDefault(), "%02d", second);
        TextTime.setText(time_left);
    }

}
