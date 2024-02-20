package com.example.newwebjsf.shootbean;

import com.google.gson.Gson;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.component.html.HtmlCommandButton;
import jakarta.faces.component.html.HtmlOutputText;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Console;
import java.io.Serializable;
import java.util.function.Supplier;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Named
@SessionScoped
public class XBean implements Serializable {
    private float x = 0;
    public XBean(){}
    public float getX() {
        return x;
    }
    public void setX(float x) {
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
