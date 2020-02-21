package com.melisa.vitrinova.model;

public class Shop {

    private Integer id;
    private String name;
    private String slug;
    private String definition;
    private Boolean nameUpdateable;
    private Integer vacationMode;
    private String createdAt;
    private Integer shopPaymentId;
    private Integer productCount;
    private Integer shopRate;
    private Integer commentCount;
    private Integer followerCount;
    private Boolean isEditorChoice;
    private Boolean isFollowing;
    private Image cover;
    private String shareUrl;
    private Object logo;


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

    public Boolean getIsEditorChoice() {
        return isEditorChoice;
    }

    public void setIsEditorChoice(Boolean isEditorChoice) {
        this.isEditorChoice = isEditorChoice;
    }

    public Boolean getIsFollowing() {
        return isFollowing;
    }

    public void setIsFollowing(Boolean isFollowing) {
        this.isFollowing = isFollowing;
    }

    public Image getCover() {
        return cover;
    }

    public void setCover(Image cover) {
        this.cover = cover;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Object getLogo() {
        return logo;
    }

    public void setLogo(Object logo) {
        this.logo = logo;
    }
}