package com.example.ecommapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<String> cart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button b1 = findViewById(R.id.addItem1);
        Button b2 = findViewById(R.id.addItem2);
        Button b3 = findViewById(R.id.addItem3);
        Button b4 = findViewById(R.id.addItem4);
        Button b5 = findViewById(R.id.addItem5);
        Button b6 = findViewById(R.id.addItem6);
        Button cartBtn = findViewById(R.id.cartBtn);

        View.OnClickListener listener = v -> {

            if (v.getId() == R.id.addItem1) {
                cart.add("Shoes");
                Toast.makeText(this, "Shoes added", Toast.LENGTH_SHORT).show();
            }

            else if (v.getId() == R.id.addItem2) {
                cart.add("Watch");
                Toast.makeText(this, "Watch added", Toast.LENGTH_SHORT).show();
            }

            else if (v.getId() == R.id.addItem3) {
                cart.add("T-Shirt");
                Toast.makeText(this, "T-Shirt added", Toast.LENGTH_SHORT).show();
            }

            else if (v.getId() == R.id.addItem4) {
                cart.add("Headphones");
                Toast.makeText(this, "Headphones added", Toast.LENGTH_SHORT).show();
            }

            else if (v.getId() == R.id.addItem5) {
                cart.add("Backpack");
                Toast.makeText(this, "Backpack added", Toast.LENGTH_SHORT).show();
            }

            else if (v.getId() == R.id.addItem6) {
                cart.add("Sunglasses");
                Toast.makeText(this, "Sunglasses added", Toast.LENGTH_SHORT).show();
            }
        };

        b1.setOnClickListener(listener);
        b2.setOnClickListener(listener);
        b3.setOnClickListener(listener);
        b4.setOnClickListener(listener);
        b5.setOnClickListener(listener);
        b6.setOnClickListener(listener);

        cartBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CartActivity.class);
            intent.putStringArrayListExtra("cartItems", cart);
            startActivity(intent);
        });
    }
}