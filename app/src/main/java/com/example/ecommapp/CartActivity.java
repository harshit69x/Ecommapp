package com.example.ecommapp;

// ✅ Correct imports
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// ✅ Use your OWN Product class (not Google Analytics one)
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    ArrayList<Product> list;
    Context context;

    public ProductAdapter(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }

    // ✅ ViewHolder class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, price;
        Button addBtn;

        public ViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.productImage);
            name = view.findViewById(R.id.productName);
            price = view.findViewById(R.id.productPrice);
            addBtn = view.findViewById(R.id.addBtn);
        }
    }

    // ✅ Create View
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    // ✅ Bind data to views
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product p = list.get(position);

        holder.name.setText(p.name);
        holder.price.setText("₹" + p.price);
        holder.image.setImageResource(p.image);

        holder.addBtn.setOnClickListener(v -> {
            Cart.items.add(p.name);
            Toast.makeText(context, p.name + " added to cart", Toast.LENGTH_SHORT).show();
        });
    }

    // ✅ Total items
    @Override
    public int getItemCount() {
        return list.size();
    }
}