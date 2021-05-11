package com.example.bovapp.documente.anexaVitei.adauga;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Vitei.db";
    public static final String TABLE_NAME="Vitei_table";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "NRMATRICOL";
    public static final String COL_3 = "NUME";
    public static final String COL_4 = "DATANASTERII";
    public static final String COL_5 = "GREUTATE";
    public static final String COL_6 = "SEX";
    public static final String COL_7 = "GESTATIA";
    public static final String COL_8 = "EMBRIOTRANSFER";
    public static final String COL_9 = "USURINTAFATARE";
    public static final String COL_10 = "AVORT";
    public static final String COL_11 = "FATAREGEMERALA";
    public static final String COL_12 = "CULOARE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NRMATRICOL INTEGER, NUME TEXT," +
                "DATANASTERII TEXT, GREUTATE INTEGER, SEX TEXT, GESTATIA TEXT, EMBRIOTRANSFER TEXT," +
                "USURINTAFATARE TEXT, AVORT TEXT, FATAREGEMERALA TEXT, CULOARE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME,null);
        return cursor;
    }
}
