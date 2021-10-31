package com.example.WildBeries4.Domain.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostPojo {
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @SerializedName("barcode")
    @Expose
    private String barcode;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @SerializedName("brand")
    @Expose
    private String brand;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDaysOnSite() {
        return daysOnSite;
    }

    public void setDaysOnSite(String daysOnSite) {
        this.daysOnSite = daysOnSite;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("daysOnSite")
    @Expose
    private String daysOnSite;
    @SerializedName("Discount")
    @Expose
    private String discount;

    public String getInWayFromClient() {
        return inWayFromClient;
    }

    public void setInWayFromClient(String inWayFromClient) {
        this.inWayFromClient = inWayFromClient;
    }

    @SerializedName("inWayFromClient")
    @Expose
    private String inWayFromClient;

    public String getInWayToClient() {
        return inWayToClient;
    }

    public void setInWayToClient(String inWayToClient) {
        this.inWayToClient = inWayToClient;
    }

    @SerializedName("inWayToClient")
    @Expose
    private String inWayToClient;

    public String getIsRealization() {
        return isRealization;
    }

    public void setIsRealization(String isRealization) {
        this.isRealization = isRealization;
    }

    @SerializedName("isRealization")
    @Expose
    private String isRealization;

    public String getIsSupply() {
        return isSupply;
    }

    public void setIsSupply(String isSupply) {
        this.isSupply = isSupply;
    }

    @SerializedName("isSupply")
    @Expose
    private String isSupply;

    public String getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(String lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    @SerializedName("lastChangeDate")
    @Expose
    private String lastChangeDate;

    public String getNmId() {
        return nmId;
    }

    public void setNmId(String nmId) {
        this.nmId = nmId;
    }

    @SerializedName("nmId")
    @Expose
    private String nmId;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @SerializedName("Price")
    @Expose
    private String price;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @SerializedName("quantity")
    @Expose
    private String quantity;

    public String getQuantityFull() {
        return quantityFull;
    }

    public void setQuantityFull(String quantityFull) {
        this.quantityFull = quantityFull;
    }

    @SerializedName("quantityFull")
    @Expose
    private String quantityFull;

    public String getQuantityNotInOrders() {
        return quantityNotInOrders;
    }

    public void setQuantityNotInOrders(String quantityNotInOrders) {
        this.quantityNotInOrders = quantityNotInOrders;
    }

    @SerializedName("quantityNotInOrders")
    @Expose
    private String quantityNotInOrders;

    public String getScCode() {
        return scCode;
    }

    public void setScCode(String scCode) {
        this.scCode = scCode;
    }

    @SerializedName("SCCode")
    @Expose
    private String scCode;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @SerializedName("subject")
    @Expose
    private String subject;

    public String getSupplierArticle() {
        return supplierArticle;
    }

    public void setSupplierArticle(String supplierArticle) {
        this.supplierArticle = supplierArticle;
    }

    @SerializedName("supplierArticle")
    @Expose
    private String supplierArticle;

    public String getTechSize() {
        return techSize;
    }

    public void setTechSize(String techSize) {
        this.techSize = techSize;
    }

    @SerializedName("techSize")
    @Expose
    private String techSize;

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    @SerializedName("warehouseName")
    @Expose
    private String warehouseName;

}
