package com.melisa.vitrinova.model;

import java.util.List;

public class BigCategory {

    private Integer id;
    private String name;
    private Object parentId;
    private Integer order;
    private Object parentCategory;
    private Image logo;
    private Image cover;
    private List<BigCategory> children = null;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Object getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Object parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public Image getCover() {
        return cover;
    }

    public void setCover(Image cover) {
        this.cover = cover;
    }

    public List<BigCategory> getChildren() {
        return children;
    }

    public void setChildren(List<BigCategory> children) {
        this.children = children;
    }


}