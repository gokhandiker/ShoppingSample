package com.melisa.vitrinova.model;

public class Image {
    private Integer width;
    private Integer height;
    private String url;
    private ImageSize medium;
    private ImageSize thumbnail;

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageSize getMedium() {
        return medium;
    }

    public void setMedium(ImageSize medium) {
        this.medium = medium;
    }

    public ImageSize getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ImageSize thumbnail) {
        this.thumbnail = thumbnail;
    }

}
