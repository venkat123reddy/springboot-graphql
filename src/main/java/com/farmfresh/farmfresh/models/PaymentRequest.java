package com.farmfresh.farmfresh.models;

import lombok.Data;

@Data
public class PaymentRequest {
   private String  paymentId;
    private int totalCost;
    private String paymentStatus;
    PaymentCard paymentCard;
}
