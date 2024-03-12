package com.example.fakeapi.FakeCartDto;

import com.example.fakeapi.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class FakeCart {
    private Long id;
    private Long userId;
    private String date;

    private Product[] products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
