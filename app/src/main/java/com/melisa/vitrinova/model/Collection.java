package com.melisa.vitrinova.model;

public class Collection {

    private Integer id;
    private String title;
    private String definition;
    private String start;
    private Object end;
    private String shareUrl;
    private Image cover;
    private Image logo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Object getEnd() {
        return end;
    }

    public void setEnd(Object end) {
        this.end = end;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Image getCover() {
        return cover;
    }

    public void setCover(Image cover) {
        this.cover = cover;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

}