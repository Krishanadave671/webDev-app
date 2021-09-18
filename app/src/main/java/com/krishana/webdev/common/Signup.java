package com.krishana.webdev.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.krishana.webdev.R;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {
    ImageView back_btn;
    FirebaseFirestore fstore;
    TextInputLayout fullname , username ,password ,email;
    Button Register,Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        back_btn = findViewById(R.id.sign_up_back);
        email = findViewById(R.id.Email);
        fullname = findViewById(R.id.fullname);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Register = findViewById(R.id.btn_Register);
        Login = findViewById(R.id.btn_login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this,activity_bottomnavigation.class);
                startActivity(intent);
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Validatefullname() | !ValidateUsername() | !validateEmail() | !validatePassword()) {
                    return;
                }
                String  Fullname= fullname.getEditText().toString().trim();
                String  Username = username.getEditText().getText().toString().trim();
                String Email = email.getEditText().getText().toString().trim();


                DocumentReference documentReference = fstore.collection("Users").document();
                Map<String,Object> user = new HashMap<>();
                user.put("full name", Fullname);
                user.put("email", Email);
                user.put("Username", Username);
                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Signup.this, "Succesfully registered", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Signup.this, "register failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });










    }

    private boolean validatePassword() {
        String Password = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (Password.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        } else if (!Password.matches(checkPassword)) {
            password.setError("Password should contain 4 characters!");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
    private boolean Validatefullname(){
        String  Fullname= fullname.getEditText().toString().trim();
        if(Fullname.isEmpty()){
            fullname.setError("Field cannot be empty");
            return false;
        }
        else{
            fullname.setError(null);
            fullname.setErrorEnabled(false);
            return true;
        }
    }
    private boolean ValidateUsername(){
        String  Username = username.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";
        if(Username.isEmpty()){
            username.setError("Field cannot be empty");
            return false;
        }
        else if (Username.length() > 20) {
            username.setError("Username is too large!");
            return false;
        } else if (!Username.matches(checkspaces)) {
            username.setError("No White spaces are allowed!");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateEmail() {
        String Email = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (Email.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        } else if (!Email.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

}
