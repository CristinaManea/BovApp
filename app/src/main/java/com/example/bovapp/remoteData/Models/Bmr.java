package com.example.bovapp.remoteData.Models;

public class Bmr {
    private String value;

    @Override
    public String toString() {
        return "Bmr{" +
                "value='" + value + '\'' +
                '}';
    }

    public Bmr(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
