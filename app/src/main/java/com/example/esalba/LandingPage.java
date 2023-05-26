package com.example.esalba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingPage extends AppCompatActivity {
    Button signupBtn, loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        getSupportActionBar().hide();

        signupBtn = findViewById(R.id.signupBtn);
        loginBtn = findViewById(R.id.loginBtn);

        signupBtn.setOnClickListener(view -> {
            Intent intent = new Intent(LandingPage.this, Signup.class);
            startActivity(intent);
        });

        loginBtn.setOnClickListener(view -> {
            Intent intent = new Intent(LandingPage.this, Login.class);
            startActivity(intent);
        });
    }
}