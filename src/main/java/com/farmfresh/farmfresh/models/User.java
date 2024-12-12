package com.farmfresh.farmfresh.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class User {
    public String userName;
    public String password;
    public String customerType;
}
