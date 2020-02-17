package com.example.sqliteteht;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {data.class}, version = 1)
public abstract class Tietokanta extends RoomDatabase {
    public static final String NIMI = "TIETOKANTA";
    public abstract MyTableDao myTableDao();
}