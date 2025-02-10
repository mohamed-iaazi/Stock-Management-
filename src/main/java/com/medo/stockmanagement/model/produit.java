package com.medo.stockmanagement.model;

public class produit {
    int id;
    String name;
    String description;
    int quantity;
    int price;
    String category;


    public produit(int id, String name, String description, int quantity, int price, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    public produit() {
    }
}
