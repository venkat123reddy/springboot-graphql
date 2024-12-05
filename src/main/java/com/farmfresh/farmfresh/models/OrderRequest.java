package com.farmfresh.farmfresh.models;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private String orderId;
    private String paymentId;
    private String customerId;
    private List<String> productIds;
    private String deliveryType;
    private Payment paymentRequest;


}
