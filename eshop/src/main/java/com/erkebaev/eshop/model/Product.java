package com.erkebaev.eshop.model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String title;
    private String description;
    private int price;
    private String city;
    private String author;

    public Product(Long id, String title, String description, int price, String city, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.city = city;
        this.author = author;
    }

    public Product() {
    }
}
