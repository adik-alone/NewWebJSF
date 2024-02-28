package com.example.newwebjsf.shootbean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class Shot implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private float x;
    private float y;
    private float r;
    private boolean result;
    private String data;
    private String execute_time;
    private String session;

    public int getId() {
        return id;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    public String getData() {
        return data;
    }

    public String getExecute_time() {
        return execute_time;
    }

    public String getSession() {
        return session;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setExecute_time(String execute_time) {
        this.execute_time = execute_time;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
    public boolean isResult() {
        return result;
    }
    public void setSession(String session) {
        this.session = session;
    }
}
