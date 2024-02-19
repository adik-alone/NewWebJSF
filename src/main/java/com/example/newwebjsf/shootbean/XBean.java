package com.example.newwebjsf.shootbean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
@Named
@SessionScoped
public class XBean implements Serializable {
    private int x = 0;
    public XBean(){}
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void doXn4(){
        x = -4;
    }
    public void doXn3(){
        x = -3;
    }
    public void doXn2(){
        x = -2;
    }
    public void doXn1(){
        x = -1;
    }
    public void doX0(){
        x = 0;
    }
    public void doXp1(){
        x = 1;
    }
    public void doXp2(){
        x = 2;
    }
    public void doXp3(){
        x = 3;
    }
    public void doXp4(){
        x = 4;
    }
}
