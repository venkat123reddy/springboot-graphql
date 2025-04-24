package com.farmfresh.farmfresh.models;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Netflix {
    public String type;
    public String title;
    public String id;
    public int releaseYear;
}
