package com.farmfresh.farmfresh.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Product {

    private String userId;
    private String productName;
    private String productType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getProductExpiryDate() {
        return productExpiryDate;
    }

    public void setProductExpiryDate(Date productExpiryDate) {
        this.productExpiryDate = productExpiryDate;
    }

    private int productCost;
    private int productQuantity;
    private Date productExpiryDate;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getProductCost() {
        return productCost;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
