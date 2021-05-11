package com.example.bovapp.reminder.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface IMonte {

    @Insert
    public void insert(Monte monte);

    @Query("Select * from Monte")
    List<Monte> getMonta();
}
