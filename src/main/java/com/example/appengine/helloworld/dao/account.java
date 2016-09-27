package com.example.appengine.helloworld.dao;

public class account {

    public String name;
    public String pass;
    public String role;

    public void Account() {

    }

    public void Account(String username, String password, String role) {
        this.name = username;
        this.pass = password;
        this.role = role;
    }
}
