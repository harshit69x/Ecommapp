package com.example.ecommapp;

public class CartItem {
    public Product product;
    public int quantity;

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
    }
}