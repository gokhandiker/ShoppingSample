package com.melisa.vitrinova.data.domain;

import java.util.List;

public class EditorShopsType extends Type {

    private List<EditorShop> shops = null;

    public List<EditorShop> getShops() {
        return shops;
    }

    public void setShops(List<EditorShop> shops) {
        this.shops = shops;
    }
}