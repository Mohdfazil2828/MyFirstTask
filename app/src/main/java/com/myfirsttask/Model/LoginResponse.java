package com.myfirsttask.Model;

public class LoginResponse {

    private int success;
    private String message;
    private Record record;

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

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}

