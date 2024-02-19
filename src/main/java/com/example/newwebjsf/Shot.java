package com.example.newwebjsf;

import java.io.Serializable;
public class Shot implements Serializable {
    private float x;
    private float y;
    private float r;
    private boolean result;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
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

    public void setResult(boolean result) {
        this.result = result;
    }
    public boolean isResult() {
        return result;
    }
}
