package com.melisa.vitrinova.data;


import com.melisa.vitrinova.data.model.CategoryBig;
import com.melisa.vitrinova.data.model.Collection;
import com.melisa.vitrinova.data.model.EditorShop;
import com.melisa.vitrinova.data.model.Featured;
import com.melisa.vitrinova.data.model.NewProducts;
import com.melisa.vitrinova.data.model.Shop;

import java.util.List;

public class GeneralObject {
    private String type;
    private String title;
    private List<Featured> featured = null;
    private List<NewProducts> products;
    private List<CategoryBig> categories;
    private List<Collection> collections = null;
    private List<EditorShop> editorShops = null;
    private List<Shop> newShops = null;

    public List<EditorShop> getEditorShops() {
        return editorShops;
    }

    public void setEditorShops(List<EditorShop> editorShops) {
        this.editorShops = editorShops;
    }

    public List<Shop> getNewShops() {
        return newShops;
    }

    public void setNewShops(List<Shop> newShops) {
        this.newShops = newShops;
    }

    public List<Collection> getCollections() {
        return collections;
    }

    public void setCollections(List<Collection> collections) {
        this.collections = collections;
    }

    public List<CategoryBig> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryBig> categories) {
        this.categories = categories;
    }


    public List<NewProducts> getProducts() {
        return products;
    }

    public void setProducts(List<NewProducts> products) {
        this.products = products;
    }


    public List<Featured> getFeaturedList() {
        return featured;
    }

    public void setFeatured(List<Featured> featured) {
        this.featured = featured;
    }


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
}
