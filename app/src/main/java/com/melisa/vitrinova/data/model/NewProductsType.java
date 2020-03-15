package com.melisa.vitrinova.data.model;

import java.util.List;

public class NewProductsType extends Type {

    private List<NewProducts> products;


    public List<NewProducts> getProducts() {
        return products;
    }

    public void setProducts(List<NewProducts> products) {
        this.products = products;
    }
}
