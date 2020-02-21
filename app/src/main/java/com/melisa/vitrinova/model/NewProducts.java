package com.melisa.vitrinova.model;

import java.util.List;

public class NewProducts {
    private String type;
    private String title;
    private List<Object> products = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Object> getProducts() {
        return products;
    }

    public void setProducts(List<Object> products) {
        this.products = products;
    }
}
