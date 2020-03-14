package com.melisa.vitrinova.data.domain;

import com.google.gson.annotations.SerializedName;

public class Collection {

    private Integer id;
    private String title;
    private String definition;
    private String start;
    private Object end;
    @SerializedName("share_url")
    private String shareUrl;
    private Cover cover;
    private Cover logo;

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

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public Cover getLogo() {
        return logo;
    }

    public void setLogo(Cover logo) {
        this.logo = logo;
    }
}