package com.farmfresh.farmfresh.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Customer {
    private String customerName;
    @Id
    private String customerId;
    private String customerEmail;
    private String address;
    private String phoneNumber;
}
