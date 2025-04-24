package com.farmfresh.farmfresh.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ProdRefData {
    private String name;
    private String type;
}
