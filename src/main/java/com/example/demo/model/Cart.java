package com.example.demo.model;

import lombok.Data;

@Data
public class Cart {
    private Product product;

    private int productCount;

    public Cart(Product product, int productCount) {
        this.product = product;
        this.productCount = productCount;
    }
}
