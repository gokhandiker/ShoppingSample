package com.melisa.vitrinova.data.model;

import androidx.annotation.Nullable;

public class Cover extends Image {
    @Nullable
    private MediumImage medium;
    @Nullable
    private ThumbnailImage thumbnail;

    @Nullable
    public MediumImage getMedium() {
        return medium;
    }

    public void setMedium(MediumImage medium) {
        this.medium = medium;
    }

    @Nullable
    public ThumbnailImage getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ThumbnailImage thumbnail) {
        this.thumbnail = thumbnail;
    }
}
