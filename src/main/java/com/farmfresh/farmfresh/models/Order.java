package com.farmfresh.farmfresh.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Order {
    @Id
    private String orderId;
    private String paymentId;
    private List<String> productIds;
    private String deliveryType;
    private String userId;
    private String orderStatus;
    private String orderCreatedDate;
    private String orderName;
    private List<ProductBill> productBillList;
}
