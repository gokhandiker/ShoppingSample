package com.melisa.vitrinova.data.domain;



import java.util.List;

public class CategoryBig extends Category {
    private Cover logo;
    private Cover cover;
    private List<CategoryBig> children = null;

    public Cover getLogo() {
        return logo;
    }

    public void setLogo(Cover logo) {
        this.logo = logo;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public List<CategoryBig> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryBig> children) {
        this.children = children;
    }
}
