package com.farmfresh.farmfresh.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String type;
    private Integer quantity;
    private String name;
    private int Cost;
    private Date expiryDate;
    private String userId;
}
