package com.example.ecommapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    TextView cartText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartText = findViewById(R.id.cartText);

        // ✅ Get data from intent
        ArrayList<String> cartItems = getIntent().getStringArrayListExtra("cartItems");

        // ✅ Display items
        if (cartItems != null && !cartItems.isEmpty()) {

            StringBuilder items = new StringBuilder();

            for (String item : cartItems) {
                items.append(item).append("\n");
            }

            cartText.setText(items.toString());

        } else {
            cartText.setText("Cart is empty");
        }
    }
}