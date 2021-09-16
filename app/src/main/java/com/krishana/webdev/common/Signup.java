package com.krishana.webdev.common;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.krishana.webdev.R;

public class Signup extends AppCompatActivity {
    ImageView back_btn;
    Button Register, login;
    TextView titletext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        back_btn = findViewById(R.id.sign_up_back);
        login = findViewById(R.id.login_btn);

    }
}
