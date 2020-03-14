package com.melisa.vitrinova.data.domain;

import java.util.List;

public class FeaturedType extends Type {

    private List<Featured> featured = null;

    public List<Featured> getFeaturedList() {
        return featured;
    }

    public void setFeatured(List<Featured> featured) {
        this.featured = featured;
    }
}
