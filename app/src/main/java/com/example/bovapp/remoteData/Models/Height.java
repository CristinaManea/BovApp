package com.example.bovapp.remoteData.Models;

import com.google.gson.annotations.SerializedName;

public class Height {
    private String m;
    private String cm;
    private String in;
    @SerializedName("ft-in")
    private String ftin;

    @Override
    public String toString() {
        return "Height{" +
                "m='" + m + '\'' +
                ", cm='" + cm + '\'' +
                ", in='" + in + '\'' +
                ", ftin='" + ftin + '\'' +
                '}';
    }

    public Height(String m, String cm, String in, String ftin) {
        this.m = m;
        this.cm = cm;
        this.in = in;
        this.ftin = ftin;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getCm() {
        return cm;
    }

    public void setCm(String cm) {
        this.cm = cm;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getFtin() {
        return ftin;
    }

    public void setFtin(String ftin) {
        this.ftin = ftin;
    }
}
