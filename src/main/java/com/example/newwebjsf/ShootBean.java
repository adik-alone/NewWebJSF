package com.example.newwebjsf;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jdk.jfr.Name;

import java.io.Serializable;
@Named
@ApplicationScoped
public class ShootBean implements Serializable {
    private String x = "";
    private String y = "";
    private String r = "";

    public String getX() {
        return x;
    }
    public String getY() {
        return y;
    }
    public String getR() {
        return r;
    }
    public void setX(String x) {
        this.x = x;
    }
    public void setY(String y) {
        this.y = y;
    }
    public void setR(String r) {
        this.r = r;
    }
    public void doShoot(){
        return;
    }
}
