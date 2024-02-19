package com.example.newwebjsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
@Named
@SessionScoped
public class FirstBean implements Serializable {
    private String message = "Hello world, friend!";
    public FirstBean(){}
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
