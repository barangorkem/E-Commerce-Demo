package com.example.demo.model;

import lombok.Data;

@Data
public class Product {

    private int Id;

    private String Title;

    private Double Price;

    private String ImageUrl;

    public Product(int id, String title, Double price, String imageUrl) {
        this.Id = id;
        this.Title = title;
        this.Price = price;
        this.ImageUrl = imageUrl;
    }
}
