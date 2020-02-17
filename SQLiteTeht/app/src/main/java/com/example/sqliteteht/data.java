package com.example.sqliteteht;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class data {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String text_from_edittext;
    public String time;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getText () {
        return text_from_edittext;
    }

    public void setText(String text){
        this.text_from_edittext = text;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String time){
        this.time = time;
    }

}
