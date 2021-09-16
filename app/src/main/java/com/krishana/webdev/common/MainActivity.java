package com.krishana.webdev.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.krishana.webdev.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

    }
    public void callLogin(View view){
    Intent intent = new Intent(this, Login_Activity.class);
    startActivity(intent);
    }
    public void callSignin(View view){
        Intent intent = new Intent(this,Signup.class);
        startActivity(intent);
    }

}