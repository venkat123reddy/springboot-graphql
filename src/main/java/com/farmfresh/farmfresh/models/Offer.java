package com.farmfresh.farmfresh.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Offer {
    @Id
    private String productId;
    private int offerPercent;
}
