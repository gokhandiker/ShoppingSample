package com.melisa.vitrinova.data.model;

import com.google.gson.annotations.SerializedName;

public class Shop {

    private Integer id;
    private String name;
    private String slug;
    private String definition;
    @SerializedName("name_updateable")
    private Boolean nameUpdateable;
    @SerializedName("vacation_mode")
    private Integer vacationMode;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("shop_payment_id")
    private Integer shopPaymentId;
    @SerializedName("product_count")
    private Integer productCount;
    @SerializedName("shop_rate")
    private Integer shopRate;
    @SerializedName("comment_count")
    private Integer commentCount;
    @SerializedName("follower_count")
    private Integer followerCount;
    @SerializedName("is_editor_choice")
    private Boolean isEditorChoice;
    @SerializedName("is_following")
    private Boolean isFollowing;
    private Cover cover;
    @SerializedName("share_url")
    private String shareUrl;
    private Cover logo;


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

    public Boolean getNameUpdateable() {
        return nameUpdateable;
    }

    public void setNameUpdateable(Boolean nameUpdateable) {
        this.nameUpdateable = nameUpdateable;
    }

    public Integer getVacationMode() {
        return vacationMode;
    }

    public void setVacationMode(Integer vacationMode) {
        this.vacationMode = vacationMode;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getShopPaymentId() {
        return shopPaymentId;
    }

    public void setShopPaymentId(Integer shopPaymentId) {
        this.shopPaymentId = shopPaymentId;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getShopRate() {
        return shopRate;
    }

    public void setShopRate(Integer shopRate) {
        this.shopRate = shopRate;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }

    public Boolean getEditorChoice() {
        return isEditorChoice;
    }

    public void setEditorChoice(Boolean editorChoice) {
        isEditorChoice = editorChoice;
    }

    public Boolean getFollowing() {
        return isFollowing;
    }

    public void setFollowing(Boolean following) {
        isFollowing = following;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Cover getLogo() {
        return logo;
    }

    public void setLogo(Cover logo) {
        this.logo = logo;
    }
}