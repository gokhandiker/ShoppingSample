package com.melisa.vitrinova.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EditorShop extends Shop {

    @SerializedName("popular_products")
    private List<PopularProducts> popularProducts = null;


    public List<PopularProducts> getPopularProducts() {
        return popularProducts;
    }

    public void setPopularProducts(List<PopularProducts> popularProducts) {
        this.popularProducts = popularProducts;
    }
}
