package com.example.newwebjsf.shootbean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
@Named
@SessionScoped
public class RBean implements Serializable {
    private float r = 1;
    public RBean(){}
    public float getR() {
        return r;
    }
    public void setR(float r) {
        this.r = r;
    }

    public void doR_1(){
        r = 1;
    }
    public void doR_1_5(){
        r = 1.5f;
    }
    public void doR_2(){
        r = 2;
    }
    public void doR_2_5(){
        r = 2.5f;
    }
    public void doR_3(){
        r = 3;
    }
}
