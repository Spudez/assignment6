package com.example.sqliteteht;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyTableDao {

    @Query("SELECT * FROM data ORDER BY id desc")
    List<data> getAllInDescendingOrder();

    @Insert
    void InsertMyEntity(data myentity);

    @Delete
    void DeleteMyEntity(data myentity);
}