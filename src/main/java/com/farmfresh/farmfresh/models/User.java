package com.farmfresh.farmfresh.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    public String userName;
    public String password;
    public String customerType;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
