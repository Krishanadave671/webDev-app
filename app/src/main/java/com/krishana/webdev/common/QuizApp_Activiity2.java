package com.krishana.webdev.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.krishana.webdev.R;

public class QuizApp_Activiity2 extends AppCompatActivity {
    private TextView finalScore;
    private Button twitter,facebook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_2);
        finalScore = findViewById(R.id.finalScore);
        twitter = findViewById(R.id.twitter);
        facebook = findViewById(R.id.facebook);

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/?lang=en-in"));
                startActivity(browserIntent);
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                startActivity(browserIntent);
            }
        });

        Intent intent = getIntent();
        String s = intent.getStringExtra(QuizApp.EXTRA_NAME);
        finalScore.setText("Your score is :"+ s);

    }

}
