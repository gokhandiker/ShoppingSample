package com.melisa.vitrinova.model;

import java.util.List;

public class Products {
    private Integer id;
    private Object code;
    private String title;
    private String slug;
    private String definition;
    private Integer oldPrice;
    private Integer price;
    private Integer stock;
    private Object maxInstallment;
    private Integer commissionRate;
    private Integer cargoTime;
    private Boolean isCargoFree;
    private Boolean isNew;
    private Object rejectReason;
    private Integer categoryId;
    private String difference;
    private Boolean isEditorChoice;
    private Integer commentCount;
    private Boolean isOwner;
    private Boolean isApproved;
    private Boolean isActive;
    private String shareUrl;
    private Boolean isLiked;
    private Integer likeCount;
    private Shop shop;
    private Category category;
    private List<Image> images = null;

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

    public Boolean getIsCargoFree() {
        return isCargoFree;
    }

    public void setIsCargoFree(Boolean isCargoFree) {
        this.isCargoFree = isCargoFree;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
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

    public Boolean getIsEditorChoice() {
        return isEditorChoice;
    }

    public void setIsEditorChoice(Boolean isEditorChoice) {
        this.isEditorChoice = isEditorChoice;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Boolean getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Boolean isOwner) {
        this.isOwner = isOwner;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Boolean getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(Boolean isLiked) {
        this.isLiked = isLiked;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
