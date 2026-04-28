package com.example.ecommapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    ArrayList<Product> list;
    Context context;

    public ProductAdapter(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }

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

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product p = list.get(position);

        holder.name.setText(p.name);
        holder.price.setText("₹" + p.price);
        holder.image.setImageResource(p.image);

        holder.addBtn.setOnClickListener(v -> {
            Cart.items.add(p.name);
            Toast.makeText(context, p.name + " added", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}