package com.example.belajar_android_sturio;

public class CheckoutItem {
    private long id;
    private String name;
    private double price;
    private int quantity;

    public CheckoutItem(long id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}