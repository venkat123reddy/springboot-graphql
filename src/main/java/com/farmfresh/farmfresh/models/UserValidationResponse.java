package com.farmfresh.farmfresh.models;

public class UserValidationResponse {

    private boolean validation;
    private String message;

    public UserValidationResponse(boolean validation, String message) {
        this.validation = validation;
        this.message = message;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
