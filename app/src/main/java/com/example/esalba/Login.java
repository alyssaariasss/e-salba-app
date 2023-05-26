package com.example.esalba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Login extends AppCompatActivity {
    ImageView loginBack;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        loginBack = findViewById(R.id.loginBack);
        loginBtn = findViewById(R.id.loginBtn);

        loginBack.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, LandingPage.class);
            startActivity(intent);
        });

        loginBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, Home.class);
            startActivity(intent);
        });
    }
}