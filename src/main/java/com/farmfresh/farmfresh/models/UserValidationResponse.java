package com.farmfresh.farmfresh.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserValidationResponse {

    private boolean validation;
    private String message;
    private int loginCount;
    private String address;
}
