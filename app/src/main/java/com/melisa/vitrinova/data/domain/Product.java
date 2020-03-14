package com.melisa.vitrinova.data.domain;

import com.google.gson.annotations.SerializedName;


import java.util.List;

public class Product {
    private Integer id;
    private Object code;
    private String title;
    private String slug;
    private String definition;
    @SerializedName("old_price")
    private Integer oldPrice;
    private Integer price;
    private Integer stock;
    @SerializedName("max_installment")
    private Object maxInstallment;
    @SerializedName("commission_rate")
    private Integer commissionRate;
    @SerializedName("cargo_time")
    private Integer cargoTime;
    @SerializedName("is_cargo_free")
    private Boolean isCargoFree;
    @SerializedName("is_new")
    private Boolean isNew;
    @SerializedName("reject_reason")
    private Object rejectReason;
    @SerializedName("category_id")
    private Integer categoryId;
    private String difference;
    @SerializedName("is_editor_choice")
    private Boolean isEditorChoice;
    @SerializedName("comment_count")
    private Integer commentCount;
    @SerializedName("is_owner")
    private Boolean isOwner;
    @SerializedName("is_approved")
    private Boolean isApproved;
    @SerializedName("is_active")
    private Boolean isActive;
    @SerializedName("share_url")
    private String shareUrl;
    @SerializedName("is_liked")
    private Boolean isLiked;
    @SerializedName("like_count")
    private Integer likeCount;
    private Category category;
    private List<Cover> images = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Integer getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Integer oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Object getMaxInstallment() {
        return maxInstallment;
    }

    public void setMaxInstallment(Object maxInstallment) {
        this.maxInstallment = maxInstallment;
    }

    public Integer getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Integer commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Integer getCargoTime() {
        return cargoTime;
    }

    public void setCargoTime(Integer cargoTime) {
        this.cargoTime = cargoTime;
    }

    public Boolean getCargoFree() {
        return isCargoFree;
    }

    public void setCargoFree(Boolean cargoFree) {
        isCargoFree = cargoFree;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Object getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(Object rejectReason) {
        this.rejectReason = rejectReason;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDifference() {
        return difference;
    }

    public void setDifference(String difference) {
        this.difference = difference;
    }

    public Boolean getEditorChoice() {
        return isEditorChoice;
    }

    public void setEditorChoice(Boolean editorChoice) {
        isEditorChoice = editorChoice;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Boolean getOwner() {
        return isOwner;
    }

    public void setOwner(Boolean owner) {
        isOwner = owner;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Boolean getLiked() {
        return isLiked;
    }

    public void setLiked(Boolean liked) {
        isLiked = liked;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Cover> getImages() {
        return images;
    }

    public void setImages(List<Cover> images) {
        this.images = images;
    }
}
