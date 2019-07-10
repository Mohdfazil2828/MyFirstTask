package com.myfirsttask.Model;

public class LoginResponse {

    private int success;
    private String message;
    private User user;

    public LoginResponse(int success, String message, User user) {
        this.success = success;
        this.message = message;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
