package com.example.esalba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Signup extends AppCompatActivity {
    ImageView signupBack;
    Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

        signupBack = findViewById(R.id.signupBack);
        signupBtn = findViewById(R.id.signupBtn);

        signupBack.setOnClickListener(view -> {
            Intent intent = new Intent(Signup.this, LandingPage.class);
            startActivity(intent);
        });

        signupBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Signup.this, Home.class);
            startActivity(intent);
        });
    }
}