package com.example.servicesteht;

import android.app.Application;

import java.io.Serializable;

public class data implements Serializable {

    public String time;


    public String getTime () {
        return time;
    }

    public void setTime(String time){
        this.time = time;
    }

}
