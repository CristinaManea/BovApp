package com.example.bovapp.remoteData.Models;

public class Weight {
    private String kg;
    private String lb;

    @Override
    public String toString() {
        return "Weight{" +
                "kg='" + kg + '\'' +
                ", lb='" + lb + '\'' +
                '}';
    }

    public Weight(String kg, String lb) {
        this.kg = kg;
        this.lb = lb;
    }

    public void setKg(String kg) {
        this.kg = kg;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }

    public String getKg() {
        return kg;
    }

    public String getLb() {
        return lb;
    }
}
