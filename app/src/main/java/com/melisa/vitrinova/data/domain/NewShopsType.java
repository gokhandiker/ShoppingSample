package com.melisa.vitrinova.data.domain;


import java.util.List;

public class NewShopsType extends Type {

    private List<Shop> shops = null;


    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

}