package com.xeylyne.uasinta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EstimationRequest {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("item_country")
    @Expose
    private String itemCountry;
    @SerializedName("item_image")
    @Expose
    private String itemImage;
    @SerializedName("item_link")
    @Expose
    private String itemLink;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("item_price")
    @Expose
    private String itemPrice;
    @SerializedName("item_rating")
    @Expose
    private Double itemRating;
    @SerializedName("item_shipping")
    @Expose
    private Double itemShipping;
    @SerializedName("item_website")
    @Expose
    private String itemWebsite;
    @SerializedName("new_item_price")
    @Expose
    private Double newItemPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemCountry() {
        return itemCountry;
    }

    public void setItemCountry(String itemCountry) {
        this.itemCountry = itemCountry;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemLink() {
        return itemLink;
    }

    public void setItemLink(String itemLink) {
        this.itemLink = itemLink;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Double getItemRating() {
        return itemRating;
    }

    public void setItemRating(Double itemRating) {
        this.itemRating = itemRating;
    }

    public Double getItemShipping() {
        return itemShipping;
    }

    public void setItemShipping(Double itemShipping) {
        this.itemShipping = itemShipping;
    }

    public String getItemWebsite() {
        return itemWebsite;
    }

    public void setItemWebsite(String itemWebsite) {
        this.itemWebsite = itemWebsite;
    }

    public Double getNewItemPrice() {
        return newItemPrice;
    }

    public void setNewItemPrice(Double newItemPrice) {
        this.newItemPrice = newItemPrice;
    }
}
