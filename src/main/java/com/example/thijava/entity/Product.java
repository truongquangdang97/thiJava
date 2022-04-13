package com.example.thijava.entity;

public class Product {
    private int id;
    public String name;
    public int price;
    public int amount;
    public String details;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", details='" + details + '\'' +
                '}';
    }

    public Product() {
    }

    public Product(int id, String name, int price, int amount, String details) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
