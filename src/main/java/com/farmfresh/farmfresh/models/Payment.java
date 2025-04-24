package com.farmfresh.farmfresh.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Payment {
    @Id
    private String paymentId;
    private int totalCost;
    private String paymentStatus;
    private PaymentCard paymentCard;
}
