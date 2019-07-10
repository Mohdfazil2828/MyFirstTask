package com.myfirsttask.Model;

public class User {

    private int id, mobile;
    private String email, name;

    public User(int id, String email, String name, int mobile) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public int getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
