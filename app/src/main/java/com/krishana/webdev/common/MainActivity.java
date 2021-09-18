package com.krishana.webdev.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.krishana.webdev.R;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!= null){
            startActivity(new Intent(MainActivity.this,activity_bottomnavigation.class));
        }

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