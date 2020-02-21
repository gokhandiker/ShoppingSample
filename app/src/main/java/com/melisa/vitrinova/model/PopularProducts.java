package com.melisa.vitrinova.model;

import com.google.gson.annotations.SerializedName;

public class PopularProducts extends Product {

    @SerializedName("view_count")
    private int viewCount;

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
