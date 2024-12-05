package com.farmfresh.farmfresh.models;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Document
public class Product {

    private String userId;
    private String productName;
    private String productType;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setProductExpiryDate(Date productExpiryDate) {
        this.productExpiryDate = productExpiryDate;
    }

    private int productCost;
    private int productQuantity;
    private Date productExpiryDate;

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
