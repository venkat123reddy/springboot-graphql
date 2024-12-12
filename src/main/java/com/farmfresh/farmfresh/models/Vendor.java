package com.farmfresh.farmfresh.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Vendor {


    private String vendorId;
    private String vendorName;
    private String vendorAddress;
    private List<String> productIds;
    @Id
    private String vendorEmail;
    private String vendorPhoneNumber;

}
