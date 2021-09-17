package com.krishana.webdev.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.krishana.webdev.R;

public class QuizApp extends AppCompatActivity {
    public static final String EXTRA_NAME ="com.example.screen2-YASH";
    public TextView points,question,countdownText,optionA,optionB,optionC,optionD;
    public Button buttonA,buttonB, buttonC, buttonD,skip;
    public int questionNo=0,playerPoints=0;
    public CountDownTimer countDownTimer;
    public long timeLeftInMilliSeconds = 300000;
    String questionList[] ={"1.what is java?","2.Who created Java?","3.Idependence Day?","4.President?"};
    String answers[]={"A","B","C","D"};
    String optionListA[]={"hii","y","k","asd"};
    String optionListB[]={"nv","dsa","ds","da"};
    String optionListC[]={"li","da","tret","f"};
    String optionListD[]={"ojoh","ret","fv","htr"};






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);
        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);
        skip = findViewById(R.id.skip);
        points = findViewById(R.id.points);
        question =findViewById(R.id.question);
        countdownText = findViewById(R.id.countDownText);
        question.setText(questionList[questionNo]);
        points.setText("Points : "+ playerPoints);
        optionA.setText(optionListA[questionNo]);
        optionB.setText(optionListB[questionNo]);
        optionC.setText(optionListC[questionNo]);
        optionD.setText(optionListD[questionNo]);

        countDownTimer = new CountDownTimer(timeLeftInMilliSeconds,1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliSeconds =l;
                updateTimer();

            }

            @Override
            public void onFinish() {


                if(questionNo<questionList.length){
                    questionNo++;
                    if(questionNo<questionList.length){
                        Toast.makeText(QuizApp.this, "Time's Up!", Toast.LENGTH_SHORT).show();
                        question.setText(questionList[questionNo]);
                        countDownTimer.cancel();
                        countDownTimer.start();
                    }
                    else{
                        end();
                    }
                }
                else{
                    countDownTimer.cancel();
                    end();
                }


            }
        }.start();


        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                if(questionNo<questionList.length){
                    if(answers[questionNo]=="A"){
                        playerPoints ++;
                        points.setText("Points : "+ playerPoints);
                        Toast.makeText(QuizApp.this, "correct!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(QuizApp.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    }
                    questionNo++;
                    if(questionNo<questionList.length){
                        countDownTimer.start();
                        question.setText(questionList[questionNo]);
                        updateOptions();
                    }
                    else{
                        end();
                    }
                }
                else{
                    end();
                }

            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                if(questionNo<questionList.length){
                    if(answers[questionNo]=="B"){
                        playerPoints ++;
                        points.setText("Points : "+ playerPoints);
                        Toast.makeText(QuizApp.this, "correct!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(QuizApp.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    }
                    questionNo++;
                    if(questionNo<questionList.length){
                        countDownTimer.start();
                        question.setText(questionList[questionNo]);
                        updateOptions();
                    }
                    else{
                        end();
                    }
                }
                else{
                    end();
                }

            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                if(questionNo<questionList.length){
                    if(answers[questionNo]=="C"){
                        playerPoints ++;
                        points.setText("Points : "+ playerPoints);
                        Toast.makeText(QuizApp.this, "correct!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(QuizApp.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    }
                    questionNo++;
                    if(questionNo<questionList.length){
                        countDownTimer.start();
                        question.setText(questionList[questionNo]);
                        updateOptions();
                    }
                    else{
                        end();
                    }
                }
                else{
                    end();
                }

            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                if(questionNo<questionList.length){
                    if(answers[questionNo]=="D"){
                        playerPoints ++;
                        points.setText("Points : "+ playerPoints);
                        Toast.makeText(QuizApp.this, "correct!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(QuizApp.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    }
                    questionNo++;
                    if(questionNo<questionList.length){
                        countDownTimer.start();
                        question.setText(questionList[questionNo]);
                        updateOptions();
                    }
                    else{
                        end();
                    }
                }
                else{
                    end();
                }

            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                Toast.makeText(QuizApp.this, "You skipped the question!", Toast.LENGTH_SHORT).show();

                if(questionNo<questionList.length){
                    questionNo++;
                    if(questionNo<questionList.length){
                        countDownTimer.start();
                        question.setText(questionList[questionNo]);
                        updateOptions();
                    }
                    else{
                        end();
                    }
                }
                else{
                    end();
                }

            }
        });






    }
    public void end(){
        countDownTimer.cancel();

        Intent intent = new Intent(this,QuizApp_Activiity2.class);
        String pointsString = Integer.toString(playerPoints);


        intent.putExtra(EXTRA_NAME,pointsString);
        startActivity(intent);
    }

    public void updateTimer(){
        int minutes = (int) timeLeftInMilliSeconds/60000;
        int seconds = (int) timeLeftInMilliSeconds%60000/1000;

        String timeLeftText;

        timeLeftText = ""+minutes;
        timeLeftText +=":";
        if (seconds<10) timeLeftText += "0";
        timeLeftText += ""+seconds;

        countdownText.setText(timeLeftText);
    }

    public void updateOptions(){
        optionA.setText(optionListA[questionNo]);
        optionB.setText(optionListB[questionNo]);
        optionC.setText(optionListC[questionNo]);
        optionD.setText(optionListD[questionNo]);

    }






}
