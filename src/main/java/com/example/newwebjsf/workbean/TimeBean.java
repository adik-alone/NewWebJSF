package com.example.newwebjsf.workbean;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

@Named
@ApplicationScoped
public class TimeBean implements Serializable {
    private LocalDateTime dateTime = LocalDateTime.now();
    private String time = String.valueOf(dateTime.getHour()) + " : " + String.valueOf(dateTime.getMinute()) + " : " + String.valueOf(dateTime.getSecond()) ;
    private String date = String.valueOf(dateTime.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH)) + ", " + String.valueOf(dateTime.getDayOfMonth()) + "th " + String.valueOf(dateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH)) + " " + String.valueOf(dateTime.getYear()) + " year";

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public void updateDateTime(){
        dateTime = LocalDateTime.now();
        time = String.valueOf(dateTime.getHour()) + " : " + String.valueOf(dateTime.getMinute()) + " : " + String.valueOf(dateTime.getSecond()) ;
        date = String.valueOf(dateTime.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH)) + ", " + String.valueOf(dateTime.getDayOfMonth()) + "th " + String.valueOf(dateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH)) + " " + String.valueOf(dateTime.getYear()) + " year";
    }
}
