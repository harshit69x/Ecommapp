package com.example.ecommapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences("session", MODE_PRIVATE);

        if (prefs.getBoolean("loggedIn", false)) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }

        setContentView(R.layout.activity_login);

        Button loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(v -> {
            prefs.edit().putBoolean("loggedIn", true).apply();
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        });
    }
}