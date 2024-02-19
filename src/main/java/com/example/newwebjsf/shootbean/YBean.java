package com.example.newwebjsf.shootbean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
@Named
@SessionScoped
public class YBean implements Serializable {
    private float y = 0;
    public YBean(){}

    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
}
