package com.example.newwebjsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@RequestScoped
public class TestBean implements Serializable {
    private String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public void newMessage(String message){
//        setMessage(message);
//    }
}
