package com.example.bovapp.reminder.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "monte")
public class Monte {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nrCrotala")
    private String nrCrotala;
    @ColumnInfo(name = "varsta")
    private String varsta;
    @ColumnInfo(name = "dataMontei")
    @TypeConverters({DateConverter.class})
    private Date dataMontei;

    @Ignore
    public Monte() {

    }

    public Monte(String nrCrotala, String varsta, Date dataMontei) {
        this.nrCrotala = nrCrotala;
        this.varsta = varsta;
        this.dataMontei = dataMontei;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNrCrotala() {
        return nrCrotala;
    }

    public void setNrCrotala(String nrCrotala) {
        this.nrCrotala = nrCrotala;
    }

    public String getVarsta() {
        return varsta;
    }

    public void setVarsta(String varsta) {
        this.varsta = varsta;
    }

    public Date getDataMontei() {
        return dataMontei;
    }

    public void setDataMontei(Date dataMontei) {
        this.dataMontei = dataMontei;
    }
}
