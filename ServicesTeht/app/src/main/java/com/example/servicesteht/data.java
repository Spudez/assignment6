package com.example.servicesteht;

import android.app.Application;

import java.io.Serializable;

public class data implements Serializable {

    String Time;

    public data() {

    }

    public data(String time) {
        this.Time = time;

    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}