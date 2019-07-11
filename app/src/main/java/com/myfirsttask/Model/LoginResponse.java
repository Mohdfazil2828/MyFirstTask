package com.myfirsttask.Model;

public class LoginResponse {

    private int success;
    private String message;
    private Record api_code;

    public LoginResponse() {
    }

    public int getSuccess() {
        return success;
    }

    
    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Record getApi_code() {
        return api_code;
    }

    public void setApi_code(Record api_code) {
        this.api_code = api_code;
    }
}

