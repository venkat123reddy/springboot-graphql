package com.farmfresh.farmfresh.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileResponse {
    private int status;
    private String message;
}
