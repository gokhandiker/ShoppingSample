package com.melisa.vitrinova.model;

import java.util.List;

public class CategoriesType extends Type {


    private List<CategoryBig> categories;

    public List<CategoryBig> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryBig> categories) {
        this.categories = categories;
    }
}