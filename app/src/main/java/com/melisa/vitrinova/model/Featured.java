package com.melisa.vitrinova.model;

import java.util.List;

public class Featured {
    private Integer id;
    private String type;
    private List<Image> cover;
    private String title;
    private String subTitle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Image> getCover() {
        return cover;
    }

    public void setCover(List<Image> cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
