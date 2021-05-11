package com.example.bovapp.reminder.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Monte.class}, version = 1, exportSchema = false)
public abstract class MonteDB extends RoomDatabase {

    public final static String DB_NAME = "monte.db";
    private static MonteDB instanta;

    public static MonteDB getInstance(Context context) {
        if (instanta == null) {
            instanta = Room.databaseBuilder(context, MonteDB.class, DB_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instanta;
    }

    public abstract IMonte getIMonte();
}
