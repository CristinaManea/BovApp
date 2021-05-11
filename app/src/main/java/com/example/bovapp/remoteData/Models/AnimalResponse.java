package com.example.bovapp.remoteData.Models;

public class AnimalResponse {
    private Weight weight;
    private Height height;
    private Bmi bmi;
    private String ideal_weight;
    private String surface_area;
    private String ponderal_index;
    private Bmr bmr;
    private Whr whr;
    private Whtr whtr;

    @Override
    public String toString() {
        return "AnimalResponse{" +
                "weight=" + weight +
                ", height=" + height +
                ", bmi=" + bmi +
                ", ideal_weight='" + ideal_weight + '\'' +
                ", surface_area='" + surface_area + '\'' +
                ", ponderal_index='" + ponderal_index + '\'' +
                ", bmr=" + bmr +
                ", whr=" + whr +
                ", whtr=" + whtr +
                '}';
    }

    public AnimalResponse(Weight weight, Height height, Bmi bmi, String ideal_weight, String surface_area, String ponderal_index, Bmr bmr, Whr whr, Whtr whtr) {
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
        this.ideal_weight = ideal_weight;
        this.surface_area = surface_area;
        this.ponderal_index = ponderal_index;
        this.bmr = bmr;
        this.whr = whr;
        this.whtr = whtr;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Bmi getBmi() {
        return bmi;
    }

    public void setBmi(Bmi bmi) {
        this.bmi = bmi;
    }

    public String getIdeal_weight() {
        return ideal_weight;
    }

    public void setIdeal_weight(String ideal_weight) {
        this.ideal_weight = ideal_weight;
    }

    public String getSurface_area() {
        return surface_area;
    }

    public void setSurface_area(String surface_area) {
        this.surface_area = surface_area;
    }

    public String getPonderal_index() {
        return ponderal_index;
    }

    public void setPonderal_index(String ponderal_index) {
        this.ponderal_index = ponderal_index;
    }

    public Bmr getBmr() {
        return bmr;
    }

    public void setBmr(Bmr bmr) {
        this.bmr = bmr;
    }

    public Whr getWhr() {
        return whr;
    }

    public void setWhr(Whr whr) {
        this.whr = whr;
    }

    public Whtr getWhtr() {
        return whtr;
    }

    public void setWhtr(Whtr whtr) {
        this.whtr = whtr;
    }
}
