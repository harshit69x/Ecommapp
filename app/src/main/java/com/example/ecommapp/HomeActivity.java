package com.example.ecommapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter adapter;
    ArrayList<Product> productList;

    Button cartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.productRecyclerView);
        cartBtn = findViewById(R.id.cartBtn);

        // Grid layout (2 columns)
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Sample products
        productList = new ArrayList<>();
        productList.add(new Product("Shoes", 999, R.drawable.shoes));
        productList.add(new Product("Watch", 1499, R.drawable.watch));
        productList.add(new Product("Sunglasses", 19999, R.drawable.sunglasses));
        productList.add(new Product("Headphones", 799, R.drawable.headphones));
        productList.add(new Product("Bag", 799, R.drawable.bag));
        productList.add(new Product("Tshirt", 799, R.drawable.tshirt));

        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        // Open CartActivity
        cartBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
}