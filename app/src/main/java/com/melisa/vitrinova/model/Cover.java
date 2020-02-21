package com.melisa.vitrinova.model;

public class Cover extends Image {
    private MediumImage medium;
    private ThumbnailImage thumbnail;

    public MediumImage getMedium() {
        return medium;
    }

    public void setMedium(MediumImage medium) {
        this.medium = medium;
    }

    public ThumbnailImage getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ThumbnailImage thumbnail) {
        this.thumbnail = thumbnail;
    }
}
